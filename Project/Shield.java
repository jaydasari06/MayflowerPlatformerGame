package Project;
import mayflower.*;

public class Shield extends Actor{
    public Shield(){
        MayflowerImage img = new MayflowerImage("img/ShieldsAndAmulets/Icon29.png");
        setImage(img);
    }

    public void act(){
        if(this.isTouching(King.class)){
            getWorld().removeObject(this);

        }

    }
    
}
