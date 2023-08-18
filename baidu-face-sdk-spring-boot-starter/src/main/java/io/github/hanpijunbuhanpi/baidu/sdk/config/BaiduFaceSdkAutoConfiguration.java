package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.face.AipFace;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.BaiduFaceConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 百度人脸识别SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 11:26
 */
@AutoConfiguration
@Import({BaiduFaceConfigurationProperties.class})
public class BaiduFaceSdkAutoConfiguration extends BaiduSdkAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.face", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipFace.class)
    public AipFace aipFace(BaiduFaceConfigurationProperties properties) {
        return super.config(AipFace.class, properties, "百度人脸识别配置：");
    }
}
