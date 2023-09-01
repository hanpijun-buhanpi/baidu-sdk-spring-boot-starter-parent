package io.test;

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

    /**
     * 通用文字识别接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicGeneral() throws Exception {
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(GeneralBasicLanguageType.CHN_ENG, true, true, true, true);
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
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(GeneralBasicLanguageType.CHN_ENG, true, true, true, true);
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
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(GeneralBasicLanguageType.CHN_ENG, true, true, true, true);
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
        GeneralBasicRequest generalBasicRequest = new GeneralBasicRequest(GeneralBasicLanguageType.CHN_ENG, true, true, true, true);
        // 正常页码
        GeneralBasicResponse generalBasicResponse = baiduOcr.basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        // 异常页码
        generalBasicResponse = baiduOcr.basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
        generalBasicResponse = baiduOcr.basicGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalBasicRequest);
        System.out.println(objectMapper.writeValueAsString(generalBasicResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneral() throws Exception {
        AccurateRequest accurateRequest = new AccurateRequest(AccurateLanguageType.CHN_ENG, true, true, true);
        AccurateResponse accurateResponse = baiduOcr.basicAccurateGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralUrl() throws Exception {
        AccurateRequest accurateRequest = new AccurateRequest(AccurateLanguageType.CHN_ENG, true, true, true);
        AccurateResponse accurateResponse = baiduOcr.basicAccurateGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralPdf() throws Exception {
        AccurateRequest accurateRequest = new AccurateRequest(AccurateLanguageType.CHN_ENG, true, true, true);
        // 正常页码
        AccurateResponse accurateResponse = baiduOcr.basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
        // 异常页码
        accurateResponse = baiduOcr.basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
        accurateResponse = baiduOcr.basicAccurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
    }

    /**
     * 通用文字识别（高精度版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void basicAccurateGeneralOfd() throws Exception {
        AccurateRequest accurateRequest = new AccurateRequest(AccurateLanguageType.CHN_ENG, true, true, true);
        // 正常页码
        AccurateResponse accurateResponse = baiduOcr.basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
        // 异常页码
        accurateResponse = baiduOcr.basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
        accurateResponse = baiduOcr.basicAccurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, accurateRequest);
        System.out.println(objectMapper.writeValueAsString(accurateResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void general() throws Exception {
        GeneralRequest generalRequest = new GeneralRequest(Granularity.small, GeneralBasicLanguageType.CHN_ENG, true, true, true, true, true);
        GeneralResponse generalResponse = baiduOcr.general("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalUrl() throws Exception {
        GeneralRequest generalRequest = new GeneralRequest(Granularity.small, GeneralBasicLanguageType.CHN_ENG, true, true, true, true, true);
        GeneralResponse generalResponse = baiduOcr.generalUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalPdf() throws Exception {
        GeneralRequest generalRequest = new GeneralRequest(Granularity.small, GeneralBasicLanguageType.CHN_ENG, true, true, true, true, true);
        // 正常页码
        GeneralResponse generalResponse = baiduOcr.generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        // 异常页码
        generalResponse = baiduOcr.generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        generalResponse = baiduOcr.generalPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（含位置信息版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void generalOfd() throws Exception {
        GeneralRequest generalRequest = new GeneralRequest(Granularity.small, GeneralBasicLanguageType.CHN_ENG, true, true, true, true, true);
        // 正常页码
        GeneralResponse generalResponse = baiduOcr.generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        // 异常页码
        generalResponse = baiduOcr.generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        generalResponse = baiduOcr.generalOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, generalRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - 图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneral() throws Exception {
        AccurateGeneralRequest accurateGeneralRequest = new AccurateGeneralRequest(AccurateLanguageType.CHN_ENG, EngGranularity.word, Granularity.small, true, true, true, true);
        GeneralResponse generalResponse = baiduOcr.accurateGeneral("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - url图像识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralUrl() throws Exception {
        AccurateGeneralRequest accurateGeneralRequest = new AccurateGeneralRequest(AccurateLanguageType.CHN_ENG, EngGranularity.word, Granularity.small, true, true, true, true);
        GeneralResponse generalResponse = baiduOcr.accurateGeneralUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - pdf识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralPdf() throws Exception {
        AccurateGeneralRequest accurateGeneralRequest = new AccurateGeneralRequest(AccurateLanguageType.CHN_ENG, EngGranularity.word, Granularity.small, true, true, true, true);
        // 正常页码
        GeneralResponse generalResponse = baiduOcr.accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 1, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        // 异常页码
        generalResponse = baiduOcr.accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", -1, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        generalResponse = baiduOcr.accurateGeneralPdf("C:\\Users\\Administrator\\Desktop\\123.pdf", 500, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
    }

    /**
     * 通用文字识别（高精度含位置版）接口测试 - ofd识别
     * @throws Exception 未知异常
     * @since 2.2
     */
    @Test
    public void accurateGeneralOfd() throws Exception {
        AccurateGeneralRequest accurateGeneralRequest = new AccurateGeneralRequest(AccurateLanguageType.CHN_ENG, EngGranularity.word, Granularity.small, true, true, true, true);
        // 正常页码
        GeneralResponse generalResponse = baiduOcr.accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 1, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        // 异常页码
        generalResponse = baiduOcr.accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", -1, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
        generalResponse = baiduOcr.accurateGeneralOfd("C:\\Users\\Administrator\\Desktop\\123.ofd", 500, accurateGeneralRequest);
        System.out.println(objectMapper.writeValueAsString(generalResponse));
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
