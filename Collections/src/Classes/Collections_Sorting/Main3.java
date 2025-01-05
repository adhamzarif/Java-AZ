package Classes.Collections_Sorting;

import Classes.Collections_ArrayList_Primitive_and_Reference_Types.Collections_Student_Comparable_Comparator.NameComparator;
import Classes.Collections_ArrayList_Primitive_and_Reference_Types.Collections_Student_Comparable_Comparator.Student;

import java.util.ArrayList;
import java.util.Collections;

public class Main3 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);

        System.out.println("Numbers = " + numbers);

        Collections.sort(numbers); //Collections.sort(list) sorts a given arrayList in ascending order

        System.out.println("Numbers (sorted) = " + numbers);

        Collections.sort(numbers, Collections.reverseOrder()); // Collections.reverseOrder() sorts list in descending order

        System.out.println("Numbers (sorted in reverse) = " + numbers);

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Bob", 3.6));
        list.add(new Student("Amy", 3.9));
        list.add(new Student("John",2.5));

        System.out.println("List = " + list);

        Collections.sort(list); // Collections.sort(list) can sort a Student list only if it implements Comparable

        System.out.println("List (sorted by cgpa) = " + list);

        Collections.sort(list, new NameComparator()); // Add a new Comparator as second parameter to sort the list using that comparator

        System.out.println("List (sorted by name) = " + list);

        Collections.sort(list, Collections.reverseOrder(new NameComparator())); // To sort in descending order, just add the comparator as parameter of reverseOrder()

        System.out.println("List (sorted by name in reverse) = " + list);


    }

}
