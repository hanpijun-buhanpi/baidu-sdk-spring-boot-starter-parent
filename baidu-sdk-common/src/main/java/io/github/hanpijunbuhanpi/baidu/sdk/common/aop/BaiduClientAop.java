package io.github.hanpijunbuhanpi.baidu.sdk.common.aop;

import io.github.hanpijunbuhanpi.baidu.sdk.common.config.property.BaiduGlobalConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 百度客户端Aop
 *
 * @author hanpijun-buhanpi
 * @since 2.2.1
 */
@Slf4j
@Aspect
public class BaiduClientAop {
    /** 百度全局配置 */
    @Autowired
    private BaiduGlobalConfigurationProperties baiduGlobalConfigurationProperties;
    /** api描述Map */
    private final HashMap<String, String> apiDescriptionMap = new HashMap<>(16);

    /**
     * 根据方法签名修改api描述
     *
     * @param methodSignature 方法签名
     * @param desc api描述
     *
     * @since 2.2.1
     */
    public void modifyApiDescription(String methodSignature, String desc) {
        apiDescriptionMap.put(methodSignature, desc);
    }

    /**
     * 根据指定的方法生成方法签名，并修改api描述
     *
     * @param desc api描述
     * @param clazz 方法所在类
     * @param methodName 方法名
     * @param paramsType 方法参数
     * @throws NoSuchMethodException 没有方法异常
     *
     * @since 2.2.1
     */
    public void modifyApiDescription(String desc, Class<?> clazz, String methodName, Class<?>... paramsType) throws NoSuchMethodException {
        String methodSignature = getMethodSignature(clazz.getMethod(methodName, paramsType));
        apiDescriptionMap.put(methodSignature, desc);
    }

    /**
     * 使用所有同名的方法生成方法签名，并修改api描述
     *
     * @param desc api描述
     * @param clazz 方法所在类
     * @param methodName 方法名
     *
     * @since 2.2.1
     */
    public void modifyApiDescription(String desc, Class<?> clazz, String methodName) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                String methodSignature = getMethodSignature(method);
                apiDescriptionMap.put(methodSignature, desc);
            }
        }
    }

    /**
     * 获取方法签名，该方法用于生成和ProceedingJoinPoint.getSignature()方法返回的一致的方法签名
     *
     * @param method 方法
     * @return 方法签名
     *
     * @since 2.2.1
     */
    public String getMethodSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getReturnType().getSimpleName()).append(" ");
        sb.append(method.getDeclaringClass().getName()).append(".");
        sb.append(method.getName()).append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 0) {
            for (Class<?> parameterType : parameterTypes) {
                sb.append(parameterType.getSimpleName()).append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * 切入点
     *
     * @since 2.2.1
     */
    @Pointcut("target(com.baidu.aip.client.BaseClient)")
    private void baiduClient() {

    }

    /**
     * 环绕通知
     *
     * @param pjp 切入点
     * @return 切入点方法执行结果
     *
     * @since 2.2.1
     */
    @Around("baiduClient()")
    private Object baiduClientLog(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        Object proceed;
        try {
            logParameter(signature.toString(), pjp.getArgs());
            long start = System.currentTimeMillis();
            proceed = pjp.proceed(pjp.getArgs());
            long end = System.currentTimeMillis();
            logResult(signature.toString(), proceed);
            logRuntime(signature.toString(), end - start);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        return proceed;
    }

    /**
     * 打印参数
     *
     * @param methodSignature 方法签名
     * @param parameters 参数数组
     *
     * @since 2.2.1
     */
    private void logParameter(String methodSignature, Object[] parameters) {
        if (baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.info ||
                baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.info_runtime) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i].getClass().getName())
                        .append(" ")
                        .append(parameters[i]);
                if (i != parameters.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            log.info(baiduGlobalConfigurationProperties.getLogLanguage().getParameter(), getApiDescription(methodSignature), sb);
        }
    }

    /**
     * 打印结果
     *
     * @param methodSignature 方法签名
     * @param result 结果
     *
     * @since 2.2.1
     */
    private void logResult(String methodSignature, Object result) {
        if (baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.info ||
                baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.info_runtime) {
            log.info(baiduGlobalConfigurationProperties.getLogLanguage().getResult(), getApiDescription(methodSignature), result);
        }
    }

    /**
     * 打印耗时
     *
     * @param methodSignature 方法签名
     * @param runtime 耗时ms
     *
     * @since 2.2.1
     */
    private void logRuntime(String methodSignature, long runtime) {
        if (baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.runtime ||
                baiduGlobalConfigurationProperties.getLog() == BaiduGlobalConfigurationProperties.Log.info_runtime) {
            log.info(baiduGlobalConfigurationProperties.getLogLanguage().getRuntime(), getApiDescription(methodSignature), runtime);
        }
    }

    /**
     * 获取api描述
     *
     * @param methodSignature 方法签名
     * @return api描述
     *
     * @since 2.2.1
     */
    private String getApiDescription(String methodSignature) {
        return apiDescriptionMap.getOrDefault(methodSignature, methodSignature);
    }
}
