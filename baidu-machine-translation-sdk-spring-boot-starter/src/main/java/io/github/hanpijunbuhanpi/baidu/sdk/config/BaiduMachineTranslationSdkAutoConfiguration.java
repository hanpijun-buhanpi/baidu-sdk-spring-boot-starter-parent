package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.machinetranslation.Machinetranslation;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduMachineTranslationConfigurationProperties;
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
public class BaiduMachineTranslationSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.machine-translation", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(Machinetranslation.class)
    public Machinetranslation machinetranslation(BaiduMachineTranslationConfigurationProperties properties) {
        return super.config(Machinetranslation.class, properties, "百度机器翻译配置：");
    }
}
