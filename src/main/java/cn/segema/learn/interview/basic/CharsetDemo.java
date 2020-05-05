package cn.segema.learn.interview.basic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetDemo {

	public static void main(String[] args) {
		byte[] bytes1 = "中".getBytes(Charset.forName("GBK"));
		byte[] bytes2 = "中".getBytes(StandardCharsets.UTF_8);
		byte[] bytes3 = "中".getBytes(StandardCharsets.ISO_8859_1);
		byte[] bytes4 = "?".getBytes(StandardCharsets.ISO_8859_1);
		
		System.out.println(bytes1);

		byte[] sameBytesISO = "?".getBytes(StandardCharsets.ISO_8859_1);
		byte[] sameBytesGBK = "?".getBytes(Charset.forName("GBK"));
		byte[] sameBytesUTF8 = "?".getBytes(StandardCharsets.UTF_8);
		boolean b = '?' == 63;
		
		System.out.println(b);

	}

}
