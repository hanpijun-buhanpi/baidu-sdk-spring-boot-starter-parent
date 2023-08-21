package io.github.hanpijunbuhanpi.baidu.sdk.kg.config;

import com.baidu.aip.kg.AipKnowledgeGraphic;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.kg.config.property.BaiduKnowledgeGraphicConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度文知识图谱SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduKnowledgeGraphicConfigurationProperties.class})
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduKnowledgeGraphicSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度知识图谱客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度知识图谱客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.kg", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipKnowledgeGraphic.class)
    public AipKnowledgeGraphic aipKnowledgeGraphic(BaiduGlobalConfigurationProperties global, BaiduKnowledgeGraphicConfigurationProperties properties) {
        return super.init(global, properties, AipKnowledgeGraphic.class, "百度知识图谱配置：");
    }
}
