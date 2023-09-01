package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 顶点位置
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class VertexesLocation {
    /**
     * 水平坐标（坐标0点为左上角）
     */
    @JsonProperty("x")
    private Integer x;

    /**
     * 垂直坐标（坐标0点为左上角）
     */
    @JsonProperty("y")
    private Integer y;
}
