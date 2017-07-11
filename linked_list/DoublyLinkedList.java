package linked_list;
public class DoublyLinkedList {
	Node root;

	public DoublyLinkedList() {
		root = null;
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}

	public void insert(int data) {
		Node newNodeToAdd = new Node(data);
		if (root == null) {
			root = newNodeToAdd;
			root.next = null;
			root.prev = null;
		} else {
			Node rootRef = root;

			while (rootRef.next != null) {
				rootRef = rootRef.next;
			}
			rootRef.next = newNodeToAdd;
			newNodeToAdd.prev = rootRef;
		}
		root.size++;
	}

	public void print() {
		Node rootRf = root;
		while (rootRf.next != null) {
			System.out.println(rootRf.data);
			rootRf = rootRf.next;
		}
		System.out.println(rootRf.data);
	}

	public void getSize() {
		System.out.println(root.size);
	}

	public void printRerverse() {
		Node rootRf = root;
		while(rootRf.next!=null){
			rootRf = rootRf.next;
		}
		
		while(rootRf.prev!=null){
			System.out.println(rootRf.data);
			rootRf  = rootRf.prev;
		}
		System.out.println(rootRf.data);

	}

	public void printRecursive() {
		printRerc(root);
	}

	private void printRerc(Node node) {

	}

	public static void main(String[] args) {
		DoublyLinkedList obj = new DoublyLinkedList();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.print();
		//obj.getSize();
		obj.printRerverse();

	}
}

class Node {
	Node next;
	Node prev;
	int data;
	int size = 0;

	public Node(int data) {
		this.data = data;
	}
}
