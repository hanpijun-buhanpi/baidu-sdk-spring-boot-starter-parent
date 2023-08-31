package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.MultiIdCardWordsResult;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 身份证混贴识别返回（同时识别正反面）
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
public class MultiIdCardResponse implements BaseBaiduResponse {
    /** 属性容器 */
    @JsonIgnore
    private final Map<String, Object> map = new HashMap<>(3);

    /**
     * 定位和识别结果数组
     */
    @JsonProperty("words_result")
    private List<MultiIdCardWordsResult> wordsResult;
}
