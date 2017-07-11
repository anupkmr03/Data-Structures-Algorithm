package linked_list;

public class StackUsingLinkedList {
	private StackNode head;
	int topOfStack = -1;

	public void push(int data) {
		StackNode newNode = new StackNode(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		topOfStack++;
	}

	public void pop() {
		if (head == null) {
			System.out.println("underflow");
		} else {
			System.out.println("Poped element is "+head.data);
			StackNode node = head.next;
			head = node;
			topOfStack--;
		}
	}
	public void print(){
		if(head == null){
			System.out.println("nothing to print");
		}
		StackNode headRef = head;
		while(headRef.next!=null){
			System.out.println(headRef.data);
			headRef = headRef.next;
		}
		System.out.println(headRef.data);
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList obj = new StackUsingLinkedList();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.print();
		obj.pop();
		obj.print();
	}

}

class StackNode {
	int data;
	StackNode next;

	public StackNode(int data) {
		this.data = data;
	}

	public String toString() {

		return "data = " + data;
	};
}
