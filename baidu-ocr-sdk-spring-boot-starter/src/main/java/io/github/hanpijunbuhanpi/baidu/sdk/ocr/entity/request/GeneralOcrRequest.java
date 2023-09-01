package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.LanguageType;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.OcrGranularity;
import lombok.*;

/**
 * 通用文字识别请求
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GeneralOcrRequest {
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
     * 下面仅限通用文字识别（高精度版）、通用文字识别（高精度含位置版）使用
     * - auto_detect：自动检测语言，并识别
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
    private LanguageType languageType;

    /**
     * <pre>
     * 表示识别语言类型为「中英文（CHN_ENG）」的情况下，英文的单字符结果是按照单词（word）维度输出还是字母（letter）维度输出，当 recognize_granularity=small 时生效
     * 注：仅限通用文字识别（高精度含位置版）使用
     * </pre>
     */
    @JsonProperty("eng_granularity")
    private OcrGranularity.Eng engGranularity;

    /**
     * <pre>
     * 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     * 注：仅限通用文字识别（标准含位置版）、通用文字识别（高精度含位置版）使用
     * </pre>
     */
    @JsonProperty("recognize_granularity")
    private OcrGranularity.Recognize recognizeGranularity;

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
     * 注：仅限通用文字识别（标准版）、通用文字识别（标准含位置版）使用
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
     * <pre>
     * 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     * 注：仅限通用文字识别（标准含位置版）、通用文字识别（高精度含位置版）使用
     * </pre>
     */
    @JsonProperty("vertexes_location")
    private Boolean vertexesLocation;

    /**
     * 构建通用文字识别（标准版）请求
     *
     * @param languageType 识别语言类型
     * @param detectDirection 是否检测图像朝向
     * @param detectLanguage 是否检测语言
     * @param paragraph 是否输出段落信息
     * @param probability 是否返回识别结果中每一行的置信度
     * @return 通用文字识别（标准版）请求
     *
     * @since 2.2
     */
    public static GeneralOcrRequest buildGeneralBasicRequest(
            LanguageType languageType, Boolean detectDirection, Boolean detectLanguage, Boolean paragraph,
            Boolean probability) {
        return GeneralOcrRequest.builder()
                .languageType(languageType)
                .detectDirection(detectDirection)
                .detectLanguage(detectLanguage)
                .paragraph(paragraph)
                .probability(probability)
                .build();
    }

    /**
     * 构建通用文字识别（标准含位置版）请求
     *
     * @param languageType 识别语言类型
     * @param recognizeGranularity 是否定位单字符位置
     * @param detectDirection 是否检测图像朝向
     * @param detectLanguage 是否检测语言
     * @param paragraph 是否输出段落信息
     * @param probability 是否返回识别结果中每一行的置信度
     * @param vertexesLocation 是否返回文字外接多边形顶点位置，不支持单字位置
     * @return 通用文字识别（标准含位置版）请求
     *
     * @since 2.2
     */
    public static GeneralOcrRequest buildGeneralRequest(
            LanguageType languageType, OcrGranularity.Recognize recognizeGranularity, Boolean detectDirection,
            Boolean detectLanguage, Boolean paragraph, Boolean probability, Boolean vertexesLocation) {
        return GeneralOcrRequest.builder()
                .languageType(languageType)
                .recognizeGranularity(recognizeGranularity)
                .detectDirection(detectDirection)
                .detectLanguage(detectLanguage)
                .paragraph(paragraph)
                .probability(probability)
                .vertexesLocation(vertexesLocation)
                .build();
    }

    /**
     * 构建通用文字识别（高精度版）请求
     *
     * @param languageType 识别语言类型
     * @param detectDirection 是否检测图像朝向
     * @param paragraph 是否输出段落信息
     * @param probability 是否返回识别结果中每一行的置信度
     * @return 通用文字识别（高精度版）请求
     *
     * @since 2.2
     */
    public static GeneralOcrRequest buildAccurateBasicRequest(
            LanguageType languageType, Boolean detectDirection, Boolean paragraph, Boolean probability) {
        return GeneralOcrRequest.builder()
                .languageType(languageType)
                .detectDirection(detectDirection)
                .paragraph(paragraph)
                .probability(probability)
                .build();
    }

    /**
     * 构建通用文字识别（高精度含位置版）请求
     *
     * @param languageType 识别语言类型
     * @param recognizeGranularity 是否定位单字符位置
     * @param detectDirection 是否检测图像朝向
     * @param paragraph 是否输出段落信息
     * @param probability 是否返回识别结果中每一行的置信度
     * @param vertexesLocation 是否返回文字外接多边形顶点位置，不支持单字位置
     * @return 通用文字识别（高精度含位置版）请求
     *
     * @since 2.2
     */
    public static GeneralOcrRequest buildAccurateRequest(
            LanguageType languageType, OcrGranularity.Eng engGranularity, OcrGranularity.Recognize recognizeGranularity,
            Boolean detectDirection, Boolean paragraph, Boolean probability, Boolean vertexesLocation) {
        return GeneralOcrRequest.builder()
                .languageType(languageType)
                .engGranularity(engGranularity)
                .recognizeGranularity(recognizeGranularity)
                .detectDirection(detectDirection)
                .paragraph(paragraph)
                .probability(probability)
                .vertexesLocation(vertexesLocation)
                .build();
    }
}
