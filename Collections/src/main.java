import java.io.*;
import java.util.*;

class Student implements Comparable<Student>, Serializable {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.cgpa, this.cgpa); // Descending order of CGPA
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

class nameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // Collections - ArrayList, Iterator
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 3.5));
        students.add(new Student(3, "Charlie", 3.9));

        System.out.println("Students (using Iterator):");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Collections - Sorting
        students.sort(new nameComparator());
        System.out.println("\nStudents sorted by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting by Comparable (CGPA)
        Collections.sort(students);
        System.out.println("\nStudents sorted by CGPA (descending):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Collections - Stack
        Stack<Student> studentStack = new Stack<>();
        studentStack.push(new Student(4, "David", 3.6));
        studentStack.push(new Student(5, "Eve", 3.7));
        System.out.println("\nStudent Stack Pop: " + studentStack.pop());

        // Collections - Set
        Set<String> courses = new HashSet<>(Arrays.asList("Math", "Physics", "Chemistry"));
        System.out.println("\nCourses Set: " + courses);

        // Collections - HashMap
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "Alice");
        studentMap.put(2, "Bob");
        System.out.println("\nStudent Map: " + studentMap);

        // Collections - ArrayList to Array Conversion
        Student[] studentArray = students.toArray(new Student[0]);
        System.out.println("\nArray from ArrayList: " + Arrays.toString(studentArray));

        // File I/O - FileWriter, Scanner
        File file = new File("students.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
        }

        System.out.println("\nReading from file using Scanner:");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

        // File I/O - FileInputStream, FileOutputStream
        String message = "Hello, File I/O!";
        try (FileOutputStream fos = new FileOutputStream("message.txt")) {
            fos.write(message.getBytes());
        }

        try (FileInputStream fis = new FileInputStream("message.txt")) {
            byte[] data = fis.readAllBytes();
            System.out.println("\nFileInputStream Output: " + new String(data));
        }

        // File I/O - ObjectInputStream, ObjectOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"))) {
            List<Student> deserializedStudents = (List<Student>) ois.readObject();
            System.out.println("\nDeserialized Students: " + deserializedStudents);
        }

        // Threads - Thread Class
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("Thread using Thread class is running.");
            }
        };
        thread1.start();

        // Threads - Runnable Interface
        Runnable task = () -> System.out.println("Thread using Runnable interface is running.");
        Thread thread2 = new Thread(task);
        thread2.start();

        // Threads - Join, States
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread with join example completed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        thread3.join();

        System.out.println("Thread 3 state after join: " + thread3.getState());
    }
}
