package cn.segema.learn.util;

public class HexUtil {

	public static String convertStringToHex(String str) {

		char[] chars = str.toCharArray();

		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}

		return hex.toString();
	}

	public static String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < hex.length() - 1; i += 2) {
			String output = hex.substring(i, (i + 2));
			int decimal = Integer.parseInt(output, 16);
			sb.append((char) decimal);
			temp.append(decimal);
		}

		return sb.toString();
	}

	// 504F533838383834 POS88884
	public static void main(String[] args) {

//		HexUtil hexUtil = new HexUtil();
//		System.out.println("\n-----ASCII码转换为16进制 -----");
//		String str = "POS88884";
//		System.out.println("字符串: " + str);
//		String hex = hexUtil.convertStringToHex(str);
//		System.out.println("转换为16进制 : " + hex);
//
//		System.out.println("\n***** 16进制转换为ASCII *****");
//		System.out.println("Hex : " + hex);
//		System.out.println("ASCII : " + hexUtil.convertHexToString(hex));

//		String t1 = "ff ff ff ff ff ff 08 00 27 b5 b7 19 08 00";
//		HexUtil hexUtil = new HexUtil();
//		String[] splited = t1.split("\\s+");
//		StringBuffer retStr = new StringBuffer();
//		for(int i=0;i<splited.length;i++) {
//			retStr = retStr.append(splited[i]);
//		}
//		System.out.println(retStr);
//		System.out.println("ASCII : " + hexUtil.convertHexToString(retStr.toString()));

		String hexStr = "ffffffffffff";

		System.out.println("ASCII : " + convertHexToString(hexStr.toString()));

	}

}
