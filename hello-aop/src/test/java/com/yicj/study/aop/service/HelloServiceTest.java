package com.yicj.study.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class HelloServiceTest {

    @Test
    public void context1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml") ;
        HelloService helloService = context.getBean(HelloService.class);
        String retValue = helloService.hello("张三");
        log.info("ret value : {}", retValue);
    }


    @Test
    public void context2(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.yicj.study.aop") ;
        HelloService helloService = context.getBean(HelloService.class);
        String retValue = helloService.hello("张三");
        log.info("ret value : {}", retValue);
    }

}
