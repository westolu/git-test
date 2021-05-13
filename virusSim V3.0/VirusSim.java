//@author Luke Weston
//* @version 3.0
public class VirusSim {
    int population = 10;
    int width = 20;
    int height = 20;
    boolean running = true;
    String[][] world = new String[width][height];
    public VirusSim(){
        Person[] people = new Person[population];
        for(int i=0; i<population; i++){
            people[i] = new Person(width, height);
        }
        people[1].infected = true;
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                world[i][j] = "0";
            }
        }
        while(running){
            for(int i=0; i<population; i++){
                if (people[i].xPos >= width || people[i].xPos <= 0 || people[i].yPos >= height || people[i].yPos <= 0){
                    running = false;
                }
                if (people[i].direction == 0){
                    if(people[i].xPos + 1 > width){
                        people[i].direction = 2;
                        people[i].xPos++;
                    }else{
                        people[i].xPos--;
                    }
                }
                if(people[i].direction == 1){
                    if(people[i].xPos - 1 < 0){
                        people[i].direction = 0;
                        people[i].xPos--;
                    }else{
                        people[i].xPos--;
                    }
                }
                if (people[i].direction == 2){
                    if(people[i].yPos + 1 > height){
                        people[i].direction = 3;
                        people[i].yPos--;
                    }else{
                        people[i].yPos++;
                    }
                }else if(people[i].direction == 3){
                    if(people[i].yPos - 1 < 0){
                        people[i].direction = 1;
                        people[i].yPos++;
                    }else{
                        people[i].yPos--;
                    }
                }
                if (people[i].xPos >= width || people[i].xPos <= 0 || people[i].yPos >= height || people[i].yPos <= 0){
                    //running = false;
                }
                world[people[i].xPos][people[i].yPos] = "A";
                for(int h=0; h<width; h++){
                    for(int g=0; g<height; g++){
                        System.out.print(world[h][g] + " ");
                    }
                    System.out.print("\n");
                }
                System.out.print("\n");
                System.out.print("\n");
            }
        }
    }
}
