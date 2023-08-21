package io.github.hanpijunbuhanpi.baidu.sdk.face.config;

import com.baidu.aip.face.AipFace;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.BaseBaiduSdkAutoConfiguration;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.face.config.property.BaiduFaceConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.face.service.BaiduFace;
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
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduFaceSdkAutoConfiguration extends BaseBaiduSdkAutoConfiguration {
    /**
     * 百度人脸识别客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @return 百度人脸识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.face", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean(AipFace.class)
    public AipFace aipFace(BaiduGlobalConfigurationProperties global, BaiduFaceConfigurationProperties properties) {
        return super.init(global, properties, AipFace.class, "百度人脸识别配置：");
    }

    /**
     * 百度SDK Starter人脸识别客户端
     *
     * @return 百度SDK Starter人脸识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.face", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({BaiduFace.class})
    public BaiduFace baiduFace() {
        return new BaiduFace();
    }
}
