package Project;

import mayflower.*;


public class LoseScreen extends World {
    
    public LoseScreen() 
    {
        setBackground("img/TitleScreen.jpg");
        Mayflower.showBounds(true);
        showText("You Lose dummy!!!", 330, 50, Color.WHITE);
        showText("Press space to restart.", 260, 100, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
            if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)){
                Mayflower.setWorld(w);
            }
    }
}