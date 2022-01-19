import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinearProbing<Key,Value> {
    //These are our variables.
    int size = 5;
    int Key_Value_Count = 0;
    private Key[] keys;
    private Value[] values;
    int[] Marks;
    static FileWriter fl;

    static {
        try {
            fl = new FileWriter("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BufferedWriter bf = new BufferedWriter(fl);

    LinearProbing() throws IOException {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        Marks = new int[size];
    }
    //We have second constructor for rehashing
    LinearProbing(int size) throws IOException {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        Marks = new int[size];
        this.size = size;
    }
    //According to the textbook the hash function.
    public int hashFunction(Key key) {
        int temp = ((key.hashCode() & 0x7fffffff) % size);
        return temp;
    }
    //In this method we are creating a temp class and inserting the items again.
    //Then equalize the old ones with the new ones.
    private void rehash(int capacity) throws IOException {
        LinearProbing<Key, Value> temp = new LinearProbing<Key, Value>(capacity);
        for (int i = 0; i <this.size; i++) {
            if (keys[i] != null) {
                temp.insert(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        size = temp.size;
        Marks = temp.Marks;
    }
    //We are inserting our value according to the hash function.
    //If it's half full it will increase it size.
    //If the index is already full it will search empty index by increasing 1.
    public void insert(Key key, Value val) throws IOException {
        if (Key_Value_Count+1>=size/2) rehash(size*2);
        int hash;
        for (hash = hashFunction(key); keys[hash] != null; hash = (hash + 1) % size) {
            if (keys[hash].equals(key)) {
                values[hash] = val;
                Marks[hash] = 0;
                return;
            }
        }
        keys[hash] = key;
        values[hash] = val;
        Key_Value_Count++;
    }
    //Whenever we find the element we are marking it as 1 to define it's deleted.
    public void delete(Key key) {
        int hash = hashFunction(key);
        while (!key.equals(keys[hash])) {
            hash = (hash + 1) % size;
        }

        // delete key and associated value
        Marks[hash] = 1;
        Key_Value_Count--;

    }
    //It helps us the find the key
    private Value findhelper(Key key) {
        for (int i = hashFunction(key); keys[i] != null; i = (i + 1) % size)
            if (keys[i].equals(key) && Marks[i] == 0)
                return values[i];
        return null;
    }
    //And this method print's the necesseary informations.
    public void find(Key key) throws IOException {
        if(findhelper(key) != null)
        {
            System.out.println(findhelper(key));
            bf.write((String)findhelper(key));
            bf.newLine();
        }
        else
        {
            System.out.println("Item not found.");
            bf.write("Item not found.");
            bf.newLine();
        }
    }
    //It prints the values in the hash table.
    public void printTable()
    {
        for(int i = 0;i<size;i++)
        {
            if(keys[i] != null)
                System.out.println("["+keys[i].toString()+", '"+values[i].toString()+"' , "+Marks[i]+"]");
            else
                System.out.println("[0, "+"\' \'"+", "+Marks[i]+"]");

        }
    }
    //It writes the hash table into the output.txt.
    public void WriteTable() throws IOException {
            for(int i =0;i<size;i++)
            {
                if(keys[i] == null)
                {
                    String k = "[0, "+"\' \'"+", "+Marks[i]+"]";
                    bf.write(k);
                    bf.newLine();
                }
                if(keys[i] != null)
                {
                    String s ="["+keys[i].toString()+", '"+values[i].toString()+"' , "+Marks[i]+"]";
                    bf.write(s);
                    bf.newLine();
                }



            }
    }
}
