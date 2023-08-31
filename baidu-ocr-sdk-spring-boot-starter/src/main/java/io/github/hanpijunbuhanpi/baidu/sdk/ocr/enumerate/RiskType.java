package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 身份证风险类型
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
public enum RiskType {
    /** 正常身份证 */
    NORMAL("normal", "正常身份证"),
    /** 复印件 */
    COPY("copy", "复印件"),
    /** 临时身份证 */
    TEMPORARY("temporary", "临时身份证"),
    /** 翻拍 */
    SCREEN("screen", "翻拍"),
    /** 其他未知情况 */
    UNKNOWN("unknown", "其他未知情况")
    ;

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static RiskType parse(String value) {
        for (RiskType riskType : values()) {
            if (riskType.value.equals(value)) {
                return riskType;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    RiskType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
