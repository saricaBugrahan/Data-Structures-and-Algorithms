import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Algo {
    //This static variable helps us the express one time to the sout lines.
    static int say = 0;
    public static double run(String filename,int sa) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(filename));
        Customer[] arr = new Customer[scan.nextInt()];
        //We are adding the customer informations into new Customers with the help of an array.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Customer(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        }
        //Then we are creating our heap.
        Heap heap = new Heap(arr.length);
        int timer = 1;
        // Our i value is helps us in the bottom while part.
        int i = 0;
        //Creating array of waiter and isAvaliable according to the count of waiter.
        int waiter[] = new int[sa];
        //Its holds the time for each Customers waits.
        int waitingTime[] = new int[12];
        boolean isAvaliable[] = new boolean[sa];
        //Total value of the minutes that Customer waits
        double total = 0;
        //Fill the array according to the size of waiter and isAvaliable(they are the same).
        for(int m =0;m<isAvaliable.length;m++)
        {
            isAvaliable[m] = true;
            waiter[m] = 1;
        }
        int IDcount =0;
        int k = 0;
        if(say == 12)
        {
            System.out.println("Minimum number of waiters required "+waiter.length);
            System.out.println("Simulation with "+waiter.length+" customers:");
        }
        //We are checking all the values in the heap is popped out.
        //Instead of using this we can also use isEmpty method.
           while (IDcount != 12) {
               //if our i value is less than 12 which is our maxID of the customer and it's time at the restaurant equal to the timer we are inserting it.
               if (i < arr.length) {
                   while (timer == arr[i].minuteAtRestaurant) {
                       heap.insert(arr[i]);
                       i++;
                       //To protect from the error we use break if(i ==12).
                       if(i == arr.length)
                           break;
                   }
               }
               for (int j = 0; j < waiter.length; j++) {
                   //As our condition says that if more than 1 waiter avaliable
                   //Lower ID get's the customer. Because of that we are using loop.
                   if (timer == waiter[j] && timer != 1 && isAvaliable[j] == false) {
                       //if timer equal to the waiter's j element and it's avaliable we are in.
                       if (i < arr.length && timer>arr[i].minuteAtRestaurant) {
                           //if timer is higher than the arr[i]'s restaurant time we are inserting it.
                           heap.insert(arr[i]);
                           i++;
                       }
                       isAvaliable[j] = true;
                   }
                   if (isAvaliable[j]) {
                       if (!heap.isEmpty()) {
                           //If it's not empty we are popping the min value.
                           Customer a = (Customer) heap.delMin();
                           //We are looking for if waiter[j] is higher than the customer's minuteAtRestaurant.
                           //Also we need to get other waiters with the second part.
                           //It was not correctly  run if I not write the second part
                           //Because it will always get false due to the first 4 customers.
                           //And I tried to solve it like that.
                           if (waiter[j] >= a.minuteAtRestaurant || ((waiter[j] == 1 && IDcount>=5))) {
                               if(waiter[j] == 1)
                               {
                                   waitingTime[k] = waiter[j]-1;
                               }
                               else
                                   waitingTime[k] = waiter[j] - a.minuteAtRestaurant;
                               if(say == 12)
                               {
                                   System.out.println("Waiter " + j + " takes customer " + a.ID + " at minute " + waiter[j] + " (wait: " + waitingTime[k] + " mins)");
                               }
                               //I increase the total time according to the waitingTime[k]
                               total+= waitingTime[k];
                               k++;
                               waiter[j] += a.lastsMeal;
                               IDcount++;
                               //And set it's value to false because it take customer.
                               isAvaliable[j] = false;
                           } else
                               //If not the condition satisfies we are inserting again.
                               heap.insert(a);
                       }
                   }
               }
               //Increase the time in all iteration.
               timer++;
           }
           total = total/12;
           if(say ==12)
           {
               System.out.println();
               System.out.println("Average waiting time: "+total+" minutes");
           }
        return total;

    }
}
