public class WhipTailv2 {
    String name;
    int length;
    WhipTailv2  Follower;
    public WhipTailv2(){
        name = "anonymous";
    }
    public WhipTailv2(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLength(int len){
        this.length = len;
    }
    public void createFollower(){
        this.Follower = new WhipTailv2();
    }
    public void createFollower(String name){
        this.Follower = new WhipTailv2(name);
    }
    public void setFollower(WhipTailv2 Follower){
        this.Follower = Follower;
    }
}
