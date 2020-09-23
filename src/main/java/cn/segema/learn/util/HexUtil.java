package cn.segema.learn.util;

public class HexUtil {

    /**
     * 字符串转16进制码
     * @param abc
     * @return 61 62 63
     */
    public static String stringToHex(String str) {
        String[] splited = str.split("\\s+");
        StringBuffer pasredStr = new StringBuffer();
        for (int i = 0; i < splited.length; i++) {
            pasredStr = pasredStr.append(splited[i]);
        }
        char[] chars = pasredStr.toString().toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int)chars[i]));
            hex.append(" ");
        }
        return hex.toString();
    }

    /**
     * @description 16进制码转字符串
     * @param hex 61 62 63
     * @return abc
     */
    public static String hexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        String newHex = hex.substring(0, 2).toLowerCase().equals("0x") ? hex.substring(2, hex.length()) : hex;
        if (newHex.length() % 2 != 0) {
            return "";
        }

        String replacedHex = newHex.replaceAll(" ", "");
        for (int i = 0; i < replacedHex.length() - 1; i += 2) {
            String output = replacedHex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // System.out.println("\n-----ASCII码转换为16进制 -----");
        // String str = "ab";
        // System.out.println("字符串: " + str);
        // String hex = stringToHex(str);
        // System.out.println("转换为16进制 : " + hex);
        //
        // System.out.println("\n***** 16进制转换为ASCII *****");
        // System.out.println("Hex : " + hex);
        // System.out.println("ASCII : " + hexToString(hex));

        String hex2 = "0x61 62 63";
        System.out.println("ASCII : " + hexToString(hex2));

    }

}
