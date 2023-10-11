package Project;

import mayflower.*;
public class AnimatedActor extends GravityActor
{
    private Animation animation; 
    private Timer animationTimer;
    private boolean isAttacking;
    public AnimatedActor() 
    {
        animation = null;
        isAttacking = false;
        animationTimer = new Timer(77000000);
    }
    
    public void setAnimation(Animation a){
        animation = a;
        
    }
    
   

    public void setIsAttacking(boolean x){
        isAttacking = x;
    }

    public boolean getIsAttacking(){
        return isAttacking;
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
