package io.github.hanpijunbuhanpi.baidu.sdk.common.config;

import com.baidu.aip.client.BaseClient;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaseBaiduConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;

import java.lang.reflect.Field;
import java.net.Proxy;

/**
 * 百度SDK自动配置
 *
 * @author lyc
 * @since 2023/8/16 11:22
 */
public class BaseBaiduSdkAutoConfiguration {
    /**
     * 初始化客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @param clazz 初始化客户端类型
     * @param tipPrefix 提示前缀
     * @return 初始化完成的客户端
     * @param <T> 客户端类型泛型
     */
    public <T extends BaseClient> T init(BaiduGlobalConfigurationProperties global, BaseBaiduConfigurationProperties properties,
                                                Class<T> clazz, String tipPrefix) {
        // 复制属性
        copy(global, properties);
        // 配置参数校验
        properties.check(tipPrefix);

        // 构建对象
        try {
            T client = clazz.getConstructor(String.class, String.class, String.class)
                    .newInstance(properties.getAppId(), properties.getApiKey(), properties.getSecretKey());

            // 超时配置
            if (properties.getConnectTimeout() != null) {
                client.setConnectionTimeoutInMillis(properties.getConnectTimeout());
            }
            if (properties.getSocketTimeout() != null) {
                client.setSocketTimeoutInMillis(properties.getSocketTimeout());
            }
            // 代理配置
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

    /**
     * 将全局配置复制到指定配置中
     *
     * @param global 全局配置
     * @param target 指定配置
     */
    public void copy(BaseBaiduConfigurationProperties global, BaseBaiduConfigurationProperties target) {
        try {
            Class<BaseBaiduConfigurationProperties> clazz = BaseBaiduConfigurationProperties.class;
            for (Field field : clazz.getDeclaredFields()) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(target) == null) {
                    field.set(target, field.get(global));
                }
                field.setAccessible(accessible);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(" 百度SDK配置属性复制异常", e);
        }
    }
}
