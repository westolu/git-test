//@author Luke Weston
//* @version 1.0
public class Item
{
    // instance variables - replace the example below with your own
    
    private String thingInMe;
    private Item afterMe;
    
    public Item(String name)
    {
        //
        this.thingInMe = name;
        afterMe = null;
    }
    public Item getAfterMe(){
        //
        return afterMe;
    }
    public void setAfterme(Item toPutAfter){
        //
        afterMe = toPutAfter;
    }
    public String getName(){
        //
        return this.thingInMe;
    }
    
}
