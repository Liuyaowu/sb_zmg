package com.mobei.bootlaunch.importresources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportResourcesTests {
    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean isExists = ioc.containsBean("testBeanService");
        System.out.println(isExists);
    }
}
