package cn.segema.learn.elasticsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @description rest-high-level-client
 * @author wangyong
 * @createDate 2020/08/25
 */
public class RestHighLevelClientDemo {
    static String indexName = "car";
    static String indexType = "transaction";

    public static void main(String[] args) throws IOException {
        String[] ips = {"10.10.143.147:9200"};
        HttpHost[] httpHosts = new HttpHost[ips.length];
        for (int i = 0; i < ips.length; i++) {
            httpHosts[i] = HttpHost.create(ips[i]);
        }
        RestClientBuilder builder = RestClient.builder(httpHosts);
        RestHighLevelClient highLevelClient = new RestHighLevelClient(builder);

        Map transaction1 = new HashMap<String,String>();
        transaction1.put("price", "25000");
        // 增, source 里对象创建方式可以是JSON字符串，或者Map，或者XContentBuilder 对象
        IndexRequest indexRequest = new IndexRequest(indexName, indexType, "1").source(transaction1);
        IndexResponse indexResponse = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        // 删
        DeleteRequest deleteRequest = new DeleteRequest(indexName, indexType, "1");
        DeleteResponse deleteResponse = highLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);

        // 改, source 里对象创建方式可以是JSON字符串，或者Map，或者XContentBuilder 对象
        UpdateRequest updateRequest = new UpdateRequest(indexName, indexType, "1").doc(transaction1);
        UpdateResponse updateResponse = highLevelClient.update(updateRequest, RequestOptions.DEFAULT);

        // 查
        GetRequest getRequest = new GetRequest(indexName, indexType, "1");
        GetResponse getResponse =  highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse);
    }

}
