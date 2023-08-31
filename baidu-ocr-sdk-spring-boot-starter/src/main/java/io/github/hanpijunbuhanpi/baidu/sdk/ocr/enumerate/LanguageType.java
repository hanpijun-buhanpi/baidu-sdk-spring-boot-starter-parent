package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 语言类型
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum LanguageType {
    /** 中英文混合 */
    CHN_ENG("CHN_ENG", "中英文混合"),
    /** 英文 */
    ENG("ENG", "英文"),
    /** 日语 */
    JAP("JAP", "日语"),
    /** 韩语 */
    KOR("KOR", "韩语"),
    /** 法语 */
    FRE("FRE", "法语"),
    /** 西班牙语 */
    SPA("SPA", "西班牙语"),
    /** 葡萄牙语 */
    POR("POR", "葡萄牙语"),
    /** 德语 */
    GER("GER", "德语"),
    /** 意大利语 */
    ITA("ITA", "意大利语"),
    /** 俄语 */
    RUS("RUS", "俄语")
    ;

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static LanguageType parse(String value) {
        for (LanguageType languageType : values()) {
            if (languageType.value.equals(value)) {
                return languageType;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    LanguageType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
