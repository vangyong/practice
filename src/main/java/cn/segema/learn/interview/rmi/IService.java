package cn.segema.learn.interview.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote {
	public String queryName(String no) throws RemoteException;
}
