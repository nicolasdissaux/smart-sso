<?php

namespace ContainerTjxDU6V;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/*
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getCache_AppService extends SimpleSAML_KernelProdContainer
{
    /*
     * Gets the public 'cache.app' shared service.
     *
     * @return \Symfony\Component\Cache\Adapter\FilesystemAdapter
     */
    public static function do($container, $lazyLoad = true)
    {
        $container->services['cache.app'] = $instance = new \Symfony\Component\Cache\Adapter\FilesystemAdapter('W7liCg9XfC', 0, ($container->targetDir.''.'/pools/app'), new \Symfony\Component\Cache\Marshaller\DefaultMarshaller(NULL, false));

        $instance->setLogger(($container->privates['logger'] ?? ($container->privates['logger'] = new \Symfony\Component\HttpKernel\Log\Logger())));

        return $instance;
    }
}
