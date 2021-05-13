
            /**
            * Write a description of class findHypo here.
            *
            * @author (your name)
            * @version (a version number or a date)
            */
            import java.util.Scanner;

            public class teReo
            {
            // instance variables - replace the example below with your own
            Scanner input = new Scanner(System.in);
            /**
            * Constructor for objects of class findHypo
            */
            public teReo()
            {
        System.out.println("how many people do you want me to greet");
        int numOfPeople = input.nextInt();
    switch(numOfPeople){
case 0 : System.out.println("no one is here :(");
break;
case 1 : System.out.println("wow hi dude");
break;
case 2 : System.out.println("hello you two");
//break;
default : System.out.println("wow there are " + numOfPeople + " of you! that is a lot.");
    }
        }
            }

