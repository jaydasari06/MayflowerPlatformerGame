package Project;

import Lab5.Block2;
import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private String[][] tiles;
    
    public void buildWorld(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[0].length; j++){
                tiles[i][j] = "";
            }
        }
        for(int i = 0; i < tiles[11].length; i ++){
            tiles[11][i] = "ground";
        }
        for(int i = 0; i < tiles.length; i ++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("ground")){
                    addObject(new Block(), j * 64 , 536);
                }
            }
        }
    }

    public MyWorld() 
    {
        setBackground("img/City.jpg");
        Mayflower.showBounds(true);
        tiles = new String[12][16];
        buildWorld();
        cat = new Cat();
        addObject(cat, 200, 0);
        showText("Score: " + cat.getScore() +  " Lives: " + cat.getLives(), 10, 30, Color.WHITE);
    }

    public void act()
    {
    }

}