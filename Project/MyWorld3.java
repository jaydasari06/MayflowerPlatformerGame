package Project;
import java.util.ArrayList;
import java.util.Collections;

import mayflower.*;


public class MyWorld3 extends World {

    private King king;
    private String[][] tiles;
    private AnimatedObelisk obelisk; 
    private Enemy enemy; 
    private Health health; 
    private Shield shield; 
    private Ladder ladder;
    
    public void buildWorld(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[0].length; j++){
                tiles[i][j] = "";
            }
        }
        
        for(int i = 0; i < tiles[11].length; i++){
            tiles[11][i] = "ground";
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("ground")){
                    addObject(new Floor(), j * 32 , 568);
                }
            }
        }

        // tiles[17][21] = "platform";
        // tiles[17][22] = "platform";
        // tiles[17][23] = "platform";
        // tiles[17][24] = "platform";
        // tiles[17][25] = "platform";
        // tiles[17][26] = "platform";

        tiles[17][13] = "platform";
        tiles[18][12] = "platform";
        tiles[19][11] = "platform";
        tiles[20][10] = "platform";
        tiles[21][9] = "platform";
        tiles[22][8] = "platform";

        
        tiles[10][17] = "platform";
        tiles[10][16] = "platform";
        tiles[10][15] = "platform";
        tiles[10][14] = "platform";
        tiles[10][13] = "platform";
        tiles[10][12] = "platform";


        tiles[8][9] = "platform";
        tiles[8][10] = "platform";
        tiles[8][11] = "platform";
        tiles[8][12] = "platform";
        tiles[8][13] = "platform";
        tiles[8][14] = "platform";

        tiles[13][20] = "platform";
        tiles[13][21] = "platform";
        tiles[13][22] = "platform";
        tiles[13][23] = "platform";
        tiles[13][24] = "platform";
        tiles[13][25] = "platform";

        tiles[7][23] = "platform";
        tiles[7][24] = "platform";
        tiles[7][25] = "platform";
        tiles[7][26] = "platform";
        tiles[7][27] = "platform";
        tiles[7][28] = "platform";
        


        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("platform")){
                    addObject(new Tiles(), j * 25, i * 25);
                }
            }
        }
    }

    public MyWorld3() 
    {
        setBackground("img/TestBackground.png");
        Mayflower.showBounds(true);
        tiles = new String[24][32];
        buildWorld();
        king = new King();
        enemy = new Enemy();
        ladder = new Ladder();
        obelisk = new AnimatedObelisk();
        health = new Health();
        shield = new Shield();
        obelisk.scale(50,50);
        addObject(ladder, 160, 430);
        addObject(king, 100, 200);
        addObject(enemy, 704, 468);
        addObject(obelisk, 700, 0);
        addObject(health, 700, 500);
        addObject(shield, 600 , 500);
        addRandomObjects();
        showText("Score: " + king.getScore() +  " Lives: " + king.getLives(), 10, 30, Color.BLACK);
    }

    public void addRandomObjects() {
        ArrayList<Integer> locations = new ArrayList<Integer>(); //create an array list to store the possible locations
        for(int i = 0; i < tiles.length - 1; i++){ //for each row except the bottom one
            for(int j = 0; j < tiles[i].length; j++){ //for each column
                if(tiles[i][j].equals("platform") && tiles[i-1][j].equals("")) { //if the tile is platform and the tile above it is empty
                    locations.add(i * 16 + j); //add the location to the array list as a single integer
                }
            }
        }
        Collections.shuffle(locations); //shuffle the array list
        
        for(int i = 0; i < 5; i++) //for the first 5 locations
        {
            int loc = locations.get(i); //get the location as an integer
            int row = loc / 16; //get the row by dividing by 16
            int col = loc % 16; //get the column by taking the remainder of dividing by 16
            addObject(new Health(), col * 25 , (row - 1) * 25 - 10); //add a Health object at one row above and offset below the corresponding location
        }
        
        for(int i = 5; i < 10; i++) //for the next 5 locations
        {
            int loc = locations.get(i); //get the location as an integer
            int row = loc / 16; //get the row by dividing by 16
            int col = loc % 16; //get the column by taking the remainder of dividing by 16
            addObject(new Shield(), col * 25 , (row - 1) * 25 - 10); //add a Shield object at one row above and offset below the corresponding location
        }
    }



    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER) && king.isTouchingObelisk()) {
            World m = new WinScreen(king.getScore());
            Mayflower.setWorld(m);
        }
    }

    public MovableAnimatedActor getKing(){
        return king;
    }

}