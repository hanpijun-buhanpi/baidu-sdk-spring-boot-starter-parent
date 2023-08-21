package io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础百度返回
 *
 * @author lyc
 * @since 2023/8/18 18:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseBaiduResponse {
    /**
     * 唯一的log id，用于问题定位
     */
    @JsonProperty("log_id")
    private Long logId;

    /**
     * 错误码
     */
    @JsonProperty("error_code")
    private Integer errorCode;

    /**
     * 错误描述信息，帮助理解和解决发生的错误
     */
    @JsonProperty("error_msg")
    private String errorMsg;
}
