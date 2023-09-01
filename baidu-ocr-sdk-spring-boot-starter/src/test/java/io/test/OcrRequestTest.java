package io.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.*;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.*;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.*;
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

    {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 通用文字识别接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneral() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralUrl() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralPdf() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .basicGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneralOfd() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralBasicRequest(LanguageType.CHN_ENG, true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneral() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateBasicRequest(LanguageType.CHN_ENG, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicAccurateGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralUrl() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateBasicRequest(LanguageType.CHN_ENG, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicAccurateGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralPdf() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateBasicRequest(LanguageType.CHN_ENG, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralOfd() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateBasicRequest(LanguageType.CHN_ENG, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void general() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralRequest(LanguageType.CHN_ENG, OcrGranularity.Recognize.small,
                        true, true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .general("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalUrl() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralRequest(LanguageType.CHN_ENG, OcrGranularity.Recognize.small,
                        true, true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .generalUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalPdf() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralRequest(LanguageType.CHN_ENG, OcrGranularity.Recognize.small,
                        true, true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalOfd() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildGeneralRequest(LanguageType.CHN_ENG, OcrGranularity.Recognize.small,
                        true, true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneral() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateRequest(LanguageType.CHN_ENG, OcrGranularity.Eng.letter, OcrGranularity.Recognize.small,
                        true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .accurateGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralUrl() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateRequest(LanguageType.CHN_ENG, OcrGranularity.Eng.letter, OcrGranularity.Recognize.small,
                        true, true, true, true);
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .accurateGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralPdf() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateRequest(LanguageType.CHN_ENG, OcrGranularity.Eng.letter, OcrGranularity.Recognize.small,
                        true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralOfd() throws Exception {
        GeneralOcrRequest generalOcrRequest = GeneralOcrRequest
                .buildAccurateRequest(LanguageType.CHN_ENG, OcrGranularity.Eng.letter, OcrGranularity.Recognize.small,
                        true, true, true, true);
        // 正常页码
        GeneralOcrResponse generalOcrResponse = baiduOcr
                .accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        // 异常页码
        generalOcrResponse = baiduOcr
                .accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
        generalOcrResponse = baiduOcr
                .accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalOcrRequest);
        System.out.println(objectMapper.writeValueAsString(generalOcrResponse));
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
