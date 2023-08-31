package com.baidu.aip.error;

import org.json.JSONObject;

/**
 * 百度AipError扩展
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public enum AipErrorExtend {
    /**
     * PDF文件读取错误
     * @since 2.2
     */
    PDF_READ_ERROR("STARTER100", "read pdf file error"),
    /**
     * OFD文件读取错误
     * @since 2.2
     */
    OFD_READ_ERROR("STARTER101", "read ofd file error")
    ;

    private final String errorCode;
    private final String errorMsg;

    AipErrorExtend(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMsg;
    }

    public JSONObject toJsonResult() {
        JSONObject json = new JSONObject();
        json.put("error_code", errorCode);
        json.put("error_msg", errorMsg);
        return json;
    }

    @Override
    public String toString() {
        return toJsonResult().toString();
    }
}
