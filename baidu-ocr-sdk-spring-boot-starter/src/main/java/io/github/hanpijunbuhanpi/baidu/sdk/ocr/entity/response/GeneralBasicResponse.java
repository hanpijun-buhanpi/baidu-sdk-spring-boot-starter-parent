package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.GeneralBasicWords;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.ParagraphsResult;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Direction;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Language;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用文字识别返回
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@Data
public class GeneralBasicResponse implements BaseBaiduResponse {
    /** 属性容器 */
    @JsonIgnore
    private final Map<String, Object> map = new HashMap<>(3);

    /**
     * <pre>
     * 图像方向，当 detect_direction=true 时返回该字段。
     * - - 1：未定义，
     * - 0：正向，
     * - 1：逆时针90度，
     * - 2：逆时针180度，
     * - 3：逆时针270度
     * </pre>
     */
    @JsonProperty("direction")
    private Direction direction;

    /**
     * 识别结果数组
     */
    @JsonProperty("words_result")
    private List<GeneralBasicWords> wordsResult;

    /**
     * 识别结果数，表示words_result的元素个数
     */
    @JsonProperty("words_result_num")
    private Integer wordsResultNum;

    /**
     * 段落检测结果，当 paragraph=true 时返回该字段
     */
    @JsonProperty("paragraphs_result")
    private List<ParagraphsResult> paragraphsResult;

    /**
     * 识别结果数，表示 paragraphs_result的元素个数，当 paragraph=true 时返回该字段
     */
    @JsonProperty("paragraphs_result_num")
    private Integer paragraphsResultNum;

    /**
     * <pre>
     * 语种类型，当 detect_language=true 时返回该字段。
     * - - 1：未定义，
     * - 0：英文，
     * - 1：日文，
     * - 2：韩文，
     * - 3：中文
     * </pre>
     */
    @JsonProperty("language")
    private Language language;

    /**
     * 传入PDF文件的总页数，当 pdf_file 参数有效时返回该字段
     */
    @JsonProperty("pdf_file_size")
    private Integer pdfFileSize;

    /**
     * 传入OFD文件的总页数，当 ofd_file 参数有效时返回该字段
     */
    @JsonProperty("ofd_file_size")
    private Integer ofdFileSize;
}
