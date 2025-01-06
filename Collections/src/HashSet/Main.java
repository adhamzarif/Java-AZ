package HashSet;
//elements will be unique, there will be no duplicate
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
    HashSet<Integer> set = new HashSet<>();
    //ArrayList<Integer> arr = new ArrayList<>(); same as

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        //Print All elements
        System.out.println(set);
        //Size
        System.out.println("Size of set is: " + set.size());
        //Search => contains
        if(set.contains(1))//if true then exists
        {
            System.out.println("Set Contains 1");
        }
        else
        {
            System.out.println("Set Doesn't Conrain");
        }

        //Delete
        set.remove(1);
        if(!set.contains(1))
        {
            System.out.println("Doesn't Contain 1");
        }

        //Iterator
        Iterator it = set.iterator();
        //HaseNext = true/false
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
