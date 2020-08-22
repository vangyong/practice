package cn.segema.learn.safe.fastjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @description 调用命令行执行
 * @author wangyong
 * @createDate 2020/08/22
 */
public class ExecDemo {
    public ExecDemo() throws IOException, InterruptedException {
//        String cmd = "/Applications/Calculator.app/Contents/MacOS/Calculator"; //mac
        String cmd ="cmd.exe /c dir "; //windows
        final Process process = Runtime.getRuntime().exec(cmd);
        printMessage(process.getInputStream());;
        printMessage(process.getErrorStream());
        int value = process.waitFor();
        System.out.println(value);
    }

    private static void printMessage(final InputStream input) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Reader reader = new InputStreamReader(input);
                BufferedReader bf = new BufferedReader(reader);
                String line = null;
                try {
                    while ((line = bf.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecDemo execDemo = new ExecDemo();
    }
}
