package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.imageclassify.AipImageClassify;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduImageClassifyConfigurationProperties;
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
public class BaiduImageClassifySdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-classify", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageClassify.class)
    public AipImageClassify aipImageClassify(BaiduImageClassifyConfigurationProperties properties) {
        return super.config(AipImageClassify.class, properties, "百度图像识别配置：");
    }
}
