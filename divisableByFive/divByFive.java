
/**
 * Write a description of class findHypo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class divByFive
{
    // instance variables - replace the example below with your own
    Scanner input = new Scanner(System.in);
    /**
     * Constructor for objects of class findHypo
     */
    public divByFive()
    {
        // initialise instance variables
        System.out.println("enter number");
        int num = input.nextInt();
        if(num % 5 == 0){
            System.out.println(num + " * STAR!!!");
            double lengthA = input.nextInt();
        }else{
            System.out.println(num + " no star :(");
        }
    }
}
