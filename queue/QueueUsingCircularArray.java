package queue;

public class QueueUsingCircularArray {
	int n = 4;
	private int[] ar = new int[n];
	private int front = 0, rear = 0;

	public void enqueue(int data) {
		rear = (rear + 1) % n;
		if (front == rear) {
			System.out.println("overflow");
			if (rear == 0) {
				rear = n - 1;
			} else {
				rear = rear - 1;
			}
		} else {
			ar[rear] = data;
		}

	}

	public void dequeue() {
		if (front == rear) {
			System.out.println("underflow");
		} else {
			front = (front + 1) % n;
			int deleted = ar[front];
			System.out.println("Item \"" + deleted + "\" has been deleted successfully from queue.");
		}
	}

	private void print() {
		int start = (front + 1) % n;
		int end = rear;
		int test = (rear + 1) % n;
		if (start == test) {
			System.out.println("Queue is Empty, Nothing to print.");
			return;
		}
		for (int i = start; i <= end; i++) {
			System.out.println(ar[i]);
		}
	}

	public static void main(String[] args) {
		QueueUsingCircularArray obj = new QueueUsingCircularArray();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.print();
		obj.dequeue();
		obj.print();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.print();
		obj.enqueue(4);
		obj.enqueue(5);
		obj.enqueue(6);
		obj.print();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.print();
		obj.dequeue();

	}

}
