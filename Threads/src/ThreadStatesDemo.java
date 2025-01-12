public class ThreadStatesDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State: " + t.getState()); // NEW
        t.start();
        System.out.println("State: " + t.getState()); // RUNNABLE
        try {
            Thread.sleep(50);
            System.out.println("State: " + t.getState()); // TIMED_WAITING
            t.join();
            System.out.println("State: " + t.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
