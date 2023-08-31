package io.github.hanpijunbuhanpi.baidu.sdk.common.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.hanpijunbuhanpi.baidu.sdk.common.entity.BaseEntity;

/**
 * 基础百度返回
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public interface BaseBaiduResponse extends BaseEntity {
    /** log_id */
    String LOG_ID = "log_id";
    /** 错误码 */
    String ERROR_CODE = "error_code";
    /** 错误描述信息，帮助理解和解决发生的错误 */
    String ERROR_MSG = "error_msg";

    /**
     * 唯一的log id，用于问题定位
     *
     * @return log_id
     */
    @JsonProperty(LOG_ID)
    default Long getLogId() {
        return getValue(LOG_ID, Long.class);
    }

    /**
     * 唯一的log id，用于问题定位
     *
     * @param logId log_id
     */
    @JsonProperty(LOG_ID)
    default void setLogId(long logId) {
        getMap().put(LOG_ID, logId);
    }

    /**
     * 错误码
     *
     * @return 错误码
     */
    @JsonProperty(ERROR_CODE)
    default String getErrorCode() {
        return getValue(ERROR_CODE, String.class);
    }

    /**
     * 错误码
     *
     * @param errorCode 错误码
     */
    @JsonProperty(ERROR_CODE)
    default void setErrorCode(String errorCode) {
        getMap().put(ERROR_CODE, errorCode);
    }

    /**
     * 错误描述信息，帮助理解和解决发生的错误
     *
     * @return 错误描述信息
     */
    @JsonProperty(ERROR_MSG)
    default String getErrorMsg() {
        return getValue(ERROR_MSG, String.class);
    }

    /**
     * 错误描述信息，帮助理解和解决发生的错误
     *
     * @param errorMsg 错误描述信息
     */
    @JsonProperty(ERROR_MSG)
    default void setErrorMsg(String errorMsg) {
        getMap().put(ERROR_MSG, errorMsg);
    }
}
