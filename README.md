# Baidu Sdk Spring Boot Starter
## 介绍

本项目用于为Spring Boot项目集成百度的JAVA-SDK，其中共包含了12个客户端，本项目可为客户端进行全局配置或单独配置，若独立配置不存在时，将使用全局配置。
本项目一共有14个组件，1个通用组件、12个独立组件、1个整合组件。其中独立组件为单独配置客户端，整合组件配置了所有客户端，从独立组件过渡到整合组件需要修改配置文件，整合组件默认开启所有客户端，所以至少需要配置全局属性才可使用。

## 项目结构

本项目结构如下

```
baidu-sdk-spring-boot-starter-parent                        //parent模块
    ├── baidu-sdk-common                                    //通用组件
    ├── baidu-body-analysis-sdk-spring-boot-starter         //人体分析
    ├── baidu-content-censor-sdk-spring-boot-starter        //内容审核
    ├── baidu-easy-dl-sdk-spring-boot-starter               //EasyDL
    ├── baidu-face-sdk-spring-boot-starter                  //人脸识别
    ├── baidu-image-classify-sdk-spring-boot-starter        //图像增强
    ├── baidu-image-process-sdk-spring-boot-starter         //图像处理
    ├── baidu-image-search-sdk-spring-boot-starter          //图像搜索
    ├── baidu-kg-sdk-spring-boot-starter                    //知识图谱
    ├── baidu-machine-translation-sdk-spring-boot-starter   //机器翻译
    ├── baidu-nlp-sdk-spring-boot-starter                   //自然语言处理
    ├── baidu-ocr-sdk-spring-boot-starter                   //文字识别
    ├── baidu-speech-sdk-spring-boot-starter                //语音技术
    └── baidu-sdk-spring-boot-starter                       //整合组件
```

## 使用

### 配置文件

独立组件

```yaml
baidu-sdk:
	client-name:
	    enable: true #是否开启配置，默认true
        app-id: '' #百度API应用ID
        api-key: '' #百度API应用的Api Key
        secret-key: '' #百度API应用的Secret Key
        connect-timeout: 10_000 #连接超时时间（单位：毫秒），默认10_000
        socket-timeout: 20_000 #传输超时时间（单位：毫秒），默认20_000
        proxy-type: http #代理服务器类型，可选值：direct-不代理，http-Http代理，socket-Socket代理（默认null，不代理）
        proxy-host: '' #代理服务器地址
        proxy-port: 80 #代理服务器端口
```

整合组件

```yaml
baidu-sdk:
	global:
	    enable: true #是否开启配置，默认true（这里改为false后，所有客户端都将禁用配置）
	    #以下配置会自动填充进对应客户端为null的属性中
        app-id: '' #百度API应用ID
        api-key: '' #百度API应用的Api Key
        secret-key: '' #百度API应用的Secret Key
        connect-timeout: 10_000 #连接超时时间（单位：毫秒），默认10_000
        socket-timeout: 20_000 #传输超时时间（单位：毫秒），默认20_000
        proxy-type: http #代理服务器类型，可选值：direct-不代理，http-Http代理，socket-Socket代理（默认null，不代理）
        proxy-host: '' #代理服务器地址
        proxy-port: 80 #代理服务器端口
	client-name:
	    enable: true #是否开启配置，默认true
        app-id: '' #百度API应用ID
        api-key: '' #百度API应用的Api Key
        secret-key: '' #百度API应用的Secret Key
        connect-timeout: 10_000 #连接超时时间（单位：毫秒），默认10_000
        socket-timeout: 20_000 #传输超时时间（单位：毫秒），默认20_000
        proxy-type: http #代理服务器类型，可选值：direct-不代理，http-Http代理，socket-Socket代理（默认null，不代理）
        proxy-host: '' #代理服务器地址
        proxy-port: 80 #代理服务器端口
```

### 引入

```java
@Autowired
private AipBodyAnalysis aipBodyAnalysis;

@Test
public void test() {
    Assert.isTrue(properties != null, "属性未注入");
    Assert.isTrue(properties.getAppId().equals("111"), "app-id属性异常");
    Assert.isTrue(properties.getApiKey().equals("222"), "api-key属性异常");
    Assert.isTrue(properties.getSecretKey().equals("333"), "secret-key属性异常");
    Assert.isTrue(aipBodyAnalysis != null, "客户端未注册");
}
```

