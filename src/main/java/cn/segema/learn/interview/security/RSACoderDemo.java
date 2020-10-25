package cn.segema.learn.interview.security;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RSACoderDemo {
	private String publicKey;
	private String privateKey;

	@Before
	public void setUp() throws Exception {
		Map<String, Object> keyMap = RSACoder.initKey();
		publicKey = RSACoder.getPublicKey(keyMap);
		privateKey = RSACoder.getPrivateKey(keyMap);
		System.err.println("公钥：" + publicKey);
		System.err.println("私钥：" + privateKey);

	}

	/**
	 * @description 非对称加密
	 * @throws Exception
	 */
	@Test
	public void testEncrypt() throws Exception {
		System.err.println("公钥加密----私钥解密");
		String inputString = "abc";
		byte[] data = inputString.getBytes();
		byte[] encodedData = RSACoder.encryptByPulicKey(data, publicKey);
		byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);

		String outputString = new String(decodedData);
		System.err.println("加密前：" + inputString + "\n\r" + "解密后：" + outputString);
	}

	/**
	 * @description 数字签名
	 * @throws Exception
	 */
	@Test
	public void testSign() throws Exception {
		System.err.println("公钥加密----私钥解密");
		String inputString = "sign";
		byte[] data = inputString.getBytes();
		String signString = RSACoder.sign(data, privateKey);
		System.err.println("签名\n"+signString);
		boolean status = RSACoder.verify(data, publicKey, signString);
		System.err.println("状态\n" + status);
	}

	public static void main(String[] args) throws Exception {
		RSACoderDemo rsaCoderDemo = new RSACoderDemo();
		rsaCoderDemo.setUp();
//		rsaCoderDemo.testEncrypt();
		
		rsaCoderDemo.testSign();
	}
}
