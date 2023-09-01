package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 段落检测结果
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class Paragraphs {
    /**
     * 一个段落包含的行序号，当 paragraph=true 时返回该字段
     */
    @JsonProperty("words_result_idx")
    private List<Integer> wordsResultIdx;

    /**
     * <pre>
     * 识别结果中每一行的多边形轮廓点坐标，当 vertexes_location=true 时返回该字段
     * 注：仅限通用文件识别（标准含位置版）、通用文字识别（高精度含位置版）返回
     * </pre>
     */
    @JsonProperty("finegrained_vertexes_location")
    private List<VertexesLocation> finegrainedVertexesLocation;

    /**
     * <pre>
     * 表示 finegrained_poly_location对应的最小外包矩形点坐标，当 vertexes_location=true 时返回该字段
     * 注：仅限通用文件识别（标准含位置版）、通用文字识别（高精度含位置版）返回
     * </pre>
     */
    @JsonProperty("min_finegrained_vertexes_location")
    private List<VertexesLocation> minFinegrainedVertexesLocation;
}
