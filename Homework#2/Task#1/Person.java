import java.util.Random;
public class Person implements Comparable {
    Random random = new Random();
    String name;
    String surname;
    long ID;

    @Override
    public int compareTo(Object o) {
        Person temp =  (Person)o;
        if(this.ID>(temp.ID)) return 1;
        else if(this.ID== temp.ID) return 0;
        else return -1;
    }
    Person(String name,String surname)
    {
        //Takes random ID for persons.
        ID = random.nextInt(100);
        this.name = name;
        this.surname = surname;
    }
    public String toString()
    {
        return "Name: "+ name +" Surname: "+ surname+" ID: "+ID;
    }
}
