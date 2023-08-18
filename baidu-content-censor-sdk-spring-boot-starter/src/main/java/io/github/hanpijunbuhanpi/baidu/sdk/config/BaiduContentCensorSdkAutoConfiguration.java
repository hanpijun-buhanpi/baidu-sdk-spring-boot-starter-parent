package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.contentcensor.AipContentCensor;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduContentCensorConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度内容审核SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduContentCensorConfigurationProperties.class})
public class BaiduContentCensorSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.content-censor", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipContentCensor.class)
    public AipContentCensor aipContentCensor(BaiduContentCensorConfigurationProperties properties) {
        return super.config(AipContentCensor.class, properties, "百度内容审核配置：");
    }
}
