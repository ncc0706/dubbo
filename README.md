# dubbo

**SpringBoot Dubbo Zookeerp 实现分布式部署**

## 如何正确、安全的停止SpringBoot应用

[Spring Boot](http://projects.spring.io/spring-boot/)，作为Spring框架对“约定优先于配置(Convention Over Configuration)”理念的最佳实践的产物，它能帮助我们很快捷的创建出独立运行、产品级别的基于Spring框架的应用，大部分Spring Boot应用只需要非常少的配置就可以快速运行起来，是一个与微服务(MicroServices)相当契合的微框架。
网络上关于Spring Boot的QuickStart式中文内容已经相当丰富，但是对于部署后怎样便捷、安全地停止服务(shutdown)，还比较缺乏，最近发现Spring Boot的官方指南更新了相关内容，因此结合该部分更新，对如何**基于官方提供的特性**正确地停止Spring Boot应用进行简单说明。

主要有两种方式：通过HTTP发送``shutdown``信号，或者通过``service stop``的方式

### 方式一：通过``HTTP``发送``shutdown``信号

该方式主要依赖Spring Boot Actuator的endpoint特性，具体步骤如下：

1.在pom.xml中引入actuator依赖

	<dependency>
	  <groupId>org.springframework.boot</groupId>
	  <artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>

2.开启shutdown endpoint

Spring Boot Actuator的shutdown endpoint默认是关闭的，因此在application.properties中开启shutdown endpoint：

	#启用shutdown
	endpoints.shutdown.enabled=true
	#禁用密码验证
	endpoints.shutdown.sensitive=false

3.发送shutdown信号

shutdown的默认url为host:port/shutdown，当需要停止服务时，向服务器post该请求即可，如：
``curl -X POST host:port/shutdown``
将得到形如``{"message":"Shutting down, bye..."}``的响应


4.安全设置

可以看出，使用该方法可以非常方便的进行远程操作，但是需要注意的是，正式使用时，必须对该请求进行必要的安全设置，比如借助spring-boot-starter-security进行身份认证：

1. pom.xml添加security依赖
```
	<dependency>
	 <groupId>org.springframework.boot</groupId>
	 <artifactId>spring-boot-starter-security</artifactId>
	</dependency>
```
2. 开启安全验证
	
在application.properties中变更配置,并

	#开启shutdown的安全验证
	endpoints.shutdown.sensitive=true
	#验证用户名
	security.user.name=admin
	#验证密码
	security.user.password=secret
	#角色
	management.security.role=SUPERUSER

3.指定路径、IP、端口


	#指定shutdown endpoint的路径
	endpoints.shutdown.path=/custompath
	#也可以统一指定所有endpoints的路径`management.context-path=/manage`
	#指定管理端口和IP
	management.port=8081
	management.address=127.0.0.1



> http://www.aloo.me/2016/06/27/%E6%AD%A3%E7%A1%AE%E3%80%81%E5%AE%89%E5%85%A8%E5%9C%B0SpringBoot%E5%BA%94%E7%94%A8/
> 








