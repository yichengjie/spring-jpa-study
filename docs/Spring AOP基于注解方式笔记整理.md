1. @EnableAspectJAutoProxy引入AspectJAutoProxyRegistrar

2. AopConfigUtils.*registerAspectJAnnotationAutoProxyCreatorIfNecessary*(registry)

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

#### AbstractAutoProxyCreator#postProcessAfterInitialization

1. AbstractAutoProxyCreator#wrapIfNecessary
2. AbstractAdvisorAutoProxyCreator#getAdvicesAndAdvisorsForBean
3. AbstractAdvisorAutoProxyCreator#findEligibleAdvisors
4. AnnotationAwareAspectJAutoProxyCreator#findCandidateAdvisors
5. BeanFactoryAdvisorRetrievalHelper#findAdvisorBeans （查询不到数据）
6. BeanFactoryAspectJAdvisorsBuilderAdapter#buildAspectJAdvisors
7. BeanFactoryAspectJAdvisorsBuilder#buildAspectJAdvisors从Spring容器中获取Aspect构建Advisor
8. 

