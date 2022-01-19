//Description: This class test the Program clasess methods.



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Program p1 = new Program();
        try {
            Scanner scan = new Scanner(new FileReader("src/sampleinput2.txt"));
            String howMany = scan.nextLine();
            //Take the first line which is input, then parse it to integer.
            int x = Integer.parseInt(howMany);
            int a = 0;
            //Loop starts.
            while(a !=x)
            {
                System.out.println("Parsing Expression #"+(a+1));
                String temp = scan.nextLine();
                p1.program(temp);
                a++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
