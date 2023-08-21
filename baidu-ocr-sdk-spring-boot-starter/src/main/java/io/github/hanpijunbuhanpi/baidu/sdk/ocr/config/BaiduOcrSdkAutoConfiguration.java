package io.github.hanpijunbuhanpi.baidu.sdk.ocr.config;

import com.baidu.aip.ocr.AipOcr;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property.BaiduOcrConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.service.BaiduOcr;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduOcrSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度文字识别客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度文字识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.ocr", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipOcr.class)
    public AipOcr aipOcr(BaiduGlobalConfigurationProperties global, BaiduOcrConfigurationProperties properties) {
        return super.init(global, properties, AipOcr.class,"百度文字识别配置：");
    }

    /**
     * 百度SDK Starter文字识别客户端
     *
     * @return 百度SDK Starter文字识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.ocr", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduOcr.class})
    public BaiduOcr baiduOcr() {
        return new BaiduOcr();
    }
}
