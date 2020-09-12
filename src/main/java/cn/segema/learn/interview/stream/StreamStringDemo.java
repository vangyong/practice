package cn.segema.learn.interview.stream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description 输入流和string互转
 * @author wangyong
 * @createDate 2020/09/12
 */
public class StreamStringDemo {

    public static void main(String[] args) throws Exception {
        // // 网络获取流数据
        // URL url = new URL("https://www.baidu.com");
        // URLConnection urlConnection = url.openConnection(); // 打开网站链接
        // BufferedReader bufferedReader =
        // new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8")); // 实例化输入流，并获取网页代码
        // String s; // 依次循环,至到读的值为空
        // StringBuffer stringBuffer = new StringBuffer();
        // while ((s = bufferedReader.readLine()) != null) {
        // stringBuffer.append(s);
        // }
        // bufferedReader.close();
        // String str = stringBuffer.toString();
        // System.out.println(str);

        // // 字符串转inputStream
        // String string1 = "this is inputStream string1";
        // InputStream inputStream1 = new ByteArrayInputStream(string1.getBytes());
        // ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        // int i;
        // while ((i = inputStream1.read()) != -1) {
        // byteArrayOutputStream1.write(i);
        // }
        // String outString1 = byteArrayOutputStream1.toString();
        // System.out.println(outString1);

        // 字符串转OutputStream
        String string2 = "this is OutputStream string1";
        OutputStream os = System.out;
        os.write(string2.getBytes());
        
        
        

    }

}
