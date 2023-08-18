package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.ocr.AipOcr;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduOcrConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度文字识别SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduOcrConfigurationProperties.class})
public class BaiduOcrSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.ocr", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipOcr.class)
    public AipOcr aipOcr(BaiduOcrConfigurationProperties properties) {
        return super.config(AipOcr.class, properties, "百度文字识别配置：");
    }
}
