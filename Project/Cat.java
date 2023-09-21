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
    public Cat() 
    {
        score = 0; 
        lives = 3; 
        String[] strings = new String[10];
        String[] strings2 = new String[10];
        String[] walkleft = new String[10];
        String[] idleleft = new String[10];
        String[] fallingright = new String[8];
        String[] fallingleft = new String[8];
        for(int i = 1; i < 11; i ++){
            strings[i-1] = "img/cat/Walk (" + i + ").png";
        }
        for(int i = 1; i < 11; i ++){
            walkleft[i-1] = "img/cat/Walk (" + i + ").png";
        }
        walk = new Animation(50, strings);
        setWalkRightAnimation(walk);
        walk.scale(100, 87);
        walk.setBounds(18, 5, 54, 80);
        
        walkLeft = new Animation(50, walkleft);
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        for(int i = 1; i < 11; i ++){
            strings2[i-1] = "img/cat/Idle (" + i + ").png";
        }
        for(int i = 1; i < 11; i ++){
            idleleft[i-1] = "img/cat/Idle (" + i + ").png";
        }
        idle = new Animation(50, strings2);
        setIdleAnimation(idle);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        idleLeft = new Animation(50, idleleft);
        setIdleLeftAnimation(idleLeft);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(100, 87);
        idleLeft.setBounds(28, 5, 54, 80);
        
        for(int i = 1; i < 9; i ++){
            fallingright[i-1] = "img/cat/Fall (" + i + ").png";
        }
        fallingRight = new Animation(50, fallingright);
        setFallingRightAnimation(fallingRight);
        fallingRight.scale(100, 87);
        fallingRight.setBounds(18, 5, 54, 80);
        
        for(int i = 1; i < 9; i ++){
            fallingleft[i-1] = "img/cat/Fall (" + i + ").png";
        }
        fallingLeft = new Animation(50, fallingleft);
        setFallingLeftAnimation(fallingLeft);
        fallingLeft.mirrorHorizontally();
        fallingLeft.scale(100, 87);
        fallingLeft.setBounds(28, 5, 54, 80);
        
        
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
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
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
