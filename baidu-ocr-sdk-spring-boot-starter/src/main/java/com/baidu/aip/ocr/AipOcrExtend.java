package com.baidu.aip.ocr;

import com.baidu.aip.error.AipError;
import com.baidu.aip.error.AipErrorExtend;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.Util;
import io.github.hanpijunbuhanpi.baidu.sdk.common.util.AesUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * 百度文字识别客户端扩展
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public class AipOcrExtend extends AipOcr {
    public AipOcrExtend(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别PDF文件中某页的所有文字
     *
     * @param pdf   - 二进制PDF文件数据
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicGeneralPdf(byte[] pdf, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(pdf);
        request.addBody("pdf_file", base64Content);
        request.addBody("pdf_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别PDF文件中某页的所有文字
     *
     * @param pdf   - 本地PDF文件路径
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicGeneralPdf(String pdf, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(pdf);
            return basicGeneralPdf(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.PDF_READ_ERROR.toJsonResult();
        }
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别OFD文件中某页的所有文字
     *
     * @param ofd   - 二进制OFD文件数据
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicGeneralOfd(byte[] ofd, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(ofd);
        request.addBody("ofd_file", base64Content);
        request.addBody("ofd_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别OFD文件中某页的所有文字
     *
     * @param ofd   - 本地OFD文件路径
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicGeneralOfd(String ofd, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(ofd);
            return basicGeneralOfd(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.OFD_READ_ERROR.toJsonResult();
        }
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param url   - 图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/png/bmp格式，当image字段存在时url字段失效
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicAccurateGeneralUrl(String url, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        request.addBody("url", url);

        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 二进制PDF文件数据
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicAccurateGeneralPdf(byte[] pdf, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(pdf);
        request.addBody("pdf_file", base64Content);
        request.addBody("pdf_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 本地PDF文件路径
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicAccurateGeneralPdf(String pdf, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(pdf);
            return basicAccurateGeneralPdf(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.PDF_READ_ERROR.toJsonResult();
        }
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 二进制OFD文件数据
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicAccurateGeneralOfd(byte[] ofd, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(ofd);
        request.addBody("ofd_file", base64Content);
        request.addBody("ofd_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 本地OFD文件路径
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     * @since 2.2
     */
    public JSONObject basicAccurateGeneralOfd(String ofd, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(ofd);
            return basicAccurateGeneralOfd(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.OFD_READ_ERROR.toJsonResult();
        }
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 二进制PDF文件数据
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     *
     * @since 2.2
     */
    public JSONObject generalPdf(byte[] pdf, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(pdf);
        request.addBody("pdf_file", base64Content);
        request.addBody("pdf_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 本地PDF文件路径
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     *
     * @since 2.2
     */
    public JSONObject generalPdf(String pdf, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(pdf);
            return generalPdf(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.PDF_READ_ERROR.toJsonResult();
        }
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 二进制OFD文件数据
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     *
     * @since 2.2
     */
    public JSONObject generalOfd(byte[] pdf, int num, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(pdf);
        request.addBody("ofd_file", base64Content);
        request.addBody("ofd_file_num", num);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 本地OFD文件路径
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link JSONObject}
     *
     * @since 2.2
     */
    public JSONObject generalOfd(String ofd, int num, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(ofd);
            return generalOfd(data, num, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipErrorExtend.PDF_READ_ERROR.toJsonResult();
        }
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
     * @return {@link JSONObject}
     * @since 2.1
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
     * @return {@link JSONObject}
     * @since 2.1
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
            JSONObject result = new JSONObject(new String(AesUtil.ecbDecrypt(data, aesKey), StandardCharsets.UTF_8));
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
     * @return {@link JSONObject}
     * @since 2.1
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
