package Project;

import mayflower.*;


public class TitleScreen extends World {
    
    public TitleScreen() 
    {
        
        Mayflower.showBounds(true);
        
    }
    
    public void act()
    {
        World w = new MyWorld();
        while(true){
            if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE)){
                Mayflower.setWorld(w);
                break;
            }
        }
    }
    
}