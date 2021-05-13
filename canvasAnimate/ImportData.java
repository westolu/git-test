
/**
 * Write a description of class importData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ImportData
{
    int data;
    public ImportData()
    {
        try {
            File myObj = new File("dataDump.txt");
            Scanner dataReader = new Scanner(myObj);
            while (dataReader.hasNextInt()) {
                data = dataReader.nextInt();
                //System.out.println(data);
            }
            dataReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}