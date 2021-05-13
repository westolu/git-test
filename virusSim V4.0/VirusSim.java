//@author Luke Weston
//* @version 4.0
import java.util.concurrent.ThreadLocalRandom;
public class VirusSim {
    int population = 10;
    int width = 10;
    int height = 10;
    //boolean running = true;
    int daysToRun = 30;
    int daysRan = 0;
    int peopleInfected = 1;
    String[][] world = new String[width][height];
    public VirusSim(){
        Person[] people = new Person[population];
        for(int i=0; i<population; i++){
            people[i] = new Person(width, height-1);
        }
        people[1].infected = true;
        while(daysRan <= daysToRun){
            for(int i=0; i<population; i++){
                //if (people[i].xPos >= width || people[i].xPos <= 0 || people[i].yPos >= height || people[i].yPos <= 0){
                //    running = false;
                //}

                for(int k=0; k<width; k++){
                    for(int l=0; l<height; l++){
                        world[k][l] = "_";
                    }
                }
                if (people[i].direction == 0){
                    if(people[i].xPos + 1 >= width){
                        people[i].direction = 2;
                        people[i].xPos--;
                    }else{
                        people[i].xPos++;
                    }
                }
                if(people[i].direction == 1){
                    if(people[i].xPos - 1 <= 0){
                        people[i].direction = 0;
                        people[i].xPos++;
                    }else{
                        people[i].xPos--;
                    }
                }
                if (people[i].direction == 2){
                    if(people[i].yPos + 1 >= height){
                        people[i].direction = 3;
                        people[i].yPos--;
                    }else{
                        people[i].yPos++;
                    }
                }else if(people[i].direction == 3){
                    if(people[i].yPos - 1 <= 0){
                        people[i].direction = 1;
                        people[i].yPos++;
                    }else{
                        people[i].yPos--;
                    }
                }
                //if (people[i].xPos >= width || people[i].xPos <= 0 || people[i].yPos >= height || people[i].yPos <= 0){
                //  running = false;
                //}
                people[i].direction = ThreadLocalRandom.current().nextInt(0, 4);
            }
            for(int p=0; p<population; p++){
                if(people[p].infected){
                    world[people[p].xPos][people[p].yPos] = "J"; 
                }else{
                    world[people[p].xPos][people[p].yPos] = "A";
                }
                for(int u=0;u<population;u++){
                    if(people[p].xPos == people[u].xPos && people[p].yPos == people[u].yPos && people[p].infected &&  people[u].infected == false){
                        if(p != u){
                            people[u].infected = true;
                            peopleInfected++;
                            System.out.println("day " + daysRan + ", " + peopleInfected + " people infected");
                        }
                    }
                }
            }

            for(int h=0; h<width; h++){
                for(int g=0; g<height; g++){
                    System.out.print(world[h][g] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
            System.out.print("\n");
            daysRan++;
            
        }
        System.out.print("\n");
        System.out.println("day " + daysRan + ", " + peopleInfected + " people infected");
    }
}
