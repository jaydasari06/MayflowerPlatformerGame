package Project;

import mayflower.*;
public class AnimatedActor extends GravityActor
{
    private Animation animation; 
    private Timer animationTimer;
    public AnimatedActor() 
    {
        animation = null;
        animationTimer = new Timer(99900);
    }
    
    public void setAnimation(Animation a){
        animation = a;
        
    }
    public void act()
    {
        super.act();
        if(animation != null)
        if(animationTimer.isDone()){
            animationTimer.reset();
            MayflowerImage var = animation.getNextFrame();
            setImage(var);
        }
    }
}
