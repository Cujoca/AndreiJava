/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * Student Name: Andrei Cojocaru
 * Student ID: 041032238
 * Program: CET:CS
 * Course: Data Structures
 * Lab Section: 301
 * Professor: James Mwangi PhD.
 */

/**
 * Main method class to test both int typed and generic versions
 * of doubly linked list.
 */
class TestDLLApp {
	/**
	 * main method to execute code
	 * @param args user input arguments through console
	 */
	public static void main(String[] args) {

		// tests and output for primitive version of list
		System.out.println("Primitive int doubly linked list\n");
		DoublyLinkedList list1 = new DoublyLinkedList();

		// create starting list
		list1.insertFirst(22);
		list1.insertFirst(44);
		list1.insertFirst(74);
		list1.insertFirst(97);

		list1.insertLast(9);
		list1.insertLast(33);
		list1.insertLast(55);

		// check that all elements have been inserted properly
		// and that both versions of print function work
		list1.printForwardsWithIndex();
		System.out.println();
		list1.printBackwardsWithIndex();
		System.out.println();

		// test all delete functions
		list1.deleteFirstNode();
		list1.deleteLastNode();
		list1.deleteSpecificNode(2);

		// test insertAfter on an element not in the list, and one in
		list1.insertAfter(22, 69);
		list1.insertAfter(33, 88);
		list1.printForwardsWithIndex();

		System.out.println("\n\n\n");
		// test generic implementation
		System.out.println("Generic double linked list (done with strings)\n");

		// will use strings for test
		DoublyLinkedListGeneric<String> list2 = new DoublyLinkedListGeneric<>();

		// create starting list
		list2.insertFirst("22");
		list2.insertFirst("44");
		list2.insertFirst("74");
		list2.insertFirst("97");

		list2.insertLast("9");
		list2.insertLast("33");
		list2.insertLast("55");

		// test that elems are added in proper order
		// and that print functions work correctly
		list2.printForwardsWithIndex();
		System.out.println();
		list2.printBackwardsWithIndex();
		System.out.println();

		// test all delete functions
		list2.deleteFirstNode();
		list2.deleteLastNode();
		list2.deleteSpecificNode(2);
		list2.printForwardsWithIndex();
		System.out.println("\n");

		// test insertAfter on an element not in the list
		// and one element which is in the list
		list2.insertAfter("22", "69");
		list2.insertAfter("33", "88");
		list2.printForwardsWithIndex();
	}
}
