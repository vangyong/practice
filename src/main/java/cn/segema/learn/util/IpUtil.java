package cn.segema.learn.util;

import java.math.BigInteger;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import com.googlecode.ipv6.IPv6Network;

public class IpUtil {

    /**
     * @description 获取远程客户端ip
     * @param request
     * @return String
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = null;
        // X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            // Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            // WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            // HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            // X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }
        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号(,)分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }
        // 还是不能获取到,最后再通过request.getRemoteAddr()获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * @description 验证ip格式是否正确
     * @param text
     * @return boolean
     */
    public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) {
            String regex =
                "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])"
                    + "$|^(([a-zA-Z]|[a-zA-Z][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z]|[A-Za-z][A-Za-z0-9\\-]*[A-Za-z0-9])$|^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|"
                    + "(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))"
                    + "|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|"
                    + "((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|"
                    + "((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}"
                    + "(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|"
                    + "(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)"
                    + "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)"
                    + "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$";
            if (text.matches(regex)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @description 一句话描述该功能
     * @param ipAddr
     * @return
     */
    public static boolean isIpv4(String ipv4) {
        String regex = "(^((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})"
            + "([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})$)";

        if (ipv4 == null) {
            System.out.println("ip addresss is null ");
            return false;
        }
        ipv4 = Normalizer.normalize(ipv4, Normalizer.Form.NFKC);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4);
        boolean match = matcher.matches();
        if (!match) {
            return false;
        }
        return match;
    }

    /**
     * @description ipv4、ipv6转换BigInteger
     * @param ip
     * @return BigInteger
     */
    public static BigInteger ipToBigInteger(String ip) {
        if (!StringUtils.isEmpty(ip)) {
            if (ip.contains(":")) {
                return ipv6ToBigInteger(ip);
            } else {
                return ipv4ToBigInteger(ip);
            }
        }
        return null;
    }

    /**
     * @description 根据ip获取范围地址 </br>
     * 如：192.168.9.返回192.168.9.0-192.168.9.255</br>
     * @param ipBigInteger
     * @return String
     */
    public static String[] getIpRange(String ip) {
        String[] returnArray = new String[2];
        String[] ipArray = ip.split("\\.");
        int length = ipArray.length;
        String lastChar = ip.substring(ip.length() - 1, ip.length());
        switch (length) {
            case 1:
                if (lastChar.equals(".")) {
                    returnArray[0] = ip + "0.0.0";
                    returnArray[1] = ip + "255.255.255";
                } else {
                    returnArray[0] = ip + ".0.0.0";
                    returnArray[1] = ip + ".255.255.255";
                }
                break;
            case 2:
                if (lastChar.equals(".")) {
                    returnArray[0] = ip + "0.0";
                    returnArray[1] = ip + "255.255";
                } else {
                    returnArray[0] = ip + ".0.0";
                    returnArray[1] = ip + ".255.255";
                }
                break;
            case 3:
                if (lastChar.equals(".")) {
                    returnArray[0] = ip + "0";
                    returnArray[1] = ip + "255";
                } else {
                    returnArray[0] = ip + ".0";
                    returnArray[1] = ip + ".255";
                }
                break;
            default:
                returnArray[0] = ip;
                returnArray[1] = ip;
                break;
        }
        if (!(ipCheck(returnArray[0]) && ipCheck(returnArray[1]))) {
            returnArray[0] = "255.255.255.255";
            returnArray[1] = "255.255.255.255";
        }
        return returnArray;
    }

    /**
     * @description 断某个ip是否在一个网段内 ip/mask IP+掩码
     * @param ip
     * @param cidr
     * @return boolean
     */
    public static boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16)
            | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24) | (Integer.parseInt(cidrIps[1]) << 16)
            | (Integer.parseInt(cidrIps[2]) << 8) | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
    }

    /**
     * @description 字符串ip转换成BigInteger型
     * @param ip
     * @return BigInteger
     */
    public static BigInteger ipv4ToBigInteger(String ip) {
        String[] ipArray = ip.split("\\.");
        Long ipLong = (Long.parseLong(ipArray[0]) << 24) + (Long.parseLong(ipArray[1]) << 16)
            + (Long.parseLong(ipArray[2]) << 8) + Long.parseLong(ipArray[3]);
        return BigInteger.valueOf(ipLong);
    }

    /**
     * @description ipv6转换为BigInteger
     * @param ipv6
     * @return
     */
    public static BigInteger ipv6ToBigInteger(String ipv6) {
        // 内嵌格式ipv6
        if (ipv6.contains(".")) {
            String ipv4Str = ipv6.substring(ipv6.lastIndexOf(":") + 1);
            String ipv6Str = ipv6.substring(0, ipv6.lastIndexOf(":") + 1) + "0000:0000";
            BigInteger ipv4BigInteger = ipToBigInteger(ipv4Str);
            BigInteger ipv6BigInteger = ipv6ToBigInteger(ipv6Str);
            return ipv4BigInteger.add(ipv6BigInteger);
        }
        int compressIndex = ipv6.indexOf("::");
        if (compressIndex != -1) {
            String part1s = ipv6.substring(0, compressIndex);
            String part2s = ipv6.substring(compressIndex + 1);
            BigInteger part1 = ipv6ToBigInteger(part1s);
            BigInteger part2 = ipv6ToBigInteger(part2s);
            int part1hasDot = 0;
            char ch[] = part1s.toCharArray();
            for (char c : ch) {
                if (c == ':') {
                    part1hasDot++;
                }
            }
            return part1.shiftLeft(16 * (7 - part1hasDot)).add(part2);
        }
        String[] str = ipv6.split(":");
        BigInteger big = BigInteger.ZERO;
        for (int i = 0; i < str.length; i++) {
            if (str[i].isEmpty()) {
                str[i] = "0";
            }
            big = big.add(BigInteger.valueOf(Long.valueOf(str[i], 16)).shiftLeft(16 * (str.length - i - 1)));
        }
        return big;
    }

    /**
     * @description BigInteger转字符串型ipv4
     * @param ipBigInteger
     * @return String
     */
    public static String bigIntegerToIpv4(BigInteger ipBigInteger) {
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf((ipBigInteger.longValue() >>> 24)));
        sb.append(".");
        sb.append(String.valueOf((ipBigInteger.longValue() & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((ipBigInteger.longValue() & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((ipBigInteger.longValue() & 0x000000FF)));
        return sb.toString();
    }

    /**
     * @description BigInteger转换为ipv6
     * @param bigInteger
     * @return
     */
    public static String bigIntegerToIpv6(BigInteger ipBigInteger) {
        String str = "";
        BigInteger ff = BigInteger.valueOf(0xffff);
        for (int i = 0; i < 8; i++) {
            str = ipBigInteger.and(ff).toString(16) + ":" + str;
            ipBigInteger = ipBigInteger.shiftRight(16);
        }
        str = str.substring(0, str.length() - 1);
        String ipv6 = str.replaceFirst("(^|:)(0+(:|$)){2,8}", "::");
        return abbreviationToIpv6(ipv6);
    }

    public static String bigIntegerToIp(BigInteger ipBigInteger) {
        String ip = bigIntegerToIpv6(ipBigInteger);
        if ("0.0.0.0".equals(ip)) {
            ip = bigIntegerToIpv4(ipBigInteger);
            return ip;
        } else {
            return ip;
        }
    }

    /**
     * 根据网段计算起始IP 网段格式:x.x.x.x/x
     * 一个网段0一般为网络地址,255一般为广播地址.
     * 起始IP计算:网段与掩码相与之后加一的IP地址
     * @param segment  网段
     * @return 起始IP
     */
    public static String getStartIpv4(String segment) {
        StringBuffer startIp = new StringBuffer();
        if (segment == null) {
            return null;
        }
        String arr[] = segment.split("/");
        String ip = arr[0];
        String maskIndex = arr[1];
        String mask = getNetMask(maskIndex);
        if (4 != ip.split("\\.").length || mask == null) {
            return null;
        }
        int ipArray[] = new int[4];
        int netMaskArray[] = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                ipArray[i] = Integer.parseInt(ip.split("\\.")[i]);
                netMaskArray[i] = Integer.parseInt(mask.split("\\.")[i]);
                if (ipArray[i] > 255 || ipArray[i] < 0 || netMaskArray[i] > 255 || netMaskArray[i] < 0) {
                    return null;
                }
                ipArray[i] = ipArray[i] & netMaskArray[i];
                if (i == 3) {
                    startIp.append(ipArray[i] + 1);
                } else {
                    startIp.append(ipArray[i] + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return startIp.toString();
    }

    /**
     * @description 根据网段计算结束ip
     * @param segment
     * @return 结束IP
     */
    public static String getEndIpv4(String segment) {
        StringBuffer endIp = new StringBuffer();
        String startIp = getStartIp(segment);
        if (segment == null) {
            return null;
        }
        String arr[] = segment.split("/");
        String maskIndex = arr[1];
        // 实际需要的IP个数
        int hostNumber = 0;
        int startIpArray[] = new int[4];
        try {
            hostNumber = 1 << 32 - (Integer.parseInt(maskIndex));
            for (int i = 0; i < 4; i++) {
                startIpArray[i] = Integer.parseInt(startIp.split("\\.")[i]);
                if (i == 3) {
                    startIpArray[i] = startIpArray[i] - 1;
                    break;
                }
            }
            startIpArray[3] = startIpArray[3] + (hostNumber - 1);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if (startIpArray[3] > 255) {
            int k = startIpArray[3] / 256;
            startIpArray[3] = startIpArray[3] % 256;
            startIpArray[2] = startIpArray[2] + k;
        }
        if (startIpArray[2] > 255) {
            int j = startIpArray[2] / 256;
            startIpArray[2] = startIpArray[2] % 256;
            startIpArray[1] = startIpArray[1] + j;
            if (startIpArray[1] > 255) {
                int k = startIpArray[1] / 256;
                startIpArray[1] = startIpArray[1] % 256;
                startIpArray[0] = startIpArray[0] + k;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                startIpArray[i] = startIpArray[i] - 1;
            }
            if ("" == endIp.toString() || endIp.length() == 0) {
                endIp.append(startIpArray[i]);
            } else {
                endIp.append("." + startIpArray[i]);
            }
        }
        return endIp.toString();
    }

    /**
     * @description 根据网段计算起始IPv6
     * @param segment
     * @return 起始IPv6
     */
    public static String getStartIpv6(String segment) {
        IPv6Network rangeNetwork = IPv6Network.fromString(segment);
        return rangeNetwork.getFirst().toString();
    }

    /**
     * @description 根据网段计算结束IPv6
     * @param segment
     * @return 结束IPv6
     */
    public static String getEndIpv6(String segment) {
        IPv6Network rangeNetwork = IPv6Network.fromString(segment);
        return rangeNetwork.getLast().toString();
    }

    /**
     * @description 根据网段计算起始IPv4或者IPv6
     * @param segment
     * @return String
     */
    public static String getStartIp(String segment) {
        if (segment.contains(":")) {
            return getStartIpv6(segment);
        } else {
            return getStartIpv4(segment);
        }
    }

    /**
     * 根据网段计算结束IPv4或者IPv6
     *
     * @param segment
     * @return 结束IPv4或者IPv6
     */
    public static String getEndIp(String segment) {
        if (segment.contains(":")) {
            return getEndIpv6(segment);
        } else {
            return getEndIpv4(segment);
        }
    }

    /**
     * @Description 根据网段计算起始IPv4或者IPv6的BigInteger值
     * @param segment
     * @return 起始ip的BigInteger值
     */
    public static BigInteger getStartIpBigInteger(String segment) {
        String startIp = getStartIp(segment);
        return ipToBigInteger(startIp);
    }

    /**
     * @Description 根据网段计算结束IPv4或者IPv6的BigInteger值
     * @param segment
     * @return 结束ip的BigInteger值
     */
    public static BigInteger getEndIpBigInteger(String segment) {
        String endIp = getEndIp(segment);
        return ipToBigInteger(endIp);
    }

    /**
     * @description 缩写转ipv6
     * @param abbreviation
     * @return
     */
    public static String abbreviationToIpv6(String abbreviation) {
        String fullIPv6 = "";
        if ("::".equals(abbreviation)) {
            return "0000:0000:0000:0000:0000:0000:0000:0000";
        }

        String[] arr = new String[] {"0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000"};

        if (abbreviation.startsWith("::")) {
            String[] temp = abbreviation.substring(2, abbreviation.length()).split(":");
            for (int i = 0; i < temp.length; i++) {
                String tempStr = "0000" + temp[i];
                arr[i + 8 - temp.length] = tempStr.substring(tempStr.length() - 4);
            }

        } else if (abbreviation.endsWith("::")) {
            String[] temp = abbreviation.substring(0, abbreviation.length() - 2).split(":");
            for (int i = 0; i < temp.length; i++) {
                String tempStr = "0000" + temp[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }

        } else if (abbreviation.contains("::")) {
            String[] tempArr = abbreviation.split("::");

            String[] temp0 = tempArr[0].split(":");
            for (int i = 0; i < temp0.length; i++) {
                String tempStr = "0000" + temp0[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }

            String[] temp1 = tempArr[1].split(":");
            for (int i = 0; i < temp1.length; i++) {
                String tempStr = "0000" + temp1[i];
                arr[i + 8 - temp1.length] = tempStr.substring(tempStr.length() - 4);
            }

        } else {
            String[] tempArr = abbreviation.split(":");

            for (int i = 0; i < tempArr.length; i++) {
                String tempStr = "0000" + tempArr[i];
                arr[i] = tempStr.substring(tempStr.length() - 4);
            }

        }
        fullIPv6 = StringUtils.join(arr, ":");
        return fullIPv6;
    }

    public static String abbreviationIpv6(String ipv6) {
        String abbreviation = "";

        // 1,校验 ":" 的个数 不等于7  或者长度不等于39  直接返回空串
        int count = ipv6.length() - ipv6.replaceAll(":", "").length();
        if (ipv6.length() != 39 || count != 7) {
            return abbreviation;
        }

        // 2,去掉每一位前面的0
        String[] arr = ipv6.split(":");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("^0{1,3}", "");
        }

        // 3,找到最长的连续的0
        String[] arr2 = arr.clone();
        for (int i = 0; i < arr2.length; i++) {
            if (!"0".equals(arr2[i])) {
                arr2[i] = "-";
            }
        }

        Pattern pattern = Pattern.compile("0{2,}");
        Matcher matcher = pattern.matcher(StringUtils.join(arr2, ""));
        String maxStr = "";
        int start = -1;
        int end = -1;
        while (matcher.find()) {
            if (maxStr.length() < matcher.group().length()) {
                maxStr = matcher.group();
                start = matcher.start();
                end = matcher.end();
            }
        }
        if (maxStr.length() > 0) {
            for (int i = start; i < end; i++) {
                arr[i] = ":";
            }
        }
        abbreviation = StringUtils.join(arr, ":");
        abbreviation = abbreviation.replaceAll(":{2,}", "::");
        return abbreviation;
    }

    /**
     * @Description 根据掩码位数计算掩码
     * @param maskIndex 掩码位
     * @return 子网掩码
     */
    public static String getNetMask(String maskIndex) {
        StringBuilder mask = new StringBuilder();
        Integer inetMask = 0;
        try {
            inetMask = Integer.parseInt(maskIndex);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
        if (inetMask > 32) {
            return null;
        }
        int num1 = inetMask / 8; // 子网掩码为1占了几个字节
        int num2 = inetMask % 8; // 子网掩码的补位位数
        int array[] = new int[4];
        for (int i = 0; i < num1; i++) {
            array[i] = 255;
        }
        for (int i = num1; i < 4; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < num2; num2--) {
            array[num1] += 1 << 8 - num2;
        }
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                mask.append(array[i]);
            } else {
                mask.append(array[i] + ".");
            }
        }
        return mask.toString();
    }

    public static void main(String[] args) {
        System.out.println(ipCheck("::ffff:a0a:1302"));
        System.out.println(isIpv4("10.10.19.2"));
        System.out.println(ipToBigInteger("fe80::"));
        System.out.println(bigIntegerToIpv6(new BigInteger("338288524927261089654018896841347694592")));
        System.out.println(bigIntegerToIp(new BigInteger("338288524927261089654018896841347694592")));
        System.out.println(ipToBigInteger("255.255.255.255"));
        System.out.println(ipToBigInteger("::ffff:a0a:1302"));
        System.out.println("------------------------------");
        System.out.println(ipToBigInteger("10.10.19.2"));
        System.out.println(ipToBigInteger("::ffff:10.10.19.2"));
        System.out.println(ipToBigInteger("::a0a:1302").intValue());
        System.out.println(ipToBigInteger("10.10.19.142"));
        System.out.println(ipToBigInteger("10.223.2.2"));
        System.out.println(ipToBigInteger("10.10.19.12"));
    }

}
