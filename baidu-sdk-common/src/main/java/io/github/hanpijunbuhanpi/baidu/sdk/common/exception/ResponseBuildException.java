package io.github.hanpijunbuhanpi.baidu.sdk.common.exception;

/**
 * 返回构建失败
 *
 * @author hanpijun-buhanpi
 * @since 2.0
 */
public class ResponseBuildException extends RuntimeException{
    public ResponseBuildException() {

    }
    public ResponseBuildException(String message) {
        super(message);
    }
    public ResponseBuildException(Throwable throwable) {
        super(throwable);
    }
    public ResponseBuildException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
