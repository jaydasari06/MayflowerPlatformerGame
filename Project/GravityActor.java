package Project;

import mayflower.*;
public class GravityActor extends Actor
{
    private boolean isJumping;
    private int y;
    private int power;
    public GravityActor(){
        int power = 0;
    }
    public void act(){
        //this is whats messing with the block clipping/jumping stuff
        setLocation(getX(),getY()+ 1);
        if(isBlocked())
            setLocation(getX(),getY()-1);
        if(isJumping){
            setLocation(getX(),getY()-(10-power/4));
            power++;
            if(isBlocked()){
                isJumping = false;
                setLocation(getX(),getY()-10);
                power = 0;
            }
            System.out.println(y + " " + getY());
        }
    }
    public boolean isBlocked(){
        return isTouching(Block.class);
    }
    public boolean isFalling()
    {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }
    public void charJump(){
        y = getY();
        setLocation(getX(), getY() + 1);
        if(isBlocked())
            isJumping = true;
    }
}