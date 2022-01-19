public class Customer implements Comparable {
    int ID;
    int year;
    int minuteAtRestaurant;
    int lastsMeal;
    //We are creating Customer constructor with the four variables which are according to the question.
    Customer(int ID,int year,int minuteAtRestaurant,int lastsMeal)
    {
        this.ID = ID;
        this.year = year;
        this.minuteAtRestaurant = minuteAtRestaurant;
        this.lastsMeal = lastsMeal;
    }
    //We implements comparable to insert our customers accordingly to the heap.
    //Otherwise it will not consider as comparable and give us a compile-time error.
    //In this method we are inserting the years accordingly. If the years are equal we are comparing them with their minuteAtRestaurant values.
    @Override
    public int compareTo(Object o) {
        Customer temp = (Customer) o;
        if(this.year>((Customer) o).year) return 1;
        if(this.year<((Customer) o).year) return -1;
        else
            if(this.minuteAtRestaurant>((Customer) o).minuteAtRestaurant) return 1;
            if(this.minuteAtRestaurant<((Customer) o).minuteAtRestaurant) return -1;
            else
                return 0;
    }
}
