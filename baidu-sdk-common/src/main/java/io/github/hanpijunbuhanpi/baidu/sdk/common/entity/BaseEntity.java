package io.github.hanpijunbuhanpi.baidu.sdk.common.entity;

import java.util.Map;

/**
 * 基础实体类
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public interface BaseEntity {
    /**
     * 获取属性容器
     *
     * @return 属性容器Map
     */
    Map<String, Object> getMap();

    /**
     * 获取值
     *
     * @param key 属性键
     * @param clazz 类型
     * @return 值
     * @param <T> 类型
     */
    default <T> T getValue(String key, Class<T> clazz) {
        Object o = getMap().get(key);
        return o == null ? null : (T) o;
    }
}
