
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;     //Holds size.
    //I create this class to use on the inorderTraversal method.
    //I take it these class from my old homework but I added the iterator part from getting insperation from our textbook.
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    public Queue() {
        first = null;
        last = null;
        n = 0;
    }
    //Returns null if it's empty
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    //Enqueue the Item to the queue.(FIFO)
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }
    //Dequeue the Item from queue.
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
    //Returns a LinkedIterator
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        //Iterator class methods.
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }
        //Looks for if there is element after itself.
        public boolean hasNext() {
            return current != null;
        }
        //Getting to the next item.
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}