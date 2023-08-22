package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 定位位置
 *
 * @author lyc
 * @since 2023/8/19 16:01
 */
@Data
public class Location {
    /**
     * 表示定位位置的长方形左上顶点的水平坐标
     */
    @JsonProperty("left")
    private Integer left;

    /**
     * 表示定位位置的长方形左上顶点的垂直坐标
     */
    @JsonProperty("top")
    private Integer top;

    /**
     * 表示定位位置的长方形的宽度
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * 表示定位位置的长方形的高度
     */
    @JsonProperty("height")
    private Integer height;
}
