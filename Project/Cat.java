package Project;

import mayflower.*;

public class Cat extends MovableAnimatedActor
{

    private int score;
    private int lives; 
    private Animation walk; 
    private Animation walkLeft;
    private Animation idleLeft;
    private Animation idle;
    private Animation fallingRight;
    private Animation fallingLeft;
    private Animation jumpingRight; 
    private Animation jumpingLeft; 

    public Cat() 
    {
        score = 0; 
        lives = 3; 
        String[] strings = new String[8];
        String[] strings2 = new String[8];
        String[] walkleft = new String[8];
        String[] idleleft = new String[8];
        String[] fallingright = new String[2];
        String[] fallingleft = new String[2];
        String[] jumpingright = new String[2];
        String[] jumpingleft = new String[2];
        for(int i = 0; i < 8; i ++){
            strings[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        for(int i = 0; i < 8; i ++){
            walkleft[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        walk = new Animation(50, strings);
        setWalkRightAnimation(walk);
        walk.scale(100, 86);
        walk.setBounds(18, 5, 54, 76);
        
        walkLeft = new Animation(50, walkleft);
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(100, 86);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 76);
        for(int i = 0; i < 8; i ++){
            strings2[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        for(int i = 0; i < 8; i ++){
            idleleft[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        idle = new Animation(50, strings2);
        setIdleAnimation(idle);
        idle.scale(100, 86);
        idle.setBounds(18, 5, 54, 76);
        idleLeft = new Animation(50, idleleft);
        setIdleLeftAnimation(idleLeft);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(100, 86);
        idleLeft.setBounds(28, 5, 54, 76);
        
        for(int i = 0; i < 2; i ++){
            fallingright[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingRight = new Animation(50, fallingright);
        setFallingRightAnimation(fallingRight);
        fallingRight.scale(100, 86);
        fallingRight.setBounds(18, 5, 54, 76);
        
        for(int i = 0; i < 2; i ++){
            fallingleft[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingLeft = new Animation(50, fallingleft);
        setFallingLeftAnimation(fallingLeft);
        fallingLeft.mirrorHorizontally();
        fallingLeft.scale(100, 86);
        fallingLeft.setBounds(28, 5, 54, 76);

        
         for(int i = 0; i < 2; i ++){
            jumpingright[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingRight = new Animation(50, jumpingright);
        setJumpingRightAnimation(fallingRight);
        jumpingRight.scale(100, 86);
        jumpingRight.setBounds(18, 5, 54, 80);
        
        for(int i = 0; i < 2; i ++){
            jumpingleft[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingLeft = new Animation(50, jumpingleft);
        setJumpingLeftAnimation(jumpingLeft);
        jumpingLeft.mirrorHorizontally();
        jumpingLeft.scale(100, 86);
        jumpingLeft.setBounds(28, 5, 54, 80);
        
        
        
    }
    public void act()
    {
        super.act();
        setPosition();
    }

    public void increaseScore( int amount )
    {
        score += amount; 
        updateText();
    }

    public int getScore()
    {
        return score; 
    }

    public int getLives()
    {
        return lives; 
    }

    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.WHITE);
    }

    public void setPosition()
    {
        if(isTouching(DogAnimatedActor.class))
        {
            lives--; 
            updateText();
            setLocation(400, 300);
            if(lives == 0)
            {
                World w = getWorld();
                w.removeObject(this);
            }
        }
    }


}