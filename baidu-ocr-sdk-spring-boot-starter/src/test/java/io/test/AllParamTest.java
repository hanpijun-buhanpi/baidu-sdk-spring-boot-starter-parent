package io.test;

import io.App;
import com.baidu.aip.ocr.AipOcr;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property.BaiduOcrConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.service.BaiduOcr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试正常配置
 *
 * @author hanpijun-buhanpi
 * @since 2.0
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test1")
public class AllParamTest {
    @Autowired
    private BaiduOcrConfigurationProperties properties;
    @Autowired
    private AipOcr aipOcr;
    @Autowired
    private BaiduOcr baiduOcr;

    @Test
    public void test() {
        Assert.isTrue(properties != null, "属性未注入");
        Assert.isTrue(properties.getAppId().equals("111"), "app-id属性异常");
        Assert.isTrue(properties.getApiKey().equals("222"), "api-key属性异常");
        Assert.isTrue(properties.getSecretKey().equals("333"), "secret-key属性异常");
        Assert.isTrue(aipOcr != null, "客户端未注册");
        Assert.isTrue(baiduOcr != null, "Starter客户端未注册");
    }
}
