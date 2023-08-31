package io.github.hanpijunbuhanpi.baidu.sdk.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * AES加解密工具类
 *
 * @author hanpijun-buhanpi
 * @since 2.1
 */
public class AesUtil {
    /** 十六进制 */
    private static final String HEX = "0123456789abcdef";
    // ECB 配置
    /**
     * ECB签名
     */
    private static final String AES_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";

    /**
     * 校验key是否合法
     *
     * @param key 密钥
     */
    private static void check(String key) {
        // 判空
        if (key == null) {
            throw new IllegalArgumentException("密钥为空");
        }
        // 长度校验
        if (key.length() != 16) {
            throw new IllegalArgumentException("密钥长度不为16");
        }
        // 十六进制校验
        if (!key.matches("^[0123456789abcdefABCDEF]*$")) {
            throw new IllegalArgumentException("密钥不为十六进制");
        }
    }

    /**
     * 十六进制转byte
     *
     * @param hex 十六进制字符串
     * @return byte数组
     */
    private static byte[] hexToBytes(String hex) {
        char[] chars = hex.toLowerCase().toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) HEX.indexOf(chars[i]);
        }
        return bytes;
    }

    /**
     * 获取key
     *
     * @param key 密钥
     * @return byte密钥
     */
    private static byte[] getKey(String key) {
        check(key);
        return hexToBytes(key);
    }

    /**
     * 通用执行方法，用来处理异常
     *
     * @param cipher Cipher
     * @param data 加密/解密前的数据
     * @return 加密/解密后的数据
     */
    private static byte[] doFinal(Cipher cipher, byte[] data) {
        try {
            return cipher.doFinal(data);
        } catch (IllegalBlockSizeException e) {
            // 工具类中Cipher全部使用PKCS5Padding模式，正常情况下不会出现此异常
            // 除非使用了NoPadding模式，而传入的数据又不符合密钥长度的倍数时
            throw new IllegalArgumentException("加密数据长度不为密钥长度的倍数", e);
        } catch (BadPaddingException e) {
            // 解密时，数据长度不为密钥长度倍数，即数据有误时触发此异常
            throw new IllegalArgumentException("解密数据错误", e);
        }
    }

    /**
     * 构建ECB Cipher
     *
     * @param key   密钥
     * @param model 模式
     * @return Cipher
     */
    private static Cipher getEcbCipher(byte[] key, int model) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM_ECB);
            cipher.init(model, secretKeySpec);
            return cipher;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            // 正常情况下不会抛出这些异常
            throw new IllegalArgumentException("ECB Cipher构建异常", e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("无效密钥", e);
        }
    }

    /**
     * ECB加密
     *
     * @param data 要加密的数据
     * @param key  加密密钥
     * @return 加密后的数据
     */
    public static byte[] ecbEncrypt(byte[] data, String key) {
        return doFinal(getEcbCipher(getKey(key), Cipher.ENCRYPT_MODE), data);
    }

    /**
     * ECB加密字符串
     *
     * @param data 要加密的数据
     * @param key  加密密钥
     * @return 加密后的数据
     */
    public static String encryptStringWithEcb(String data, String key) {
        return Base64.getEncoder().encodeToString(ecbEncrypt(data.getBytes(StandardCharsets.UTF_8), key));
    }

    /**
     * ECB解密
     *
     * @param data 要解密的数据
     * @param key  解密密钥
     * @return 解密后的数据
     */
    public static byte[] ecbDecrypt(byte[] data, String key) {
        return doFinal(getEcbCipher(getKey(key), Cipher.DECRYPT_MODE), data);
    }

    /**
     * ECB解密字符串
     *
     * @param data 要解密的数据
     * @param key  解密密钥
     * @return 解密后的数据
     */
    public static String decryptStringWithEcb(String data, String key) {
        return new String(ecbDecrypt(Base64.getDecoder().decode(data), key));
    }
}