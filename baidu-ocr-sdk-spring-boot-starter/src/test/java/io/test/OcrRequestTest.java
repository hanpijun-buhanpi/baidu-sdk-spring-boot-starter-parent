package io.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.request.IdCardRequest;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.IdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.entity.response.MultiIdCardResponse;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.enumerate.IdCardSide;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.service.BaiduOcr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 文字识别请求测试
 *
 * @author lyc
 * @since 2023/8/21 16:37
 */
@SpringBootTest
@ActiveProfiles("test-request")
public class OcrRequestTest {
    @Autowired
    private BaiduOcr baiduOcr;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void idcard() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcard("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    @Test
    public void idcardUrl() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcardUrl("http://5b0988e595225.cdn.sohucs.com/images/20171215/97fd34a8029a42bbac0642661d45a8d8.jpeg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    @Test
    public void idcardAes() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        IdCardResponse idcard = baiduOcr.idcardAes("C:\\Users\\Administrator\\Desktop\\123412341234.jpg", IdCardSide.FRONT, idCardRequest);
        System.out.println(objectMapper.writeValueAsString(idcard));
    }

    @Test
    public void multiIdcard() throws Exception {
        IdCardRequest idCardRequest = new IdCardRequest(true, true, true, true, true);
        MultiIdCardResponse response = baiduOcr.multiIdcard("C:\\Users\\Administrator\\Desktop\\654654654.png", idCardRequest);
        System.out.println(objectMapper.writeValueAsString(response));
    }
}
