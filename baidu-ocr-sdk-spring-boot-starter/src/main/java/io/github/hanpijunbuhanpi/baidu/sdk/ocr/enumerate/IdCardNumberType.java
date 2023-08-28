package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 身份证对应关系
 *
 * @author lyc
 * @since 2023/8/19 15:53
 */
public enum IdCardNumberType {
    /**
     * 用于校验身份证号码、性别、出生是否一致，输出结果及其对应关系如下：
     * -1： 身份证正面所有字段全为空
     * 0： 身份证证号不合法，此情况下不返回身份证证号
     * 1： 身份证证号和性别、出生信息一致
     * 2： 身份证证号和性别、出生信息都不一致
     * 3： 身份证证号和出生信息不一致
     * 4： 身份证证号和性别信息不一致
     */
    ALL_NULL(-1, "身份证正面所有字段全为空"),
    ID_CARD_NUMBER_ILLEGALITY(0, "身份证证号不合法，此情况下不返回身份证证号"),
    NORMAL(1, "身份证证号和性别、出生信息一致"),
    GENDER_BIRTHDAY_INCONSISTENT(2, "身份证证号和性别、出生信息都不一致"),
    BIRTHDAY_INCONSISTENT(3, "身份证证号和出生信息不一致"),
    GENDER_INCONSISTENT(4, "身份证证号和性别信息不一致"),
    ;

    /**
     * value
     */
    @JsonValue
    public final int value;

    @JsonCreator
    public static IdCardNumberType parse(int value) {
        for (IdCardNumberType idCardNumberType : values()) {
            if (idCardNumberType.value == value) {
                return idCardNumberType;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    IdCardNumberType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
