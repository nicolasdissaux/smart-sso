<?php

namespace ContainerTjxDU6V;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/*
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getHttpKernelService extends SimpleSAML_KernelProdContainer
{
    /*
     * Gets the public 'http_kernel' shared service.
     *
     * @return \Symfony\Component\HttpKernel\HttpKernel
     */
    public static function do($container, $lazyLoad = true)
    {
        $a = new \Symfony\Component\EventDispatcher\EventDispatcher();
        $a->addSubscriber(($container->privates['router_listener'] ?? $container->getRouterListenerService()));
        $a->addSubscriber(new \Symfony\Component\HttpKernel\EventListener\ResponseListener('UTF-8'));

        return $container->services['http_kernel'] = new \Symfony\Component\HttpKernel\HttpKernel($a, new \Symfony\Component\HttpKernel\Controller\ContainerControllerResolver($container), ($container->services['request_stack'] ?? ($container->services['request_stack'] = new \Symfony\Component\HttpFoundation\RequestStack())), new \Symfony\Component\HttpKernel\Controller\ArgumentResolver(new \Symfony\Component\HttpKernel\ControllerMetadata\ArgumentMetadataFactory(), new RewindableGenerator(function () use ($container) {
            yield 0 => ($container->privates['argument_resolver.request_attribute'] ?? ($container->privates['argument_resolver.request_attribute'] = new \Symfony\Component\HttpKernel\Controller\ArgumentResolver\RequestAttributeValueResolver()));
            yield 1 => ($container->privates['argument_resolver.request'] ?? ($container->privates['argument_resolver.request'] = new \Symfony\Component\HttpKernel\Controller\ArgumentResolver\RequestValueResolver()));
            yield 2 => ($container->privates['argument_resolver.session'] ?? ($container->privates['argument_resolver.session'] = new \Symfony\Component\HttpKernel\Controller\ArgumentResolver\SessionValueResolver()));
            yield 3 => ($container->privates['argument_resolver.service'] ?? $container->load('getArgumentResolver_ServiceService'));
            yield 4 => ($container->privates['argument_resolver.default'] ?? ($container->privates['argument_resolver.default'] = new \Symfony\Component\HttpKernel\Controller\ArgumentResolver\DefaultValueResolver()));
            yield 5 => ($container->privates['argument_resolver.variadic'] ?? ($container->privates['argument_resolver.variadic'] = new \Symfony\Component\HttpKernel\Controller\ArgumentResolver\VariadicValueResolver()));
        }, 6)));
    }
}
