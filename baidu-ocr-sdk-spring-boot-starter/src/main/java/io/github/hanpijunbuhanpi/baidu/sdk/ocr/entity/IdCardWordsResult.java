package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 身份证识别定位和识别结果集合对象
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
@Data
public class IdCardWordsResult {
    /**
     * 住址
     */
    @JsonProperty("住址")
    private IdCardWords address;

    /**
     * 公民身份号码
     */
    @JsonProperty("公民身份号码")
    private IdCardWords idCardNumber;

    /**
     * 出生
     */
    @JsonProperty("出生")
    private IdCardWords birthday;

    /**
     * 姓名
     */
    @JsonProperty("姓名")
    private IdCardWords name;

    /**
     * 性别
     */
    @JsonProperty("性别")
    private IdCardWords gender;

    /**
     * 民族
     */
    @JsonProperty("民族")
    private IdCardWords nationality;

    /**
     * 签发机关
     */
    @JsonProperty("签发机关")
    private IdCardWords issueAuthority;

    /**
     * 签发日期
     */
    @JsonProperty("签发日期")
    private IdCardWords issueDate;

    /**
     * 失效日期
     */
    @JsonProperty("失效日期")
    private IdCardWords expireDate;
}
