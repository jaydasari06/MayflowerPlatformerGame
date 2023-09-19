package Project;

import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private Block block;
    private Block block2;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        Mayflower.showBounds(true);
        cat = new Cat();
        addObject(cat, 400, 100);
        block = new Block();
        block2 = new Block();
        addObject(block, 400, 500);
        addObject(block2, 528, 372);
    }
    
    public void act()
    {
    }
    
}