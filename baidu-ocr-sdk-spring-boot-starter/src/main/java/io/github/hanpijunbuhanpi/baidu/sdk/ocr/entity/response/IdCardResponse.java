package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.IdCardInfo;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.IdCardWordsResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 身份证识别返回
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IdCardResponse extends IdCardInfo implements BaseBaiduResponse {
    /** 属性容器 */
    @JsonIgnore
    private final Map<String, Object> map = new HashMap<>(3);

    /**
     * 定位和识别结果
     */
    @JsonProperty("words_result")
    private IdCardWordsResult wordsResult;

    /**
     * 识别结果数，表示words_result的元素个数
     */
    @JsonProperty("words_result_num")
    private Integer wordsResultNum;
}
