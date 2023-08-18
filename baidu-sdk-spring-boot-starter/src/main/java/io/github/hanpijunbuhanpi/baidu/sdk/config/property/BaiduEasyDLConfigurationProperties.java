package io.github.hanpijunbuhanpi.baidu.sdk.config.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度EasyDL零门槛AI开发配置
 *
 * @author lyc
 * @since 2023/8/16 10:51
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.easy-dl")
public class BaiduEasyDLConfigurationProperties extends BaiduBaseConfigurationProperties {
}
