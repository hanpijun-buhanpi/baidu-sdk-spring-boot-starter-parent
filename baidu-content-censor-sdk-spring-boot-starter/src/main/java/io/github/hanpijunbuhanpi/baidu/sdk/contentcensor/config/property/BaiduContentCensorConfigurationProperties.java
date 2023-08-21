package io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.config.property;

import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaseBaiduConfigurationProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度内容审核配置
 *
 * @author lyc
 * @since 2023/8/15 11:11
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.content-censor")
public class BaiduContentCensorConfigurationProperties extends BaseBaiduConfigurationProperties {

}
