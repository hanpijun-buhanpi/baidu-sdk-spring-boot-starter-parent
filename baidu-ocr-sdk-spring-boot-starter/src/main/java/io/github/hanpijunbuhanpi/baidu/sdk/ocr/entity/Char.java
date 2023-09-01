package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 单字符结果
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class Char {
    /**
     * 单字符识别结果，当 recognize_granularity=small 时返回该字段
     */
    @JsonProperty("char")
    private Character character;

    /**
     * 位置数组（坐标0点为左上角）
     */
    @JsonProperty("location")
    private Location location;
}
