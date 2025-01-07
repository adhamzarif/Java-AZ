package Classes.File_IO;

class ThreadA extends Thread //can extend Thread class to make your class a Thread
{
    public ThreadA(String name)
    {
        super(name); // can use the parent constructor to give a name to the thread
    }

    public void run() // the run() method contains the code of the thread
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println(this.getName() + ": " + i); // getName() gives the name of the thread
            try {
                Thread.sleep(2000);  // Thread.sleep(milliseconds) function keeps the thread waiting for given time and then moves to next code
            }
            catch(Exception e){}
        }

        System.out.println(this.getName() + " is over. BYEBYE!!!");
    }
}

public class Thread_Class {

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("Thread 1");
        ThreadA t2 = new ThreadA("Thread 2");
        t1.start();  // call start() method to start the thread
        t2.start();
    }
}
