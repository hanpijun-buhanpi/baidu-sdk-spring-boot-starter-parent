package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduBodyAnalysisConfigurationProperties;
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
public class BaiduBodyAnalysisSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.body-analysis", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipBodyAnalysis.class)
    public AipBodyAnalysis aipBodyAnalysis(BaiduBodyAnalysisConfigurationProperties properties) {
        return super.config(AipBodyAnalysis.class, properties, "百度人体分析配置：");
    }
}
