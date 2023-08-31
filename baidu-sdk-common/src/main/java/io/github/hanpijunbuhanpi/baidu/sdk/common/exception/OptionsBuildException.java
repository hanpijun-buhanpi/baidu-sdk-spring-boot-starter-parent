package io.github.hanpijunbuhanpi.baidu.sdk.common.exception;

/**
 * 可选项构建异常
 *
 * @author hanpijun-buhanpi
 * @since 2.0
 */
public class OptionsBuildException extends RuntimeException {
    public OptionsBuildException() {

    }
    public OptionsBuildException(String message) {
        super(message);
    }
    public OptionsBuildException(Throwable throwable) {
        super(throwable);
    }
    public OptionsBuildException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
