#### AnnotationConfigApplicationContext初始化
1. 初始化AnnotatedBeanDefinitionReader(registry) 实例
2. 初始化ClassPathBeanDefinitionScanner(registry) 实例
#### AnnotatedBeanDefinitionReader初始化
1. 初始化ConditionEvaluator实例
2. AnnotationConfigUtils.*registerAnnotationConfigProcessors*(this.registry)
#### AnnotationConfigUtils.registerAnnotationConfigProcessors
1. 向容器中注入ConfigurationClassPostProcessor
2. 向容器中注入AutowiredAnnotationBeanPostProcessor
3. 向容器中注入CommonAnnotationBeanPostProcessor .. 等组件