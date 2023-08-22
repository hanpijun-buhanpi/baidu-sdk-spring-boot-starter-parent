package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 身份证图片状态
 *
 * @author lyc
 * @since 2023/8/19 15:24
 */
public enum ImageStatus {
    /** 识别正常 */
    NORMAL("normal", "识别正常"),
    /** 身份证正反面颠倒 */
    REVERSED_SIDE("reversed_side", "身份证正反面颠倒"),
    /** 上传的图片中不包含身份证 */
    NON_IDCARD("non_idcard", "上传的图片中不包含身份证"),
    /** 身份证模糊 */
    BLURRED("blurred", "身份证模糊"),
    /** 其他类型证照 */
    OTHER_TYPE_CARD("other_type_card", "其他类型证照"),
    /** 身份证关键字段反光或过曝 */
    OVER_EXPOSURE("over_exposure", "身份证关键字段反光或过曝"),
    /** 身份证欠曝（亮度过低） */
    OVER_DARK("over_dark", "身份证欠曝（亮度过低）"),
    /** 未知状态 */
    UNKNOWN("unknown", "未知状态")
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

    ImageStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
