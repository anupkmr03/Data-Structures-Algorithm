package linked_list;

public class LinkedList {
	private SNode head = null;
	private int size = 0;

	public void addAtFirst(int data) {
		SNode SNode = new SNode(data);
		if (head == null) {
			head = SNode;
		} else {
			SNode.next = head;
			head = SNode;
		}
		size++;
	}

	public void addAtLast(int data) {
		SNode SNode = new SNode(data);
		if (head == null) {
			head = SNode;
		} else {
			SNode headRef = head;
			while (headRef.next != null) {
				headRef = headRef.next;
			}
			headRef.next = SNode;
		}
		size++;
	}

	public void display() {
		SNode headRef = head;
		while (headRef.next != null) {
			System.out.println(headRef.data);
			headRef = headRef.next;
		}
		System.out.println(headRef.data);

	}

	public void displayReverse() {
		displayReverse(head);
	}

	public void displayReverse(SNode SNode) {
		if (SNode == null)
			return;
		displayReverse(SNode.next);
		System.out.println(SNode.data);
	}

	public void delete(int index) {
		SNode headRef = head;
		if (head == null)
			return;
		for (int i = 0; i < index - 1; i++) {
			headRef = headRef.next;
		}
		SNode newRef = headRef;
		newRef = newRef.next.next;
		headRef.next = newRef;
		size--;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void deleteAll() {
		this.head = null;
	}

}
