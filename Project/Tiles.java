package Project;
import mayflower.*;
public class Tiles extends NoGravityAnimatedActor{

    public Tiles(){
        MayflowerImage img = new MayflowerImage("img/platform.png");
        img.scale(25,25);

        setImage(img);

    }

    public void act(){

    }
    
}
