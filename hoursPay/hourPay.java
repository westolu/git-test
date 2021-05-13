
/**
 * Write a description of class hourPay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class hourPay
{
    int hoursWorked = 12;
    int normalHourPay = 20;
    int overTimePay = 30;
    int totalPay = 0;
    /**
     * Constructor for objects of class hourPay
     */
    public hourPay()
    {
        // initialise instance variables
        if(hoursWorked > 10){
            totalPay = totalPay + (10*20);
            totalPay = totalPay + ((hoursWorked - 10) * 30);
            System.out.println(totalPay);
        } else {
            System.out.println(normalHourPay * hoursWorked);
        }
    }
}
