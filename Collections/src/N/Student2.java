package N;
import java.io.*;
import java.util.*;

// Implement Comparable for natural ordering
class Student2 implements Comparable<Student> {
    int id;
    String name;
    double cgpa;

    Student2(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + cgpa;
    }

    // Natural ordering: Sort by CGPA descending, then by ID ascending
    @Override
    public int compareTo(Student other) {
        if (Double.compare(other.cgpa, this.cgpa) == 0) {
            return Integer.compare(this.id, other.id); // Sort by ID if CGPA is the same
        }
        return Double.compare(other.cgpa, this.cgpa); // Sort by CGPA descending
    }
}

class Main2 {
    public static void main(String[] args) throws IOException {
        // Create a list of students with predefined data
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", 3.8));
        students.add(new Student(102, "Bob", 3.9));
        students.add(new Student(103, "Charlie", 3.8));
        students.add(new Student(104, "David", 3.7));

        // Sort using Comparable (natural ordering)
        Collections.sort(students);

        System.out.println("\nSorted Students (using Comparable):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Define a custom Comparator to sort by name alphabetically
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        };

        // Sort using Comparator (by name alphabetically)
        students.sort(nameComparator);

        System.out.println("\nSorted Students (by Name using Comparator):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Write the sorted students to a file (by name)
        File file = new File("students.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
        }

        System.out.println("\nStudent details have been written to students.txt");
    }
}

