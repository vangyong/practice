package cn.segema.learn.interview.algorithm;

/**
 * @description 红黑树
 * @author wangyong
 * @createDate 2020/08/08
 */
public class RedBlackTreeDemo {

	private final int R = 0;
	private final int B = 1;

	private Node root = null;

	class Node {
		int data;
		int color;
		Node left;
		Node right;
		Node parent;

		public Node(int data) {
			this.data = data;
		}
	}

	//节点插入
	public void insert(Node root, int data) {
		if (root.data < data) {
			if (root.right == null) {
				root.right = new Node(data);
			} else {
				insert(root.right, data);
			}
		} else {
			if (root.left == null) {
				root.left = new Node(data);
			} else {
				insert(root.left, data);
			}
		}
	}
	
	//左旋
	public void leftRotate(Node node) {
		if(node.parent==null) {
			Node E = root;
			Node S = E.right;
			
			//第一步移S的左子树
			E.right = S.left;
			S.left.parent = E;
			
			//第二步修改E的指针
			E.parent = S;
			
			//第三步修改S的指针
			S.parent = null;
		}
	}
}
