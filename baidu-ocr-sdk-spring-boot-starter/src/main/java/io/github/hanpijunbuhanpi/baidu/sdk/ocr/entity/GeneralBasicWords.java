package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 通用文字识别结果
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class GeneralBasicWords {
    /**
     * 识别结果中每一行的置信度值，包含average：行置信度平均值，variance：行置信度方差，min：行置信度最小值，当 probability=true 时返回该字段
     */
    @JsonProperty("probability")
    private Probability probability;

    /**
     * 识别结果字符串
     */
    @JsonProperty("words")
    private String words;
}
