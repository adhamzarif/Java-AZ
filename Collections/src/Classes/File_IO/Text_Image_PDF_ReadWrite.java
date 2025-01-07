package Classes.File_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Text_Image_PDF_ReadWrite  {

    public static void main(String[] args) {

        try
        {
            //Text Copy
            //    FileReader fr = new FileReader("Data.txt");
            //    FileWriter fw = new FileWriter("Copy.txt");

            //Does not copy Image
            //    FileReader fr = new FileReader("cat.jpg");
            //    FileWriter fw = new FileWriter("meow.jpg");

            //     FileInputStream fr = new FileInputStream("cat.jpg");
            //     FileOutputStream fw = new FileOutputStream("meow.jpg");

            FileInputStream fr = new FileInputStream("CT1.pdf");
            FileOutputStream fw = new FileOutputStream("CT2.pdf");

            int i;
            while( (i = fr.read()) != -1)
            {
                fw.write(i);
            }
            fw.flush();
            fw.close();
            fr.close();

        }
        catch(Exception e){}

    }

}
