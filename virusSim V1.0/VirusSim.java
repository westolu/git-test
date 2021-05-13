//@author Luke Weston
//* @version 1.0
public class VirusSim {
    int population = 10;
    int width = 50;
    int height = 50;
    boolean running = true;
    String world[][];
    public VirusSim(){
        Person[] people = new Person[population];
        for(int i=0; i<population; i++){
            people[i] = new Person(height, width);
            System.out.println(people[i].yPos);
        }
        people[1].infected = true;
        while(running){
            for(int i=0; i<population; i++){
                if (people[i].direction == 0){
                    people[i].xPos++;
                }else if(people[i].direction == 2){
                    people[i].xPos--;
                }
                if (people[i].direction == 1){
                    people[i].yPos++;
                }else if(people[i].direction == 3){
                    people[i].yPos--;
                }
                if (people[i].xPos >= width || people[i].yPos >= height){
                    running = false;
                }
                System.out.println(people[i].xPos);
                System.out.println(people[i].yPos);
            }
        }
    }
}
