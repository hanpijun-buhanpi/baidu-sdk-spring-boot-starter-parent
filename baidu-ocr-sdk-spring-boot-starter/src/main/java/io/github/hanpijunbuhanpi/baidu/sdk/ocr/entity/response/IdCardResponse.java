package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.CardQuality;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response.BaseBaiduResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.IdCardWordsResult;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.Location;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.Direction;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.IdCardNumberType;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.ImageStatus;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.RiskType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 身份证识别返回
 *
 * @author lyc
 * @since 2023/8/21 14:02
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IdCardResponse extends BaseBaiduResponse {
    /**
     * <pre>
     * 图像方向，输入参数 detect_direction= true 时返回。
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
     * <pre>
     * normal-识别正常
     * reversed_side-身份证正反面颠倒
     * non_idcard-上传的图片中不包含身份证
     * blurred-身份证模糊
     * other_type_card-其他类型证照
     * over_exposure-身份证关键字段反光或过曝
     * over_dark-身份证欠曝（亮度过低）
     * unknown-未知状态
     * </pre>
     */
    @JsonProperty("image_status")
    private ImageStatus imageStatus;

    /**
     * 输入参数 detect_risk = true 时，则返回该字段识别身份证风险类型:
     * normal-正常身份证；
     * copy-复印件；
     * temporary-临时身份证；
     * screen-翻拍；
     * unknown-其他未知情况
     */
    @JsonProperty("risk_type")
    private RiskType riskType;

    /**
     * 如果参数 detect_risk = true 时，则返回此字段。如果检测身份证被编辑过，该字段指定编辑软件名称，如:Adobe Photoshop CC 2014 (Macintosh),如果没有被编辑过则返回值无此参数
     */
    @JsonProperty("edit_tool")
    private String editTool;

    /**
     * <pre>
     * 输入参数 detect_quality = true 时，则返回该字段识别身份证质量类型:
     * IsClear - 是否清晰；
     * IsComplete - 是否边框/四角完整；
     * IsNoCover - 是否头像、关键字段无遮挡/马赛克。
     * 及对应的概率：IsComplete_propobility、IsClear_propobility、IsNoCover_propobility，值在0-1之间，值越大表示图像质量越好。
     * 默认阈值（仅为推荐值，建议按照实际业务场景，基于图片返回的具体概率值，自定义设置判断阈值）：当 IsClear_propobility、IsComplete_propobility 超过0.5时，对应IsClear、IsComplete 返回1，低于0.5，则返回0；
     * 当 IsNoCover_propobility 超过0.3时，对应IsNoCover 返回1，低于0.3，则返回0
     * </pre>
     */
    @JsonProperty("card_quality")
    private CardQuality cardQuality;

    /**
     * 当请求参数 detect_photo = true时返回，头像切图的 base64 编码（无编码头，需自行处理）
     */
    @JsonProperty("photo")
    private String photo;

    /**
     * 当请求参数 detect_photo = true时返回，头像的位置信息（坐标0点为左上角）
     */
    @JsonProperty("photo_location")
    private Location photoLocation;

    /**
     * 当请求参数 detect_card = true时返回，身份证裁剪切图的 base64 编码（无编码头，需自行处理）
     */
    @JsonProperty("card_image")
    private String cardImage;

    /**
     * 当请求参数 detect_card = true时返回，身份证裁剪切图的位置信息（坐标0点为左上角）
     */
    @JsonProperty("card_location")
    private Location cardLocation;

    /**
     * <pre>
     * 用于校验身份证号码、性别、出生是否一致，输出结果及其对应关系如下：
     * - 1： 身份证正面所有字段全为空
     * 0： 身份证证号不合法，此情况下不返回身份证证号
     * 1： 身份证证号和性别、出生信息一致
     * 2： 身份证证号和性别、出生信息都不一致
     * 3： 身份证证号和出生信息不一致
     * 4： 身份证证号和性别信息不一致
     * </pre>
     */
    @JsonProperty("idcard_number_type")
    private IdCardNumberType idcardNumberType;

    /**
     * 定位和识别结果
     */
    @JsonProperty("words_result")
    private IdCardWordsResult wordsResult;

    /**
     * 识别结果数，表示words_result的元素个数
     */
    @JsonProperty("words_result_num")
    private Integer wordsResultNum;
}
