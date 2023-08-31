package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 语言枚举
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum Language {
    /** 未定义 */
    unknown(-1, "未定义"),
    /** 英文 */
    english(0, "英文"),
    /** 日文 */
    japanese(1, "日文"),
    /** 韩文 */
    korean(2, "韩文"),
    /** 中文 */
    chinese(3, "中文")
    ;

    /**
     * value
     */
    @JsonValue
    public final int value;

    @JsonCreator
    public static Language parse(int value) {
        for (Language language : values()) {
            if (language.value == value) {
                return language;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    Language(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
