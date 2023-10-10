package Project;

import mayflower.*;


public class TitleScreen extends World {
    
    public TitleScreen() 
    {
        setBackground("img/TitleScreen.jpg");
        Mayflower.showBounds(true);
        showText("Welcome!", 330, 50, Color.WHITE);
        showText("Press Enter to Play: ", 260, 100, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
            if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
                Mayflower.setWorld(w);
            }
    }
}