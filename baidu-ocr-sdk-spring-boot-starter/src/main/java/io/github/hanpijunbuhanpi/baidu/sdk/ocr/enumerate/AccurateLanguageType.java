package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 通用文字识别（高精度版）识别语言类型
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum AccurateLanguageType {
    /** 自动检测语言，并识别 */
    AUTO_DETECT("auto_detect", "自动检测语言，并识别"),
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
    RUS("RUS", "俄语"),
    /** 丹麦语 */
    DAN("DAN", "丹麦语"),
    /** 荷兰语 */
    DUT("DUT", "荷兰语"),
    /** 马来语 */
    MAL("MAL", "马来语"),
    /** 瑞典语 */
    SWE("SWE", "瑞典语"),
    /** 印尼语 */
    IND("IND", "印尼语"),
    /** 波兰语 */
    POL("POL", "波兰语"),
    /** 罗马尼亚语 */
    ROM("ROM", "罗马尼亚语"),
    /** 土耳其语 */
    TUR("TUR", "土耳其语"),
    /** 希腊语 */
    GRE("GRE", "希腊语"),
    /** 匈牙利语 */
    HUN("HUN", "匈牙利语"),
    /** 泰语 */
    THA("THA", "泰语"),
    /** 越南语 */
    VIE("VIE", "越南语"),
    /** 阿拉伯语 */
    ARA("ARA", "阿拉伯语"),
    /** 印地语 */
    HIN("HIN", "印地语")
    ;

    /**
     * value
     */
    @JsonValue
    public final String value;

    @JsonCreator
    public static AccurateLanguageType parse(String value) {
        for (AccurateLanguageType accurateLanguageType : values()) {
            if (accurateLanguageType.value.equals(value)) {
                return accurateLanguageType;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    AccurateLanguageType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
