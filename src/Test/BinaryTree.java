package Test;

public class BinaryTree {
	
	BinaryTreeNode root = null;
	public BinaryTree() {
	    root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		root.setLeft(node2);
		root.setRight(node3);
		
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		node2.setLeft(node4);	
		node2.setRight(node5);
		
		BinaryTreeNode node6 = new BinaryTreeNode(4);
		BinaryTreeNode node7 = new BinaryTreeNode(5);
		node3.setLeft(node6);	
		node3.setRight(node7);
		
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		node4.setLeft(node8);	
		node4.setRight(node9);
		
	}
	public BinaryTreeNode getRoot() {
		return root;
	}
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
}
