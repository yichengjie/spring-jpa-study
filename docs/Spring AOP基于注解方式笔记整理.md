#### 基于注解AOP对象创建流程
1. @EnableAspectJAutoProxy引入AspectJAutoProxyRegistrar
2. AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary*(registry)
3. 向容器中注入AnnotationAwareAspectJAutoProxyCreator后置处理器
4. AnnotationAwareAspectJAutoProxyCreator#initBeanFactory中初始化解析工具
   ```
   this.advisorRetrievalHelper = new BeanFactoryAdvisorRetrievalHelperAdapter(beanFactory);
   this.aspectJAdvisorFactory = new ReflectiveAspectJAdvisorFactory(beanFactory);
   this.aspectJAdvisorsBuilder =
       new BeanFactoryAspectJAdvisorsBuilderAdapter(beanFactory, this.aspectJAdvisorFactory);
   ```
5. AbstractAutoProxyCreator#postProcessBeforeInstantiation
6. AbstractAutoProxyCreator#postProcessAfterInitialization
7. AbstractAutoProxyCreator#wrapIfNecessary
8. AbstractAutoProxyCreator#createProxy
9. ProxyFactory#getProxy获取代理对象
#### AbstractAutoProxyCreator#postProcessBeforeInstantiation
1. AspectJAwareAdvisorAutoProxyCreator#shouldSkip
2. AnnotationAwareAspectJAutoProxyCreator#findCandidateAdvisors
3. BeanFactoryAspectJAdvisorsBuilderAdapter#buildAspectJAdvisors
4. 从BeanFactory容器中获取所有的Aspect对象
5. ReflectiveAspectJAdvisorFactory#getAdvisors解析出Advisor并放入缓存
#### AbstractAutoProxyCreator#wrapIfNecessary创建代理对象
1. AbstractAdvisorAutoProxyCreator#getAdvicesAndAdvisorsForBean
2. AbstractAdvisorAutoProxyCreator#findEligibleAdvisors
3. AnnotationAwareAspectJAutoProxyCreator#findCandidateAdvisors
4. AbstractAdvisorAutoProxyCreator#findCandidateAdvisors
5. BeanFactoryAdvisorRetrievalHelper#findAdvisorBeans获取容器中的Advisor集合(我们没有手动向容器中注入过Advisor对象，所以这里有一定会返回空集合)
6. BeanFactoryAspectJAdvisorsBuilderAdapter#buildAspectJAdvisors从缓存中获取到Advisor集合
7. AbstractAutoProxyCreator#createProxy
8. ProxyFactory#getProxy创建代理对象