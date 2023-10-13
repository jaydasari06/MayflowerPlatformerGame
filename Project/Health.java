package Project;

import mayflower.*;

public class Health extends Actor
{
    public Health(){
        MayflowerImage img = new MayflowerImage("img/Potions/Icon1.png");
        img.scale(0.61);
        setImage(img);
    }

    public void act()
    {
        if(this.isTouching(King.class)){
            getWorld().removeObject(this);
        }
    }
}
