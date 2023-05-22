package com.smart.resource.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 扩展加载插件yml配置
 *
 * @see org.springframework.boot.env.YamlPropertySourceLoader
 */
@Slf4j
public class PluginEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private static final String[] DIRS = {"module", "plugin"};

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        for (String dir : DIRS) {
            parseResources(environment, resourcePatternResolver, dir + "/*/application.yml");
        }
    }

    private void parseResources(ConfigurableEnvironment environment, ResourcePatternResolver resourcePatternResolver, String location) {
        try {
            Resource[] resources = resourcePatternResolver.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + location);
            for (Resource resource : resources) {
                if (resource.exists() && resource.isReadable()) {
                    Properties properties = loadProperties(resource);
                    if (!properties.isEmpty()) {
                        MutablePropertySources propertySources = environment.getPropertySources();
                        String pathName = parsePluginResourcePathName(resource);
                        propertySources.addLast(new PropertiesPropertySource(pathName, properties));
                    }
                }
            }
        } catch (IOException e) {
            log.error("", e);
        }
    }

    private String parsePluginResourcePathName(Resource resource) {
        String path;
        try {
            path = resource.getURL().getPath();
        } catch (IOException e) {
            log.error("", e);
            return null;
        }
        return path;
    }

    private Properties loadProperties(Resource resource) throws IOException {
        Properties properties = new Properties();
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
        factoryBean.setResources(encodedResource.getResource());
        properties.putAll(factoryBean.getObject());
        return properties;
    }
}