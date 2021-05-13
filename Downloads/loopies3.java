//AUTHOR: LUKE WESTON
public class loops3
{
    int another=0;
    int counter=0;
    boolean finished=false; 
    public loopies3()
    {
      while(!finished){
        if(counter % 27 == 0){System.out.println(counter); another++; }   
        counter++;
        
        if(another>3)
           finished = true;
        if(counter>100)
           finished = true;
      }
    }

 
    }
