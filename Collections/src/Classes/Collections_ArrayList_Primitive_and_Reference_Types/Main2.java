package Classes.Collections_ArrayList_Primitive_and_Reference_Types;

import Classes.Collections_ArrayList_Primitive_and_Reference_Types.Collections_Student_Comparable_Comparator.Student;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        // Can also create ArrayList of my defined types and classes
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("Bob", 3.60);

        list.add(s1);

        System.out.println("List = " + list);

        // Can directly create a Student and add to the list
        list.add(new Student("Amy", 3.9));
        list.add(new Student("John",2.5));

        System.out.println("List = " + list);

        // ArrayList<int> numbers = new ArrayList<>(); - cannot use primitive type like int for lists, only reference types

        // Integer is the reference type/ wrapper class for int data type
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Numbers = " + numbers);


    }
}