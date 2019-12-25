package com.mobei.bootlaunch.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @PropertySource默认不支持读取yaml格式外部配置文件,所以我们继承DefaultPropertySourceFactory, 然后对它的createPropertySource进行重写
 */
public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String srcName = (name != null) ? name : resource.getResource().getFilename();
        if (!resource.getResource().exists()) {
            return new PropertiesPropertySource(srcName, new Properties());
        }
        if (srcName.endsWith(".yml") || srcName.endsWith(".yaml")) {
            Properties propertiesFromYml = loadYml(resource);
            return new PropertiesPropertySource(srcName, propertiesFromYml);
        }
        return super.createPropertySource(name, resource);
    }

    private Properties loadYml(EncodedResource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
