package Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> lst = new ArrayList<>();
        lst.add(new Customer("c"));
        lst.add(new Customer("a"));
        lst.add(new Customer("b"));

        Collections.sort(lst);

        System.out.println(lst);
    }
}
