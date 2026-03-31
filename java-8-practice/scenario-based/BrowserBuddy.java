import java.util.Scanner;
import java.util.Stack;

class Node {
	String tabName;
	Node next;
	Node prev;

	Node(String tabName) {
		this.tabName = tabName;
	}
}

public class BrowserBuddy {
	Stack<Node> st = new Stack<>();
	Node head;
	Node tail;
	static int size = 0;

	public void addTab(String name) {
		Node newNode = new Node(name);
		if (head == null) {
			head = newNode;
			tail = newNode;

		} else {

			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;

	}

	public void deleteBackward() {
		if (tail == null) {
			System.out.print("No tabs to delete");
			return;
		}
		st.push(tail);
		if (head == tail) {
			head = null;
			tail = null;
		} else {

			tail = tail.prev;
			tail.next = null;
		}
		size--;
	}

	public void deleteForward() {
		if (head == null) {
			System.out.print("No tabs to delete");
			return;
		}

		st.push(head);
		if (head == tail) {
			head = null;
			tail = null;
		} else {

			head = head.next;
			head.prev = null;
		}

		size--;
	}

	public void deleteKthPositon(int k) {
		if (k < 0 || k >= size) {
			System.out.println("Invalid position");
			return;
		}
		if (k == 0) {
			deleteForward();
			return;
		}

		if (k == size - 1) {
			deleteBackward();
			return;
		}
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		st.push(temp);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
	}

	public void restoreTabs() {
		if (st.isEmpty()) {
			System.out.println("No tabs to restore");
		}
		Node temp = st.pop();
		temp.next = null;
		temp.prev = null;
		if (head == null) {
			head = null;
			tail = null;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
		size++;
	}

	public void display() {
		Node tamp = head;
		while (tamp != null) {
			System.out.print(tamp.tabName + "->");
			tamp = tamp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		BrowserBuddy obj = new BrowserBuddy();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n=== BrowserBuddy Menu =======");
			System.out.println("1. Add New Tab");
			System.out.println("2. Close Backward Tab");
			System.out.println("3. Close Forward Tab");
			System.out.println("4. Close Kth Tab");
			System.out.println("5. Restore Recently Closed Tab");
			System.out.println("6. Display Tabs");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");
			 if (!sc.hasNextInt()) {   
			        System.out.println(" Invalid input! Please enter a number.");
			        sc.next(); 
			        continue;
			    }
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter tab name: ");
				sc.nextLine(); 
				String name = sc.nextLine();
				obj.addTab(name);
				break;

			case 2:
				obj.deleteBackward();
				break;

			case 3:
				obj.deleteForward();
				break;

			case 4:
				System.out.print("Enter position (0-based): ");
				int k = sc.nextInt();
				obj.deleteKthPositon(k);
				break;

			case 5:
				obj.restoreTabs();
				break;

			case 6:
				obj.display();
				break;

			case 7:
				System.out.println("Browser closed.");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice ");
			}
		}
	}

}
