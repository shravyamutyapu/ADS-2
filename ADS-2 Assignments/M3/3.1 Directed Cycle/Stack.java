/**
 * import iterator.
 */
import java.util.Iterator;
/**
 * no such ele exception.
 */
import java.util.NoSuchElementException;
/**
 *stack class.
 */
public class Stack<Item> implements Iterable<Item> {
	/**
	 *  size of the stack.
	 */
    private int size;
    /**
     *  top of stack.
     */
    private Node first;
    // helper linked list class
    private class Node {
    	/**
    	 * Item type.
    	 */
        private Item item;
        /**
         * next address.
         */
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        size = 0;
    }

   /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the stack.
     */
    public int size() {
        return size;
    }

   /**
     * Add the item to the stack.
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

   /**
     * Delete and return the
     * item most recently added to the stack.
     * Throw an exception if no such item
     * exists because the stack is empty.
     */
    public Item pop() {
        if (isEmpty()){
       throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        size--;
        return item;                   // return the saved item
    }


   /**
     * Return the item most recently
     * added to the stack.
     * Throw an exception if no such
     * item exists because the stack is empty.
     */
    public Item peek() {
        if (isEmpty()){
        throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }

   /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }


   /**
     * Return an iterator to the stack that
     * iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
    	return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
        	return current != null;
        }
        public void remove() {
        	throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
            	throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


   /**
     * A test client.
     */
/*    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }*/
}

