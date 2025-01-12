public class MultithreadingCT {

    // 1. Sum of an Array
    public static void sumOfArray() throws InterruptedException {
        class ArraySumThread extends Thread {
            private int[] arr;
            private int start, end;
            private int partialSum;

            public ArraySumThread(int[] arr, int start, int end) {
                this.arr = arr;
                this.start = start;
                this.end = end;
            }

            public int getPartialSum() {
                return partialSum;
            }

            @Override
            public void run() {
                partialSum = 0;
                for (int i = start; i < end; i++) {
                    partialSum += arr[i];
                }
            }
        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = arr.length / 2;

        ArraySumThread t1 = new ArraySumThread(arr, 0, mid);
        ArraySumThread t2 = new ArraySumThread(arr, mid, arr.length);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int totalSum = t1.getPartialSum() + t2.getPartialSum();
        System.out.println("Total Sum: " + totalSum);
    }

    // 2. Synchronized Method and Block
    static class Counter {
        private int count = 0;

        public synchronized void incrementMethod() {
            count++;
        }

        public void incrementBlock() {
            synchronized (this) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void synchronizedMethodAndBlock() throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) counter.incrementMethod();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) counter.incrementBlock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());
    }

    // 3. Bank Withdrawal using Synchronization
    static class BankAccount {
        private int balance;

        public BankAccount(int balance) {
            this.balance = balance;
        }

        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("Remaining Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient balance.");
            }
        }
    }

    public static void bankWithdrawal() {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                account.withdraw(600);
            }
        }, "Thread-1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                account.withdraw(500);
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }

    // 4. Deadlock
    public static void deadlockDemo() {
        class Resource {}

        final Resource r1 = new Resource();
        final Resource r2 = new Resource();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (r1) {
                    System.out.println("Thread 1: Locked Resource 1");
                    try { Thread.sleep(50); } catch (InterruptedException e) {}
                    synchronized (r2) {
                        System.out.println("Thread 1: Locked Resource 2");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (r2) {
                    System.out.println("Thread 2: Locked Resource 2");
                    try { Thread.sleep(50); } catch (InterruptedException e) {}
                    synchronized (r1) {
                        System.out.println("Thread 2: Locked Resource 1");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    // 5. Thread Class vs Runnable Interface
    public static void threadVsRunnable() {
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("Thread running: " + Thread.currentThread().getName());
            }
        }

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Thread running: " + Thread.currentThread().getName());
            }
        }

        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
    }

    // 6. Join and Thread States
    public static void joinAndThreadStates() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread-1: " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread-2: " + i);
                }
            }
        });

        System.out.println("State before start: " + t1.getState()); // NEW
        t1.start();
        t1.join();
        t2.start();
        System.out.println("State after join: " + t2.getState());
    }

    // Main Method to Run All Examples
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1. Sum of an Array:");
        sumOfArray();

        System.out.println("\n2. Synchronized Method and Block:");
        synchronizedMethodAndBlock();

        System.out.println("\n3. Bank Withdrawal using Synchronization:");
        bankWithdrawal();

        System.out.println("\n4. Deadlock Demo:");
        deadlockDemo();

        System.out.println("\n5. Thread Class vs Runnable Interface:");
        threadVsRunnable();

        System.out.println("\n6. Join and Thread States:");
        joinAndThreadStates();
    }
}
