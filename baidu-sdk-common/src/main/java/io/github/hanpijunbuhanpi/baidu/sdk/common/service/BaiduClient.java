package io.github.hanpijunbuhanpi.baidu.sdk.common.service;

import com.baidu.aip.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 百度客户端
 *
 * @author hanpijun-buhanpi
 * @since 2.0
 */
public class BaiduClient<T extends BaseClient> {
    @Autowired
    protected T client;

    @Autowired
    protected BaiduBeanService baiduBeanService;
}
