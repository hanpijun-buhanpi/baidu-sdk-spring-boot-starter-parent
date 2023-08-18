package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.client.BaseClient;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduBaseConfigurationProperties;

import java.net.Proxy;

/**
 * 百度SDK自动配置
 *
 * @author lyc
 * @since 2023/8/16 11:22
 */
public abstract class BaiduSdkAutoConfiguration {
    /**
     * 配置客户端
     *
     * @param clazz 客户端类型
     * @param properties 配置属性
     * @param tipPrefix 提示前缀
     * @return 配置好的客户端
     */
    public <T extends BaseClient> T config(Class<T> clazz, BaiduBaseConfigurationProperties properties, String tipPrefix) {
        // 配置参数校验
        properties.check(tipPrefix);

        // 装配对象
        try {
            T client = clazz.getConstructor(String.class, String.class, String.class)
                    .newInstance(properties.getAppId(), properties.getApiKey(), properties.getSecretKey());
            client.setConnectionTimeoutInMillis(properties.getConnectTimeout());
            client.setSocketTimeoutInMillis(properties.getSocketTimeout());
            if (properties.getProxyType() != null && properties.getProxyType() != Proxy.Type.DIRECT) {
                if (properties.getProxyType() == Proxy.Type.HTTP) {
                    client.setHttpProxy(properties.getProxyHost(), properties.getProxyPort());
                } else {
                    client.setSocketProxy(properties.getProxyHost(), properties.getProxyPort());
                }
            }
            // log4j日志配置
            if (properties.getLog4jConfigPath() != null && !"".equals(properties.getLog4jConfigPath().trim())) {
                System.setProperty("aip.log4j.conf", properties.getLog4jConfigPath());
            }
            return client;
        } catch (Throwable e) {
            throw new RuntimeException(tipPrefix + " 百度客户端构建异常", e);
        }
    }
}
