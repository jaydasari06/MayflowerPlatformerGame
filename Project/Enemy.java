package Project;

import mayflower.World;

public class Enemy extends AnimatedActor
{
    private Animation attackingAndIdling; 
    private int lives;
    private String direction = "right";
    private int ogX;
    private Animation deathAnimation;

    public Enemy() 
    {
        ogX = getX();
        String[] fullAnimation = new String[25];
        String[] deathAnimationList = new String[20];
        // for(int i = 0; i < 4; i ++){
        //     strings[i] = "img/Enemy/idle/0" + i + "_idle.png";
        // }
        // // idle = new Animation(50, strings);
        // // setAnimation(idle);
        // // idle.scale(150, 150);
        // // idle.setBounds(45, 30, 80, 90);

        // for(int i = 0; i < 13; i ++){
        //     strings2[i] = "img/Enemy/attacking/" + (i < 10 ? "0" + i : i) +  "_attacking.png";
        // }
        // attacking = new Animation(50, strings2);
        // setAnimation(attacking);
        // attacking.scale(150, 150);
        // attacking.setBounds(45, 30, 80, 90);

        int i = 0; 
        while(i < 25){
            if(i < 12){
                for(int j = 0; j < 4; j++){
                    fullAnimation[i+j] = "img/Enemy/idle/0" + j + "_idle.png";
                }
                i+=4;
            }
            if(i >= 12){
                for(int j = 0; j < 13; j++){
                    fullAnimation[i+j] = "img/Enemy/attacking/" + (j < 10 ? "0" + j : j) +  "_attacking.png";
                }
                i+=13;
            }
        }
        attackingAndIdling = new Animation(50, fullAnimation);
        setAnimation(attackingAndIdling);
        attackingAndIdling.scale(150, 150);
        attackingAndIdling.setBounds(45, 30, 80, 90);

        for(int k = 0; k < 20; k ++){
            deathAnimationList[k] = "img/Enemy/death/" + (k<10 ? "0" + k : k) + "_death.png";
        }
        deathAnimation = new Animation(50, deathAnimationList);
        deathAnimation.scale(150, 150);
        deathAnimation.setBounds(45, 30, 80, 90);
        
    }
    public void act()
    {
        super.act();
        checkAttacked();
        if(direction.equals("right")){
            setLocation(getX()+5, getY());
        } else {
            setLocation(getX()-5, getY());
        }

        if(getX() > ogX + 100 || getX() < ogX - 100){
            if(direction.equals("right")){
                direction = "left";
            } else {
                direction = "right";
            }
        }
    }
    public void checkAttacked(){
        // System.out.print(lives);
        if(isTouching(King.class)){
            
            // lives--; 
            // if(lives == 0){
            //     World w = getWorld();
            //     w.removeObject(this);
            // }
            World w = getWorld();
            w.removeObject(this);
        }
        
        
    }
}