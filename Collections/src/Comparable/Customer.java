package Comparable;

public class Customer implements Comparable<Customer>{
    private String name;

    public Customer(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Customer other) {
        //this < other -> -1
        //this == other -> 0
        //this > other -> 1
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
