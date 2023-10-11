package Project;

import mayflower.*;


public class WinScreen extends World {
    private int score;
    public WinScreen(int s) 
    {
        setBackground("img/TitleScreen.jpg");
        score = s;
        Mayflower.showBounds(true);
        showText("You WIN!!!!", 330, 50, Color.WHITE);
        showText("Your score was: " + score, 330, 100, Color.WHITE);
        showText("Press space to restart.", 260, 150, Color.WHITE);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
            if (Mayflower.isKeyDown(Keyboard.KEY_SPACE)){
                Mayflower.setWorld(w);
            }
    }
}