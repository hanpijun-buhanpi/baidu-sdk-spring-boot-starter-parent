package io.github.hanpijunbuhanpi.baidu.sdk.common.service;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度Bean服务
 *
 * @author lyc
 * @since 2023/8/18 18:35
 */
public interface BaiduBeanService {
    /**
     * 构建可选项
     *
     * @param request 请求对象
     * @return 可选项
     */
    HashMap<String, String> buildStringOptions(Object request);

    /**
     * 构建可选项
     *
     * @param request 请求对象
     * @return 可选项
     */
    HashMap<String, Object> buildObjectOptions(Object request);

    /**
     * 构建返回
     *
     * @param jsonObject 百度客户端返回的JSON对象
     * @param type 构建的类型
     * @return 返回
     * @param <T> 构建的类型
     */
    <T> T buildResponse(JSONObject jsonObject, Class<T> type);
}
