package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 身份证识别结果
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
public class IdCardWords {
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
