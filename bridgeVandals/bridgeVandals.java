/**
 * Write a description of class bridgeVandals here.
 *
 * @author (Luke Weston)
 * @version (1.00)
 */
public class bridgeVandals
{
    double vandals = 3;
    double crowdlimit = 10;
    double tick = 1;
    int statues = 0;
    public bridgeVandals()
    {
        // initialise instance variables
        for(double crowd = 0; crowd < crowdlimit; tick++){
            //every tick, 2 statues are pushed in.
            crowd = crowd + 5; //Math.pow(tick, 2);
            statues += 2;
            System.out.println("crowd " + crowd + " statues " + statues + " tick " + tick);
        }
    }
}
