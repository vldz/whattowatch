package com.vanillastorm.util.spring;

import com.vanillastorm.service.MovieService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextProvider {
    private static ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");

    public static Object getBean(String name) {
        return appContext.getBean(name);
    }
}
