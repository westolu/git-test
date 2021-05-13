
/**
 * Write a description of class adding here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class adding
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    Scanner input = new Scanner(System.in);
    /**
     * Constructor for objects of class adding
     */
    public adding()
    {
        // initialise instance variables
        x = input.nextInt();
        y = input.nextInt();
        System.out.println("ADDED!!!!!!!!!!" + x+y);
        System.out.println("multerply" + x*y);
        System.out.println("DIVEDE!!!!!!!!!!" + x/y);
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
