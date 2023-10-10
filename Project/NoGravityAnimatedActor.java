package Project;

import mayflower.*;
public class NoGravityAnimatedActor extends Actor
{
    private Animation animation; 
    private Timer animationTimer;
    public NoGravityAnimatedActor() 
    {
        animation = null;
        animationTimer = new Timer(100000000);
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
