package io.github.hanpijunbuhanpi.baidu.sdk.common.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.OptionsBuildException;
import io.github.hanpijunbuhanpi.baidu.sdk.common.exception.ResponseBuildException;
import io.github.hanpijunbuhanpi.baidu.sdk.common.service.BaiduBeanService;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 百度Bean服务实现类
 *
 * @author lyc
 * @since 2023/8/18 18:42
 */
public class BaiduBeanServiceJacksonImpl implements BaiduBeanService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 构建可选项
     *
     * @param request 请求对象
     * @return 可选项
     */
    @Override
    public HashMap<String, String> buildStringOptions(Object request) {
        try {
            String json = objectMapper.writeValueAsString(request);
            return objectMapper.readValue(json, new TypeReference<HashMap<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new OptionsBuildException(e);
        }
    }

    /**
     * 构建可选项
     *
     * @param request 请求对象
     * @return 可选项
     */
    @Override
    public HashMap<String, Object> buildObjectOptions(Object request) {
        try {
            String json = objectMapper.writeValueAsString(request);
            return objectMapper.readValue(json, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new OptionsBuildException(e);
        }
    }

    /**
     * 构建返回
     *
     * @param jsonObject 百度客户端返回的JSON对象
     * @param type       构建的类型
     * @return 返回
     */
    @Override
    public <T> T buildResponse(JSONObject jsonObject, Class<T> type) {
        try {
            return objectMapper.readValue(jsonObject.toString(), type);
        } catch (JsonProcessingException e) {
            throw new ResponseBuildException(e);
        }
    }
}
