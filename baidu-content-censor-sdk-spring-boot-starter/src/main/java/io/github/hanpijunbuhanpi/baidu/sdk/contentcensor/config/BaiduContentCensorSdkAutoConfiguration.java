package io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.config;

import com.baidu.aip.contentcensor.AipContentCensor;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.config.property.BaiduContentCensorConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.service.BaiduContentCensor;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduContentCensorSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度内容审核客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度内容审核客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.content-censor", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipContentCensor.class)
    public AipContentCensor aipContentCensor(BaiduGlobalConfigurationProperties global, BaiduContentCensorConfigurationProperties properties) {
        return super.init(global, properties, AipContentCensor.class, "百度内容审核配置：");
    }

    /**
     * 百度SDK Starter内容审核客户端
     *
     * @return 百度SDK Starter内容审核客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.content-censor", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduContentCensor.class})
    public BaiduContentCensor baiduContentCensor() {
        return new BaiduContentCensor();
    }
}
