package io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.NotFoundEnumException;

/**
 * 文字识别粒度
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public interface OcrGranularity {
    /**
     * 识别粒度
     */
    enum Recognize {
        /** 粗粒度 */
        big("big", "粗粒度"),
        /** 细粒度 */
        small("small", "细粒度"),
        ;

        /**
         * value
         */
        @JsonValue
        public final String value;

        @JsonCreator
        public static Recognize parse(String value) {
            for (Recognize recognize : values()) {
                if (recognize.value.equals(value)) {
                    return recognize;
                }
            }
            throw new NotFoundEnumException();
        }

        /**
         * 描述
         */
        public final String desc;

        Recognize(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }
    }

    /**
     * 英文单字符识别粒度
     */
    enum Eng {
        /** 按单词识别 */
        word("word", "按单词识别"),
        /** 按字母识别 */
        letter("letter", "按字母识别"),
        ;

        /**
         * value
         */
        @JsonValue
        public final String value;

        @JsonCreator
        public static Eng parse(String value) {
            for (Eng eng : values()) {
                if (eng.value.equals(value)) {
                    return eng;
                }
            }
            throw new NotFoundEnumException();
        }

        /**
         * 描述
         */
        public final String desc;

        Eng(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }
    }
}
