package Classes.File_IO;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriter_Scanner {

    public static void main(String[] args) {

        //FILE CREATION
        File myFile = new File("FileDemo.txt"); //The file FileDemo.txt will be in the Project Folder


        try{
            myFile.createNewFile(); //Creates the file
        }
        catch(Exception e){
        }


        //FILE WRITING
        try {
            FileWriter fw = new FileWriter("FileDemo.txt"); // A character stream to write characters
            // FileWriter fw = new FileWriter("FileDemo.txt", true);  // Set the 2nd parameter to true if you want to append i.e. join new writing with previous

            fw.write("Hello Everyone"); // Can write a whole string
            fw.close(); // Always close streams after work is done
        }
        catch(Exception e){}



        //FILE READING
        File newFile = new File("ReadFile.txt"); // ReadFile.txt must be available in the Project Folder

        ///Scanner
        try {
            Scanner sc = new Scanner(newFile); // Can use Scanner to read files, just add the file as parameter
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch(Exception e){}

        //FILE DELETE
        myFile.delete();  // Can delete a specific file

    }


}
