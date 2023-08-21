package io.github.hanpijunbuhanpi.baidu.sdk.common.service;

import com.baidu.aip.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 百度客户端
 *
 * @author lyc
 * @since 2023/8/21 9:00
 */
public class BaiduClient<T extends BaseClient> {
    @Autowired
    protected T client;

    @Autowired
    protected BaiduBeanService baiduBeanService;
}
