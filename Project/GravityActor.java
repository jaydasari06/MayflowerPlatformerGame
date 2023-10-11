package Project;

import mayflower.*;

public class GravityActor extends Actor
{
    private boolean isJumping;
    private boolean isGravity;  // New instance variable
    private int y;
    private int strength;

    public GravityActor(){
        strength = 0;
        isGravity = true;  // Default to true, gravity is active
    }

    public void act(){
        if(isGravity){  // Only apply gravity features if isGravity is true
            setLocation(getX(),getY() + 1);
            if(isBlocked())
                setLocation(getX(),getY() - 1);
            if(isJumping){
                setLocation(getX(),getY()-(10-strength/5));
                strength++;
                if(isBlocked()){
                    isJumping = false;
                    setLocation(getX(),getY() - 10);
                    strength = 0;
                }
                //System.out.println(y + " " + getY());
            }
        }
    }
    
    public boolean isBlocked(){
        return isTouching(Floor.class);
    }
    
    public boolean isFalling()
    {
        boolean ret;
        setLocation(getX(), getY() + 3);
        ret = isTouching(Floor.class);
        setLocation(getX(), getY() - 3);
        return !ret;
    }
    
    public void charJump(){
        y = getY();
        setLocation(getX(), getY() + 1);
        if(isBlocked())
            isJumping = true;
    }

    public void setIsGravity(boolean s){  // New setter method
        isGravity = s;
    }
}
