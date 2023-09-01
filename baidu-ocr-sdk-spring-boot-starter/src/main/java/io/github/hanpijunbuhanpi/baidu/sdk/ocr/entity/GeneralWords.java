package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 通用文字识别（含位置信息版）结果
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class GeneralWords {
    /**
     * 识别结果字符串
     */
    @JsonProperty("words")
    private String words;

    /**
     * 位置数组（坐标0点为左上角）
     */
    @JsonProperty("location")
    private Location location;

    /**
     * 单字符结果，当 recognize_granularity=small 时返回该字段
     */
    @JsonProperty("chars")
    private List<Char> chars;

    /**
     * 识别结果中每一行的置信度值，包含average：行置信度平均值，variance：行置信度方差，min：行置信度最小值，当 probability=true 时返回该字段
     */
    @JsonProperty("probability")
    private Probability probability;

    /**
     * 识别结果中每一行的外包四边形点坐标，当 vertexes_location=true 时返回该字段
     */
    @JsonProperty("vertexes_location")
    private List<VertexesLocation> vertexesLocation;

    /**
     * 识别结果中每一行的多边形轮廓点坐标，当 vertexes_location=true 时返回该字段
     */
    @JsonProperty("finegrained_vertexes_location")
    private List<VertexesLocation> finegrainedVertexesLocation;

    /**
     * min_finegrained_vertexes_location
     */
    @JsonProperty("min_finegrained_vertexes_location")
    private List<VertexesLocation> minFinegrainedVertexesLocation;
}
