package io.github.hanpijunbuhanpi.baidu.sdk.ocr.service;

import com.baidu.aip.error.AipError;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import io.github.hanpijunbuhanpi.baidu.sdk.common.service.BaiduClient;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property.BaiduOcrConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.IdCardRequest;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.IdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.MultiIdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.IdCardSide;
import io.github.hanpijunbuhanpi.baidu.sdk.common.util.AesUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;

/**
 * 百度文字识别
 *
 * @author lyc
 * @since 2023/8/18 9:40
 */
public class BaiduOcr extends BaiduClient<AipOcr> {
    @Autowired
    private BaiduOcrConfigurationProperties ocrConfigurationProperties;

    /**
     * 身份证识别接口
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 二进制图像数据
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public IdCardResponse idcard(byte[] image, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.idcard(image, idCardSide.value, baiduBeanService.buildStringOptions(options)), IdCardResponse.class);
    }

    /**
     * 身份证识别接口
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 本地图片路径
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public IdCardResponse idcard(String image, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.idcard(image, idCardSide.value, baiduBeanService.buildStringOptions(options)), IdCardResponse.class);
    }

    /**
     * 身份证识别接口（AES加密版）
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 二进制图像数据
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public IdCardResponse idcardAes(byte[] image, IdCardSide idCardSide, IdCardRequest options) {
        // 加密图片
        String aesKey = ocrConfigurationProperties.getAesKey();
        byte[] bytes = AesUtil.ecbEncrypt(image, aesKey);
        // 添加可选项：使用AES加密
        HashMap<String, String> map = baiduBeanService.buildStringOptions(options);
        map.put("AESEncry", "true");
        // 发起请求
        JSONObject jsonObject = client.idcard(bytes, idCardSide.value, map);
        // 解析返回
        try {
            String result = new String(AesUtil.ecbDecrypt(Base64Util.decode(jsonObject.getString("result")), aesKey));
            IdCardResponse idCardResponse = baiduBeanService.buildResponse(new JSONObject(result), IdCardResponse.class);
            idCardResponse.setLogId(jsonObject.getLong("log_id"));
            return idCardResponse;
        } catch (JSONException e) {
            return baiduBeanService.buildResponse(jsonObject, IdCardResponse.class);
        }
    }

    /**
     * 身份证识别接口（AES加密版）
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 本地图片路径
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public IdCardResponse idcardAes(String image, IdCardSide idCardSide, IdCardRequest options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return idcardAes(data, idCardSide, options);
        } catch (IOException e) {
            e.printStackTrace();
            return baiduBeanService.buildResponse(AipError.IMAGE_READ_ERROR.toJsonResult(), IdCardResponse.class);
        }
    }

    /**
     * 身份证混贴识别
     * https://ai.baidu.com/ai-doc/OCR/akp3gfbmc
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                https://ai.baidu.com/ai-doc/OCR/akp3gfbmc#%E8%AF%B7%E6%B1%82%E8%AF%B4%E6%98%8E
     * @return JSONObject
     */
    public MultiIdCardResponse multiIdcard(byte[] image, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.multiIdcard(image, baiduBeanService.buildObjectOptions(options)), MultiIdCardResponse.class);
    }

    /**
     * 身份证混贴识别
     * https://ai.baidu.com/ai-doc/OCR/akp3gfbmc
     *
     * @param image   - 图片路径
     * @param options - 可选参数对象，key: value都为string类型
     *                https://ai.baidu.com/ai-doc/OCR/akp3gfbmc#%E8%AF%B7%E6%B1%82%E8%AF%B4%E6%98%8E
     * @return JSONObject
     */
    public MultiIdCardResponse multiIdcard(String image, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.multiIdcard(image, baiduBeanService.buildObjectOptions(options)), MultiIdCardResponse.class);
    }

    /**
     * 身份证混贴识别
     * https://ai.baidu.com/ai-doc/OCR/akp3gfbmc
     *
     * @param url     - 图片完整url
     * @param options - 可选参数对象，key: value都为string类型
     *                https://ai.baidu.com/ai-doc/OCR/akp3gfbmc#%E8%AF%B7%E6%B1%82%E8%AF%B4%E6%98%8E
     * @return JSONObject
     */
    public MultiIdCardResponse multiIdcardUrl(String url, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.multiIdcardUrl(url, baiduBeanService.buildObjectOptions(options)), MultiIdCardResponse.class);
    }
}
