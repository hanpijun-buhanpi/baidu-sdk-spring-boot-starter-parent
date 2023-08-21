package io.github.hanpijunbuhanpi.baidu.sdk.speech.config;

import com.baidu.aip.speech.AipSpeech;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.speech.config.property.BaiduSpeechConfigurationProperties;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduSpeechSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度语音技术客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度语音技术客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.speech", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipSpeech.class)
    public AipSpeech aipSpeech(BaiduGlobalConfigurationProperties global, BaiduSpeechConfigurationProperties properties) {
        return super.init(global, properties, AipSpeech.class, "百度语音技术配置：");
    }
}
