
/**
 * Write a description of class strongs here.
 *
 * @author (LUKE WESTON (not ryan bright))
 * @version (10.2)
 */
import java.util.Scanner;
public class strongs
{
    // instance variables - replace the example below with your own
    private String thisIsLukesWork;
    private String LukeWestonIsTheOwnerOfThisCode;
    private String RyanBrightIsNotTheOwnerOfThisCode;
    private String notAnyOneButLukesWork;
    private String NeitherIsJamesGoode;
    private String woahIHopeThisWorkIsNotStolen;
    Scanner notRyansWork = new Scanner(System.in);

    /**
     * Constructor for objects of class strongs
     */
    public strongs()
    {
        System.out.println("hey LUKE (owner of this code) would you mind inputting three STRINGS?");
        thisIsLukesWork = notRyansWork.nextLine();
        LukeWestonIsTheOwnerOfThisCode = notRyansWork.nextLine();
        RyanBrightIsNotTheOwnerOfThisCode= thisIsLukesWork.concat(LukeWestonIsTheOwnerOfThisCode);
        System.out.println(thisIsLukesWork + " " + LukeWestonIsTheOwnerOfThisCode);
        System.out.println(RyanBrightIsNotTheOwnerOfThisCode);
        System.out.println(RyanBrightIsNotTheOwnerOfThisCode.charAt(RyanBrightIsNotTheOwnerOfThisCode.length()-1));
        System.out.println("input a string that has the characters 'o', 'e', and 's'");
        NeitherIsJamesGoode = notRyansWork.nextLine();
        NeitherIsJamesGoode = NeitherIsJamesGoode.replaceAll("o", "0");
        NeitherIsJamesGoode = NeitherIsJamesGoode.replaceAll("e", "3");
        NeitherIsJamesGoode = NeitherIsJamesGoode.replaceAll("s", "5");
        System.out.println(NeitherIsJamesGoode);
        System.out.println("input 2 numbers");
        notAnyOneButLukesWork = notRyansWork.nextLine();
        woahIHopeThisWorkIsNotStolen = notRyansWork.nextLine();
        int thisWorkIsCopyrightedUnderLestonInc = Integer.parseInt(notAnyOneButLukesWork);
        int ryanStoleThisDidntHe = Integer.parseInt(notAnyOneButLukesWork);
        System.out.println(thisWorkIsCopyrightedUnderLestonInc + ryanStoleThisDidntHe);
        if (woahIHopeThisWorkIsNotStolen.toLowerCase().equals(notAnyOneButLukesWork.toLowerCase())) System.out.println("woah they are the same how about that jeez this is LUKE WESTONS WORK");
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = notAnyOneButLukesWork.getBytes();
 
        byte[] result = new byte[strAsByteArray.length];
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
 
        System.out.println(new String(result));
    }
}
