package Project;
import mayflower.*;


public class MyWorld extends World {

    private King king;
    private String[][] tiles;
    private Platform obelisk; 
    private Enemy enemy; 
    private Ladder ladder;
    
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
        setBackground("img/TestBackground.png");
        Mayflower.showBounds(true);
        tiles = new String[12][16];
        buildWorld();
        king = new King();
        enemy = new Enemy();
        ladder = new Ladder();
        obelisk = new Platform();
        obelisk.scale(50,50);
        addObject(ladder, 200, 300);
        addObject(king, 200, 0);
        addObject(enemy, 400, 408);
        addObject(obelisk, 700, 0);
        
        showText("Score: " + king.getScore() +  " Lives: " + king.getLives(), 10, 30, Color.WHITE);
    }

    public void act()
    {
    }

    public MovableAnimatedActor getKing(){
        return king;
    }

}