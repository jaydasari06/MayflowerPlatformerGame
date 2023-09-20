package Lab5;

import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private DogAnimatedActor dog;
    private String[][] tiles;
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat();
        dog = new DogAnimatedActor();
        tiles = new String[6][8];
        buildWorld();
        addRandomObjects();
       
        addMainCharacter();
        addSecondCharacter();
    }
    
    public void buildWorld(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[0].length; j++){
                tiles[i][j] = "";
            }
        }
        for(int i = 0; i < tiles[5].length; i ++){
            tiles[5][i] = "ground";
        }
        for(int i = 0; i < tiles.length; i ++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("ground")){
                    addObject(new Block(), j *100 , i * 95);
                }
            }
        
        }
        for(int i = 0; i < tiles.length; i ++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("water")){
                    addObject(new Block2(), j *104 , i * 100);
                }
            }
        
        }
    }
    
    public void addRandomObjects() {
        int num;
        for(int i = 0; i < tiles.length - 1; i++){
            for(int j = 0; j < tiles[i].length; j ++){
                if(tiles[i][j].equals("")) {
                    num = (int) (Math.random() * 10);  // Changed the range to 0-9
                    if(num < 3){
                        addObject(new Yarn(), j* 100, i* 95);
                        tiles[i][j] = "yarn";
                    } else if (num > 6){
                        addObject(new Crate(), j* 100, i* 95);
                        tiles[i][j] = "Crate";
                    }
                }
            }
        }
    }
    
    
    public void addMainCharacter(){
        cat = new Cat();
        boolean added = false;
        while(added == false){
            int row = (int) (Math.random()*tiles.length);
            int col = (int) (Math.random()*tiles[row].length);
            if(tiles[row][col].equals("")){
                addObject(cat, col * 100, row * 95);
                tiles[row][col] = "cat";
                added = true;
            }
        }
        



    }
    public void addSecondCharacter(){
        dog = new DogAnimatedActor();
        boolean added = false;
        while(added == false){
            int row = (int) (Math.random()*tiles.length);
            int col = (int) (Math.random()*tiles[row].length);
            if(tiles[row][col].equals("")){
                addObject(dog, col * 100, row * 95);
                tiles[row][col] = "dog";
                added = true;
            }
        }
        



    }
    
    public void act()
    {
    }
    
}