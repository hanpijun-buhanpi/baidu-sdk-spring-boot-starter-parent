package io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.config;

import com.baidu.aip.imageclassify.AipImageClassify;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.config.property.BaiduImageClassifyConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.service.BaiduImageClassify;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度图像识别SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduImageClassifyConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduImageClassifySdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度图像识别客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度图像识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-classify", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageClassify.class)
    public AipImageClassify aipImageClassify(BaiduGlobalConfigurationProperties global, BaiduImageClassifyConfigurationProperties properties) {
        return super.init(global, properties, AipImageClassify.class, "百度图像识别配置：");
    }

    /**
     * 百度SDK Starter图像识别客户端
     *
     * @return 百度SDK Starter图像识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-classify", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduImageClassify.class})
    public BaiduImageClassify baiduImageClassify() {
        return new BaiduImageClassify();
    }
}
