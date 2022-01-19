

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private int n; //size
    private Node first;

    //As I said in the queue class I take it from my first homework for using inorderTraversal method.

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    //Check whether stack empty or not.
    public boolean isEmpty() {
        return first == null;
    }

        public int size() {
        return n;
    }
    //Adding item to the stack.
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    //Popping out the stack from the top of the stack.(FILO)
    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }



    public Iterator<Item> iterator()  { return new ListIterator();  }

    //Its the similiar methods with the queue.
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
