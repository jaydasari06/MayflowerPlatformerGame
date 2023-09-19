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
    
        if (this.isBlocked()) {
            setLocation(x + 1, y);
        }
    
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
        } else if (isFalling && direction.equals("left")) {
            newAction = "fallingLeft";
        } else if (Mayflower.isKeyDown(Keyboard.KEY_UP)) {
            if (y > 0) {
                setLocation(x, y - 1);
            }
            if (this.isTouching(Block.class)) {
                setLocation(x, y + 1);
            }
        } else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN)) {
            if (y < ymax) {
                setLocation(x, y + 1);
            }
            if (this.isTouching(Block.class)) {
                setLocation(x, y - 1);
            }
        } else {
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
                
            currentAction = newAction;  
        }
    }

    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
}
