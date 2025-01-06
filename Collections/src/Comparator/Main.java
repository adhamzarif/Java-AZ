package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> lst = new ArrayList<>();
        lst.add(new Customer("c", "e3"));
        lst.add(new Customer("a", "e2"));
        lst.add(new Customer("b", "e1"));

        Collections.sort(lst, new EmailComparator());

        System.out.println(lst);
    }
}
