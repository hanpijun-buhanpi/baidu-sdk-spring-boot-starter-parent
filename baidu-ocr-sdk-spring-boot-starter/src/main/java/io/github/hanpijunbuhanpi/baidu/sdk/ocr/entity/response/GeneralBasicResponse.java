package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Language;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通用文字识别（标准版）返回
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GeneralBasicResponse extends AccurateResponse implements BaseBaiduResponse {
    /**
     * <pre>
     * 语种类型，当 detect_language=true 时返回该字段。
     * - - 1：未定义，
     * - 0：英文，
     * - 1：日文，
     * - 2：韩文，
     * - 3：中文
     * </pre>
     */
    @JsonProperty("language")
    private Language language;
}
