package io.test;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
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
import io.App;
import io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.config.property.BaiduBodyAnalysisConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.config.property.BaiduContentCensorConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.easydl.config.property.BaiduEasyDLConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.face.config.property.BaiduFaceConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.config.property.BaiduImageClassifyConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.config.property.BaiduImageProcessConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.imagesearch.config.property.BaiduImageSearchConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.kg.config.property.BaiduKnowledgeGraphicConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.machinetranslation.config.property.BaiduMachineTranslationConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.nlp.config.property.BaiduNlpConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.config.property.BaiduOcrConfigurationProperties;
import io.github.hanpijunbuhanpi.baidu.sdk.speech.config.property.BaiduSpeechConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试全局全参配置
 *
 * @author lyc
 * @since 2023/8/16 16:44
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test1")
public class GlobalAllParamTest {
    @Autowired
    private BaiduGlobalConfigurationProperties globalConfigurationProperties;
    @Autowired
    private BaiduBodyAnalysisConfigurationProperties bodyAnalysisConfigurationProperties;
    @Autowired
    private BaiduContentCensorConfigurationProperties contentCensorConfigurationProperties;
    @Autowired
    private BaiduEasyDLConfigurationProperties easyDLConfigurationProperties;
    @Autowired
    private BaiduFaceConfigurationProperties faceConfigurationProperties;
    @Autowired
    private BaiduImageClassifyConfigurationProperties imageClassifyConfigurationProperties;
    @Autowired
    private BaiduImageProcessConfigurationProperties imageProcessConfigurationProperties;
    @Autowired
    private BaiduImageSearchConfigurationProperties imageSearchConfigurationProperties;
    @Autowired
    private BaiduKnowledgeGraphicConfigurationProperties knowledgeGraphicConfigurationProperties;
    @Autowired
    private BaiduMachineTranslationConfigurationProperties machineTranslationConfigurationProperties;
    @Autowired
    private BaiduNlpConfigurationProperties nlpConfigurationProperties;
    @Autowired
    private BaiduOcrConfigurationProperties ocrConfigurationProperties;
    @Autowired
    private BaiduSpeechConfigurationProperties speechConfigurationProperties;
    @Autowired
    private AipBodyAnalysis aipBodyAnalysis;
    @Autowired
    private AipContentCensor aipContentCensor;
    @Autowired
    private AipEasyDL aipEasyDL;
    @Autowired
    private AipFace aipFace;
    @Autowired
    private AipImageClassify aipImageClassify;
    @Autowired
    private AipImageProcess aipImageProcess;
    @Autowired
    private AipImageSearch aipImageSearch;
    @Autowired
    private AipKnowledgeGraphic aipKnowledgeGraphic;
    @Autowired
    private Machinetranslation machinetranslation;
    @Autowired
    private AipNlp aipNlp;
    @Autowired
    private AipOcr aipOcr;
    @Autowired
    private AipSpeech aipSpeech;

