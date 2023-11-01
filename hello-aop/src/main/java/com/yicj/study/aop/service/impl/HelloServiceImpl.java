package com.yicj.study.aop.service.impl;

import com.yicj.study.aop.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        log.info("service hello execute ... ");
        return "hello world";
    }
}
