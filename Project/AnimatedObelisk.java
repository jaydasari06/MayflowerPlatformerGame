package Project;

import mayflower.*;

public class AnimatedObelisk extends NoGravityAnimatedActor
{
    private Animation obelisk; 

    public AnimatedObelisk(){
        String[] fullAnimation = new String[14];
        for(int i = 0; i < 14; i++){
            fullAnimation[i] = "img/Obelisk_effects/" + (i < 10 ? "0" + i : i) + "_Obelisk_effects.png";
        }
        obelisk = new Animation(50, fullAnimation);
        setAnimation(obelisk);
        obelisk.scale(200/2, 420/2);
        obelisk.setBounds(20/2, 90/2, 150/2, 320/2);
        
    }
    public void act(){
        super.act();
    }
}
