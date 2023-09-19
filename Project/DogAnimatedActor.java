package Project;

import mayflower.*;

public class DogAnimatedActor extends AnimatedActor
{
    private Animation walk; 
    public DogAnimatedActor() 
    {
        String[] strings = new String[10];
        for(int i = 1; i < 11; i ++){
            strings[i-1] = "img/dog/Idle (" + i + ").png";
        }
        walk = new Animation(50, strings);
        setAnimation(walk);
        walk.scale(100, 100);
        walk.setTransparency(30);
    }
    public void act()
    {
        super.act();
    }
}