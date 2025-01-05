package Classes.Collections_Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main5 {

    public static void main(String[] args) {

        //  Set<Integer> set = new HashSet<>();
        // elements are not added sequentially

        Set<Integer> set = new LinkedHashSet<>();
        // elements are added sequentially

        set.add(32);
        set.add(45);
        set.add(20);
        set.add(100);
        set.add(100); //duplicate element not added

        System.out.println("Set = " + set);


        set.remove(20); //removes given element

        System.out.println("Set = " + set);


        System.out.println("Set contains 100? : " + set.contains(100));
        System.out.println("Set contains 10? : " + set.contains(10));
        // returns true if element present, else false

        System.out.println("Is set empty? : " + set.isEmpty());
        // true if set empty, else false

        System.out.println("Set size = " + set.size());
        //returns no of elements

        set.clear(); // clears entire set
        System.out.println("Set = " + set);

    }

}
