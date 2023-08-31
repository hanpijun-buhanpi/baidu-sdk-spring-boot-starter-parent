package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 通用文字识别置信度
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class Probability {
    /**
     * 行置信度平均值
     */
    @JsonProperty("average")
    private Double average;

    /**
     * 行置信度方差
     */
    @JsonProperty("variance")
    private Double variance;

    /**
     * 行置信度最小值
     */
    @JsonProperty("min")
    private Double min;
}
