package Project;

import mayflower.*;


public class TitleScreen extends World {
    
    public TitleScreen() 
    {
        setBackground("img/City.jpg");
        Mayflower.showBounds(true);
        showText("Welcome!", 200, 200, Color.WHITE);
        showText("Press Space to Play: ", 200, 330, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
        if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE)){
            Mayflower.setWorld(w);
        }
    }
}