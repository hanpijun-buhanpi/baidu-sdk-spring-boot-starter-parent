package io.github.hanpijunbuhanpi.baidu.sdk.easydl.config;

import com.baidu.aip.easydl.AipEasyDL;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.easydl.config.property.BaiduEasyDLConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度EasyDL零门槛AI开发SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduEasyDLConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduEasyDLSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度EasyDL客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度EasyDL客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.easy-dl", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipEasyDL.class)
    public AipEasyDL aipEasyDL(BaiduGlobalConfigurationProperties global, BaiduEasyDLConfigurationProperties properties) {
        return super.init(global, properties, AipEasyDL.class, "百度EasyDL配置：");
    }
}
