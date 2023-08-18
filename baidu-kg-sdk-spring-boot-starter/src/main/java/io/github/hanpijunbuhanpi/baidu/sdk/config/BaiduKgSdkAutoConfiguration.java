package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.kg.AipKnowledgeGraphic;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduKgConfigurationProperties;
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
@Import({BaiduKgConfigurationProperties.class})
public class BaiduKgSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.kg", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipKnowledgeGraphic.class)
    public AipKnowledgeGraphic aipKnowledgeGraphic(BaiduKgConfigurationProperties properties) {
        return super.config(AipKnowledgeGraphic.class, properties, "百度知识图谱配置：");
    }
}
