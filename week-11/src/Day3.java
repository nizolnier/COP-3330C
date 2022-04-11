
class LinkedList {

	private Node list;
	private int size;
	// ___________________________________

	public LinkedList() {
		list = null;
		size = 0;
	}

	public void sort() {
		Node temp = list;
		boolean goAgain = true;

		if (list == null || list.next == null)
			return;
		while (goAgain == true) {
			temp = list;
			goAgain = false;
			while (temp.next != null) {
				if (temp.data > temp.next.data) {
					int buffer;
					buffer = temp.data;
					temp.data = temp.next.data;
					temp.next.data = buffer;
					goAgain = true;
				}
				temp = temp.next;
			}
		}
	}

	public void clear() {
		list = null;
		size = 0;
	}

	public void print() {
		Node temp = list;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;

		}
		System.out.println("null");
	}

	// -----
	public void add(int data) {
		if (list == null) {
			list = new Node();
			list.next = null;
			list.data = data;
			++size;
			// return list;
			return;
		}
		Node temp = list;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node();
		temp.next.data = data;
		temp.next.next = null;
		++size;

		// return list;
	}

	public void remove(int data) {
		if (list == null)
			// return list;
			return;

		if (list.data == data) {
			list = list.next;
			size--;
			return;
			// return list;
		}

		Node temp = list;

		while (temp.next != null && temp.next.data != data) {
			temp = temp.next;
		}

		if (temp.next == null) {
			// return list;
			return;
		}

		if (temp.next.data == data) {
			temp.next = temp.next.next;
			size--;
			// return list;
		}
		// return list;

	}

}// end of class LinkedList
//________________________________________________

public class Day3 {

	public static Node sort(Node list) {
		Node temp = list;
		boolean goAgain = true;

		if (list == null || list.next == null)
			return list;
		while (goAgain == true) {
			temp = list;
			goAgain = false;
			while (temp.next != null) {
				if (temp.data > temp.next.data) {
					int buffer;
					buffer = temp.data;
					temp.data = temp.next.data;
					temp.next.data = buffer;
					goAgain = true;
				}
				temp = temp.next;
			}
		}
		return list;
	}

	public static void main(String[] args) {

		LinkedList myList = new LinkedList();
		myList.add(100);
		myList.add(15000);
		myList.add(200);
		myList.print();

		// myList.remove(200);
		// myList.remove(100);
		myList.sort();
		myList.print();

		/*
		 * Node list = null;
		 * 
		 * list = new Node(); list.data = 7; list.next = null;
		 * 
		 * list.next = new Node(); list.next.data = 3; list.next.next = null;
		 * 
		 * list = add(list, 56); list = add(list, 6); list = add(list, 560); list =
		 * add(list, 156);
		 * 
		 * printR(list); // list = delete(list, 7); list = sort(list);
		 * System.out.println(""); printR(list);
		 * 
		 * // System.out.println("\n"+size(list));
		 */
	}

	public static Node delete(Node list, int data) {
		if (list == null)
			return list;

		if (list.data == data) {
			list = list.next;
			return list;
		}

		Node temp = list;

		while (temp.next != null && temp.next.data != data) {
			temp = temp.next;
		}

		if (temp.next == null) {
			return list;
		}

		if (temp.next.data == data) {
			temp.next = temp.next.next;
			return list;
		}
		return list;

	}

	public static int size(Node list) {
		int length = 0;
		while (list != null) {
			length++;
			list = list.next;
		}
		return length;
	}

	public static int sizeR(Node list) {
		if (list == null)
			return 0;
		return 1 + sizeR(list.next);
	}

	public static Node add(Node list, int data) {
		if (list == null) {
			list = new Node();
			list.next = null;
			list.data = data;
			return list;
		}
		Node temp = list;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node();
		temp.next.data = data;
		temp.next.next = null;

		return list;
	}

	public static void printR(Node list) {
		if (list != null) {

			System.out.print(list.data + " ->");
			printR(list.next);
		} else
			System.out.print("null");

	}

	public static void print(Node list) {
		Node temp = list;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;

		}
		System.out.println("null");
	}

}

//__________________
class Node {
	public int data;
	Node next;
}
