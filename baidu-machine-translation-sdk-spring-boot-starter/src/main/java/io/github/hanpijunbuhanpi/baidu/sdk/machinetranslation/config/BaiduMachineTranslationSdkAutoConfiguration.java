package io.github.hanpijunbuhanpi.baidu.sdk.machinetranslation.config;

import com.baidu.aip.machinetranslation.Machinetranslation;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.machinetranslation.config.property.BaiduMachineTranslationConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.machinetranslation.service.BaiduMachineTranslation;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度机器翻译SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduMachineTranslationConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduMachineTranslationSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度机器翻译客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度机器翻译客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.machine-translation", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(Machinetranslation.class)
    public Machinetranslation machinetranslation(BaiduGlobalConfigurationProperties global, BaiduMachineTranslationConfigurationProperties properties) {
        return super.init(global, properties, Machinetranslation.class, "百度机器翻译配置：");
    }

    /**
     * 百度SDK Starter机器翻译客户端
     *
     * @return 百度SDK Starter机器翻译客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.machine-translation", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduMachineTranslation.class})
    public BaiduMachineTranslation baiduMachineTranslation() {
        return new BaiduMachineTranslation();
    }
}