    @Test
    public void test() {
        // 全局
        Assert.isTrue(globalConfigurationProperties != null, "全局属性未注入");
        Assert.isTrue(globalConfigurationProperties.getAppId().equals("111"), "全局app-id属性异常");
        Assert.isTrue(globalConfigurationProperties.getApiKey().equals("222"), "全局api-key属性异常");
        Assert.isTrue(globalConfigurationProperties.getSecretKey().equals("333"), "全局secret-key属性异常");
        // 人体分析
        Assert.isTrue(bodyAnalysisConfigurationProperties != null, "人体分析属性未注入");
        Assert.isTrue(bodyAnalysisConfigurationProperties.getAppId().equals("111"), "人体分析app-id属性异常");
        Assert.isTrue(bodyAnalysisConfigurationProperties.getApiKey().equals("222"), "人体分析api-key属性异常");
        Assert.isTrue(bodyAnalysisConfigurationProperties.getSecretKey().equals("333"), "人体分析secret-key属性异常");
        Assert.isTrue(aipBodyAnalysis != null, "人体分析客户端未注册");
        // 内容审核
        Assert.isTrue(contentCensorConfigurationProperties != null, "内容审核属性未注入");
        Assert.isTrue(contentCensorConfigurationProperties.getAppId().equals("111"), "内容审核app-id属性异常");
        Assert.isTrue(contentCensorConfigurationProperties.getApiKey().equals("222"), "内容审核api-key属性异常");
        Assert.isTrue(contentCensorConfigurationProperties.getSecretKey().equals("333"), "内容审核secret-key属性异常");
        Assert.isTrue(aipContentCensor != null, "内容审核客户端未注册");
        // EasyDL零门槛AI开发
        Assert.isTrue(easyDLConfigurationProperties != null, "EasyDL属性未注入");
        Assert.isTrue(easyDLConfigurationProperties.getAppId().equals("111"), "EasyDLapp-id属性异常");
        Assert.isTrue(easyDLConfigurationProperties.getApiKey().equals("222"), "EasyDLapi-key属性异常");
        Assert.isTrue(easyDLConfigurationProperties.getSecretKey().equals("333"), "EasyDLsecret-key属性异常");
        Assert.isTrue(aipEasyDL != null, "EasyDL客户端未注册");
        // 人脸识别
        Assert.isTrue(faceConfigurationProperties != null, "人脸识别属性未注入");
        Assert.isTrue(faceConfigurationProperties.getAppId().equals("111"), "人脸识别app-id属性异常");
        Assert.isTrue(faceConfigurationProperties.getApiKey().equals("222"), "人脸识别api-key属性异常");
        Assert.isTrue(faceConfigurationProperties.getSecretKey().equals("333"), "人脸识别secret-key属性异常");
        Assert.isTrue(aipFace != null, "人脸识别客户端未注册");
        // 图像增强
        Assert.isTrue(imageClassifyConfigurationProperties != null, "图像增强属性未注入");
        Assert.isTrue(imageClassifyConfigurationProperties.getAppId().equals("111"), "图像增强app-id属性异常");
        Assert.isTrue(imageClassifyConfigurationProperties.getApiKey().equals("222"), "图像增强api-key属性异常");
        Assert.isTrue(imageClassifyConfigurationProperties.getSecretKey().equals("333"), "图像增强secret-key属性异常");
        Assert.isTrue(aipImageClassify != null, "图像增强客户端未注册");
        // 图像处理
        Assert.isTrue(imageProcessConfigurationProperties != null, "图像处理属性未注入");
        Assert.isTrue(imageProcessConfigurationProperties.getAppId().equals("111"), "图像处理app-id属性异常");
        Assert.isTrue(imageProcessConfigurationProperties.getApiKey().equals("222"), "图像处理api-key属性异常");
        Assert.isTrue(imageProcessConfigurationProperties.getSecretKey().equals("333"), "图像处理secret-key属性异常");
        Assert.isTrue(aipImageProcess != null, "图像处理客户端未注册");
        // 图像搜索
        Assert.isTrue(imageSearchConfigurationProperties != null, "图像搜索属性未注入");
        Assert.isTrue(imageSearchConfigurationProperties.getAppId().equals("111"), "图像搜索app-id属性异常");
        Assert.isTrue(imageSearchConfigurationProperties.getApiKey().equals("222"), "图像搜索api-key属性异常");
        Assert.isTrue(imageSearchConfigurationProperties.getSecretKey().equals("333"), "图像搜索secret-key属性异常");
        Assert.isTrue(aipImageSearch != null, "图像搜索客户端未注册");
        // 知识图谱
        Assert.isTrue(knowledgeGraphicConfigurationProperties != null, "知识图谱属性未注入");
        Assert.isTrue(knowledgeGraphicConfigurationProperties.getAppId().equals("111"), "知识图谱app-id属性异常");
        Assert.isTrue(knowledgeGraphicConfigurationProperties.getApiKey().equals("222"), "知识图谱api-key属性异常");
        Assert.isTrue(knowledgeGraphicConfigurationProperties.getSecretKey().equals("333"), "知识图谱secret-key属性异常");
        Assert.isTrue(aipKnowledgeGraphic != null, "知识图谱客户端未注册");
        // 机器翻译
        Assert.isTrue(machineTranslationConfigurationProperties != null, "机器翻译属性未注入");
        Assert.isTrue(machineTranslationConfigurationProperties.getAppId().equals("111"), "机器翻译app-id属性异常");
        Assert.isTrue(machineTranslationConfigurationProperties.getApiKey().equals("222"), "机器翻译api-key属性异常");
        Assert.isTrue(machineTranslationConfigurationProperties.getSecretKey().equals("333"), "机器翻译secret-key属性异常");
        Assert.isTrue(machinetranslation != null, "机器翻译客户端未注册");
        // 自然语言处理
        Assert.isTrue(nlpConfigurationProperties != null, "自然语言处理属性未注入");
        Assert.isTrue(nlpConfigurationProperties.getAppId().equals("111"), "自然语言处理app-id属性异常");
        Assert.isTrue(nlpConfigurationProperties.getApiKey().equals("222"), "自然语言处理api-key属性异常");
        Assert.isTrue(nlpConfigurationProperties.getSecretKey().equals("333"), "自然语言处理secret-key属性异常");
        Assert.isTrue(aipNlp != null, "自然语言处理客户端未注册");
        // 文字识别
        Assert.isTrue(ocrConfigurationProperties != null, "文字识别属性未注入");
        Assert.isTrue(ocrConfigurationProperties.getAppId().equals("111"), "文字识别app-id属性异常");
        Assert.isTrue(ocrConfigurationProperties.getApiKey().equals("222"), "文字识别api-key属性异常");
        Assert.isTrue(ocrConfigurationProperties.getSecretKey().equals("333"), "文字识别secret-key属性异常");
        Assert.isTrue(aipOcr != null, "文字识别客户端未注册");
        // 语音技术
        Assert.isTrue(speechConfigurationProperties != null, "语音技术属性未注入");
        Assert.isTrue(speechConfigurationProperties.getAppId().equals("111"), "语音技术app-id属性异常");
        Assert.isTrue(speechConfigurationProperties.getApiKey().equals("222"), "语音技术api-key属性异常");
        Assert.isTrue(speechConfigurationProperties.getSecretKey().equals("333"), "语音技术secret-key属性异常");
        Assert.isTrue(aipSpeech != null, "语音技术客户端未注册");
    }
}
