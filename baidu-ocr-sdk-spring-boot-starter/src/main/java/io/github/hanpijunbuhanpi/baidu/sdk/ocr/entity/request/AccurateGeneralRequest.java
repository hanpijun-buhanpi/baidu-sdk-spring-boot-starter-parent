package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.AccurateLanguageType;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.EngGranularity;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Granularity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用文字识别（高精度含位置版）请求
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccurateGeneralRequest {
    /**
     * <pre>
     * 识别语言类型，默认为CHN_ENG
     * 可选值包括：
     * - auto_detect：自动检测语言，并识别
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
     * - DAN：丹麦语
     * - DUT：荷兰语
     * - MAL：马来语
     * - SWE：瑞典语
     * - IND：印尼语
     * - POL：波兰语
     * - ROM：罗马尼亚语
     * - TUR：土耳其语
     * - GRE：希腊语
     * - HUN：匈牙利语
     * - THA：泰语
     * - VIE：越南语
     * - ARA：阿拉伯语
     * - HIN：印地语
     * </pre>
     */
    @JsonProperty("language_type")
    private AccurateLanguageType languageType;

    /**
     * 表示识别语言类型为「中英文（CHN_ENG）」的情况下，英文的单字符结果是按照单词（word）维度输出还是字母（letter）维度输出，当 recognize_granularity=small 时生效
     */
    @JsonProperty("eng_granularity")
    private EngGranularity engGranularity;

    /**
     * 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     */
    @JsonProperty("recognize_granularity")
    private Granularity recognizeGranularity;

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
