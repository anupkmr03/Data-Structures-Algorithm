package tree;

public class BinaryTree {
	BTNode root;

	public void insert(int data) {
		root = insert(root, data);
	}

	public BTNode insert(BTNode node, int data) {
		if (node == null) {
			node = new BTNode(data);
		} else {
			if (node.left == null) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public void inorderTraversal() {
		inorderTraversal(root);
	}

	private void inorderTraversal(BTNode node) {
		if (node != null) {
			inorderTraversal(node.left);
			System.out.println(node.data);
			inorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(1);
		bt.insert(4);
		bt.insert(15);
		bt.insert(14);
		bt.insert(21);
		bt.insert(6);
		bt.inorderTraversal();
	}
}

class BTNode {
	int data;
	BTNode left;
	BTNode right;

	public BTNode(int data) {
		this.data = data;
	}
}
