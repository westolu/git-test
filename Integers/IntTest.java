

/**
 * Write a description of class IntTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntTest
{
    // instance variables - replace the example below with your own
    private int Int1;
    private int Int2;
    /**
     * Constructor for objects of class IntTest
     */
    public IntTest()
    {
        // initialise instance variables
        Int1 = 1;
        Int2 = 1;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1 = Int1 + 1;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1++;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        int m = 1; 
        // Flip all the set bits  
        // until we find a 0  
        while( (int)(Int1 & m) >= 1) {
            Int1 = Int1 ^ m; 
            m <<= 1;
        } 
      
        // flip the rightmost 0 bit  
        Int1 = Int1 ^ m;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1 = Int1 + Int2;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1 = Int1 - Int2;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1 = Int1 * Int2;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
        
        Int1 = Int1 / Int2;
        System.out.println(Int1);
        System.out.println(Int2 + "\n");
    }
}
