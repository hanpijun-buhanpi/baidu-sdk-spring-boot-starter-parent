package io.github.hanpijunbuhanpi.baidu.sdk.ocr.service;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.ocr.AipOcrExtend;
import io.github.hanpijunbuhanpi.baidu.sdk.common.service.BaiduClient;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property.BaiduOcrConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.*;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.*;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.IdCardSide;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * 百度文字识别
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
public class BaiduOcr extends BaiduClient<AipOcr> {
    @Autowired
    private BaiduOcrConfigurationProperties properties;

    /**
     * 通用文字识别接口
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneral(byte[] image, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(client.basicGeneral(image, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param image   - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneral(String image, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(client.basicGeneral(image, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param url     - 图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/png/bmp格式，当image字段存在时url字段失效
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneralUrl(String url, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(client.basicGeneralUrl(url, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别PDF文件中某页的所有文字
     *
     * @param pdf     - 二进制PDF文件数据
     * @param num     - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneralPdf(byte[] pdf, int num, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别PDF文件中某页的所有文字
     *
     * @param pdf     - 本地PDF文件路径
     * @param num     - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneralPdf(String pdf, int num, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别OFD文件中某页的所有文字
     *
     * @param ofd     - 二进制OFD文件数据
     * @param num     - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneralOfd(byte[] ofd, int num, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别OFD文件中某页的所有文字
     *
     * @param ofd     - 本地OFD文件路径
     * @param num     - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralBasicResponse}
     *
     * @since 2.2
     */
    public GeneralBasicResponse basicGeneralOfd(String ofd, int num, GeneralBasicRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneral(byte[] image, AccurateRequest options) {
        return baiduBeanService.buildResponse(client.basicAccurateGeneral(image, baiduBeanService.buildStringOptions(options)), AccurateResponse.class);
    }

    /**
     * 通用文字识别（高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param image   - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneral(String image, AccurateRequest options) {
        return baiduBeanService.buildResponse(client.basicAccurateGeneral(image, baiduBeanService.buildStringOptions(options)), AccurateResponse.class);
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
     * @return {@link AccurateRequest}
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneralUrl(String url, AccurateRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicAccurateGeneralUrl(url, baiduBeanService.buildStringOptions(options)), AccurateResponse.class);
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
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneralPdf(byte[] pdf, int num, AccurateRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicAccurateGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
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
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneralPdf(String pdf, int num, AccurateRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicAccurateGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
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
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneralOfd(byte[] ofd, int num, AccurateRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicAccurateGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
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
     * @return {@link AccurateResponse}
     *
     * @since 2.2
     */
    public AccurateResponse basicAccurateGeneralOfd(String ofd, int num, AccurateRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).basicAccurateGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralBasicResponse.class);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse general(byte[] image, GeneralRequest options) {
        return baiduBeanService.buildResponse(client.general(image, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
     *
     * @param image   - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse general(String image, GeneralRequest options) {
        return baiduBeanService.buildResponse(client.general(image, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
     *
     * @param url     - 图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/png/bmp格式，当image字段存在时url字段失效
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse generalUrl(String url, GeneralRequest options) {
        return baiduBeanService.buildResponse(client.generalUrl(url, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
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
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse generalPdf(byte[] pdf, int num, GeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).generalPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
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
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse generalPdf(String pdf, int num, GeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).generalPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置信息版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 二进制OFD文件数据
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse generalOfd(byte[] ofd, int num, GeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).generalOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
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
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse generalOfd(String ofd, int num, GeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).generalOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneral(byte[] image, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(client.accurateGeneral(image, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
     *
     * @param image   - 本地图片路径
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneral(String image, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(client.accurateGeneral(image, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
     *
     * @param url   - 图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/png/bmp格式，当image字段存在时url字段失效
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneralUrl(String url, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).accurateGeneralUrl(url, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 二进制PDF文件数据
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneralPdf(byte[] pdf, int num, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).accurateGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别PDF文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param pdf   - 本地PDF文件路径
     * @param num   - PDF文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneralPdf(String pdf, int num, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).accurateGeneralPdf(pdf, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 二进制OFD文件数据
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneralOfd(byte[] ofd, int num, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).accurateGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

    /**
     * 通用文字识别（含位置高精度版）接口
     * 用户向服务请求识别OFD文件中某页中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
     *
     * @param ofd   - 本地OFD文件路径
     * @param num   - OFD文件页码
     * @param options - 可选参数对象，key: value都为string类型
     *                options - options列表:
     *                recognize_granularity 是否定位单字符位置，big：不定位单字符位置，默认值；small：定位单字符位置
     *                detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                vertexes_location 是否返回文字外接多边形顶点位置，不支持单字位置。默认为false
     *                probability 是否返回识别结果中每一行的置信度
     * @return {@link GeneralResponse}
     *
     * @since 2.2
     */
    public GeneralResponse accurateGeneralOfd(String ofd, int num, AccurateGeneralRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).accurateGeneralOfd(ofd, num, baiduBeanService.buildStringOptions(options)), GeneralResponse.class);
    }

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
     * @return {@link IdCardResponse}
     *
     * @since 2.1
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
     * @return {@link IdCardResponse}
     *
     * @since 2.1
     */
    public IdCardResponse idcard(String image, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.idcard(image, idCardSide.value, baiduBeanService.buildStringOptions(options)), IdCardResponse.class);
    }

    /**
     * 身份证识别接口
     * 用户向服务请求识别身份证，身份证识别包括正面和背面。
     *
     * @param url      - 图片url
     * @param idCardSide - front：身份证含照片的一面；back：身份证带国徽的一面
     * @param options    - 可选参数对象，key: value都为string类型
     *                   options - options列表:
     *                   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *                   detect_risk 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
     * @return {@link IdCardResponse}
     *
     * @since 2.1
     */
    public IdCardResponse idcardUrl(String url, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(((AipOcrExtend) client).idcardUrl(url, idCardSide.value, baiduBeanService.buildStringOptions(options)), IdCardResponse.class);
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
     * @return {@link IdCardResponse}
     *
     * @since 2.1
     */
    public IdCardResponse idcardAes(byte[] image, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(
                ((AipOcrExtend) client).idcardAes(image, properties.getAesKey(), idCardSide.value, baiduBeanService.buildStringOptions(options)),
                IdCardResponse.class);
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
     * @return {@link IdCardResponse}
     *
     * @since 2.1
     */
    public IdCardResponse idcardAes(String image, IdCardSide idCardSide, IdCardRequest options) {
        return baiduBeanService.buildResponse(
                ((AipOcrExtend) client).idcardAes(image, properties.getAesKey(), idCardSide.value, baiduBeanService.buildStringOptions(options)),
                IdCardResponse.class);
    }

    /**
     * 身份证混贴识别
     * https://ai.baidu.com/ai-doc/OCR/akp3gfbmc
     *
     * @param image   - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     *                https://ai.baidu.com/ai-doc/OCR/akp3gfbmc#%E8%AF%B7%E6%B1%82%E8%AF%B4%E6%98%8E
     * @return {@link MultiIdCardResponse}
     *
     * @since 2.1
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
     * @return {@link MultiIdCardResponse}
     *
     * @since 2.1
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
     * @return {@link MultiIdCardResponse}
     *
     * @since 2.1
     */
    public MultiIdCardResponse multiIdcardUrl(String url, IdCardRequest options) {
        return baiduBeanService.buildResponse(client.multiIdcardUrl(url, baiduBeanService.buildObjectOptions(options)), MultiIdCardResponse.class);
    }
}
