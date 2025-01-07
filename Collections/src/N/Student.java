package N;
import java.io.*;
import java.util.*;

// Implement Comparable for natural ordering
class Student implements Comparable<Student> {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
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
        // Compare by CGPA descending
        if (Double.compare(other.cgpa, this.cgpa) == 0) {
            // If CGPA is the same, compare by ID ascending
            return Integer.compare(this.id, other.id);
        }
        return Double.compare(other.cgpa, this.cgpa);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        // Create a list of students with predefined data
        List<Student> students = new ArrayList<>();
        File file = new File("C:/Users/Admin/Downloads/Java/Collections/src/N/students.txt");

        // Read the students.txt from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.valueOf(parts[0]);
                String name = parts[1];
                double cgpa = Double.valueOf(parts[2]);
                students.add(new Student(id, name, cgpa));
            }
        }

        // Display the students.txt read from the file
        System.out.println("\nStudents read from file:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort the students using the natural ordering defined in compareTo
        Collections.sort(students);

        // Display the sorted students
        System.out.println("\nSorted Students (by CGPA and ID):");
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

        // Sort the students by name using the custom comparator
        students.sort(nameComparator);

        // Display the sorted students by name
        System.out.println("\nSorted Students (by Name using Comparator):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
