package cn.segema.learn.interview.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandTest {
	public static void exeCmd(String commandStr) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(commandStr);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally
		{
			if (br != null)
			{
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		String commandStr = "ping www.taobao.com";
		//String commandStr = "ipconfig";
		CommandTest.exeCmd(commandStr);
	}
}