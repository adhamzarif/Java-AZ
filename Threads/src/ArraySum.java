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

public class ArraySum {
    public static void main(String[] args) throws InterruptedException {
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
}
