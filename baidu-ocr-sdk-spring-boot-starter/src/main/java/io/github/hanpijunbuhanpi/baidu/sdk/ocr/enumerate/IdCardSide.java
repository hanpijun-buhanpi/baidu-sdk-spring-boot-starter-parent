package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 身份证方面
 *
 * @author lyc
 * @since 2023/8/18 9:37
 */
public enum IdCardSide {
    /**
     * 身份证含照片的一面
     */
    FRONT("front", "身份证含照片的一面"),
    /**
     * 身份证带国徽的一面
     */
    BACK("back", "身份证带国徽的一面");

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static IdCardSide parse(String value) {
        for (IdCardSide idCardSide : values()) {
            if (idCardSide.value.equals(value)) {
                return idCardSide;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    IdCardSide(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
