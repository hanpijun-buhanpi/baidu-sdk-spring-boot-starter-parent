package com.baidu.aip.ocr;

import com.baidu.aip.error.AipError;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import io.github.hanpijunbuhanpi.baidu.sdk.common.util.AesUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * 百度文字识别客户端扩展
 *
 * @author lyc
 * @since 2023/8/23 13:45
 */
public class AipOcrExtend extends AipOcr {
    public AipOcrExtend(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    /**
     * 身份证识别接口
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param url      - 图片url路径
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public JSONObject idcardUrl(String url, String idCardSide, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        request.addBody("url", url);

        request.addBody("id_card_side", idCardSide);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.IDCARD);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 身份证识别接口（AES加密）
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 二进制图像数据
     * @param aesKey     - 百度智能云应用中的AES密钥
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public JSONObject idcardAes(byte[] image,String aesKey, String idCardSide, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(AesUtil.ecbEncrypt(image, aesKey));
        request.addBody("image", base64Content);

        request.addBody("id_card_side", idCardSide);
        request.addBody("AESEncry", "true");
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.IDCARD);
        postOperation(request);
        JSONObject jsonObject = requestServer(request);

        try {
            byte[] data = Base64Util.decode(jsonObject.getString("result"));
            JSONObject result = new JSONObject(new String(AesUtil.ecbDecrypt(data, aesKey)));
            result.put("log_id", jsonObject.get("log_id"));
            return result;
        } catch (JSONException e) {
            return jsonObject;
        }
    }

    /**
     * 身份证识别接口（AES加密）
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param image      - 本地图片路径
     * @param aesKey     - 百度智能云应用中的AES密钥
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return JSONObject
     */
    public JSONObject idcardAes(String image,String aesKey, String idCardSide, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return idcardAes(data, aesKey, idCardSide, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }
}
