import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

// Custom comparator for sorting employees by salary
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.salary, e2.salary);
    }
}

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // Collections - ArrayList, Iterator
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 50000));
        employees.add(new Employee(2, "Bob", 60000));
        employees.add(new Employee(3, "Charlie", 55000));

        System.out.println("Employees (using Iterator):");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Collections - Sorting
        employees.sort(new SalaryComparator());
        System.out.println("\nEmployees sorted by salary:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Collections - Stack
        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.push(new Employee(4, "David", 70000));
        employeeStack.push(new Employee(5, "Eve", 80000));
        System.out.println("\nEmployee Stack Pop: " + employeeStack.pop());

        // Collections - Set
        Set<String> skills = new HashSet<>(Arrays.asList("Java", "Python", "C++"));
        System.out.println("\nSkills Set: " + skills);

        // Collections - HashMap
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(1, "Alice");
        employeeMap.put(2, "Bob");
        System.out.println("\nEmployee Map: " + employeeMap);

        // Collections - ArrayList to Array Conversion
        Employee[] employeeArray = employees.toArray(new Employee[0]);
        System.out.println("\nArray from ArrayList: " + Arrays.toString(employeeArray));

        // File I/O - FileWriter, Scanner
        File file = new File("employees.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (Employee emp : employees) {
                writer.write(emp.toString() + "\n");
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees: " + deserializedEmployees);
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

