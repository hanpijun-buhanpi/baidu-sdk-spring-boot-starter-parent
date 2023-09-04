package io.github.hanpijunbuhanpi.baidu.sdk.common.config.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度全局配置
 *
 * @author hanpijun-buhanpi
 * @since 2.2.1
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Configuration
@ConfigurationProperties(prefix = "baidu-sdk.global")
public class BaiduGlobalConfigurationProperties extends BaseBaiduConfigurationProperties {
    /**
     * 日志打印内容
     */
    private Log log = Log.no;
    public enum Log {
        /** 不打印日志 */
        no,
        /** 信息（入参和返回） */
        info,
        /** 运行耗时 */
        runtime,
        /** 信息和运行耗时 */
        info_runtime
    }
    /**
     * 日志打印语言
     */
    private LogLanguage logLanguage = LogLanguage.zh_cn;
    public enum LogLanguage {
        /** 中文 */
        zh_cn("百度SDK客户端 - 请求: 接口: {}, 请求参数: {}",
                "百度SDK客户端 - 返回: 接口: {}, 返回结果: {}",
                "百度SDK客户端 - 执行耗时: 接口: {}, 耗时: {}ms"),
        /** 英文 */
        en_us("Baidu SDK Client - request: api: {}, parameter: {}",
                "Baidu SDK Client - return: api: {}, result: {}",
                "Baidu SDK Client - runtime: api: {}, run time: {}ms")
        ;

        /** 参数打印语句 */
        @Getter
        private final String parameter;

        /** 结果打印语句 */
        @Getter
        private final String result;

        /** 耗时打印语句 */
        @Getter
        private final String runtime;

        LogLanguage(String parameter, String result, String runtime) {
            this.parameter = parameter;
            this.result = result;
            this.runtime = runtime;
        }
    }
}
