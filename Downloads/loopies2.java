//AUTHOR: LUKE WESTON
public class loops2
{
    
    int counter=0;
    boolean finished=false; 
    public loopies2()
    {
      while(!finished){
        if(counter % 5 == 0){System.out.println(counter);}   
        counter++;
     
        if(counter>100)
           finished = true;
      }
    }

 
    }

