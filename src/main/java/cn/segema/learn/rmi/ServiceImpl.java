package cn.segema.learn.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

	private static final long serialVersionUID = 682805210518738166L;

	protected ServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String queryName(String no) throws RemoteException {
		System.out.println("hello" + no);
		return String.valueOf(System.currentTimeMillis());
	}
}
