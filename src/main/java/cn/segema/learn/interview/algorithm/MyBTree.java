package cn.segema.learn.interview.algorithm;

class BTreeNode{
	int T;
	int count;
	int key[];
	BTreeNode childs[];
	Boolean isleaf;
	
	public BTreeNode(int T) {
		this.T = T;
		key = new int[2+T-1];
		childs = new BTreeNode[2*T];
		isleaf = true;
		count = 0;
	}
}

public class MyBTree {

}
