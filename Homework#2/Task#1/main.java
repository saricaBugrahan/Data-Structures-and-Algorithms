import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    //It's sorts from left to right and in descending order.
    public static void ModifiedinstertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = n-2; i >=0; i--) {
            int key = arr[i];
            int j = i+1;
            while (j >i && arr[j] > key) {
                arr[j-1] = arr[j];
                j = j + 1;
                if(j>=n) break;
            }
            arr[j-1] = key;
        }

    }
    //It's the same in the top as in double form.
    public static void ModifiedinstertionSort(double arr[])
    {
        int n = arr.length;
        for (int i = n-2; i >=0; i--) {
            double key = arr[i];
            int j = i+1;
            while (j >i && arr[j] > key) {
                arr[j-1] = arr[j];
                j = j + 1;
                if(j>=n) break;
            }
            arr[j-1] = key;
        }

    }
    public static void ModifiedbubbleSort(int arr[])
    {
        //Descending Bubble Sort
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] < arr[j+1])
                {
                    //swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);

        }
    }
    //For taking int values from the file.
    public static int[] readFile(String filename) throws InputMismatchException,FileNotFoundException {

        Scanner scan = new Scanner(new FileReader("src/sample.txt"));
        int [] temp = new int[scan.nextInt()];
        for (int i =0;i<temp.length;i++)
        {
            temp[i] = scan.nextInt();
        }
        return temp;
    }
    //For taking the double values from the file.
    public static double[] readFile2(String filename) throws InputMismatchException,FileNotFoundException {

        Scanner scan2 = new Scanner(new FileReader("src/sample2.txt"));
        double [] temp = new double[scan2.nextInt()];
        for (int i =0;i<temp.length;i++) {
            temp[i] = scan2.nextDouble();
        }
        return temp;
    }

    public static void main(String[] args) {

        try {
            int[] temp = readFile("src/sample.txt");
            ModifiedinstertionSort(temp);
            for(int val: temp)
            {
                System.out.print(val+" ");
            }
            double[] temp2 = readFile2("src/sample2.txt");
            ModifiedinstertionSort(temp2);
            System.out.println();
            for(double val: temp2)
            {
                System.out.print(val+" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Creating Person arrays with length and fill it with the person objects.
        Person[] persons = new Person[10];
        persons[0] = new Person("Buğra","Sarıca");
        persons[1] = new Person("Sam","Wase");
        persons[2] = new Person("Jhin","Joy");
        persons[3] = new Person("Tonik","Ton");
        persons[4] = new Person("Sally","Sal");
        persons[5] = new Person("Ally","All");
        persons[6] = new Person("Wally","Wal");
        persons[7] = new Person("Tilly","Til");
        persons[8] = new Person("Willy","Will");
        persons[9] = new Person("Kully","Kul");
        Person[] temp = new Person[10];
        System.out.println();
        Merge.sort(persons,temp,0 ,persons.length-1);
        for(Person p : persons)
            System.out.println(p);
    }


}

