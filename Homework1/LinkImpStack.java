//Description: This class creates a Linked List implementation of stack with generics.

public class LinkImpStack <Item>{
    Node top = null;
    class Node {
        Node next;
        Item item;
    }
    public void push(Item item)
    {
        //Create a placeholder for first Node
        //Create a new Node for the push and assign to the first node
        //Insert new item at the beginning of Linked List (Top of the stack)
        Node oldFirstHolder = top;
        Node newFirst = new Node();
        top = newFirst;
        top.item = item;
        top.next = oldFirstHolder;
    }

    public Item pop()
    {
        //Create item and assign to the top of the Node's item.
        //Equalize the top to the second node and pop the item.
        Item item = top.item;
        top = top.next;
        return item;

    }
    public boolean isEmpty()
    //Check if the top of the is null or not.
    {
        if(top == null)
        {
            return false;
        }
        return true;
    }

}
