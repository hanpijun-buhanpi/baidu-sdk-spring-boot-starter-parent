package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 英文单字符识别粒度
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum EngGranularity {
    /** 按单词识别 */
    word("word", "按单词识别"),
    /** 按字母识别 */
    letter("letter", "按字母识别"),
    ;

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static EngGranularity parse(String value) {
        for (EngGranularity engGranularity : values()) {
            if (engGranularity.value.equals(value)) {
                return engGranularity;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    EngGranularity(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
