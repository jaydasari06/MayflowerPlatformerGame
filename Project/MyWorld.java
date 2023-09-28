package Project;

import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private DogAnimatedActor dog; 
    private Block block;
    private Block block2;
    
    public MyWorld() 
    {
        setBackground("img/City.jpg");
        Mayflower.showBounds(true);
        cat = new Cat();
        dog = new DogAnimatedActor();
        addObject(cat, 400, 100);
        block = new Block();
        block2 = new Block();
        addObject(block, 400, 472);
        addObject(block2, 528, 372);
        addObject(dog, 528, 272);


        showText("Score: " + cat.getScore() +  " Lives: " + cat.getLives(), 10, 30, Color.BLACK);
    }
    
    public void act()
    {
    }
    
}