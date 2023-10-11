package Project;

import mayflower.*;

public class Ladder extends NoGravityAnimatedActor
{
    private Animation ladder; 

    public Ladder(){
        String[] fullAnimation = new String[1];
        for(int i = 0; i < 1; i++){
            fullAnimation[i] = "img/Objects/stairs_full.png";
        }
        ladder = new Animation(50, fullAnimation);
        setAnimation(ladder);
        ladder.scale(200, 200);
        ladder.setBounds(80,40,40,120);
        
    }
    public void act(){
        super.act();
    }

}
