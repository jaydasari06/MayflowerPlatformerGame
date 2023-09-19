package Project;

public class JackAnimatedActor extends AnimatedActor
{
    private Animation walk; 
    public JackAnimatedActor() 
    {
        String[] strings = new String[10];
        for(int i = 1; i < 11; i ++){
            strings[i-1] = "img/jack/Slide (" + i + ").png";
        }
        walk = new Animation(50, strings);
        setAnimation(walk);
        walk.scale(150, 87);
        walk.setTransparency(70);
    }
    public void act()
    {
        super.act();
    }
}