package Project;

import Lab5.Block2;
import mayflower.*;


public class MyWorld extends World {

    private Cat king;
    private String[][] tiles;
    private Platform obelisk; 
    
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
                    addObject(new Floor(), j * 64 , 536);
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
        king = new Cat();
        obelisk = new Platform();
        obelisk.scale(50,50);
        addObject(king, 200, 0);
        addObject(obelisk, 300, 100);
        showText("Score: " + king.getScore() +  " Lives: " + king.getLives(), 10, 30, Color.BLACK);
    }

    public void act()
    {
    }

}