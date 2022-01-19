import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        int a = 0;
        try {
            Scanner scan = new Scanner(new FileReader("src/sampleinput1.txt"));
            Program p1 = new Program();
            //Take the first line which is input, then parse it to integer.
            String howMany = scan.nextLine();
            int count = Integer.parseInt(howMany);
            while(a != count)
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
