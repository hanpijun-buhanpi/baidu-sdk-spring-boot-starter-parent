package io.github.hanpijunbuhanpi.baidu.sdk.easydl.config.property;

import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaseBaiduConfigurationProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度EasyDL零门槛AI开发配置
 *
 * @author lyc
 * @since 2023/8/15 11:11
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.easy-dl")
public class BaiduEasyDLConfigurationProperties extends BaseBaiduConfigurationProperties {

}
