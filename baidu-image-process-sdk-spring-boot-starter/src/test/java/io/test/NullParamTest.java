package io.test;

import io.App;
import com.baidu.aip.imageprocess.AipImageProcess;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.config.property.BaiduImageProcessConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.service.BaiduImageProcess;
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
    private BaiduImageProcessConfigurationProperties properties;
    @Autowired
    private AipImageProcess aipImageProcess;
    @Autowired
    private BaiduImageProcess baiduImageProcess;

    @Test
    public void test() {
        Assert.isTrue(properties != null, "属性未注入");
        Assert.isTrue(properties.getAppId() == null, "app-id属性注入了");
        Assert.isTrue(properties.getApiKey() == null, "api-key属性注入了");
        Assert.isTrue(properties.getSecretKey() == null, "secret-key属性注入了");
        Assert.isTrue(aipImageProcess == null, "客户端注册了");
        Assert.isTrue(baiduImageProcess == null, "Starter客户端注册了");
    }
}
