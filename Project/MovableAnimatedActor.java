package Project;

import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor {
    private Animation walkRight;
    private Animation idle;
    private String currentAction;
    private Animation walkLeft;
    private String direction;
    private Animation idleLeft;
    private Animation fallingRight;
    private Animation fallingLeft;
    private Animation jumpingRight; 
    private Animation jumpingLeft; 
    private Animation attackRight; 
    private Animation attackLeft; 
    private boolean jumpReady; 

    public MovableAnimatedActor() {
        direction = "right";
    }

    public void setWalkRightAnimation(Animation ani) {
        walkRight = ani;
    }

    public void setWalkLeftAnimation(Animation ani) {
        walkLeft = ani;
    }

    public void setIdleAnimation(Animation ani) {
        idle = ani;
    }

    public void setIdleLeftAnimation(Animation ani) {
        idleLeft = ani;
    }

    public void setFallingRightAnimation(Animation ani) {
        fallingRight = ani;
    }

    public void setFallingLeftAnimation(Animation ani) {
        fallingLeft = ani;
    }

    public void setJumpingRightAnimation(Animation ani) {
        jumpingRight = ani;
    }

    public void setJumpingLeftAnimation(Animation ani) {
        jumpingLeft = ani;
    }

    public void setAttackLeftAnimation(Animation ani) {
        attackLeft = ani;
    }

    public void setAttackRightAnimation(Animation ani) {
        attackRight = ani;
    }



    public void act() {
        super.act();
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        int xmax = 800 - w;
        int ymax = 600 - h;
        String newAction = "null";
        
        boolean isFalling = this.isFalling();
    
        if (currentAction == null) {
            newAction = "idle";
        }
    
        if(!this.isBlocked() && !isFalling)
        {
            jumpReady = true; 
        }
        else if (this.isBlocked() || isFalling) {
            jumpReady = false; 
        }
        /*if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && y < 456 && jumpReady)
        {
            direction = "right";
            if (!isFalling) {
                newAction = "jumpingRight";
            } else {
                newAction = "fallingRight";
            }
            this.charJump();
            if(this.isTouching(Block.class)){
                setLocation(x + 20, y - 20); 
            }
            jumpReady = false; 
        } else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && y < 456 && jumpReady){
            direction = "left";
            if (!isFalling) {
                newAction = "jumpingLeft";
            } else {
                newAction = "fallingLeft";
            }
            this.charJump();
            if(this.isTouching(Block.class)){
                setLocation(x - 20, y - 20); 
            }
            jumpReady = false; 
        }*/
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT)) {
            direction = "right";
            if (x < xmax) {
                setLocation(x + 1, y);
            }
            if (!isFalling) {
                newAction = "walkRight";
            } else {
                newAction = "fallingRight";
            }
    
            if (this.isTouching(Block.class)) {
                setLocation(x - 1, y);
            }
        } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT)) {
            direction = "left";
            if (x > 0) {
                setLocation(x - 1, y);
            }
            if (!isFalling) {
                newAction = "walkLeft";
            } else {
                newAction = "fallingLeft";
            }
    
            if (this.isTouching(Block.class)) {
                setLocation(x + 1, y);
            }
        } else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && jumpReady){
            if(direction == "left"){
                newAction = "jumpingLeft";
            }
            else{
                newAction = "jumpingRight";
            }
            this.charJump();
            if(this.isTouching(Block.class)){
                setLocation(x, y - 20); 
            }
            jumpReady = false; 
        } else if(Mayflower.isKeyDown(Keyboard.KEY_Z)){
            if(direction == "left"){
                newAction = "attackLeft";
            }
            else{
                newAction = "attackRight";
            }
        } else if (isFalling && direction.equals("left")) {
            newAction = "fallingLeft";
        } /*else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            if (y < ymax) {
                setLocation(x, y + 1);
            }
            if (this.isTouching(Block.class)) {
                setLocation(x, y - 1);
            }
        } */else {
            newAction = "idle";
            if (direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            } else if (isFalling) {
                if (direction != null && direction.equals("right")) {
                    newAction = "fallingRight";
                }
                if (direction != null && direction.equals("left")) {
                    newAction = "fallingLeft";
                }
            }
        }
        if (!newAction.equals(currentAction) && newAction != null) {
            if(newAction.equals("fallingRight")){
                    setAnimation(fallingRight);
                }
            if(newAction.equals("fallingLeft")){
                    setAnimation(fallingLeft);
                }
            if(newAction.equals("idle")){
                    setAnimation(idle);
                }
            if(newAction.equals("idleLeft")){
                    setAnimation(idleLeft);
                }
            if(newAction.equals("walkRight")){
                    setAnimation(walkRight);
                }
            if(newAction.equals("walkLeft")){
                    setAnimation(walkLeft);
                }
            if(newAction.equals("jumpingRight")){
                    setAnimation(jumpingRight);
            }
            if(newAction.equals("jumpingLeft")){
                    setAnimation(jumpingLeft);
            }
            if(newAction.equals("attackRight")){
                    setAnimation(attackRight);
            }
            if(newAction.equals("attackLeft")){
                    setAnimation(attackLeft);
            }
            currentAction = newAction;  
        }
    }

    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
}
