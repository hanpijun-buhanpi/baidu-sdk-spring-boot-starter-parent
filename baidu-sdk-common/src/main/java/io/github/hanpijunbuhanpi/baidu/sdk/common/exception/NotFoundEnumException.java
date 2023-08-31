package io.github.hanpijunbuhanpi.baidu.sdk.common.exception;

/**
 * 找不到枚举值异常
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public class NotFoundEnumException extends RuntimeException {
    public NotFoundEnumException() {
        super("未知枚举值");
    }
    public NotFoundEnumException(String message) {
        super(message);
    }
    public NotFoundEnumException(Throwable throwable) {
        super("未知枚举值", throwable);
    }
    public NotFoundEnumException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
