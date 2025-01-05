package Classes.Collections_HashMap;

import java.util.HashMap;
import java.util.Set;

public class Main6 {

    public static void main(String[] args) {

        HashMap<String, Double> cgpa = new HashMap<>();
        //HashMap<Class1, Class2> is used to map Class1 with Class2
        //Class1 is the Key while Class2 is the Value
        //Key is unique, but Values can be same

        //For example, Student ID is unique, cgpa can be the same
        // put(key,value) function is used to insert a key-value pair in a hashmap
        cgpa.put("0112010220", 3.5);
        cgpa.put("0112110340", 2.6);
        cgpa.put("0111910356", 3.5);

        System.out.println("HashMap cgpa = " + cgpa);

        cgpa.put("0112110340", 3.9);

        // If you put the same key, it will only replace the value of that key, keys are not duplicated, only value changed
        System.out.println("HashMap cgpa = " + cgpa);

        cgpa.remove("0112110340"); // remove(key) removes the key

        System.out.println("HashMap cgpa = " + cgpa);

        cgpa.remove("0111910356", 3.4); // remove(key,value) removes the key-value pair if it is present

        System.out.println("HashMap cgpa = " + cgpa);

        cgpa.remove("0111910356", 3.5); // removes here since present

        System.out.println("HashMap cgpa = " + cgpa);

        cgpa.put("0112010220", 3.5);
        cgpa.put("0112110340", 2.6);
        cgpa.put("0111910356", 3.5);

        System.out.println("HashMap cgpa = " + cgpa);

        Set<String> keys = cgpa.keySet(); // keySet() returns the Set of Keys

        for(String s: keys)
        {
            System.out.println(s + " has a cgpa of " + cgpa.get(s));  // get(key) return value of the key
        }

    }

}
