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
public class ParagraphsResult {
    /**
     * 一个段落包含的行序号，当 paragraph=true 时返回该字段
     */
    @JsonProperty("words_result_idx")
    private List<Integer> wordsResultIdx;

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
