package io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.config;

import com.baidu.aip.imageprocess.AipImageProcess;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.config.property.BaiduImageProcessConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.service.BaiduImageProcess;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduImageProcessSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度图像增强客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度图像增强客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-process", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageProcess.class)
    public AipImageProcess aipImageProcess(BaiduGlobalConfigurationProperties global, BaiduImageProcessConfigurationProperties properties) {
        return super.init(global, properties, AipImageProcess.class, "百度图像增强配置：");
    }

    /**
     * 百度SDK Starter图像增强客户端
     *
     * @return 百度SDK Starter图像增强客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-process", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduImageProcess.class})
    public BaiduImageProcess baiduImageProcess() {
        return new BaiduImageProcess();
    }
}
