package Project;

import mayflower.*;


public class TitleScreen extends World {
    
    public TitleScreen() 
    {
        setBackground("img/City.jpg");
        Mayflower.showBounds(true);
        showText("Welcome!", 350, 200, Color.WHITE);
        showText("Press Enter to Play: ", 300, 300, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
            if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
                Mayflower.setWorld(w);
            }
    }
}