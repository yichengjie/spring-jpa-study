#### XML AOP 加载流程
1. ClassPathXmlApplicationContext#refresh
2. AbstractApplicationContext#obtainFreshBeanFactory
3. AbstractRefreshableApplicationContext#refreshBeanFactory
4. 创建DefaultListableBeanFactory
5. AbstractApplicationContext#loadBeanDefinitions(beanFactory)
6. 创建XmlBeanDefinitionReader(beanFactory)
7. AbstractApplicationContext#loadBeanDefinitions(beanDefinitionReader)
8. AbstractBeanDefinitionReader#loadBeanDefinitions(locations)
9. XmlBeanDefinitionReader#loadBeanDefinitions(encodedResource)
10. XmlBeanDefinitionReader#doLoadBeanDefinitions(inputSource,  resource)
11. XmlBeanDefinitionReader#registerBeanDefinitions(doc, resource)
12. 创建DefaultBeanDefinitionDocumentReader对象
13. DefaultBeanDefinitionDocumentReader#registerBeanDefinitions(doc, readerContext)
14. DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions（element）
15. DefaultBeanDefinitionDocumentReader#parseBeanDefinitions(element, delegate)
16. 解析默认标签：DefaultBeanDefinitionDocumentReader#parseDefaultElement 
17. 解析非默认标签：BeanDefinitionParserDelegate#parseCustomElement(ele)
#### 解析非默认标签
1. 通过element获取namespaceUri
2. 从readerContext中获取NamespaceHandler: DefaultNamespaceHandlerResolver
3. DefaultNamespaceHandlerResolver#resolve(namespaceUri)
4. 从META-INF/spring.handlers中加载所有的handlerMapping并根据namespaceUri获取匹配的值
5. 实例化AopNamespaceHandler并调用init进行初始化，并返回实例对象
6. NamespaceHandlerSupport#parse(element, parserContext) 解析标签beanDefinition信息
7. 根据标签获取AopNamespaceHandler中注册的BeanDefinitionParser
8. ConfigBeanDefinitionParser#parse(element, parserContext)解析pointcut, advisor, aspect信息

