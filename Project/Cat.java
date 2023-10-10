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
    private Animation attackRight; 
    private Animation attackLeft; 

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
        int yBox = 82;
        int height = 80;
        int xBox = 70;
        int width = 60;
        String[] attackright = new String[4];
        String[] attackleft = new String[4];
        for(int i = 0; i < 8; i ++){
            strings[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        for(int i = 0; i < 8; i ++){
            walkleft[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        walk = new Animation(10, strings);
        setWalkRightAnimation(walk);
        walk.scale(200, 172);
        walk.setBounds(xBox, yBox, width, height);
        
        walkLeft = new Animation(10, walkleft);
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(200, 172);
        walkLeft.scale(200, 172);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 8; i ++){
            strings2[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        for(int i = 0; i < 8; i ++){
            idleleft[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        idle = new Animation(10, strings2);
        setIdleAnimation(idle);
        idle.scale(200, 172);
        idle.setBounds(xBox, yBox, width, height);
        idleLeft = new Animation(10, idleleft);
        setIdleLeftAnimation(idleLeft);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(200, 172);
        idleLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 2; i ++){
            fallingright[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingRight = new Animation(10, fallingright);
        setFallingRightAnimation(fallingRight);
        fallingRight.scale(200, 172);
        fallingRight.setBounds(xBox, yBox, width, height);
        
        for(int i = 0; i < 2; i ++){
            fallingleft[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingLeft = new Animation(10, fallingleft);
        setFallingLeftAnimation(fallingLeft);
        fallingLeft.mirrorHorizontally();
        fallingLeft.scale(200, 172);
        fallingLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 2; i ++){
            jumpingright[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingRight = new Animation(10, jumpingright);
        setJumpingRightAnimation(jumpingRight);
        jumpingRight.scale(200, 172);
        jumpingRight.setBounds(xBox, yBox, width, height + 5);
        
        for(int i = 0; i < 2; i ++){
            jumpingleft[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingLeft = new Animation(10, jumpingleft);
        setJumpingLeftAnimation(jumpingLeft);
        jumpingLeft.mirrorHorizontally();
        jumpingLeft.scale(200, 172);
        jumpingLeft.setBounds(xBox,yBox, width, height + 5);
        
        for(int i = 0; i < 4; i ++){
            attackright[i] = "img/Medival King/Attack1/0" + i + "_Attack1.png";
        }
        attackRight = new Animation(1, attackright);
        setAttackRightAnimation(attackRight);
        attackRight.scale(200, 172);
        attackRight.setBounds(xBox, yBox, width + 50, height);
        
        for(int i = 0; i < 4; i ++){
            attackleft[i] = "img/Medival King/Attack1/0" + i + "_Attack1.png";
        }
        attackLeft = new Animation(1, attackleft);
        setAttackLeftAnimation(attackLeft);
        attackLeft.mirrorHorizontally();
        attackLeft.scale(200, 172);
        attackLeft.setBounds(xBox, yBox, width + 50, height);
        
        
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