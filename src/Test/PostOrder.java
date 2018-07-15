package Test;

import java.util.Stack;

public class PostOrder {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		postOrder(tree.getRoot());
	}

	private static void postOrder(BinaryTreeNode root) {

		Stack<BinaryTreeNode> s = new Stack<>();
		while(true) {
			while(root != null) {
				s.push(root);
				root = root.getLeft();
			}
			
			if (s.isEmpty()) {
				break;
			}
			
			root = s.pop();
			if (root.getRight() == null) {
				System.out.println(root.getData());
				root = s.pop();
			}else {
				root = root.getRight();
			}
			
		}
	}
}
