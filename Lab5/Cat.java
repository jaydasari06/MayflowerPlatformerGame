package Lab5;

public class Cat extends AnimatedActor
{
    private Animation walk; 
    public Cat() 
    {
        String[] strings = new String[10];
        for(int i = 1; i < 11; i ++){
            strings[i-1] = "img/cat/Walk (" + i + ").png";
        }
        walk = new Animation(50, strings);
        setAnimation(walk);
        walk.scale(100, 100);
        walk.setTransparency(80);
    }
    public void act()
    {
        super.act();
    }
}
