package io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.config.property;

import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaseBaiduConfigurationProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度人体分析配置
 *
 * @author lyc
 * @since 2023/8/16 11:00
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.body-analysis")
public class BaiduBodyAnalysisConfigurationProperties extends BaseBaiduConfigurationProperties {

}
