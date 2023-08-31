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
    @JsonProperty("words_result_idx")
    private List<Integer> wordsResultIdx;
}
