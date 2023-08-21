package io.test;

import io.App;
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
import io.github.hanpijunbuhanpi.baidu.sdk.bodyanalysis.service.BaiduBodyAnalysis;
import io.github.hanpijunbuhanpi.baidu.sdk.contentcensor.service.BaiduContentCensor;
import io.github.hanpijunbuhanpi.baidu.sdk.easydl.service.BaiduEasyDL;
import io.github.hanpijunbuhanpi.baidu.sdk.face.service.BaiduFace;
import io.github.hanpijunbuhanpi.baidu.sdk.imageclassify.service.BaiduImageClassify;
import io.github.hanpijunbuhanpi.baidu.sdk.imageprocess.service.BaiduImageProcess;
import io.github.hanpijunbuhanpi.baidu.sdk.imagesearch.service.BaiduImageSearch;
import io.github.hanpijunbuhanpi.baidu.sdk.kg.service.BaiduKnowledgeGraphic;
import io.github.hanpijunbuhanpi.baidu.sdk.machinetranslation.service.BaiduMachineTranslation;
import io.github.hanpijunbuhanpi.baidu.sdk.nlp.service.BaiduNlp;
import io.github.hanpijunbuhanpi.baidu.sdk.ocr.service.BaiduOcr;
import io.github.hanpijunbuhanpi.baidu.sdk.speech.service.BaiduSpeech;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试全局不启用配置
 *
 * @author lyc
 * @since 2023/8/16 16:44
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test2")
public class GlobalDisableTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        // 人体分析
        boolean b1 = false;
        try {
            applicationContext.getBean(AipBodyAnalysis.class);
        } catch (Exception e) {
            b1 = true;
        }
        Assert.isTrue(b1, "人体分析客户端注册了");
        // 内容审核
        boolean b2 = false;
        try {
            applicationContext.getBean(AipContentCensor.class);
        } catch (Exception e) {
            b2 = true;
        }
        Assert.isTrue(b2, "内容审核客户端注册了");
        // EasyDL零门槛AI开发
        boolean b3 = false;
        try {
            applicationContext.getBean(AipEasyDL.class);
        } catch (Exception e) {
            b3 = true;
        }
        Assert.isTrue(b3, "EasyDL客户端注册了");
        // 人脸识别
        boolean b4 = false;
        try {
            applicationContext.getBean(AipFace.class);
        } catch (Exception e) {
            b4 = true;
        }
        Assert.isTrue(b4, "人脸识别客户端注册了");
        // 图像识别
        boolean b5 = false;
        try {
            applicationContext.getBean(AipImageClassify.class);
        } catch (Exception e) {
            b5 = true;
        }
        Assert.isTrue(b5, "图像识别客户端注册了");
        // 图像增强
        boolean b6 = false;
        try {
            applicationContext.getBean(AipImageProcess.class);
        } catch (Exception e) {
            b6 = true;
        }
        Assert.isTrue(b6, "图像增强客户端注册了");
        // 图像搜索
        boolean b7 = false;
        try {
            applicationContext.getBean(AipImageSearch.class);
        } catch (Exception e) {
            b7 = true;
        }
        Assert.isTrue(b7, "图像搜索客户端注册了");
        // 知识图谱
        boolean b8 = false;
        try {
            applicationContext.getBean(AipKnowledgeGraphic.class);
        } catch (Exception e) {
            b8 = true;
        }
        Assert.isTrue(b8, "知识图谱客户端注册了");
        // 机器翻译
        boolean b9 = false;
        try {
            applicationContext.getBean(Machinetranslation.class);
        } catch (Exception e) {
            b9 = true;
        }
        Assert.isTrue(b9, "机器翻译客户端注册了");
        // 自然语言处理
        boolean b10 = false;
        try {
            applicationContext.getBean(AipNlp.class);
        } catch (Exception e) {
            b10 = true;
        }
        Assert.isTrue(b10, "自然语言处理客户端注册了");
        // 文字识别
        boolean b11 = false;
        try {
            applicationContext.getBean(AipOcr.class);
        } catch (Exception e) {
            b11 = true;
        }
        Assert.isTrue(b11, "文字识别客户端注册了");
        // 语音技术
        boolean b12 = false;
        try {
            applicationContext.getBean(AipSpeech.class);
        } catch (Exception e) {
            b12 = true;
        }
        Assert.isTrue(b12, "语音技术客户端注册了");



        // 人体分析
        b1 = false;
        try {
            applicationContext.getBean(BaiduBodyAnalysis.class);
        } catch (Exception e) {
            b1 = true;
        }
        Assert.isTrue(b1, "Starter人体分析客户端注册了");
        // 内容审核
        b2 = false;
        try {
            applicationContext.getBean(BaiduContentCensor.class);
        } catch (Exception e) {
            b2 = true;
        }
        Assert.isTrue(b2, "Starter内容审核客户端注册了");
        // EasyDL零门槛AI开发
        b3 = false;
        try {
            applicationContext.getBean(BaiduEasyDL.class);
        } catch (Exception e) {
            b3 = true;
        }
        Assert.isTrue(b3, "Starter EasyDL客户端注册了");
        // 人脸识别
        b4 = false;
        try {
            applicationContext.getBean(BaiduFace.class);
        } catch (Exception e) {
            b4 = true;
        }
        Assert.isTrue(b4, "Starter人脸识别客户端注册了");
        // 图像识别
        b5 = false;
        try {
            applicationContext.getBean(BaiduImageClassify.class);
        } catch (Exception e) {
            b5 = true;
        }
        Assert.isTrue(b5, "Starter图像识别客户端注册了");
        // 图像增强
        b6 = false;
        try {
            applicationContext.getBean(BaiduImageProcess.class);
        } catch (Exception e) {
            b6 = true;
        }
        Assert.isTrue(b6, "Starter图像增强客户端注册了");
        // 图像搜索
        b7 = false;
        try {
            applicationContext.getBean(BaiduImageSearch.class);
        } catch (Exception e) {
            b7 = true;
        }
        Assert.isTrue(b7, "Starter图像搜索客户端注册了");
        // 知识图谱
        b8 = false;
        try {
            applicationContext.getBean(BaiduKnowledgeGraphic.class);
        } catch (Exception e) {
            b8 = true;
        }
        Assert.isTrue(b8, "Starter知识图谱客户端注册了");
        // 机器翻译
        b9 = false;
        try {
            applicationContext.getBean(BaiduMachineTranslation.class);
        } catch (Exception e) {
            b9 = true;
        }
        Assert.isTrue(b9, "Starter机器翻译客户端注册了");
        // 自然语言处理
        b10 = false;
        try {
            applicationContext.getBean(BaiduNlp.class);
        } catch (Exception e) {
            b10 = true;
        }
        Assert.isTrue(b10, "Starter自然语言处理客户端注册了");
        // 文字识别
        b11 = false;
        try {
            applicationContext.getBean(BaiduOcr.class);
        } catch (Exception e) {
            b11 = true;
        }
        Assert.isTrue(b11, "Starter文字识别客户端注册了");
        // 语音技术
        b12 = false;
        try {
            applicationContext.getBean(BaiduSpeech.class);
        } catch (Exception e) {
            b12 = true;
        }
        Assert.isTrue(b12, "Starter语音技术客户端注册了");
    }
}
