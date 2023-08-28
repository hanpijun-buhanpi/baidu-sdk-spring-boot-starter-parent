package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 方向
 *
 * @author lyc
 * @since 2023/8/19 15:17
 */
public enum Direction {
    /** -1 未定义 */
    UNDEFINED(-1, "未定义"),
    /** 0 正向 */
    FRONT(0, "正向"),
    /** 1 逆时针90度 */
    ANTICLOCKWISE90(1, "逆时针90度"),
    /** 2 逆时针180度 */
    ANTICLOCKWISE180(2, "逆时针180度"),
    /** 3 逆时针270度 */
    ANTICLOCKWISE270(3, "逆时针270度")
    ;

    /**
     * value
     */
    @JsonValue
    public final int value;

    @JsonCreator
    public static Direction parse(int value) {
        for (Direction direction : values()) {
            if (direction.value == value) {
                return direction;
            }
        }
        throw new NotFoundEnumException();
    }

    /**
     * 描述
     */
    public final String desc;

    Direction(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
