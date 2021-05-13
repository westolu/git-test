//@author Luke Weston
//* @version 1.0
import java.util.concurrent.ThreadLocalRandom;
public class Person
{
   int xPos;
   int yPos;
   boolean infected = false;
   int direction;
   int healTime;
   public Person(int height, int width)
   {
        xPos = ThreadLocalRandom.current().nextInt(0, width);
        yPos = ThreadLocalRandom.current().nextInt(0, height);
        direction = ThreadLocalRandom.current().nextInt(0, 4);
   }
}
