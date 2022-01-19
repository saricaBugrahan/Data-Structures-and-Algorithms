import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            //Scan the filename and the max waiting time.
            Scanner scan = new Scanner(System.in);
            String file = scan.next();
            int min = scan.nextInt();
            int waiter = 0;
            double[] arr = new double[12];
            //Insert the average times into the array.
            for(int i =0;i<arr.length;i++)
            {
                arr[i] = Algo.run(file,i+1);
                Algo.say++;

            }
            //Search for the last min>arr[i] value and break it.
            for(int i = 0;i<arr.length;i++)
            {
                if(min>=arr[i])
                {
                    waiter = i+1;
                    break;
                }
            }
            //Then run for the last time with the specific informations.
            Algo.run(file,waiter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}

