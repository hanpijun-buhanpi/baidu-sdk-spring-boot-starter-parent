package io.github.hanpijunbuhanpi.baidu.sdk.common.config.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度全局配置
 *
 * @author hanpijun-buhanpi
 * @since 2.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.global")
public class BaiduGlobalConfigurationProperties extends BaseBaiduConfigurationProperties {

}
