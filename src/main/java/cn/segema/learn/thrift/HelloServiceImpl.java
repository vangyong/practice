package cn.segema.learn.thrift;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {
	public String helloString(String para) throws TException {
		return "server result:" + para;
	}
}
