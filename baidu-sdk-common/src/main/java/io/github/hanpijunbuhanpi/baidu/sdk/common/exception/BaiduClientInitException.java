package io.github.hanpijunbuhanpi.baidu.sdk.common.exception;

/**
 * 百度客户端初始化异常
 *
 * @author lyc
 * @since 2.2
 */
public class BaiduClientInitException extends RuntimeException {
    public BaiduClientInitException() {

    }
    public BaiduClientInitException(String message) {
        super(message);
    }
    public BaiduClientInitException(Throwable throwable) {
        super(throwable);
    }
    public BaiduClientInitException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
