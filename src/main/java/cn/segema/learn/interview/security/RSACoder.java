package cn.segema.learn.interview.security;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.hbase.thirdparty.org.apache.commons.collections4.map.HashedMap;

public class RSACoder {

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
	public static final String PUBLIC_KEY = "public";
	public static final String PRIVATE_KEY = "private";

	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashedMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
	
	public static String getPublicKey(Map<String, Object> keyMap) {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return encodeBase64(key.getEncoded());
	}
	
	public static String getPrivateKey(Map<String, Object> keyMap) {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encodeBase64(key.getEncoded());
	}
	
	/**
	 * @description 公钥加密
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception 
	 */
	public static byte[] encryptByPulicKey(byte[] data,String key) throws Exception {
		byte[] keyBytes = decodeBase64(key);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		Cipher cipher= Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE,publicKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * @description 私钥解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	public static byte[] decryptByPrivateKey(byte[] data,String key) throws Exception {
		byte[] keyBytes = decodeBase64(key);
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher= Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE,privateKey);
		return cipher.doFinal(data);
	}
	
	public static String encodeBase64(byte[] src) {
		 return Base64.getEncoder().encodeToString(src);
	}

	public static byte[] decodeBase64(String str) {
		return Base64.getDecoder().decode(str);
	}
	
	/**
	 * @description 一句话描述该功能
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data,String privateKey) throws Exception {
		byte[] keyBytes = decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);
		return encodeBase64(signature.sign());
	}
	
	/**
	 * @description 一句话描述该功能
	 * @param data
	 * @param publicKey
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(byte[] data,String publicKey,String sign) throws Exception {
		byte[] keyBytes = decodeBase64(publicKey);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		//验证签名是否正常
		return signature.verify(decodeBase64(sign));
	}
	
}
