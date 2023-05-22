package com.smart.i18n.entity;

import com.smart.core.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.Objects;

/**
 * 国际化支持
 */
@Slf4j
public class I18nMessage extends Message {

    private MessageSource messageSource;

    public I18nMessage(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getKey(String key, Object... args) {
        String message = getMessage(LocaleContextHolder.getLocale(), key, args);
        if (Objects.isNull(message)) {
            return DEFAULT.getKey(key, args);
        } else {
            return message;
        }
    }

    private String getMessage(Locale locale, String key, Object... args) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("use country[{}]-language[{}]", locale.getCountry(), locale.getLanguage());
            }
            return messageSource.getMessage(key, args, locale);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}