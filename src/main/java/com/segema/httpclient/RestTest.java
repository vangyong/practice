package com.segema.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.map.ObjectMapper;



public class RestTest {
	private static String LOGINURL = null;

	@SuppressWarnings("deprecation")
	public static ResultVo test(String userName, String paaWord) throws Exception {
		getAuthenticateUrl();
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(LOGINURL);
		post.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		post.setRequestHeader("Accept-Encoding", "gzip, deflate");
		post.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8");
		post.addRequestHeader("Content-Type","application/json");
		post.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		
		Parameter parameter = new Parameter();
		parameter.setEventId("5ccaa57a-2950-4277-9f48-3bf3ea0e2ae7");
		parameter.setEventId("eventId");
		ObjectMapper mapper = new ObjectMapper();
		String parameterJsonStr = mapper.writeValueAsString(parameter);
		Parameter parameterJson = mapper.readValue(parameterJsonStr, Parameter.class);  
		
		//下面三行不是必须参数
		//NameValuePair user_login_name = new NameValuePair("user_login_name", userName);
		//NameValuePair user_password = new NameValuePair("user_password", paaWord);
		//post.setRequestBody(new NameValuePair[] {user_login_name, user_password});
		
		post.setRequestBody(parameterJsonStr);
		
		//httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

		int status;
		ResultVo resultVo = new ResultVo();
		try {
			status = httpClient.executeMethod(post);
			if(status==200){
				String returnStr = post.getResponseBodyAsString();
				if(returnStr!=null&&(!"".equals(returnStr))){
					ObjectMapper returnMapper = new ObjectMapper();
					resultVo = returnMapper.readValue(returnStr, ResultVo.class);  
				}else{
					Result result = new Result();
					result.setStatus(0);
					resultVo.setResult(result);
					resultVo.setUserVo(null);
				}
			}else{
				Result result = new Result();
				result.setStatus(0);
				resultVo.setResult(result);
				resultVo.setUserVo(null);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return resultVo;
	}

	public static void getAuthenticateUrl() throws Exception {
		InputStream inputStream = RestTest.class.getClassLoader()
				.getResourceAsStream("authenticate.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(null!= properties.getProperty("centerAuth.url")&&!"".equals(properties.getProperty("centerAuth.url"))){
			LOGINURL = properties.getProperty("centerAuth.url");
		}else{
			throw new Exception("authenticate.properties 配置出错！");
		}
	}
}
