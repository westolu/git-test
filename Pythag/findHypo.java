
/**
 * Write a description of class findHypo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class findHypo
{
    // instance variables - replace the example below with your own
    Scanner input = new Scanner(System.in);
    /**
     * Constructor for objects of class findHypo
     */
    public findHypo()
    {
        // initialise instance variables
        System.out.println("enter true if you have the longest side and a short side, false if you have two short sides.");
        boolean yn = input.nextBoolean();
        if(yn == true){
            System.out.println("enter length A (long side) and then length B (short side). computer will then calculate hypotenuse");
            double lengthA = input.nextInt();
            double lengthB = input.nextInt();
            double hypotenuse = Math.pow(lengthA, 2) - Math.pow(lengthB, 2);;
            hypotenuse = Math.pow(hypotenuse, 0.5);
            System.out.println("hypotenuse is: " + hypotenuse);
        }else{
            System.out.println("enter length A and then length B. computer will then calculate hypotenuse");
            double lengthA = input.nextInt();
            double lengthB = input.nextInt();
            double hypotenuse = Math.pow(lengthA, 2) + Math.pow(lengthB, 2);;
            hypotenuse = Math.pow(hypotenuse, 0.5);
            System.out.println("hypotenuse is: " + hypotenuse);
        }
    }
}
