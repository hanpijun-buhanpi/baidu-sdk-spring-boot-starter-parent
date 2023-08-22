package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.MultiIdCardWordsResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 身份证混贴识别返回（同时识别正反面）
 *
 * @author lyc
 * @since 2023/8/21 16:52
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MultiIdCardResponse extends BaseBaiduResponse {
    /**
     * 定位和识别结果数组
     */
    @JsonProperty("words_result")
    private List<MultiIdCardWordsResult> wordsResult;
}
