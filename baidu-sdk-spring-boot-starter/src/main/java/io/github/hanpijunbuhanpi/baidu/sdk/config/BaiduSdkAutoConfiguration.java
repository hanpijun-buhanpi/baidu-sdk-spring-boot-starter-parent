package io.github.hanpijunbuhanpi.baidu.sdk.config;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.baidu.aip.client.BaseClient;
import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.easydl.AipEasyDL;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.imagesearch.AipImageSearch;
import com.baidu.aip.kg.AipKnowledgeGraphic;
import com.baidu.aip.machinetranslation.Machinetranslation;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.speech.AipSpeech;
import io.github.hanpijunbuhanpi.baidu.sdk.config.property.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Field;
import java.net.Proxy;

/**
 * 百度SDK自动配置
 *
 * @author lyc
 * @since 2023/8/15 16:34
 */
@AutoConfiguration
@ConditionalOnProperty(prefix = "baidu-sdk.global", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaiduSdkAutoConfiguration {
    /**
     * 人体识别客户端
     *
     * @param global 全局配置
     * @param properties 人体识别配置
     * @return 人体识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.body-analysis", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipBodyAnalysis.class})
    public AipBodyAnalysis aipBodyAnalysis(BaiduGlobalConfigurationProperties global, BaiduBodyAnalysisConfigurationProperties properties) {
        return init(global, properties, AipBodyAnalysis.class, "百度人体识别配置：");
    }
    /**
     * 内容审核客户端
     *
     * @param global 全局配置
     * @param properties 内容审核配置
     * @return 内容审核客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.content-censor", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipContentCensor.class})
    public AipContentCensor aipContentCensor(BaiduGlobalConfigurationProperties global, BaiduContentCensorConfigurationProperties properties) {
        return init(global, properties, AipContentCensor.class, "百度内容审核配置：");
    }
    /**
     * EasyDL零门槛AI开发客户端
     *
     * @param global 全局配置
     * @param properties EasyDL零门槛AI开发配置
     * @return EasyDL零门槛AI开发客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.easy-dl", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipEasyDL.class})
    public AipEasyDL aipEasyDL(BaiduGlobalConfigurationProperties global, BaiduEasyDLConfigurationProperties properties) {
        return init(global, properties, AipEasyDL.class, "百度EasyDL配置：");
    }
    /**
     * 人脸识别客户端
     *
     * @param global 全局配置
     * @param properties 人脸识别配置
     * @return 人脸识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.face", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipFace.class})
    public AipFace aipFace(BaiduGlobalConfigurationProperties global, BaiduFaceConfigurationProperties properties) {
        return init(global, properties, AipFace.class, "百度人脸识别配置：");
    }
    /**
     * 图像识别客户端
     *
     * @param global 全局配置
     * @param properties 图像识别配置
     * @return 图像识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-classify", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipImageClassify.class})
    public AipImageClassify aipImageClassify(BaiduGlobalConfigurationProperties global, BaiduImageClassifyConfigurationProperties properties) {
        return init(global, properties, AipImageClassify.class, "百度图像识别配置：");
    }
    /**
     * 图像增强客户端
     *
     * @param global 全局配置
     * @param properties 图像增强配置
     * @return 图像增强客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-process", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipImageProcess.class})
    public AipImageProcess aipImageProcess(BaiduGlobalConfigurationProperties global, BaiduImageProcessConfigurationProperties properties) {
        return init(global, properties, AipImageProcess.class, "百度图像增强配置：");
    }
    /**
     * 图像搜索客户端
     *
     * @param global 全局配置
     * @param properties 图像搜索配置
     * @return 图像搜索客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.image-search", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipImageSearch.class})
    public AipImageSearch aipImageSearch(BaiduGlobalConfigurationProperties global, BaiduImageSearchConfigurationProperties properties) {
        return init(global, properties, AipImageSearch.class, "百度图像搜索配置：");
    }
    /**
     * 知识图谱客户端
     *
     * @param global 全局配置
     * @param properties 知识图谱配置
     * @return 知识图谱客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.kg", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipKnowledgeGraphic.class})
    public AipKnowledgeGraphic aipKnowledgeGraphic(BaiduGlobalConfigurationProperties global, BaiduKnowledgeGraphicConfigurationProperties properties) {
        return init(global, properties, AipKnowledgeGraphic.class, "百度知识图谱配置：");
    }
    /**
     * 机器翻译客户端
     *
     * @param global 全局配置
     * @param properties 机器翻译配置
     * @return 机器翻译客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.machine-translation", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({Machinetranslation.class})
    public Machinetranslation machinetranslation(BaiduGlobalConfigurationProperties global, BaiduMachineTranslationConfigurationProperties properties) {
        return init(global, properties, Machinetranslation.class, "百度机器翻译配置：");
    }
    /**
     * 文字识别客户端
     *
     * @param global 全局配置
     * @param properties 文字识别配置
     * @return 文字识别客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.ocr", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipOcr.class})
    public AipOcr aipOcr(BaiduGlobalConfigurationProperties global, BaiduOcrConfigurationProperties properties) {
        return init(global, properties, AipOcr.class, "百度文字识别配置：");
    }
    /**
     * 自然语言处理客户端
     *
     * @param global 全局配置
     * @param properties 自然语言处理配置
     * @return 自然语言处理客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.nlp", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipNlp.class})
    public AipNlp aipNlp(BaiduGlobalConfigurationProperties global, BaiduNlpConfigurationProperties properties) {
        return init(global, properties, AipNlp.class, "百度自然语言处理配置：");
    }
    /**
     * 语音技术客户端
     *
     * @param global 全局配置
     * @param properties 语音技术配置
     * @return 语音技术客户端
     */
    @Bean
    @ConditionalOnProperty(prefix = "baidu-sdk.speech", name = "enable", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean({AipSpeech.class})
    public AipSpeech aipSpeech(BaiduGlobalConfigurationProperties global, BaiduSpeechConfigurationProperties properties) {
        return init(global, properties, AipSpeech.class, "百度语音技术配置：");
    }

    /**
     * 初始化客户端
     *
     * @param global 全局配置
     * @param properties 指定配置
     * @param clazz 初始化客户端类型
     * @param tipPrefix 提示前缀
     * @return 初始化完成的客户端
     * @param <T> 客户端类型泛型
     */
    public static <T extends BaseClient> T init(BaiduBaseConfigurationProperties global, BaiduBaseConfigurationProperties properties,
                                                   Class<T> clazz, String tipPrefix) {
        // 复制属性
        copy(global, properties);
        // 配置参数校验
        properties.check(tipPrefix);

        // 构建对象
        try {
            T client = clazz.getConstructor(String.class, String.class, String.class)
                    .newInstance(properties.getAppId(), properties.getApiKey(), properties.getSecretKey());

            // 超时配置
            if (properties.getConnectTimeout() != null) {
                client.setConnectionTimeoutInMillis(properties.getConnectTimeout());
            }
            if (properties.getSocketTimeout() != null) {
                client.setSocketTimeoutInMillis(properties.getSocketTimeout());
            }
            // 代理配置
            if (properties.getProxyType() != null && properties.getProxyType() != Proxy.Type.DIRECT) {
                if (properties.getProxyType() == Proxy.Type.HTTP) {
                    client.setHttpProxy(properties.getProxyHost(), properties.getProxyPort());
                } else {
                    client.setSocketProxy(properties.getProxyHost(), properties.getProxyPort());
                }
            }
            // log4j日志配置
            if (properties.getLog4jConfigPath() != null && !"".equals(properties.getLog4jConfigPath().trim())) {
                System.setProperty("aip.log4j.conf", properties.getLog4jConfigPath());
            }

            return client;
        } catch (Throwable e) {
            throw new RuntimeException(tipPrefix + " 百度客户端构建异常", e);
        }
    }

    /**
     * 将全局配置复制到指定配置中
     *
     * @param global 全局配置
     * @param target 指定配置
     */
    public static void copy(BaiduBaseConfigurationProperties global, BaiduBaseConfigurationProperties target) {
        try {
            Class<BaiduBaseConfigurationProperties> clazz = BaiduBaseConfigurationProperties.class;
            for (Field field : clazz.getDeclaredFields()) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(target) == null) {
                    field.set(target, field.get(global));
                }
                field.setAccessible(accessible);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(" 百度SDK配置属性复制异常", e);
        }
    }
}
