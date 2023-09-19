package Project;

import mayflower.*;
public class Animation
{
    private MayflowerImage[] characters;
    private int framerate;
    private int currentframe;
    private int framelength;
    
    public Animation(int framer, String[] filenames){
        framerate = framer;
        characters = new MayflowerImage[filenames.length];
        for(int i = 0; i < filenames.length; i ++){
            characters[i] = new MayflowerImage(filenames[i]);
        }
        framelength = characters.length;
    }
    
    public void scale(int w, int h){
        for(int i = 0; i < characters.length; i ++){
            characters[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent){
        for(int i = 0; i < characters.length; i ++){
            characters[i].setTransparency(percent);
        }
    }
    
    public int getFrameRate() {
        return framerate;
    }
    public void mirrorHorizontally(){
        for(int i = 0; i < characters.length; i ++){
            characters[i].mirrorHorizontally();
        }
    }
    public void setBounds(int x, int y, int w, int h){
       for(int i = 0; i < characters.length; i ++){
            characters[i].crop(x, y, w, h);
        }
    }
    
    public MayflowerImage getNextFrame(){ 
        currentframe += 1;
        if(currentframe >= framelength){
            currentframe = currentframe % framelength;
        }
        MayflowerImage currentimage = characters[currentframe];
        
        
        return currentimage;
    }
}
