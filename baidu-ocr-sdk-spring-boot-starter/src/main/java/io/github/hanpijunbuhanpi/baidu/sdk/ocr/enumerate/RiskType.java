package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 身份证风险类型
 *
 * @author lyc
 * @since 2023/8/19 15:36
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

    /**
     * 描述
     */
    public final String desc;

    RiskType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
