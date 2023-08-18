package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.imagesearch.AipImageSearch;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduImageSearchConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度图像搜索SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduImageSearchConfigurationProperties.class})
public class BaiduImageSearchSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-search", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageSearch.class)
    public AipImageSearch aipImageSearch(BaiduImageSearchConfigurationProperties properties) {
        return super.config(AipImageSearch.class, properties, "百度图像搜索配置：");
    }
}
