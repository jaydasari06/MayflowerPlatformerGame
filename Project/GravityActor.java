package Project;

import mayflower.*;
public class GravityActor extends Actor
{
    public GravityActor()
    {
        
    }
    public boolean isBlocked(){
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
    public void act(){
        setLocation(getX(), getY() + 1);
        if(isBlocked()){
            setLocation(getX(), getY() - 1);
        }
        
    }

}
