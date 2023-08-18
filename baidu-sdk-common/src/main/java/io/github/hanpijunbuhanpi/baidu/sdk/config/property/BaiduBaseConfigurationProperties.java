package io.github.hanpijunbuhanpi.baidu.sdk.config.property;

import lombok.Data;
import org.springframework.util.Assert;

import java.net.Proxy;

/**
 * 百度基础配置
 *
 * @author lyc
 * @since 2023/8/15 10:53
 */
@Data
public class BaiduBaseConfigurationProperties {
    /**
     * 是否启用配置
     */
    private boolean enable = true;
    /**
     * App Id
     */
    private String appId;
    /**
     * Api Key
     */
    private String apiKey;
    /**
     * Secret Key
     */
    private String secretKey;
    /**
     * 建立连接的超时时间（单位：毫秒）
     */
    private int connectTimeout = 10_000;
    /**
     * 通过打开的连接传输数据的超时时间（单位：毫秒）
     */
    private int socketTimeout = 20_000;
    /**
     * 代理服务器类型
     */
    private Proxy.Type proxyType;
    /**
     * 代理服务器地址
     */
    private String proxyHost;
    /**
     * 代理服务器端口
     */
    private int proxyPort = 80;
    /**
     * log4j日志配置文件路径
     */
    private String log4jConfigPath;

    /**
     * 参数校验
     *
     * @param tipPrefix 提示前缀
     */
    public void check(String tipPrefix) {
        Assert.isTrue(appId != null, tipPrefix + "App Id 不能为空");
        Assert.isTrue(apiKey != null, tipPrefix + "Api Key 不能为空");
        Assert.isTrue(secretKey != null, tipPrefix + "Secret Key 不能为空");
        Assert.isTrue(connectTimeout > -1, tipPrefix + "Connect Timeout 不能为负数");
        Assert.isTrue(socketTimeout > -1, tipPrefix + "Socket Timeout 不能为负数");
        if (proxyType != null) {
            Assert.isTrue(proxyHost != null && !"".equals(proxyHost.trim()), tipPrefix + "Proxy Host 不能为空");
            Assert.isTrue(0 <= proxyPort && proxyPort <= 65535, tipPrefix + " Proxy Port 必须在 0~65535 之间");
        }
        Assert.isTrue(log4jConfigPath == null || !"".equals(log4jConfigPath.trim()), tipPrefix + " Log4j日志配置文件路径 需为有效路径");
    }
}
