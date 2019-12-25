package com.mobei.bootlaunch.model.yaml;

import com.mobei.bootlaunch.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 *                  @ConfigurationProperties        @Value
 *  功能                  批量注入属性               单个指定
 *  松散语法绑定           支持                      不支持
 *  SpEL                  不支持                    支持
 *  复杂数据类型(嵌套)      支持                      不支持
 *  JSR303数据校验         支持                      不支持
 *
 *  @Validated: 在需要校验的属性装配类上加该注解,只有加上才会触发数据校验,
 *      配合@ConfigurationProperties进行属性校验
 *
 */
@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family") //以family为前缀,后面的内容全部注入,注意:变量名需要和yml中对应,比如下面的father如果是father1则该变量结果为null
//@PropertySource:读取外部yml和properties文件:这里会把family.yml配置文件中的属性加载到Family类,factory = MixPropertySourceFactory.class是因为不支持读取yml所以才需要该类做转换,
// 如果是family.properties文件则只需要@PropertySource(value = {"classpath:family.properties"})即可
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
public class Family {
    // @Value:只能完成对单个属性的注入
    @Value("${family.family-name}")
    @NotEmpty //需要配合@Validated和@ConfigurationProperties(测试发现注释掉该注解并不会抛异常)注解使用,此时如果familyName为空则会抛出异常
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
