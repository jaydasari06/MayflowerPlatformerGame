package Project;

import mayflower.*;


public class WinScreen extends World {
    
    public WinScreen() 
    {
        setBackground("img/TitleScreen.jpg");
        Mayflower.showBounds(true);
        showText("You WIN!!!!", 330, 50, Color.WHITE);
        showText("Press enter to restart.", 260, 100, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
            if (Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
                Mayflower.setWorld(w);
            }
    }
}