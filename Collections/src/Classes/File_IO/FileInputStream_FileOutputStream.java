package Classes.File_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputStream_FileOutputStream {

    public static void main(String[] args) {

        File file = new File("Sample.txt");

        if(!file.exists()) // exists() function checks if the file is present or not
        {
            try {
                file.createNewFile();
                System.out.println("Create new File");
            }catch(Exception e){}
        }



        // FILEOUTPUTSTREAM for writing text file
        try {
            FileOutputStream fos = new FileOutputStream(file); // This is a byte stream to write bytes
            String output = "Hello Class \nThis is File Output Stream";
            fos.write(output.getBytes()); // Need to use getBytes() function of a string to convert it into bytes array so that it can be written
            fos.flush(); // sometimes needed to clear the buffer memory
            fos.close();
        }catch(Exception e){}



        //FILEINPUTSTREAM for reading text file
        try {
            FileInputStream fis = new FileInputStream(file);
            int i = fis.read(); // read() function reads 1 byte at a time

            while (i != -1) {  // ASCII of End Of File (EOF) is -1
                char c = (char) i;
                System.out.print(c);  // Typecast to a char and then print
                i = fis.read();
            }
            fis.close();
        }
        catch(Exception e){}


    }



}
