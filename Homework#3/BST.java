
public class BST<Key extends Comparable<Key>,Value>{
    private Node root;
     class Node
    {
        private Key key;
        private Value val;
        private Node left,right;
        BST actors = new BST(); // Every movie has a bst for actors
        Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;

        }
    }
    //I am returning as my value arr String array because all of the values are string.
    public Value get(Key key)
    {
        Node x = root;

        while (x != null)
        {
            String a = (String)x.val;
            String[] arr = a.split(",");
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return (Value)arr;
        }

        return null;
    }
    //This method returns actors tree of every node given by it's key.
    public BST getBST(Key key)
    {
        Node x = root;
        while(x!= null)
        {
            int cmp = key.compareTo(x.key);
            if(cmp<0) x = x.left;
            else if(cmp>0) x = x.right;
            else return x.actors;
        }
        return null;
    }

    public Queue<Key> Keys()
    {
        Queue<Key> q = new Queue<>();
        inorderKeys(root, q);
        return q;
    }
    //Take all the values according to inordertraversal(Smallest->Biggest).
    //Add into the queue first left's and right's.
    private void inorderKeys(Node x, Queue<Key> q)
    {
        if (x == null) return;
        inorderKeys(x.left, q);
        q.enqueue(x.key);
        inorderKeys(x.right, q);

    }
    //We are paralelly dequeue value and keys if value matched it returns the key.
    public Key getKey(Value val)
    {
        Queue<Value> q = Values();
        Queue<Key> q2 = Keys();
        while (!q.isEmpty() || !q.isEmpty())
        {
            String[] arr = (String[]) q.dequeue();
            Key x = q2.dequeue();
            String temp = (String)val;
            if(temp.contains(arr[0]))
            {
                return x;
            }

        }
        return null;
    }
    public void insertNode(Key key, Value val)
    {
        root = insertNode(root,key,val);
    }
    //Insertion of the bst.
    //If it's small go left,if not go right else equalize.
    //Recursion
    private Node insertNode(Node temp,Key key,Value val)
    {

        if(temp == null) return new Node(key,val);
        int cmp = key.compareTo(temp.key);
        if(cmp<0) {
            temp.left = insertNode(temp.left, key, val);
        }
        else if(cmp>0) {
            temp.right = insertNode(temp.right, key, val);
        }
        else if(cmp ==0) {
            temp.val = val;
        }
        return temp;
    }
    public Queue<Value> Values()
    {
        Queue<Value> q = new Queue<Value>();
        inorder(root, q);
        return q;
    }
    //Take all the values according to inordertraversal(Smallest->Biggest).
    //Add into the queue as string array and split into array to get reach more easily.
    private void inorder(Node x, Queue q)
    {
        if (x == null) return;
        inorder(x.left, q);
        String a = (String)x.val;
        String[] arr = a.split(",");
        q.enqueue(arr);
        inorder(x.right, q);

    }

    public Stack<Value> ReverseValues()
    {
        Stack<Value> stack = new Stack<Value>();
        ReverseInorder(root, stack);
        return stack;
    }
    //Its the same method but it uses stack to reverse the order.
    //When we are popping it will be biggest to smallest.(Descending)
    private void ReverseInorder(Node x, Stack stack)
    {
        if (x == null) return;
        ReverseInorder(x.left, stack);
        String a = (String)x.val;
        String[] arr = a.split(",");
        stack.push(arr);
        ReverseInorder(x.right, stack);

    }
    //It returns a boolean value if the bst has the key or not with using get() method.
    public boolean contains(Key key) {
        return get(key) != null;

    }
    public void deleteMin()
    { root = deleteMin(root); }
    //Go left until null and delete.
    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    public void delete(Key key)
    { root = delete(root, key); }
    //We are deleting a specific node from our bst with using deletemin() method.
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    //To find out the minimum value of the bst.
    //Go left until it's null
    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

}
