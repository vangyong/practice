package cn.segema.learn.util;

/**
 * 进制转换工具
 */
public final class BaseUtill {

	// 默认进制进制表
	private static final char[] HEX_TABLE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			.toCharArray();

	public static char[] getHexTable() {
		return HEX_TABLE;
	}

	/**
	 * 获取默认代码表支持的最大进制数
	 * 
	 * @return
	 */
	public static int getTableMaxHex() {
		return HEX_TABLE.length;
	}

	/**
	 * 获取字符代码的原数字
	 * 
	 * @param ch
	 * @return
	 */
	public static int getHexTableChar(char ch) {
		return String.valueOf(HEX_TABLE).indexOf(ch);
	}

	/**
	 * 十进制转任意进制
	 * 
	 * @param number 原10进制数
	 * @param hex    被转换成的进制数
	 * @return String
	 */
	public static String hex10ToAny(long number, int hex) {
		return hex10ToAny(number, hex, HEX_TABLE);
	}

	/**
	 * 十进制转任意进制
	 * 
	 * @param number   原10进制数
	 * @param hex      被转换成的进制数
	 * @param hexTable 进制表
	 * @return
	 */
	public static String hex10ToAny(long number, int hex, char[] hexTable) {
		if (hex > hexTable.length)
			return null;
		StringBuffer s = new StringBuffer();
		boolean negative = false; // 是否为负数
		if (number < 0) {
			number = -number;
			negative = true;
		}
		while (number != 0) {
			s.insert(0, hexTable[(int) (number % hex)]);
			number /= hex;
		}
		if (s.toString().isEmpty())
			s.append("0");
		else
			s.insert(0, negative ? "-" : "");
		return s.toString();
	}

	/**
	 * 任意进制转十进制<br/>
	 * 当返回null时，说明当前的进制数超过了进制表所能表达的字符
	 * 
	 * @param hexNumber 任意进制值
	 * @param hex       进制
	 * @return Long
	 */
	public static Long anyToHex10(String hexNumber, int hex) {
		return anyToHex10(hexNumber, hex, HEX_TABLE);
	}

	/**
	 * 任意进制转十进制<br/>
	 * 当返回null时，说明当前的进制数 超过了进制表所能表达的字符
	 * 
	 * @param hexNumber 任意进制值
	 * @param hex       进制
	 * @param hexTable  进制表
	 * @return Long
	 */
	public static Long anyToHex10(String hexNumber, int hex, char[] hexTable) {
		if (hex > hexTable.length)
			return null;
		String hexTableString = String.valueOf(hexTable);
		boolean negative = false; // 是否为负数
		if (hexNumber.indexOf("-") == 0) {
			hexNumber = hexNumber.substring(1);
			negative = true;
		}
		int hexNumLen = hexNumber.length();
		long number = 0;
		for (int i = 0; i < hexNumLen; i++)
			number += Math.pow(hex, i) * hexTableString.indexOf(hexNumber.charAt(hexNumLen - i - 1));
		if (negative)
			number = 0 - number;
		return number;
	}

	/**
	 * 任意进制转任意进制
	 * 
	 * @param hexNumber 任意进制值
	 * @param hex       任意进制
	 * @param toHex     转换成的进制
	 * @param hexTable  进制表
	 * @return
	 */
	public static String anyToAny(String hexNumber, int hex, int toHex, char[] hexTable) {
		Long hex10 = anyToHex10(hexNumber, hex, hexTable);
		if (hex10 == null)
			return null;
		return hex10ToAny(hex10, toHex, hexTable);
	}

	/**
	 * 任意进制转任意进制
	 * 
	 * @param hexNumber  任意进制值
	 * @param hex        任意进制
	 * @param toHex      转换成的进制
	 * @param hexTable   用于解析的进制表
	 * @param toHexTable 输出的进制表
	 * @return
	 */
	public static String anyToAny(String hexNumber, int hex, int toHex, char[] hexTable, char[] toHexTable) {
		Long hex10 = anyToHex10(hexNumber, hex, hexTable);
		if (hex10 == null)
			return null;
		return hex10ToAny(hex10, toHex, toHexTable);
	}

	/**
	 * 任意进制转任意进制
	 * 
	 * @param hexNumber 任意进制值
	 * @param hex       任意进制
	 * @param toHex     转换成的进制
	 * @return
	 */
	public static String anyToAny(String hexNumber, int hex, int toHex) {
		Long hex10 = anyToHex10(hexNumber, hex);
		if (hex10 == null)
			return null;
		return hex10ToAny(hex10, toHex);
	}
	
	
	public static void main(String[] args) {
		System.out.println(BaseUtill.anyToAny("110",2,16));
		
		
	}

}