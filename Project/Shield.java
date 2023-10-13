package Project;
import mayflower.*;

public class Shield extends Actor{
    public Shield(){
        MayflowerImage img = new MayflowerImage("img/ShieldsAndAmulets/Icon29.png");
        img.scale(0.61);
        setImage(img);
    }

    public void act(){
        if(this.isTouching(King.class)){
            getWorld().removeObject(this);

        }

    }
    
}
