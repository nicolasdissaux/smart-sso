<?php

namespace Container8r8xhgn;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/*
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class getMenuService extends SimpleSAML_KernelProdContainer
{
    /*
     * Gets the public 'SimpleSAML\Module\admin\Controller\Menu' shared autowired service.
     *
     * @return \SimpleSAML\Module\admin\Controller\Menu
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->services['SimpleSAML\\Module\\admin\\Controller\\Menu'] = new \SimpleSAML\Module\admin\Controller\Menu();
    }
}