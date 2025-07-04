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

/**
 * Generic version of a doubly linked list
 *
 * @param <T> type of data held within nodes
 */
public class DoublyLinkedListGeneric <T extends Comparable<T>> {

    /**
     * Node class to store instances of information in the
     * DLL data structure
     *
     * @param <T> Type of data held within
     */
    public static class Node<T extends Comparable<T>> {
        T value;
        public Node<T> next;
        public Node<T> prev;

        public Node (T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Places a new Node at the start of the list
     *
     * @param elem value of new node
     */
    public void insertFirst(T elem) {
        // if is empty, set both first and last to new node
        if (isEmpty()) {
            this.first = new Node<T>(elem);
            this.last = this.first;
        } else {
            // set the former first's previous to new
            first.prev = new Node<>(elem);
            // set new's next to first
            first.prev.next = first;
            // set first to new
            first = first.prev;
        }
    }

    /**
     * Places a new Node at the end of the list
     *
     * @param elem value of new node
     */
    public void insertLast(T elem) {
        // if is empty then set both first and last to new
        if (isEmpty()) {
            this.last = new Node<>(elem);
            this.first = this.last;
        } else {
            // set former last's next to new
            this.last.next = new Node<>(elem);
            // set new's previous to former last
            this.last.next.prev = this.last;
            // set last to new
            this.last = this.last.next;
        }
    }

    /**
     * Insert after a specific number
     * if number does not exist, return false
     *
     * @param elemFind element to add new after
     * @param newElem value for new node
     * @return true if successful, false if not
     */
    public boolean insertAfter(T elemFind, T newElem) {
        // if is empty, no node to insert after so return null
        if (isEmpty()) return false;

        // iterator variable
        Node<T> cur = this.first;
        // go until end of list
        while (cur != null) {
            // if we find desired node, put in place
            if (cur.value.compareTo(elemFind) == 0) {
                if (cur == last) {
                    this.insertLast(newElem);
                    return true;
                }
                // set the node to the right's previous to new
                cur.next.prev = new Node<>(newElem);
                // set cur's next to new
                cur.next = cur.next.prev;
                // set cur's next to new
                cur.next.prev = cur;
                return true;
            }
            cur = cur.next;
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
    public Node<T> deleteFirstNode() {
        // if is empty then there is no first to delete
        if (isEmpty()) return null;

        // if list has one node, delete and return
        if (first == last) {
            Node<T> temp = first;
            first = null;
            return temp;
        }

        // hold former first for later
        Node<T> temp = first;
        // set first to new first
        first = first.next;
        // remove connection to list
        temp.next = null;
        // remove connection from list
        first.prev = null;
        return temp;
    }

    /**
     * Delete last node of list
     *
     * @return node that has been deleted, null if empty
     */
    public Node<T> deleteLastNode() {
        // if is empty then there is no last to delete
        if (isEmpty()) return null;

        // if list has one node, delete and return
        if (last == first) {
            Node<T> temp = last;
            last = null;
            return temp;
        }

        // hold for later
        Node<T> temp = last;
        // move last back one node
        last = last.prev;
        // remove connection to list
        temp.prev = null;
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
    public Node<T> deleteSpecificNode(int index) {
        // if is empty then there is no node to delete
        if (isEmpty()) return null;

        // if requested index is 0 then delete head
        if (index == 0) return deleteFirstNode();

        // iterator variable
        Node<T> cur = first;
        // index iterator
        int i = 0;

        // go through list until desired index or until end
        while (i < index && cur != null) {
            // if is last node then call existing last
            if (cur == last) return deleteLastNode();
            cur = cur.next;
            i++;
        }

        // if cur is null then is not in list
        if (cur != null) {
            // set cur's previous' next to cur's next
            cur.prev.next = cur.next;
            // set cur's next's previous to cur's previous
            cur.next.prev = cur.prev;
            // remove connections to list
            cur.next = null;
            cur.prev = null;
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
        Node<T> cur = first;
        int i = 0;
        while (cur != null) {
            // go through all elements and print index and data
            System.out.println("Node[" + i + "] = " + cur.value.toString());
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
        Node<T> cur = first;
        int i = 0;
        // first we need to iterate to end of list so that
        // we know how many elements there are in the list
        while (cur.next != null) {
            cur = cur.next;
            i++;
        }

        // now that we have our size, iterate backwards and print
        while (cur != null) {
            System.out.println("Node[" + i + "] = " + cur.value.toString());
            cur = cur.prev;
            i--;
        }

    }
}
