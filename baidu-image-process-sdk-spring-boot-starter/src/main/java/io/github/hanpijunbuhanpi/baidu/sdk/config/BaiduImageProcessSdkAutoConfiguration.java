package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.imageprocess.AipImageProcess;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduImageProcessConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度图像增强SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduImageProcessConfigurationProperties.class})
public class BaiduImageProcessSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-process", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageProcess.class)
    public AipImageProcess aipImageProcess(BaiduImageProcessConfigurationProperties properties) {
        return super.config(AipImageProcess.class, properties, "百度图像增强配置：");
    }
}
