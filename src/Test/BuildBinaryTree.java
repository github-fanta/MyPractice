package Test;

import java.util.LinkedList;
import java.util.Queue;

public class BuildBinaryTree {

	static int rootIndex = 0;
	
	public static void main(String[] args) {
		//测试数据一
		int[] preOrder = new int[] {1,2,4,5,3,6,8,10, 9, 11, 7};
		int[] inOrder = new int[] {4,2,5,1,10,8,6,11,9,3,7};
		//测试数据二
		///int[] preOrder = new int[] {1,2,4,5,3,6};
		//int[] inOrder = new int[] {4,2,5,1,6,3};
		BinaryTreeNode root = buildTree(preOrder, inOrder, 0, inOrder.length-1);
		
		/*层次遍历*/
		LinkedList<BinaryTreeNode> Q = new LinkedList<BinaryTreeNode>();
		Q.offer(root);
		while (Q.size() > 0) {
			BinaryTreeNode temp = Q.poll();
			if (temp.getLeft() != null) {
				Q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				Q.offer(temp.getRight());
			}
			System.out.println(temp.getData());
		}
		
	}
	
	//递归建立
	static BinaryTreeNode buildTree(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
		
		if (inStart > inEnd) {
			return null;
		}
		//递归的每一层，都是选取测范围数据的先序第0个作为根结点，刚好是按先序一个个向前访问
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.setData(preOrder[rootIndex]);
		rootIndex ++;

		int inIndex = search(inOrder, inStart, inEnd, newNode.getData());
		newNode.setLeft(buildTree(preOrder, inOrder, inStart, inIndex-1));
		newNode.setRight(buildTree(preOrder, inOrder, inIndex+1, inEnd));
		return newNode;
	}

	//在中序遍历中的位置
	private static int search(int[] inOrder, int inStart, int inEnd, int data) {

		if (inOrder == null) {
			System.out.println("search inOrder failure: inOrder is null");
			return -1;
		}
		for (int i=0; i<inOrder.length; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		System.out.println("have not found data in preOrder");
		return -1;
	}
}
