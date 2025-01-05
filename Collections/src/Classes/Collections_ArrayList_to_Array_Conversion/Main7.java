package Classes.Collections_ArrayList_to_Array_Conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main7 {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

        Integer [] arr = new Integer[list1.size()];
        list1.toArray(arr); // toArray(array) function of a list converts the list into an array inside the parameter array

        System.out.print("Array: ");
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        String [] names = new String[]{"Bob", "Amy", "Jim"};
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(names)); // Arrays.asList(array) converts the array to a list, use as parameter of ArrayList constructor
        System.out.println("list2 = " + list2);

    }

}
