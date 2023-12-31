package io.test;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import io.App;
import io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.config.property.BaiduBodyAnalysisConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.service.BaiduBodyAnalysis;
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
    private BaiduBodyAnalysisConfigurationProperties properties;
    @Autowired
    private AipBodyAnalysis aipBodyAnalysis;
    @Autowired
    private BaiduBodyAnalysis baiduBodyAnalysis;

    @Test
    public void test() {
        Assert.isTrue(properties != null, "属性未注入");
        Assert.isTrue(properties.getAppId() == null, "app-id属性注入了");
        Assert.isTrue(properties.getApiKey() == null, "api-key属性注入了");
        Assert.isTrue(properties.getSecretKey() == null, "secret-key属性注入了");
        Assert.isTrue(aipBodyAnalysis == null, "客户端注册了");
        Assert.isTrue(baiduBodyAnalysis == null, "Starter客户端注册了");
    }
}
