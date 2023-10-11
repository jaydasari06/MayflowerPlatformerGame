package Project;

import mayflower.*;

public class King extends MovableAnimatedActor
{

    private int score;
    private int lives; 
    private boolean isAttacking;
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
    private Animation climbingRight;
    private Animation attackRight2; 
    private Animation attackLeft2;
    private Animation attackRight3; 
    private Animation attackLeft3;

    public King() 
    {
        score = 0; 
        lives = 3; 
        isAttacking = false;
        String[] strings = new String[8];
        String[] strings2 = new String[8];
        String[] walkleft = new String[8];
        String[] idleleft = new String[8];
        String[] fallingright = new String[2];
        String[] fallingleft = new String[2];
        String[] jumpingright = new String[2];
        String[] climbingright = new String[2];
        String[] jumpingleft = new String[2];
        String[] attackright = new String[4];
        String[] attackleft = new String[4];
        String[] attackright2 = new String[4];
        String[] attackleft2 = new String[4];
        String[] attackright3 = new String[4];
        String[] attackleft3 = new String[4];
        int yBox = 82;
        int height = 80;
        int xBox = 70;
        int width = 55;
        int frame = 1000; 
        for(int i = 0; i < 8; i ++){
            strings[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        for(int i = 0; i < 8; i ++){
            walkleft[i] = "img/Medival King/Run/0" + i + "_Run.png";
        }
        walk = new Animation(frame, strings);
        setWalkRightAnimation(walk);
        walk.scale(200, 172);
        walk.setBounds(xBox, yBox, width, height);
        
        walkLeft = new Animation(frame, walkleft);
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(200, 172);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 8; i ++){
            strings2[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        for(int i = 0; i < 8; i ++){
            idleleft[i] = "img/Medival King/Idle/0" + i + "_Idle.png";
        }
        idle = new Animation(frame, strings2);
        setIdleAnimation(idle);
        idle.scale(200, 172);
        idle.setBounds(xBox, yBox, width, height);
        idleLeft = new Animation(frame, idleleft);
        setIdleLeftAnimation(idleLeft);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(200, 172);
        idleLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 2; i ++){
            fallingright[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingRight = new Animation(frame, fallingright);
        setFallingRightAnimation(fallingRight);
        fallingRight.scale(200, 172);
        fallingRight.setBounds(xBox, yBox, width, height);
        
        for(int i = 0; i < 2; i ++){
            fallingleft[i] = "img/Medival King/Fall/0" + i + "_Fall.png";
        }
        fallingLeft = new Animation(frame, fallingleft);
        setFallingLeftAnimation(fallingLeft);
        fallingLeft.mirrorHorizontally();
        fallingLeft.scale(200, 172);
        fallingLeft.setBounds(xBox, yBox, width, height);

        for(int i = 0; i < 2; i ++){
            jumpingright[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingRight = new Animation(frame, jumpingright);
        setJumpingRightAnimation(jumpingRight);
        jumpingRight.scale(200, 172);
        jumpingRight.setBounds(xBox, yBox, width, height + 5);
        
        for(int i = 0; i < 2; i ++){
            jumpingleft[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        jumpingLeft = new Animation(frame, jumpingleft);
        setJumpingLeftAnimation(jumpingLeft);
        jumpingLeft.mirrorHorizontally();
        jumpingLeft.scale(200, 172);
        jumpingLeft.setBounds(xBox,yBox, width, height + 5);
        
        for(int i = 0; i < 4; i ++){
            attackright[i] = "img/Medival King/Attack1/0" + i + "_Attack1.png";
        }
        attackRight = new Animation(frame, attackright);
        setAttackRightAnimation(attackRight);
        attackRight.scale(200, 172);
        attackRight.setBounds(xBox, yBox, width + 65, height);
        
        for(int i = 0; i < 4; i ++){
            attackleft[i] = "img/Medival King/Attack1/0" + i + "_Attack1.png";
        }
        attackLeft = new Animation(frame, attackleft);
        setAttackLeftAnimation(attackLeft);
        attackLeft.mirrorHorizontally();
        attackLeft.scale(200, 172);
        attackLeft.setBounds(xBox - 65, yBox, width + 65, height);

        for(int i = 0; i < 2; i ++){
            climbingright[i] = "img/Medival King/Jump/0" + i + "_Jump.png";
        }
        climbingRight = new Animation(frame, climbingright);
        setJumpingRightAnimation(jumpingRight);
        climbingRight.scale(200, 172);
        climbingRight.setBounds(xBox, yBox, width, height + 5);

        /* 
        for(int i = 0; i < 4; i ++){
            attackright2[i] = "img/Medival King/Attack2/0" + i + "_Attack2.png";
        }
        attackRight2 = new Animation(frame, attackright2);
        setAttackRight2Animation(attackRight2);
        attackRight.scale(200, 172);
        attackRight.setBounds(xBox, yBox, width + 65, height);
        
        for(int i = 0; i < 4; i ++){
            attackleft2[i] = "img/Medival King/Attack2/0" + i + "_Attack2.png";
        }
        attackLeft2 = new Animation(frame, attackleft2);
        setAttackLeftAnimation(attackLeft2);
        attackLeft.mirrorHorizontally();
        attackLeft.scale(200, 172);
        attackLeft.setBounds(xBox-65, yBox, width + 65, height);

        for(int i = 0; i < 4; i ++){
            attackright[i] = "img/Medival King/Attack3/0" + i + "_Attack3.png";
        }
        attackRight3 = new Animation(frame, attackright3);
        setAttackRight3Animation(attackRight3);
        attackRight.scale(200, 172);
        attackRight.setBounds(xBox, yBox, width + 65, height);
        
        for(int i = 0; i < 4; i ++){
            attackleft3[i] = "img/Medival King/Attack3/0" + i + "_Attack3.png";
        }
        attackLeft3 = new Animation(frame, attackleft3);
        setAttackLeft3Animation(attackLeft3);
        attackLeft.mirrorHorizontally();
        attackLeft.scale(200, 172);
        attackLeft.setBounds(xBox-65, yBox, width + 65, height);
        */
    }

    public void act()
    {
        super.act();
        
        if(super.getAnimation().equals("attackLeft") || super.getAnimation().equals("attackRight")){
            super.setAttackingBool(true);
        } else {
            super.setAttackingBool(false);
        }
        setPosition();
        pickUpHealth();
        pickUpShield();
    }

    public boolean isTouchingObelisk(){
        if(this.isTouching(AnimatedObelisk.class)){
            return true;
        }
        return false;
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

    public void addLives(){
        lives+=1; 
        updateText();
    }

    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.WHITE);
    }

    public void setPosition()
    {
        if(isTouching(Enemy.class))
        {
            
            
            if(!getAttackingBool()){
                lives--;
                if(super.getAnimation().equals("fallingRight") || super.getAnimation().equals("fallingLeft"))
                {
                    setLocation(0, 449);
                }
                else
                {
                    setLocation(0,450);
                }
            }
            updateText();
            if(lives == 0)
            {
                World w = new LoseScreen();
                Mayflower.setWorld(w);
            }
        }
    }

    public void pickUpHealth(){
        if(this.isTouching(Health.class)){
            addLives();
        }
    }

    public void pickUpShield(){
        if(this.isTouching(Shield.class)){
            increaseScore(1);
        }
        
    }


}