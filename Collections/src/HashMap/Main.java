package HashMap;
//Hashmap is works unorderd
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //country(key), population(value)
        HashMap<String, Integer> map = new HashMap<>();

        //Insertion
        map.put("Bangladesh", 140);
        map.put("USA", 200);
        map.put("UK", 150);
//        map.put("USA", 180); //previous values will be updated
        System.out.println(map);

        //Search
        if(map.containsKey("USA"))
        {
            System.out.println("Key is present");
        }
        else
        {
            System.out.println("Key isn't present");
        }
        //WithValue
        System.out.println(map.get("USA")); //Key exits
        System.out.println(map.get("China")); // doesn't exits

        int arr[] = {12, 15, 18};
//        for(int i = 0; i < 3; i++)
//        {
//            System.out.print(arr[i]  + " ");
//        }
//        System.out.println();
        for(int val : arr)
        {
            System.out.print(val  + " ");
        }
        System.out.println();
        //for loop in hashmap
        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            System.out.print(e.getKey() + " ");
            System.out.print(e.getValue() + " ");
        }
        System.out.println();
        //Another way with set
        Set<String> keys = map.keySet();
        for(String key : keys)
        {
            System.out.print(key + " " + map.get(key) + " ");
        }
        System.out.println();
        //Removing A pair
        map.remove("USA");
        System.out.println(map);
    }
}
