package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.GeneralBasicLanguageType;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Granularity;
import lombok.*;

/**
 * 通用文字识别（含位置信息版）请求
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralRequest {
    /**
     * 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     */
    @JsonProperty("recognize_granularity")
    private Granularity recognizeGranularity;

    /**
     * <pre>
     * 识别语言类型，默认为CHN_ENG
     * 可选值包括：
     * - CHN_ENG：中英文混合
     * - ENG：英文
     * - JAP：日语
     * - KOR：韩语
     * - FRE：法语
     * - SPA：西班牙语
     * - POR：葡萄牙语
     * - GER：德语
     * - ITA：意大利语
     * - RUS：俄语
     * </pre>
     */
    @JsonProperty("language_type")
    private GeneralBasicLanguageType languageType;

    /**
     * <pre>
     * 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:
     * - true：检测朝向；
     * - false：不检测朝向。
     * </pre>
     */
    @JsonProperty("detect_direction")
    private Boolean detectDirection;

    /**
     * <pre>
     * 是否检测语言，默认不检测，即：false。当前支持中文、英语、日语、韩语
     * </pre>
     */
    @JsonProperty("detect_language")
    private Boolean detectLanguage;

    /**
     * <pre>
     * 是否输出段落信息
     * </pre>
     */
    @JsonProperty("paragraph")
    private Boolean paragraph;

    /**
     * <pre>
     * 是否返回识别结果中每一行的置信度
     * </pre>
     */
    @JsonProperty("probability")
    private Boolean probability;

    /**
     * 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     */
    @JsonProperty("vertexes_location")
    private Boolean vertexesLocation;
}
