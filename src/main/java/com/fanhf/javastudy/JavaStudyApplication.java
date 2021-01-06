package com.fanhf.javastudy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

//
/**
 * https://mp.weixin.qq.com/s?__biz=MzI4NTM1NDgwNw==&mid=2247486981&idx=2&sn=338f0f443bb50ee4a9be7de5d35e7e73&chksm=ebec305ddc9bb94b424bdd0f6f2ca440fdd97e379113140fb9239910cf2603fcce9aa216756c&mpshare=1&scene=1&srcid=1207olQbtwbIVcbwaiSSyNai&sharer_sharetime=1607318984334&sharer_shareid=612f5b49e3a144665772976c7ebceb16&key=caee7f8dc320c5c15796fbf0338920586e8a7063074b7e70273cffac7798334a26bab1f9ea7e37c00b32a873a15a9085b2d01d26c7b721d38ab3ae65fac97cc21dc14cd27bb676ca0774799b08ff9e8324669895de2a772c62f5773d90058cc9babdd173d7732cdbc2dd24cff830b787aec1c44f8aabad6d08536f2d6493d7b3&ascene=1&uin=MjYxMTc2MDAwMw%3D%3D&devicetype=Windows+10+x64&version=63000039&lang=zh_CN&exportkey=Afz7bkNmM9i3hDiuvmG%2B1gw%3D&pass_ticket=OEX%2BubR0kIR1ZL23nzw2gyVY%2BB4ZrW96h3qNRAefzaQR1iWpsoEnRyggWs9pT1gP&wx_header=0
 * "@SpringBootApplication"等同于如下3个注解
 * "@Configuration"
 * "@EnableAutoConfiguration"
 * "@ComponentScan"
 **/

@Configuration
@EnableAutoConfiguration

/**
 * @Date 2020/12/31 17:14
 *
 * @EnableAutoConfiguration注解
 * 里面有个@AutoConfigurationPackage
 * 标注了此注解的类会发生一系列的初始化动作
 * SpringBoot扫描到@EnableAutoConfiguration注解时，就使用Spring框架的SpringFactoriesLoader去扫描classpath下
 * 所有META-INF/spring.factories文件的配置信息，其中包括如下一些callback接口（在前中后等不同时机执行）
 *
 * org.springframework.boot.SpringApplicationRunListener。
 * org.springframework.context.ApplicationContextInitializer.
 * org.springframework.context.ApplicationListener。
 * 然后SpringBoot加载符合当前场景需要的配置类型并供当前或下一步的流程使用，这里说的场景就是提取以org.springframework.boot.autoconfigure.EnableAutoConfiguration
 * 作为key标志一系列java配置类，然后将这些Java配置类中的Bean定义加载到Spring容器中。
 *
 * 此外，可以使用Spring 3.0系列引入的@Conditional，通过像@ConditionalOnClass、@ConditionalOnMissingBean等具体的类型
 * 和条件来进一步筛选通过SpringFactoriesLoader加载的类。
 *
 * Spring Boot启动
 * 每一个Spring Boot应用都一个入口类，在其中定义main方法，然后使用SpringApplication这个类来加载指定配置并运行
 * Spring Boot Application。如上面写过的入口类中的main方法中的‘SpringApplication.run(JavaStudyApplication.class, args);’
 *
 * @SpringBootApplication 注解是一个复合注解，可以用：
 * @Configuration、@EnableAutoConfiguration、@ComponentScan代替。通过SpringApplication的run方法，Spring就使用BootDemo作为
 * java配置类来读取相关配置，加载和扫描相关的Bean。
 *
 *这样，基于@SpringBootApplication或者替代的这3个注解，Spring容器会自动完成指定语义的一系列工作，
 * 包括@EnableAutoConfiguration要求的东西，如从Springboot提供的多个Starter模块中加载java Config 配置，
 * 然后将这些Java Config配置帅选上来的bean定义加入Spring容器中，在refresh容器，一个Spring Boot应用即启动完成。
 *
 *
 *
 **/

@ComponentScan
@Slf4j
public class JavaStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApplication.class, args);

        //https://japidocs.agilestudio.cn/#/zh-cn/?id=%E5%85%A5%E9%97%A8
        //JApidocs替代swagger
       /* DocsConfig config = new DocsConfig();
        config.setProjectPath("your springboot project path"); // 项目根目录
        config.setProjectName("ProjectName"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("your api docs path"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档*/
        log.info("启动成功...........");
    }

}
