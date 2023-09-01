package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 粒度
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum Granularity {
    /** 粗粒度 */
    big("big", "粗粒度"),
    /** 细粒度 */
    small("small", "细粒度"),
    ;

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static Granularity parse(String value) {
        for (Granularity granularity : values()) {
            if (granularity.value.equals(value)) {
                return granularity;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    Granularity(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
