package com.yicj.study.hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class HelloAopTest {

    @Test
    public void hello(){
        Person person = new Student() ;
        person.hello();
    }


    class Person{
        public void hello(){
            log.info("-----> Person hello() method execute !");
            this.doHello();
        }

        protected void doHello(){
            log.info("----> Person doHello() method execute !");
        }
    }

    class Student extends Person{

        @Override
        protected void doHello() {
            log.info("----> Student doHello() method execute !");
        }
    }

}
