package Project;

import mayflower.*;


public class TitleScreen extends World {
    
    public TitleScreen() 
    {
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
    }
    
    public void act()
    {
        World w = new MyWorld();
        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE)){
           Mayflower.setWorld(w);
        }
    }
    
}