package io.github.hanpijunbuhanpi.baidu.sdk.imagesearch.config;

import com.baidu.aip.imagesearch.AipImageSearch;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imagesearch.config.property.BaiduImageSearchConfigurationProperties;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduImageSearchSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度图像搜索客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度图像搜索客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-search", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipImageSearch.class)
    public AipImageSearch aipImageSearch(BaiduGlobalConfigurationProperties global, BaiduImageSearchConfigurationProperties properties) {
        return super.init(global, properties, AipImageSearch.class, "百度图像搜索配置：");
    }
}
