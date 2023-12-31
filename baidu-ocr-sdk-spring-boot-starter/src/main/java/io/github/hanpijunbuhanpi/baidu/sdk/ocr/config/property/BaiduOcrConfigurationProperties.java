package io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property;

import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaseBaiduConfigurationProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度文字识别配置
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.ocr")
public class BaiduOcrConfigurationProperties extends BaseBaiduConfigurationProperties {
    /**
     * AES密钥
     * @since 2.1
     */
    private String aesKey = null;
}
