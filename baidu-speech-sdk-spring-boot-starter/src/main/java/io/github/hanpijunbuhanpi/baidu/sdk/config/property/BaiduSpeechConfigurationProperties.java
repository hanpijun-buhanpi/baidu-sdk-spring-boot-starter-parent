package io.github.hanpijunbuhanpi.baidu.sdk.config.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度语音技术配置
 *
 * @author lyc
 * @since 2023/8/15 11:11
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.speech")
public class BaiduSpeechConfigurationProperties extends BaiduBaseConfigurationProperties {

}
