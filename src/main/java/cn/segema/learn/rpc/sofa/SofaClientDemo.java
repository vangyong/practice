package cn.segema.learn.rpc.sofa;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;

public class SofaClientDemo {
	 public static void main(String[] args) {
	        // 指定注册中心
	        RegistryConfig registryConfig = new RegistryConfig()
	                .setProtocol("zookeeper")
	                .setAddress("127.0.0.1:2181");
	        // 引用一个服务
	        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
	                .setInterfaceId(HelloService.class.getName())
	                .setProtocol("bolt")
	                .setRegistry(registryConfig);
	        // 拿到代理类
	        HelloService service = consumerConfig.refer();
	        
	        // 发起调用
	        while (true) {
	            System.out.println(service.sayHello("world"));
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	            }
	        }
	    }
}
