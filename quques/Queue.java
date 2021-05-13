//@author Luke Weston
//* @version 2.0
public class Queue
{
    private Item head;
    private Item tail;
    public Queue()
    {
        //
        head = null;
        tail = null;

    }

    public void addToQueue(String follower){
        Item ItemToAdd = new Item(follower);
        if(this.head == null){
            this.head = ItemToAdd;
        } else {
            this.tail.setAfterme(ItemToAdd);
        }
        this.tail = ItemToAdd;
        
    }
    public String removeFromQueue(){
        String ItemToRemove = this.head.getName();
        this.head = this.head.getAfterMe();
        if (this.head == null){
            this.tail = null;
        }
        return ItemToRemove;
    }
    public boolean isEmpty(){
        //
        boolean isEmpty = false;
        if(this.head == null){
            isEmpty = true;
        }
        return isEmpty;
    }
}
