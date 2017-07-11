package linked_list;
public class TestApp {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addAtFirst(1);
		linkedList.addAtFirst(2);
		linkedList.addAtFirst(3);
		linkedList.addAtFirst(4);
		linkedList.addAtFirst(5);
		linkedList.display();
		//linkedList.displayReverse();
		linkedList.deleteAll();
		System.out.println();
		linkedList.addAtLast(1); // 0
		linkedList.addAtLast(2); // 1
		linkedList.addAtLast(3); // 2
		linkedList.addAtLast(4); // 3
		linkedList.addAtLast(5); // 4
		linkedList.display();
		System.out.println();
		//linkedList.displayReverse();
		linkedList.delete(4);
		linkedList.display();
		System.out.println("list size "+linkedList.getSize());
		System.out.println(linkedList.isEmpty());
		linkedList.deleteAll();
		System.out.println(linkedList.isEmpty());
		
	}
}	
