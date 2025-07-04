
/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * Student Name:Andrei Cojocaru
 * Student ID: 041032238
 * Program: CET:CS
 * Course: Data Structures
 * Lab Section: 301
 * Professor: James Mwangi PhD.
 */

class DoublyLinkedList {
    private Node first;
    private Node last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Places a new Node at the start of the list
     *
     * @param num value of new node
     */
    public void insertFirst(int num) {
        // if is empty, set both first and last to new node
        if (isEmpty()) {
            this.first = new Node(num);
            this.last = this.first;
        } else {
            // set the former first's previous to new
            first.previous = new Node(num);
            // set new's next to first
            first.previous.next = first;
            // set first to new
            first = first.previous;
        }
    }

    /**
     * Places a new Node at the end of the list
     *
     * @param num value of new node
     */
    public void insertLast(int num) {
        // if is empty then set both first and last to new
        if (isEmpty()) {
            this.last = new Node(num);
            this.first = this.last;
        } else {
            // set former last's next to new
            this.last.next = new Node(num);
            // set new's previous to former last
            this.last.next.previous = this.last;
            // set last to new
            this.last = this.last.next;
        }
    }

    /**
     * Insert after a specific number
     * if number does not exist, return false
     *
     * @param numToFind num to add new after
     * @param newNumber value for new node
     * @return true if successful, false if not
     */
    public boolean insertAfter(int numToFind, int newNumber) {
        // if is empty, no node to insert after so return null
        if (isEmpty()) return false;

        // iterator variable
        Node cur = this.first;
        // go until end of list
        while (cur != null) {
            // if we find desired node, put in place
            if (cur.mData == numToFind) {
                // set the node to the right's previous to new
                cur.next.previous = new Node(newNumber);
                // set cur's next to new
                cur.next = cur.next.previous;
                // set cur's next to new
                cur.next.previous = cur;
                return true;
            }
        }
        // this is reached if we get to end of list
        // this means number requested is not contained in list
        return false;
    }

    /**
     * Delete first node of list
     *
     * @return node that has been deleted, null if empty
     */
    public Node deleteFirstNode() {
        // if is empty then there is no first to delete
        if (isEmpty()) return null;

        // if list has one node, delete and return
        if (first == last) {
            Node temp = first;
            first = null;
            return temp;
        }

        // hold former first for later
        Node temp = first;
        // set first to new first
        first = first.next;
        // remove connection to list
        temp.next = null;
        // remove connection from list
        first.previous = null;
        return temp;
    }

    /**
     * Delete last node of list
     *
     * @return node that has been deleted, null if empty
     */
    public Node deleteLastNode() {
        // if is empty then there is no last to delete
        if (isEmpty()) return null;

        // if list has one node, delete and return
        if (last == first) {
            Node temp = last;
            last = null;
            return temp;
        }

        // hold for later
        Node temp = last;
        // move last back one node
        last = last.previous;
        // remove connection to list
        temp.previous = null;
        // remove connection from list
        last.next = null;
        return temp;
    }

    /**
     * Delete a Node at an index
     *
     * @param index node to be deleted
     * @return node that has been deleted, null if empty or invalid index
     */
    public Node deleteSpecificNode(int index) {
        // if is empty then there is no node to delete
        if (isEmpty()) return null;

        // if requested index is 0 then delete head
        if (index == 0) return deleteFirstNode();

        // iterator variable
        Node cur = first;
        // index iterator
        int i = 0;

        // go through list until desired index or until end
        while (i < index && cur != null) {
            // if is last node then call existing last
            if (cur == last) return deleteLastNode();
            i++;
        }

        // if cur is null then is not in list
        if (cur != null) {
            // set cur's previous' next to cur's next
            cur.previous.next = cur.next;
            // set cur's next's previous to cur's previous
            cur.next.previous = cur.previous;
            // remove connections to list
            cur.next = null;
            cur.previous = null;
            return cur;
        }
        return null;
    }

    /**
     * Print all elements of the list from start to end
     */
    public void printForwardsWithIndex() {
        // if is empty then nothing to print
        if (isEmpty()) return;

        // iterator variable
        Node cur = first;
        int i = 0;
        while (cur != null) {
            // go through all elements and print index and data
            System.out.println("Node[" + i + "] = " + cur.mData);
            cur = cur.next;
            i++;
        }
    }

    /**
     * Print all elements of the list from end to start
     */
    public void printBackwardsWithIndex() {
        // if is empty then nothing to print
        if (isEmpty()) return;

        // iterator variables
        Node cur = first;
        int i = 0;
        // first we need to iterate to end of list so that
        // we know how many elements there are in the list
        while (cur.next != null) {
            cur = cur.next;
            i++;
        }

        // now that we have our size, iterate backwards and print
        while (cur != null) {
            System.out.println("Node[" + i + "] = " + cur.mData);
            cur = cur.previous;
            i--;
        }

    }

    /**
     * Items contained within the DLL
     */
    class Node {
        public int mData; // data item
        public Node next; // next node in list
        public Node previous; // previous node in list

        public Node(int d) // constructor
        {
            mData = d;
        }

        public void displayNode() {
            System.out.print(mData + " ");
        }


    }

}