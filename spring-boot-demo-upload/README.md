# Getting Started
# spring boot 实现简单上传
1、pom.xml文件添加依赖
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
   </dependency>
2、yml文件添加配置参数
server:
  port: 8080
  servlet:
    context-path: /demo
spring:
  servlet:
    multipart:
      enabled: true
      location: D:\
      file-size-threshold: 5MB
      max-file-size: 20MB
  mvc:
    view:
      prefix: classpath:/templates/
      suffix: .html
    static-path-pattern: /static/**

3、在templates目录下添加index.html
4、mvc实现页面跳转
    方法一、
    @Controller
    public class IndexController {
        @GetMapping("")
        public String index() {
            return "index";
        }
    }
    方法二、
   @RestController
   public class IndexController {
       @GetMapping("")
       public ModelAndView index() {
           ModelAndView modelAndView = new ModelAndView();
           modelAndView.setViewName("index");
           return modelAndView;
       }
   }
   RestController 相当于 Controller + RequestBody，因此在使用RestController里需要配置视图解析器
  5、代码实现文件上传


