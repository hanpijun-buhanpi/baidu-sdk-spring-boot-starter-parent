package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 证件质量
 *
 * @author lyc
 * @since 2023/8/19 15:41
 */
@Data
public class CardQuality {
    /**
     * 是否清晰
     */
    @JsonProperty("IsClear")
    private Boolean isClear;

    /**
     * 是否边框/四角完整
     */
    @JsonProperty("IsComplete")
    private Boolean isComplete;

    /**
     * 是否头像、关键字段无遮挡/马赛克
     */
    @JsonProperty("IsNoCover")
    private Boolean isNoCover;

    /**
     * 清晰概率，值在0-1之间，值越大表示图像质量越好
     */
    @JsonProperty("IsComplete_propobility")
    private Double isCompletePropobility;

    /**
     * 边框/四角完整概率，值在0-1之间，值越大表示图像质量越好
     */
    @JsonProperty("IsClear_propobility")
    private Double isClearPropobility;

    /**
     * 头像、关键字段无遮挡/马赛克，值在0-1之间，值越大表示图像质量越好
     */
    @JsonProperty("IsNoCover_propobility")
    private Double isNoCoverPropobility;
}
