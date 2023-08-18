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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * 测试部分不启用配置
 *
 * @author lyc
 * @since 2023/8/16 16:44
 */
@SpringBootTest(classes = {App.class})
@ActiveProfiles("test3")
public class PartDisableTest {
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
        // 图像增强
        boolean b5 = false;
        try {
            applicationContext.getBean(AipImageClassify.class);
        } catch (Exception e) {
            b5 = true;
        }
        Assert.isTrue(b5, "图像增强客户端注册了");
        // 图像处理
        boolean b6 = false;
        try {
            applicationContext.getBean(AipImageProcess.class);
        } catch (Exception e) {
            b6 = true;
        }
        Assert.isTrue(b6, "图像处理客户端注册了");
        // 图像搜索
        applicationContext.getBean(AipImageSearch.class);
        // 知识图谱
        applicationContext.getBean(AipKnowledgeGraphic.class);
        // 机器翻译
        applicationContext.getBean(Machinetranslation.class);
        // 自然语言处理
        applicationContext.getBean(AipNlp.class);
        // 文字识别
        applicationContext.getBean(AipOcr.class);
        // 语音技术
        applicationContext.getBean(AipSpeech.class);
    }
}
