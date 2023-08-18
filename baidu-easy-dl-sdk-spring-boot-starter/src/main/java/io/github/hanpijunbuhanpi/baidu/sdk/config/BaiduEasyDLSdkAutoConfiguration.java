package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.easydl.AipEasyDL;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduEasyDLConfigurationProperties;
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
public class BaiduEasyDLSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.easy-dl", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipEasyDL.class)
    public AipEasyDL aipEasyDL(BaiduEasyDLConfigurationProperties properties) {
        return super.config(AipEasyDL.class, properties, "百度EasyDL配置：");
    }
}
