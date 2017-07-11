package linked_list;
public class RemoveDuplicates {

	public static SNode removeDuplicates(SNode head) {
		if (head == null || head.next == null)
			return head;
		SNode root = head;
		while (head.next != null) {
			if (head.data != head.next.data) {
				head = head.next;
			} else {
				head.next = head.next.next;
			}
		}
		return root;
	}

	private static void print(SNode n) {
		SNode nref = n;
		while (nref != null) {
			System.out.print(nref.data + " ");
			nref = nref.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SNode n = new SNode(1);
		SNode n1 = new SNode(1);
		SNode n2 = new SNode(1);
		SNode n3 = new SNode(1);
		SNode n4 = new SNode(1);
		SNode n5 = new SNode(1);

		n.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		print(n);

		SNode removeDuplicates = removeDuplicates(n);
		print(removeDuplicates);

	}

}


