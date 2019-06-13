package cn.segema.learn.elasticsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestClientDemo {

	public static final RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

//		RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
//		builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//			@Override
//			public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//				return httpClientBuilder.setProxy(new HttpHost("proxy", 9000, "http"));
//			}
//		});
//		RestClient restClient2 = builder.build();

		
		Map<String, String> params = new HashMap<>();
		Response response;
		try {
			response = restClient.performRequest("GET", "/article*/_search", params);
			System.out.println("采用performRequest:");
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		restClient.performRequestAsync("GET", "/csoc-alert*/_search", params, new ResponseListener() {
			@Override
			public void onSuccess(Response response) {
				try {
					JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
					System.out.println("采用performRequestAsync:");
					System.out.println(jsonObject.get("hits"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Exception e) {
				e.printStackTrace();
			}
		});

	}

}
