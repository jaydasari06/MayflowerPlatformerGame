package Project;

public class Enemy extends AnimatedActor
{
    private Animation attackingAndIdling; 
    public Enemy() 
    {
        String[] fullAnimation = new String[25];
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
        // System.out.print("START");
        // for(int k = 0; k<33; k++){
        //     System.out.print(fullAnimation[k] != null ? fullAnimation[k].substring(0,4) : "NONE" + "****");
        // }
        
    }
    public void act()
    {
        super.act();
    }
}