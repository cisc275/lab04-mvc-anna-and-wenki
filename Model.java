/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

import java.util.*;


class Model{
    //model.updateLocationAndDirection();
    //model = new Model(view.getWidth(), view.getHeight()), view.getImageWidth(), view.getImageHeight());
    
    Direction d = Direction.NORTH;
    
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
    
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8; //used as speed basically
    final int yIncr = 6;
    int xChange = xIncr;
    int yChange = yIncr;


    
    Model(int w, int h, int iw, int ih){
	frameWidth = w;
	frameHeight = h;
	imgWidth = iw;
	imgHeight = ih;
    }

    //model.getX(), model.getY(), model.getDirect());
    public int getX(){return xloc;}
    public int getY(){return yloc;}
    public Direction getDirect(){return d;}
 
    
    public void updateLocationAndDirection(){}

}
