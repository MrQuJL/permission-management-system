package com.lyu.drp.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.lyu.drp.util.EncryptUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 类名称: 测试各种加密算法的测试类
 * 类描述: 用于测试各种加密算法
 * 全限定性类名: com.lyu.drp.test.EncryptTest
 * @author 曲健磊
 * @date 2018年1月15日 下午12:37:31
 * @version V1.0
 */
public class EncryptTest {
	
	// 测试不可逆加密算法MD5
	@Test
	public void testMD5() {
		String plainPsd = "123456";
		System.out.println(DigestUtils.md5Hex(plainPsd));
		// e10adc3949ba59abbe56e057f20f883e
	}
	
	// 测试不可逆的加密算法SHA1
	@Test
	public void testSha1() {
		String plainPsd = "123456";
		System.out.println(DigestUtils.sha1Hex(plainPsd));
		// 7c4a8d09ca3762af61e59520943dc26494f8941b
	}
	
	// 测试可逆的加密算法BASE64加密
	@Test
	public void testBASE64Encode() {
		String plainPsd = "123456";
		System.out.println(Base64.encode(plainPsd.getBytes()));
		// MTIzNDU2
	}
	
	// 测试可逆的加密算法BASE64解密
	@Test
	public void testBASE64Decode() {
		String plainPsd = "MTIzNDU2";
		System.out.println(new String(Base64.decode(plainPsd)));
		// 123456
		// 返回的是一个字节数组
	}
	
	// 测试可逆的加密算法HEX加密
	@Test
	public void testHexEncode() {
		String plainPsd = "123456";
		System.out.println(Hex.encodeHex(plainPsd.getBytes()));
		// 313233343536
		// 12位
	}
	
	// 测试可逆的加密算法HEX解密
	@Test
	public void testHexDecode() throws DecoderException {
		String plainPsd = "313233343536";
		System.out.println(new String(Hex.decodeHex(plainPsd.toCharArray())));
		// 123456
		// hex加密后的密文的位数是元位数的2倍
	}
	
//	1. 生成一个随机数
//	2. 用可逆的加密算法Hex加密随机数
//	3. 将随机数和密码用sha1不可逆算法加密
//	4. 将第三步得到的字符串值用可逆的加密算法加密
//	5. 将第2步和第四步的值拼凑
	
//  更可靠的原因：
//	1. 破译者不知道使用的那种加密算法
//	2. 盐的位数不确定
//	3. 迭代次数也可以设置
	
	@Test
	public void testDrpEncrypt() {
		EncryptUtils encryptUtil = new EncryptUtils();
		// 原密码
		String plainPsd = "123456";
		// 1. 生成一个随机数
		byte[] random = encryptUtil.generateSalt(8);
		// 2. 用可逆的加密算法加密随机数
		String randomHex = encryptUtil.encodeHex(random);
		// 3. 将随机数和密码用sha1不可逆加密算法加密
		byte[] temp = encryptUtil.sha1(plainPsd.getBytes(), random, 1024);
		// 4. 将第3步得到的字符串值用可逆的加密算法加密
		String sha1Psd = encryptUtil.encodeHex(temp);
		// 5. 将第2步和第四步的值拼凑
		String encryptPsd = randomHex + sha1Psd;
		
		// d69b3e3983365aecfa39b7f23b0ae06d57f6200f0e6a12e3292aa73f
		System.out.println(encryptPsd);
		
	}
	
	// 密码验证(解密操作)
	@Test
	public void testPsdValidator() {
		String password = "123456";
		String encryptPsd = "d69b3e3983365aecfa39b7f23b0ae06d57f6200f0e6a12e3292aa73f";
		// 将密文逆转，截取salt盐的明文
		byte[] salt = EncryptUtils.decodeHex(encryptPsd.substring(0, 16));
		
		// 重新拼凑盐和密码，进行sha1加密
		byte[] hashPass = EncryptUtils.sha1(password.getBytes(), salt, 1024);
		String newEncryptPsd = EncryptUtils.encodeHex(salt) + EncryptUtils.encodeHex(hashPass);
		System.out.println(newEncryptPsd);
	}
	
	
}
