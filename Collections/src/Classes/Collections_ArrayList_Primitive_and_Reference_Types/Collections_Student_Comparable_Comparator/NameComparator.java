package Classes.Collections_ArrayList_Primitive_and_Reference_Types.Collections_Student_Comparable_Comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> // Comparator<ClassName> creates an extra comparison, different from the Comparable comparison
{
    public int compare(Student s1, Student s2) //compare(ClassName c1, ClassName c2) compares both objects, +ve if c1>c2, -ve if c1<c2, 0 if c1==c2
    {
        return s1.name.compareTo(s2.name); //can use String's built in compareTo(String s) method to compare alphabetically
    }
}
