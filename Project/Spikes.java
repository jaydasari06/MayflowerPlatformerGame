package Project;
import mayflower.*;
public class Spikes extends NoGravityAnimatedActor{

    public Spikes(){
        MayflowerImage img = new MayflowerImage("img/Tiles/tile39.png");
        img.scale(25,25);
        img.crop(0,17,25,8);
        setImage(img);

    }

    public void act(){

    }
    
}