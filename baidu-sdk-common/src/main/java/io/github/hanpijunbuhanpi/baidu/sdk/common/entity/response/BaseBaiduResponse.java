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
    @JsonProperty("log_id")
    private String logId;
}
