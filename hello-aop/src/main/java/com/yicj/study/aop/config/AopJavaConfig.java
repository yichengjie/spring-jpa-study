package com.yicj.study.aop.config;

import com.yicj.study.aop.aspect.HelloAspect;
import com.yicj.study.aop.service.HelloService;
import com.yicj.study.aop.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yicj
 * @date 2023年11月02日 13:35
 */
@EnableAspectJAutoProxy
@Configuration
public class AopJavaConfig {

    @Bean
    public HelloAspect helloAspect(){
        return new HelloAspect() ;
    }

    @Bean
    public HelloService helloService(){
        return new HelloServiceImpl() ;
    }

}
