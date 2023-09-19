package Project;

import mayflower.*;

public class NinjaAnimatedActor extends AnimatedActor
{
    private Animation walk; 
    public NinjaAnimatedActor() 
    {
        String[] strings = new String[10];
        for(int i = 0; i < 10; i ++){
            strings[i] = "img/ninjagirl/Throw__00" + i + ".png";
        }
        walk = new Animation(50, strings);
        setAnimation(walk);
        walk.scale(300, 87);
        walk.setTransparency(90);
    }
    public void act()
    {
        super.act();
    }
}
