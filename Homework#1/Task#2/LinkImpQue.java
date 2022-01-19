//Description: This class creates a Linked List implementation of queue with generics.

public class LinkImpQue<Item> {
    public class Node{
        Node next;
        Item item;
    }
    Node first,last = null;
    int size = 0;
    public void enqueue(Item item)
    {
        //Create a placeholder for first Node
        //Create a new Node for the enqueue and assign to the first node and it's item
        //Then equalize the oldLast next to the last.
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty())
            first = last;
        else oldLast.next = last;
        size++;

    }
    public boolean isEmpty()
    {
        //Checks if the first Node is null
        if(first == null)
        {
            return true;
        }
        return false;
    }
    public Item dequeue()
    {
        //Create a variable type Item.
        //Equalize it to the first item and return it.
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        size--;
        return item;
    }

}
