import java.io.*;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        //Creates two instances and do the procedure according to the pdf file.
        LinearProbing ht = new LinearProbing();
        DoubleHashing ht2 = new DoubleHashing();
        String k = "********************************";
        Scanner scan = new Scanner(new FileReader("src/fruits.txt"));
        System.out.println(scan.nextLine());
        for(int i =0;i<4;i++)
        {

            ht.insert(scan.nextInt(),scan.nextLine());
        }
        ht.printTable();
        ht.WriteTable();
        System.out.println(k);
        LinearProbing.bf.write(k);
        LinearProbing.bf.newLine();

        ht.insert(4225,	"avocado large hass");
        ht.printTable();
        ht.WriteTable();
        for(int i = 0;i<16;i++)
        {
            ht.insert(scan.nextInt(),scan.nextLine());
        }
        System.out.println(k);
        LinearProbing.bf.write(k);
        LinearProbing.bf.newLine();
        ht.find(4514);
        ht.find(4225);
        ht.find(4017);
        ht.delete(4514);
        ht.delete(4225);
        ht.delete(4017);
        System.out.println(k);
        LinearProbing.bf.write(k);
        LinearProbing.bf.newLine();
        ht.find(4514);
        ht.find(4225);
        ht.find(4017);
        System.out.println(k);
        LinearProbing.bf.write(k);
        LinearProbing.bf.newLine();
        ht.printTable();
        ht.WriteTable();
        System.out.println(k);
        LinearProbing.bf.write(k);
        LinearProbing.bf.newLine();
        LinearProbing.bf.close();

        for(int i =0;i<4;i++)
        {

            ht2.insert(scan.nextInt(),scan.nextLine());
        }
        ht2.prinTable();
        ht2.WriteTable();
        System.out.println(k);
        DoubleHashing.bf.write(k);
        DoubleHashing.bf.newLine();


        ht2.insert(4225,	"avocado large hass");
        ht2.prinTable();
        ht2.WriteTable();
        DoubleHashing.bf.newLine();
        for(int i = 0;i<16;i++)
        {
            ht2.insert(scan.nextInt(),scan.nextLine());
        }
        System.out.println(k);
        DoubleHashing.bf.write(k);
        DoubleHashing.bf.newLine();
        ht2.printFind(4820);
        ht2.printFind(4528);
        ht2.printFind(3173);
        ht2.delete(4820);
        ht2.delete(4528);
        ht2.delete(3173);
        System.out.println(k);
        DoubleHashing.bf.write(k);
        DoubleHashing.bf.newLine();
        ht2.printFind(4820);
        ht2.printFind(4528);
        ht2.printFind(3173);
        System.out.println(k);
        DoubleHashing.bf.write(k);
        DoubleHashing.bf.newLine();
        ht2.prinTable();
        ht2.WriteTable();
        DoubleHashing.bf.close();
    }
}
