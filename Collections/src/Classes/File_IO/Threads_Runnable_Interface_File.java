package Classes.File_IO;

class ThreadB implements Runnable // Can implement Runnable interface to make your class a Runnable, needed if you cannot extend Thread class
{
    String name;

    ThreadB(String name)
    {
        this.name = name; // not a thread class, so cannot use the parent constructor
    }

    public void run()
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println(this.name + ": " + i);
            try {
                Thread.sleep(2000);
            }
            catch(Exception e){}
        }

        System.out.println(this.name + " is over. BYEBYE!!!");
    }
}

class Runnable_Interface_File {

    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadB("Thread 1"));  // Create a thread object, and give your Runnable object as parameter to the thread
        Thread t2 = new Thread(new ThreadB("Thread 2"));
        t1.start();
        t2.start();

        try
        {
            Thread.sleep(15000);  // One way to end the Main thread last is to keep it waiting by Thread.sleep(), but very inefficient
        }
        catch(Exception e){}
        System.out.println("Main Thread Over - BYE BYE!!!!");

    }

}