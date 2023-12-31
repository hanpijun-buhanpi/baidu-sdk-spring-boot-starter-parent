package io.test;

import io.App;
import com.baidu.aip.imageclassify.AipImageClassify;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.config.property.BaiduImageClassifyConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.service.BaiduImageClassify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试无配置
 *
 * @author lyc
 * @since 2023/8/16 16:44
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test2")
public class NullParamTest {
    @Autowired
    private BaiduImageClassifyConfigurationProperties properties;
    @Autowired
    private AipImageClassify aipImageClassify;
    @Autowired
    private BaiduImageClassify baiduImageClassify;

    @Test
    public void test() {
        Assert.isTrue(properties != null, "属性未注入");
        Assert.isTrue(properties.getAppId() == null, "app-id属性注入了");
        Assert.isTrue(properties.getApiKey() == null, "api-key属性注入了");
        Assert.isTrue(properties.getSecretKey() == null, "secret-key属性注入了");
        Assert.isTrue(aipImageClassify == null, "客户端注册了");
        Assert.isTrue(baiduImageClassify == null, "Starter客户端注册了");
    }
}
