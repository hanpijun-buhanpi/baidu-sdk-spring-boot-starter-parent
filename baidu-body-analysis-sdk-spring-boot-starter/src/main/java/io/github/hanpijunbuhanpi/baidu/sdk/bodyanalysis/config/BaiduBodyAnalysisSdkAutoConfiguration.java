package io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.config;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.config.property.BaiduBodyAnalysisConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度人体分析SDK自动配置
 *
 * @author lyc
 * @since 2023/8/16 10:59
 */
@AutoConfiguration
@Import({BaiduBodyAnalysisConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduBodyAnalysisSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度人体分析客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度人体分析客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.body-analysis", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipBodyAnalysis.class)
    public AipBodyAnalysis aipBodyAnalysis(BaiduGlobalConfigurationProperties global, BaiduBodyAnalysisConfigurationProperties properties) {
        return super.init(global, properties, AipBodyAnalysis.class, "百度人体分析配置：");
    }
}
