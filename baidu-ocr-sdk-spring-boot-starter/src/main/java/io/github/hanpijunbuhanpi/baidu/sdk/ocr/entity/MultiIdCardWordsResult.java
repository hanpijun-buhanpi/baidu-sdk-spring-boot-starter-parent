package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 混贴身份证识别定位和识别结果集合对象
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
public class MultiIdCardWordsResult {
    /**
     * 识别结果信息，包含身份证的位置信息、风险检测信息、质量检测信息、正反面信息、方向信息
     */
    @JsonProperty("card_info")
    private IdCardInfo cardInfo;

    /**
     * 定位和识别结果
     */
    @JsonProperty("card_result")
    private IdCardWordsResult cardResult;
}
