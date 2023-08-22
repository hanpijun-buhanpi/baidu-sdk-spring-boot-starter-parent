package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 身份证类型
 *
 * @author lyc
 * @since 2023/8/21 17:34
 */
public enum IdCardType {
    /** 身份证正面（头像面） */
    IDCARD_FRONT("idcard_front", "身份证正面（头像面）"),
    /** 身份证反面（国徽面） */
    IDCARD_BACK("idcard_back", "身份证反面（国徽面）"),
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

    IdCardType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
