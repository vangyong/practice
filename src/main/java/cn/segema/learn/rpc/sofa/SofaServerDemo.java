//package cn.segema.learn.rpc.sofa;
//
//import com.alipay.sofa.rpc.config.ProviderConfig;
//import com.alipay.sofa.rpc.config.RegistryConfig;
//import com.alipay.sofa.rpc.config.ServerConfig;
//
//public class SofaServerDemo {
//	public static void main(String[] args) {
//        // 指定注册中心
//        RegistryConfig registryConfig = new RegistryConfig()
//                .setProtocol("zookeeper")
//                .setAddress("127.0.0.1:2181");
//        // 指定服务端协议和地址
//        ServerConfig serverConfig = new ServerConfig()
//                .setProtocol("bolt")
//                .setPort(12345)
//                .setDaemon(false);
//        //　发布一个服务
//        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
//                .setInterfaceId(HelloService.class.getName())
//                .setRef(new HelloServiceImpl())
//                .setRegistry(registryConfig)
//                .setServer(serverConfig);
//        providerConfig.export();
//    }
//
//}
