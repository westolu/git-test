//@author Luke Weston
//* @version 2.0
public class AccessQueue
{
    Queue queueTest;

    public AccessQueue()
    {
        // initialise instance variables

        queueTest = new Queue();
        queueTest.addToQueue("bob");
        queueTest.addToQueue("dod");
        queueTest.addToQueue("oob");
        queueTest.addToQueue("ryan");
        
        while(!queueTest.isEmpty()){
            String ItemRemoved = queueTest.removeFromQueue();
            System.out.println(ItemRemoved);
        }
        System.out.println("no more Items in queue");
        
    }
}
