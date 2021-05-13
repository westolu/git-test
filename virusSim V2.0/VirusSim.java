//@author Luke Weston
//* @version 2.0
public class VirusSim {
    int population = 10;
    int width = 50;
    int height = 60;
    boolean running = true;
    String[][] world = new String[width][height];
    public VirusSim(){
        Person[] people = new Person[population];
        for(int i=0; i<population; i++){
            people[i] = new Person(width, height);
        }
        people[1].infected = true;
        for(int i=1; i<width; i++){
            for(int j=1; j<height; j++){
                world[i][j] = " ";
            }
        }
        while(running){
            for(int i=0; i<population; i++){
                if (people[i].xPos >= width || people[i].xPos <= 0 || people[i].yPos >= height || people[i].yPos <= 0){
                    running = false;
                }
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
                world[people[i].xPos][people[i].yPos] = "O";
                for(int h=0; h<width; h++){
                    for(int g=0; g<height; g++){
                        System.out.println(world[h][g]);
                    }
                }
            }
        }
    }
}
