import java.util.Arrays;
/**
 * Creating a linked list
 * @author Anna Bogdanova
 * @version 1.0.0
 */
public class LinkedList<T> {
    /** The first element of linked list*/
    private Node<T> start;
    /** The last element of linked list*/
    private Node<T> end;
    /** Initial size of array list*/
    private int size = 0;
    /** Class of creating a linked list*/
    public class Node<T> {
        /** The element of linked list*/
        T element;
        /** Link to the next element*/
        Node<T> next;
        /** Link to the last element*/
        Node<T> last;
        /** Creating a linked list constructor*/
        public Node(T element) {
            this.element = element;
        }
    }
    /**
     * Adding an item to a linked list
     * @param element The element that needs to be added
     */
    public void addElement(T element) {
        Node<T> node = new Node<>(element);
        if (end == null) {
            start = node;
        } else {
            end.next = node;
            node.last = end;
        }
        end = node;
        size++;
    }
    /**
     * Adding an item to a linked list by index
     * @param element The element that needs to be added
     * @param index The index where the element should be inserted
     */
    public void addElement(T element, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        Node<T> node = new Node<T>(element);
        if (index == 0) {
            node.next = start;
            start.last = node;
            start = node;
        } else {
            Node<T> temp = start;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            node.last = temp;
            temp.next = node;
            if (node.next != null) {
                node.next.last = node;
            } else {
                end = node;
            }
        }
        size++;
    }
    /**
     * Getting an item from linked list by index
     * @param index The index of element to be retrieved
     * @return An element by the requested index
     */
    public T getElement(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        Node<T> node = start;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }
    /**
     * Deleting an element by index
     * @param index the index of the item to be deleted
     * If the index is 0, remove the item from the beginning of the linked list
     * Otherwise, we find the node preceding the node to be deleted
     * Skip the node being deleted by redirecting the link of the previous node
     * Reducing the size of the linked list
     */
    public void deleteElement(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        if (index == 0) {
            start = start.next;
        } else {
            Node<T> current = start;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    /**
     *Method for sorting the collection
     *A new array is created inside the method into which all the elements of the linked list are copied
     *After that, sorting is performed and clearing the current linked list
     *All the elements are copied from the sorted array to the new linked list
     */
    public void sortList() {
        T[] array = (T[]) new Object[size];
        Node<T> node = start;
        for (int i = 0; i < size; i++) {
            array[i] = node.element;
            node = node.next;
        }
        Arrays.sort(array);
        clearList();
        for (int i = 0; i < array.length; i++) {
            addElement(array[i]);
        }
    }
    /**
     * Clear the linked list
     */
    public void clearList() {
        start = null;
        end = null;
        size = 0;
    }
    /**
     * Getting the current size of the linked list
     * @return linked list size
     */
    public int getSize() {
        return size;
    }
    /**
     * Converting a linked list to a string representation for console output
     * @return String representation of a linked list
     */
    public String toString() {
        StringBuilder elements = new StringBuilder();
        Node<T> node = start;
        while (node != null) {
            elements.append(node.element).append(" ");
            node = node.next;
        }
        return elements.toString();
    }
}