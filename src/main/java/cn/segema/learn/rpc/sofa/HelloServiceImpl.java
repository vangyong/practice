package cn.segema.learn.rpc.sofa;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
        return "hello " + name;
    }


}
