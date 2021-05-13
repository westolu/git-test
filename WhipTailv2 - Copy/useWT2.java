public class useWT2
{
    WhipTailv2 numberOne;
    public useWT2()
    {
        //First create a Whiptail for us to work with.
        numberOne=new WhipTailv2("Doris"); 
        // now add in her Follower. 
        numberOne.createFollower("Eliza"); 
        // NB we left the Follower variable public in the class, so we // can manipulate it directly. We really should provide a method // to return who a Follower is, but for the moment, this is convenient.
        // We can now create a grandFollower.. 
        numberOne.Follower.createFollower("Geraldine"); 
        // and a Great GrandFollower 
        numberOne.Follower.Follower.createFollower("Hermione");
        numberOne.Follower.Follower.Follower.createFollower("luke :D"); 
        WhipTailv2 current = numberOne;
        while(current.Follower != null){
            System.out.println(current.name);
            current=current.Follower;
        }
        System.out.println(current.name);
    }
}
