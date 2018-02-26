package com.bikesystem.utils;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class AESEnctype {
	static final String KEY_ALGORITHM = "AES";
	static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";
	static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
	static final String CIPHER_ALGORITHM_CBC_NoPadding = "AES/CBC/NoPadding";
	static final String PASSWORD = "abc";

	/**
	 * 使用AES 算法 加密，默认模�? AES/ECB
	 */
	public static String encrypt(String content) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产�?
			kgen.init(128, new SecureRandom(PASSWORD.getBytes()));// 利用用户密码作为随机数初始化�?
			// 加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就�?样，�?以解密只要有password就行
			SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密�?
			byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回null
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
			Cipher cipher = Cipher.getInstance("AES");// 创建密码�?
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器
			byte[] result = cipher.doFinal(byteContent);// 加密
			return bytesToHexString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 解密
	 public static String decrypt(String srcHex) {
	        try {
	            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产�?
	            kgen.init(128, new SecureRandom(PASSWORD.getBytes()));
	            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密�?
	            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密�?
	            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
	            Cipher cipher = Cipher.getInstance("AES");// 创建密码�?
	            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
	            byte[] content = hexStringToByteArray(srcHex);
	            byte[] result = cipher.doFinal(content);  
	            return new String(result,"utf-8"); // 明文   
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return null;
	    }
	
	

	/**
	 * 16进制表示的字符串转换为字节数�?
	 *
	 * @param s
	 *            16进制表示的字符串
	 * @return byte[] 字节数组
	 */
	public static byte[] hexStringToByteArray(String s) {
		s = s.toLowerCase();
		int len = s.length();
		byte[] b = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			// 两位�?组，表示�?个字�?,把这样表示的16进制字符串，还原成一个字�?
			b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return b;
	}

	/**
	 * byte[]数组转换�?16进制的字符串
	 *
	 * @param bytes
	 *            要转换的字节数组
	 * @return 转换后的结果
	 */
	private static String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString().toUpperCase();
	}

	@Test
	public void test() {
		System.out.println(encrypt("user:123"));
		System.out.println(decrypt("A3A17B03C43E22CC8738995288B80B52"));
	}
}
