package io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 身份证识别定位和识别结果集合对象
 *
 * @author lyc
 * @since 2023/8/21 14:07
 */
@Data
public class IdCardWordsResult {
    /**
     * 住址
     */
    @JsonProperty("住址")
    private Words address;

    /**
     * 公民身份号码
     */
    @JsonProperty("公民身份号码")
    private Words idCardNumber;

    /**
     * 出生
     */
    @JsonProperty("出生")
    private Words birthday;

    /**
     * 姓名
     */
    @JsonProperty("姓名")
    private Words name;

    /**
     * 性别
     */
    @JsonProperty("性别")
    private Words gender;

    /**
     * 民族
     */
    @JsonProperty("民族")
    private Words nationality;

    /**
     * 签发机关
     */
    @JsonProperty("签发机关")
    private Words issueAuthority;

    /**
     * 签发日期
     */
    @JsonProperty("签发日期")
    private Words issueDate;

    /**
     * 失效日期
     */
    @JsonProperty("失效日期")
    private Words expireDate;
}
