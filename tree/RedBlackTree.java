package tree;

public class RedBlackTree {

	private RBNode root;

	public static void main(String[] args) {

		RedBlackTree tree = new RedBlackTree();

		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);

		tree.traverseGraph();
	}

	public void traverseGraph() {
		if (this.root != null) {
			traverseInOrder(root);
		}
	}

	public void insert(int newData) {

		RBNode RBNode = new RBNode(newData);
		root = insertIntoTree(root, RBNode);

		fixViolations(RBNode);
	}

	private RBNode insertIntoTree(RBNode root, RBNode RBNode) {

		if (root == null)
			return RBNode;

		if (RBNode.getData() < root.getData()) {
			root.setLeftChild(insertIntoTree(root.getLeftChild(), RBNode));
			root.getLeftChild().setParent(root);
		} else if (RBNode.getData() > root.getData()) {
			root.setRightChild(insertIntoTree(root.getRightChild(), RBNode));
			root.getRightChild().setParent(root);
		}

		return root;
	}

	private void fixViolations(RBNode RBNode) {

		RBNode parentNode = null;
		RBNode grandParentNode = null;

		while (RBNode != root && RBNode.getColor() != NodeColor.BLACK
				&& RBNode.getParent().getColor() == NodeColor.RED) {

			parentNode = RBNode.getParent();
			grandParentNode = RBNode.getParent().getParent();

			if (parentNode == grandParentNode.getLeftChild()) {

				RBNode uncle = grandParentNode.getRightChild();

				// given RBNode x's parent is a left child + uncle is red -->
				// only recoloring
				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					RBNode = grandParentNode; // this will be the x after the
												// recoloring because we have to
												// check whether
					// the properties are violated or not
				} else {

					if (RBNode == parentNode.getRightChild()) {
						leftRotate(parentNode);
						RBNode = parentNode;
						parentNode = RBNode.getParent();
					}

					rightRotate(grandParentNode);
					System.out.println("Recoroling " + parentNode + " + " + grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					RBNode = parentNode;
				}
			} else {

				RBNode uncle = grandParentNode.getLeftChild();

				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					RBNode = grandParentNode;
				} else {

					if (RBNode == parentNode.getLeftChild()) {
						rightRotate(parentNode);
						RBNode = parentNode;
						parentNode = RBNode.getParent();
					}
					leftRotate(grandParentNode);
					System.out.println("Recoroling " + parentNode + " + " + grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					RBNode = parentNode;
				}
			}
		}

		if (root.getColor() == NodeColor.RED) {
			System.out.println("Recoloring the root to black...");
			root.setColor(NodeColor.BLACK);
		}
	}

	private void rightRotate(RBNode RBNode) { // az input a beszurt RBNode
												// grandparentje
		System.out.println("Rotate right on RBNode " + RBNode);
		RBNode tempLeftNode = RBNode.getLeftChild();
		RBNode.setLeftChild(tempLeftNode.getRightChild());

		if (RBNode.getLeftChild() != null)
			RBNode.getLeftChild().setParent(RBNode);

		tempLeftNode.setParent(RBNode.getParent());

		if (tempLeftNode.getParent() == null)
			root = tempLeftNode;
		else if (RBNode == RBNode.getParent().getLeftChild())
			RBNode.getParent().setLeftChild(tempLeftNode);
		else
			RBNode.getParent().setRightChild(tempLeftNode);

		tempLeftNode.setRightChild(RBNode);
		RBNode.setParent(tempLeftNode);
	}

	private void leftRotate(RBNode RBNode) { // az input a beszurt RBNode
												// grandparentje
		System.out.println("Rotate left on RBNode " + RBNode);
		RBNode tempRightNode = RBNode.getRightChild();
		RBNode.setRightChild(tempRightNode.getLeftChild());

		if (RBNode.getRightChild() != null)
			RBNode.getRightChild().setParent(RBNode);

		tempRightNode.setParent(RBNode.getParent());

		if (tempRightNode.getParent() == null)
			root = tempRightNode;
		else if (RBNode == RBNode.getParent().getLeftChild())
			RBNode.getParent().setLeftChild(tempRightNode);
		else
			RBNode.getParent().setRightChild(tempRightNode);

		tempRightNode.setLeftChild(RBNode);
		RBNode.setParent(tempRightNode);
	}

	private void traverseInOrder(RBNode RBNode) {

		System.out.println(RBNode + " with color: " + RBNode.getColor() + " LeftNode: " + RBNode.getLeftChild()
				+ " - RightNode: " + RBNode.getRightChild());

		if (RBNode.getLeftChild() != null) {
			traverseInOrder(RBNode.getLeftChild());
		}

		if (RBNode.getRightChild() != null) {
			traverseInOrder(RBNode.getRightChild());
		}
	}
}

enum NodeColor {

	RED, BLACK;
}


class RBNode {

	private int data;
	private RBNode parent;
	private RBNode leftChild;
	private RBNode rightChild;
	private NodeColor color;

	public RBNode(int data) {
		this.data = data;
		this.color = NodeColor.RED;
	}

	public int getData() {
		return data;
	}

	public RBNode getParent() {
		return parent;
	}

	public void setParent(RBNode parent) {
		this.parent = parent;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public RBNode getLeftChild() {
		return leftChild;
	}

	public RBNode getRightChild() {
		return rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeftChild(RBNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(RBNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return ""+this.data+" : "+this.getColor();
	}
}
