package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 识别结果
 *
 * @author lyc
 * @since 2023/8/19 16:04
 */
@Data
public class Words {
    /**
     * 定位位置
     */
    @JsonProperty("location")
    private Location location;

    /**
     * 识别结果
     */
    @JsonProperty("words")
    private String words;
}
