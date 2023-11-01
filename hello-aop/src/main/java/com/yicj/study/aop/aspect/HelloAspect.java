package com.yicj.study.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class HelloAspect {
    @Pointcut("execution(String com.yicj.study.aop.service.HelloService.hello(String))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pj) throws Throwable{
        log.info("before ...");
        Object result = pj.proceed();
        log.info("after ...");
        return result ;
    }

}
