class Resource {
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1: Locked Resource 1");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (r2) {
                    System.out.println("Thread 1: Locked Resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread 2: Locked Resource 2");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (r1) {
                    System.out.println("Thread 2: Locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
