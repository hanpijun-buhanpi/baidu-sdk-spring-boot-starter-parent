package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.speech.AipSpeech;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduSpeechConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度语音技术SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduSpeechConfigurationProperties.class})
public class BaiduSpeechSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.speech", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipSpeech.class)
    public AipSpeech aipSpeech(BaiduSpeechConfigurationProperties properties) {
        return super.config(AipSpeech.class, properties, "百度语音技术配置：");
    }
}
