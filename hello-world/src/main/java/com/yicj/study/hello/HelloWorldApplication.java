package com.yicj.study.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author yicj
 * @date 2023/10/26 21:25
 */
@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        ConfigurableEnvironment env =
                SpringApplication.run(HelloWorldApplication.class, args)
                .getEnvironment();
        log.info("地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
