package io.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.GeneralBasicRequest;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.IdCardRequest;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.GeneralBasicResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.IdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.MultiIdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.IdCardSide;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.LanguageType;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.service.BaiduOcr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 文字识别请求测试
 *
 * @author hanpijun-buhanpi
 * @since 2.2
 */
@SpringBootTest
@ActiveProfiles("test-request")
public class OcrRequestTest {
    @Autowired
    private BaiduOcr baiduOcr;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 通用文字识别接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneral() throws Exception {
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        GeneralBasicResponse generalBasicResponse = baiduOcr.basicGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
    }

    /**
     * 通用文字识别接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralUrl() throws Exception {
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        GeneralBasicResponse generalBasicResponse = baiduOcr.basicGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
    }

    /**
     * 通用文字识别接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralPdf() throws Exception {
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        // 正常页码
        GeneralBasicResponse generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        // 异常页码
        generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
    }

    /**
     * 通用文字识别接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralOfd() throws Exception {
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        // 正常页码
        GeneralBasicResponse generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        // 异常页码
        generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        generalBasicResponse = baiduOcr.basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
    }

    /**
     * 身份证识别 - 图像识别
     * @throws Exception 未知异常
     * @since 2.1
     */
    @Test
    public void idcard() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcard("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    /**
     * 身份证识别 - url图像识别
     * @throws Exception 未知异常
     * @since 2.1
     */
    @Test
    public void idcardUrl() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcardUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    /**
     * 身份证识别 - 图像AES加密识别
     * @throws Exception 未知异常
     * @since 2.1
     */
    @Test
    public void idcardAes() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcardAes("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    /**
     * 身份证混贴识别 - 图像识别
     * @throws Exception 未知异常
     * @since 2.1
     */
    @Test
    public void multiIdcard() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        MultiIdCardResponse response = baiduOcr.multiIdcard("C:\\Users\\Administrator\\Desktop\\654654654.png", idCardRequest);
        System.out.println(objectMapper.writeValueAsString(response));
    }

    /**
     * 身份证混贴识别 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void multiIdcardUrl() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        MultiIdCardResponse response = baiduOcr.multiIdcardUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", idCardRequest);
        System.out.println(objectMapper.writeValueAsString(response));
    }
}
