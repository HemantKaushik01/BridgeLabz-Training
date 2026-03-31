package in.senerio;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Node {
	String name;
	Node next;

	Node(String name) {
		this.name = name;
	}

}

public class BookShelf {
	HashMap<String, Node> map = new HashMap<>();

// INSEST THE BOOK
	public void insert(String genre, String book) {
		Node newNode = new Node(book);
		if (map.containsKey(genre)) {

			Node temp = map.get(genre);
			while (temp.next != null) {
				temp = temp.next;

			}
			temp.next = newNode;

		} else {
			map.put(genre, newNode);
		}

	}

// BORROWED THE BOOK
	public void borrowed(String genre, String book) {
		if (!map.containsKey(genre)) {
			System.out.println("Genre not found: " + genre);
			System.out.println("Re-enter the genre");
			return;
		}
		Node curr = map.get(genre);
		Node prev = null;
		boolean found = false;
		while (curr != null) {
			if (curr.name.equals(book)) {
				found = true;
				break;
			}
			prev = curr;
			curr = curr.next;
		}

		if (!found) {
			System.out.println("This book is not available: " + book);
			return;
		}

		if (prev == null) {
			map.put(genre, curr.next);

		}

		else {
			prev.next = curr.next;
		}
		System.out.println("This book has borrowed successfully: " + book);

	}

	public void display() {
		if (map.isEmpty()) {
			System.out.println("Library is empty.");
			return;
		}
		System.out.println("\nDisplay library \n");
		for (Map.Entry<String, Node> entry : map.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			Node temp = entry.getValue();
			while (temp != null) {
				System.out.print(temp.name + " -> ");
				temp = temp.next;
			}
			System.out.println("\n==========================\n");
		}
	}

	private void loadDefaultBooks() {

		insert("Programming", "Java");
		insert("Programming", "Python");
		insert("Programming", "C++");

		insert("Fiction", "HarryPotter");
		insert("Fiction", "LordOfRings");

		insert("Science", "Physics");
		insert("Science", "Chemistry");

		insert("History", "WorldWar");
	}

	public static void main(String[] args) {

		BookShelf library = new BookShelf();
		library.loadDefaultBooks();

		Scanner sc = new Scanner(System.in);
		int choice;

		System.out.println("===== Welcome to BridgeLabz Library System =====");

		while (true) {

			System.out.println("\n1. Insert Book");
			System.out.println("2. Borrow Book");
			System.out.println("3. Display Library");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Genre: ");
				String genre = sc.nextLine();
				System.out.print("Enter Book Name: ");
				String book = sc.nextLine();
				library.insert(genre, book);
				break;

			case 2:
				System.out.print("Enter Genre: ");
				genre = sc.nextLine();
				System.out.print("Enter Book Name: ");
				book = sc.nextLine();
				library.borrowed(genre, book);
				break;

			case 3:
				library.display();
				break;

			case 4:
				System.out.println("Thank you for using the Library System.");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
