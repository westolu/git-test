
//@author Luke Weston
//* @version 6.0
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class VirusSim {
    Scanner input = new Scanner(System.in);
    public VirusSim() throws Exception{
        System.out.println("enter population");
        int population = input.nextInt();
        System.out.println("enter width of world");
        int width = input.nextInt();
        System.out.println("enter height of world");
        int height = input.nextInt();
        System.out.println("enter days to run");
        int daysToRun = input.nextInt();
        System.out.println("enter number of people to start as infected");
        int peopleStartingInfected = input.nextInt();
        String[][] world = new String[width][height];
        File file = new File ("output.txt");
        System.out.println("enter how many times to repeat");
        int timesToRepeat = input.nextInt();
        
        FileWriter writer = new FileWriter(file);
        for(int y=0; y<timesToRepeat; y++){
            int peopleInfected = 1;
            Person[] people = new Person[population];
            for(int i=0; i<population; i++){
                people[i] = new Person(width, height-1);
            }
            for(int q=0; q<peopleStartingInfected; q++){
                people[1].infected = true;
            }
            
            int daysRan = 0;
            while(daysRan < daysToRun){
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
                                //System.out.println("day " + daysRan + ", " + peopleInfected + " people infected");
                            }
                        }
                    }
                }

                // for(int h=0; h<width; h++){
                // for(int g=0; g<height; g++){
                // System.out.print(world[h][g] + " ");
                // }
                // System.out.print("\n");
                // }
                // System.out.print("\n");
                // System.out.print("\n");
                daysRan++;

            }
            System.out.print("\n");
            System.out.println("day " + daysRan + ", " + peopleInfected + " people infected");
            writer.write("daysRan peopleInfected daysRan/peopleInfected" + "\n");
            writer.write(daysRan + " " + peopleInfected + " " + daysRan/peopleInfected + "\n");
        }
        writer.flush();
        writer.close();
    }
}