package tree;

public class BinarySearchTree {
	BSTNode root;

	public void insert(int data) {
		root = insert(root, data);
	}

	public BSTNode insert(BSTNode node, int data) {

		if (node == null) {
			node = new BSTNode(data);
		} else if (node.data < data) {
			node.right = insert(node.right, data);
		} else {
			node.left = insert(node.left, data);
		}
		return node;
	}
	
	public void inorderTraversal(){
		inorderTraversal(root);
	}
	
	private void inorderTraversal(BSTNode node){
		if(node!=null){
			inorderTraversal(node.left);
			System.out.println(node.data);
			inorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(3);
		bt.insert(2);
		bt.insert(1);
		bt.insert(8);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.inorderTraversal();

	}

}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int data) {
		this.data = data;
	}
}
