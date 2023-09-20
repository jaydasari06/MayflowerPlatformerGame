package Lab5;

import mayflower.*;
public class AnimatedActor extends Actor
{
    private Animation animation; 
    private Timer animationTimer;
    public AnimatedActor() 
    {
        animation = null;
        animationTimer = new Timer(100000);
    }
    
    public void setAnimation(Animation a){
        animation = a;
        
    }
    public void act()
    {
        if(animation != null)
        if(animationTimer.isDone()){
            animationTimer.reset();
            MayflowerImage var = animation.getNextFrame();
            setImage(var);
        }
    }
}
