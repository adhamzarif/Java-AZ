package Classes.File_IO;

import java.io.*;

class Student implements Serializable //Need to implement Serializable so that the object can be read and written
{
    String name;
    int id;

    Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}


public class ObjectInputStream_ObjectOutputStream {

    public static void main(String[] args) {

        Student std = new Student(10,"Somik");
        Student std2 = new Student(15,"Tamim");

        try {
            FileOutputStream fos = new FileOutputStream("Obj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos); // This stream is used to write objects, put FOS as parameter
            oos.writeObject(std); // writeObject(object) function writes the object to the file
            oos.writeObject(std2);
            fos.close();
            oos.close();
        }catch(Exception e){}


        try {
            FileInputStream fis = new FileInputStream("Obj.txt");
            ObjectInputStream ois = new ObjectInputStream(fis); // This stream is used to read objects, put FIS as parameter
            Student stdnew = (Student) ois.readObject(); // readObject() function reads a object and returns it, need to typecast it to required type
            Student std2new = (Student) ois.readObject();
            fis.close();
            ois.close();

            System.out.println(stdnew.id + " " + stdnew.name);
            System.out.println(std2new.id + " " + std2new.name);

        }
        catch (Exception e){}


    }

}
