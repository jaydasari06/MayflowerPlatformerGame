package Project;

import mayflower.*;
public class GravityActor extends Actor
{

    private boolean isJumping; 
    private int jumpStrength; 
    private int jumpDistance;
    private int GravityDistance; 

    public GravityActor()
    {
        jumpStrength = -15;
        jumpDistance = 200 - (jumpStrength/50); 
        GravityDistance = 5 + (jumpStrength/50);
    }
    public boolean isBlocked()
    {
        return this.isTouching(Block.class);
    }

    public boolean isFalling()
    {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }

    public void act()
    {
    
        if(!isJumping)
        {
            setLocation(getX(), getY() + GravityDistance);
            jumpStrength++; 
            if(isBlocked()){
                setLocation(getX(), getY() - GravityDistance);
            }
            jumpStrength = 0; 
        }
        if(isJumping)
        {
            while(jumpDistance != 0 && !isBlocked())
            {
                setLocation(getX(), getY() - jumpDistance);
                jumpStrength++; 
            }
            jumpStrength = 0;
            if(isBlocked())
            {
                isJumping = false; 
            }
        }
        else if(isBlocked() && !isFalling() && isJumping)
        {
            setLocation(getX(), getY() + 1);
        }
        
    }

    public void charJump()
    {
        setLocation(getX(), getY() - jumpDistance);
        if(isBlocked())
        {
            isJumping = true; 
        }
    }

}
