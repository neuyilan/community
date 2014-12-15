package com.community.framework.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;

import com.mysql.jdbc.StringUtils;

public class ShiroUtil {

	/**
	 * 对密码进行shiro提供加密方式
	 * 过程：加salt随机数，进行512次hash迭代，再进行base64压缩，最终返回加密后的密码
	 * @param password
	 * @return
	 */
	public static String encrypt(String password) {
		String encryptedPassword = "";
		if(StringUtils.isNullOrEmpty(password)) {
			return null;
		}else{
			RandomNumberGenerator rng = new SecureRandomNumberGenerator();
			Object salt = rng.nextBytes();
			Sha512Hash encodedPassword = new Sha512Hash(password, salt, 512);
			encryptedPassword = encodedPassword.toBase64();
		}
		return encryptedPassword;
	}
	
}
