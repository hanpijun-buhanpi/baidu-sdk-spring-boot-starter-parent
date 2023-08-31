package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 身份证识别请求
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdCardRequest {
    /**
     * <pre>
     * 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)检测功能，默认不开启，即：false。
     * - true：开启，请查看返回参数risk_type；
     * - false：不开启
     * </pre>
     */
    @JsonProperty("detect_risk")
    private Boolean detectRisk;

    /**
     * <pre>
     * 是否开启身份证质量类型(边框/四角不完整、头像或关键字段被遮挡/马赛克)检测功能，默认不开启，即：false。
     * - true：开启，请查看返回参数card_quality；
     * - false：不开启
     * </pre>
     */
    @JsonProperty("detect_quality")
    private Boolean detectQuality;

    /**
     * 是否检测头像内容，默认不检测。可选值：true-检测头像并返回头像的 base64 编码及位置信息
     */
    @JsonProperty("detect_photo")
    private Boolean detectPhoto;

    /**
     * 是否检测身份证进行裁剪，默认不检测。可选值：true-检测身份证并返回证照的 base64 编码及位置信息
     */
    @JsonProperty("detect_card")
    private Boolean detectCard;

    /**
     * <pre>
     * 是否检测上传的身份证图片方向，默认不检测。可选值：
     * -true：检测
     * - false：不检测
     * </pre>
     */
    @JsonProperty("detect_direction")
    private Boolean detectDirection;
}
