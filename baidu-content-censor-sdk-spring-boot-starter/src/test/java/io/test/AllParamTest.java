package io.test;

import io.App;
import com.baidu.aip.contentcensor.AipContentCensor;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.config.property.BaiduContentCensorConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.service.BaiduContentCensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试正常配置
 *
 * @author lyc
 * @since 2023/8/16 16:44
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test1")
public class AllParamTest {
    @Autowired
    private BaiduContentCensorConfigurationProperties properties;
    @Autowired
    private AipContentCensor aipContentCensor;
    @Autowired
    private BaiduContentCensor baiduContentCensor;

    @Test
    public void test() {
        Assert.isTrue(properties != null, "属性未注入");
        Assert.isTrue(properties.getAppId().equals("111"), "app-id属性异常");
        Assert.isTrue(properties.getApiKey().equals("222"), "api-key属性异常");
        Assert.isTrue(properties.getSecretKey().equals("333"), "secret-key属性异常");
        Assert.isTrue(aipContentCensor != null, "客户端未注册");
        Assert.isTrue(baiduContentCensor != null, "Starter客户端未注册");
    }
}
