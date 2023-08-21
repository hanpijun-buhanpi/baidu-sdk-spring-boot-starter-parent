package io.github.hanpijunbuhanpi.baidu.sdk.nlp.config;

import com.baidu.aip.nlp.AipNlp;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.nlp.config.property.BaiduNlpConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度自然语言处理SDK起步依赖
 *
 * @author lyc
 * @since 2023/8/15 17:27
 */
@AutoConfiguration
@Import({BaiduNlpConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduNlpSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.nlp", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipNlp.class)
    public AipNlp aipNlp(BaiduGlobalConfigurationProperties global, BaiduNlpConfigurationProperties properties) {
        return super.init(global, properties, AipNlp.class, "百度自然语言处理配置：");
    }
}
