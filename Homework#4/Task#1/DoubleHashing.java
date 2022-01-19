import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoubleHashing<Key,Value> {
    //Our values is the same as Linear Probing.
    int size =5;
    int Key_Value_count = 0;
    Key[] keys;
    Value[] values;
    int[] marked;
    static FileWriter fl2;

    static {
        try {
            fl2 = new FileWriter("output2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BufferedWriter bf = new BufferedWriter(fl2);
    DoubleHashing()
    {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        marked = new int[size];
    }
    DoubleHashing(int size)
    {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        marked = new int[size];
        this.size = size;
    }
    public int hashFunction(Key key)
    {
        int temp = ((key.hashCode() & 0x7fffffff) % size);
        return temp;
    }
    //Our second hash function to iterate if the index is already full.
    public int hashFunction2(Key key)
    {
        return 7-((int)key%7);
    }
    public void delete(Key key)
    {
        //It's same as the linear but we are increment the hash with second hash function.
        int hash = hashFunction(key);
        int hash2 = hashFunction2(key);
        while(!keys[hash].equals(key))
        {
            hash = hash + hash2;
        }
        marked[hash] = 1;
        Key_Value_count--;
    }
    public void insert(Key key,Value value)
    {
        //As we did in the linear probing we are rehashing and look for the value and place to insert
        if (Key_Value_count+1>=size/2) rehash(size*2);
        int hash;
        int hash2 = hashFunction2(key);
        //The difference is we are increment with the hash2 function.
        for (hash = hashFunction(key); keys[hash] != null; hash = (hash + hash2) % size) {
            if (keys[hash].equals(key)) {
                values[hash] = value;
                marked[hash] = 0;
                return;
            }
        }
        keys[hash] = key;
        values[hash] = value;
        Key_Value_count++;

    }
    //Its the same procedure in Linear probing but we are incrementing with the hash2

    private Value find(Key key) {
        int hash = hashFunction(key);
        int hash2 = hashFunction2(key);
        while (!keys[hash].equals(key)) {
            hash = hash + hash2;
        }
        if(marked[hash] == 0)
            return values[hash];
        return null;
    }
    //It prints the find value.
    public void printFind(Key key) throws IOException {
        if(find(key) != null)
        {
            System.out.println(find(key));
            bf.write((String) find(key));
            bf.newLine();
        }
        else
        {
            System.out.println("Item not found");
            bf.write("Item not found");
            bf.newLine();
        }
    }
    //Double the size and insert again.
    private void rehash(int capacity) {
        DoubleHashing temp = new DoubleHashing(capacity);
        for (int i = 0; i <this.size; i++) {
            if (keys[i] != null) {
                temp.insert(keys[i], values[i]);
            }
        }
        keys = (Key[]) temp.keys;
        values = (Value[]) temp.values;
        size = temp.size;
        marked = temp.marked;
    }
    //Below is the same as LinearProbing class.
    public void prinTable()
    {
        for(int i = 0;i<size;i++)
        {
            if(keys[i] != null)
                System.out.println("["+keys[i].toString()+", '"+values[i].toString()+"' , "+marked[i]+"]");
            else
                System.out.println("[0, "+"\' \'"+", "+marked[i]+"]");

        }
    }
    public void WriteTable() throws IOException {

            for(int i =0;i<size;i++)
            {
                if(keys[i] == null)
                {
                    String k = "[0, "+"\' \'"+", "+marked[i]+"]";
                    bf.write(k);
                    bf.newLine();
                }
                if(keys[i] != null)
                {
                    String s ="["+keys[i].toString()+", '"+values[i].toString()+"' , "+marked[i]+"]";
                    bf.write(s);
                    bf.newLine();
                }
            }

    }
}
