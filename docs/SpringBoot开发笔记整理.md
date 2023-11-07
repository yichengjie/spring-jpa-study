1. SpringBoot打印启动访问地址
    ```text
    ConfigurableEnvironment env =
            SpringApplication.run(HelloWorldApplication.class, args)
            .getEnvironment();
    log.info("地址：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    ```
2. 