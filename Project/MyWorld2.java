package Project;
import java.util.ArrayList;
import java.util.Collections;

import mayflower.*;


public class MyWorld2 extends World {

    private King king;
    private String[][] tiles;
    private AnimatedObelisk obelisk; 
    private Enemy enemy; 
    private Enemy enemy2; 
    private Enemy enemy3; 
    private Enemy enemy4; 
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

        tiles[14][0] = "platform";
        tiles[14][1] = "platform";
        tiles[14][2] = "platform";
        tiles[14][3] = "platform";
        tiles[14][4] = "platform";

        tiles[16][10] = "platform";
        tiles[16][11] = "platform";
        tiles[16][12] = "platform";

        tiles[8][0] = "platform";
        tiles[8][1] = "platform";
        tiles[8][2] = "platform";
        tiles[8][3] = "platform";


        tiles[6][5] = "platform";
        tiles[6][6] = "platform";
        tiles[6][7] = "platform";

        tiles[17][15] = "platform";
        tiles[17][16] = "platform";
        tiles[17][17] = "platform";
        tiles[17][18] = "platform";
        tiles[17][19] = "platform";
        tiles[17][20] = "platform";
        tiles[17][21] = "platform";

        tiles[3][12] = "platform";
        tiles[3][13] = "platform";
        tiles[3][14] = "platform";

        tiles[19][30] = "platform";
        tiles[19][31] = "platform";

        tiles[19][29] = "ladder";

        tiles[7][26] = "platform";
        tiles[7][27] = "platform";
        tiles[7][28] = "platform";
        tiles[7][29] = "platform";
        tiles[7][30] = "platform";
        tiles[7][31] = "platform";

        tiles[10][23] = "spike";
        tiles[10][24] = "spike";

        tiles[16][20] = "spike";
        tiles[16][21] = "spike";

        tiles[10][22] = "platform";
        tiles[10][21] = "platform";

        tiles[0][29] = "obelisk";
        tiles[0][30] = "obelisk1";
        tiles[0][31] = "obelisk1";

        tiles[18][24] = "enemy";
        tiles[18][27] = "enemy1";
        tiles[18][26] = "enemy1";
        tiles[18][25] = "enemy1";

        
        tiles[12][16] = "enemy";
        tiles[12][17] = "enemy1";
        tiles[12][15] = "enemy1";
        tiles[12][18] = "enemy1";

        tiles[13][16] = "enemy1";
        tiles[13][17] = "enemy1";
        tiles[13][15] = "enemy1";
        tiles[13][18] = "enemy1";

        tiles[14][16] = "enemy1";
        tiles[14][17] = "enemy1";
        tiles[14][15] = "enemy1";
        tiles[14][18] = "enemy1";

        tiles[15][16] = "enemy1";
        tiles[15][17] = "enemy1";
        tiles[15][15] = "enemy1";
        tiles[15][18] = "enemy1";

        tiles[16][16] = "enemy1";
        tiles[16][17] = "enemy1";
        tiles[16][15] = "enemy1";
        tiles[16][18] = "enemy1";


        tiles[11][10] = "enemy";
        tiles[11][9] = "enemy1";
        tiles[11][8] = "enemy1";
        tiles[11][11] = "enemy1";

        tiles[12][10] = "enemy1";
        tiles[12][9] = "enemy1";
        tiles[12][8] = "enemy1";
        tiles[12][11] = "enemy1";

        tiles[13][10] = "enemy1";
        tiles[13][9] = "enemy1";
        tiles[13][8] = "enemy1";
        tiles[13][11] = "enemy1";
        
        tiles[14][10] = "enemy1";
        tiles[14][9] = "enemy1";
        tiles[14][8] = "enemy1";
        tiles[14][11] = "enemy1";

        tiles[15][10] = "enemy1";
        tiles[15][9] = "enemy1";
        tiles[15][8] = "enemy1";
        tiles[15][11] = "enemy1";
        


        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("platform")){
                    addObject(new Tiles(), j * 25, i * 25);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("spike")){
                    addObject(new Spikes(), j * 25, i * 25);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("obelisk")){
                    addObject(new AnimatedObelisk(), j * 25, i * 25);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("enemy")){
                    addObject(new Enemy(), j * 25, i * 25);
                }
            }
        }

        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("ladder")){
                    addObject(new Ladder(), j * 25, i * 25);
                }
            }
        }
    }

    public MyWorld2() 
    {
        setBackground("img/TestBackground.png");
        Mayflower.showBounds(false);
        tiles = new String[24][32];
        buildWorld();
        king = new King();
        addObject(king, 0, 450);
        addRandomObjects();
        showText("Score: " + king.getScore() +  " Lives: " + king.getLives(), 10, 30, Color.WHITE);
    }

    public void addRandomObjects() {
        ArrayList<Integer> locations = new ArrayList<Integer>(); //create an array list to store the possible locations
        for(int i = 0; i < tiles.length - 1; i++){ //for each row except the bottom one
            for(int j = 0; j < tiles[i].length; j++){ //for each column
                if(tiles[i][j].equals("platform") && tiles[i-1][j].equals("") && !tiles[i][j].equals("enemy1") && (((i-1) != 6) && ((j != 29) || (j != 30) || (j != 31)))) { //if the tile is platform and the tile above it is empty
                    locations.add(i * tiles[0].length + j); //add the location to the array list as a single integer
                }
            }
        }
        Collections.shuffle(locations); //shuffle the array list
        
        for(int i = 0; i < 3; i++) //for the first 5 locations
        {
            int loc = locations.get(i); //get the location as an integer
            int row = loc / tiles[0].length; //get the row by dividing by the number of columns in the array
            int col = loc % tiles[0].length; //get the column by taking the remainder of dividing by the number of columns in the array
            addObject(new Health(), col * 25 , (row - 1) * 25 - 10); //add a Health object at one row above and offset below the corresponding location
        }
        
        for(int i = 3; i < 7; i++) //for the next 5 locations
        {
            int loc = locations.get(i); //get the location as an integer
            int row = loc / tiles[0].length; //get the row by dividing by the number of columns in the array
            int col = loc % tiles[0].length; //get the column by taking the remainder of dividing by the number of columns in the array
            addObject(new Shield(), col * 25 , (row - 1) * 25 - 10); //add a Shield object at one row above and offset below the corresponding location
        }
    }



    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER) && king.isTouchingObelisk()) {
            World m = new MyWorld3();
            Mayflower.setWorld(m);
        }
    }

    public MovableAnimatedActor getKing(){
        return king;
    }

}