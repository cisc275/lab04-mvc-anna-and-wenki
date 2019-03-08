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
    
    final int frameWidth;
    final int frameHeight;
    final int imgWidth;
    final int imgHeight ;
    //ss
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8; //used as speed basically
    final int yIncr = 6;
    int xChange = xIncr;
    int yChange = yIncr;
    private static boolean moveEast = false;
	private static boolean moveWest = false;
	private static boolean moveNorth = false;
	private static boolean moveSouth = false;


    
    Model(int w, int h, int iw, int ih){
	frameWidth = w;
	frameHeight = h;
	imgWidth = iw;
	imgHeight = ih;
    }

    //model.getX(), model.getY(), model.getDirect());
    public int getX(){
    	return xloc;
    	}
    public int getY(){
    	return yloc;
    	}
    public Direction getDirect(){
    	return d;
    	}
    
    public void updateLocationAndDirection(){
    	if(yloc == 0) {//if reach the upside edge
    		if(d == Direction.NORTH) {//if current direction is north
    			d = Direction.SOUTH;
    			xloc = xloc; // do nothing w/ x location
    			yloc += yIncr; //increase the y location
    		}
    		else if(d ==Direction.NORTHEAST) {
    			d = Direction.SOUTHEAST; //if currently moving in south east
    			xloc += xIncr; // still moving east
    			yloc += yIncr; //moving south vertically
    		}
    		else if (d == Direction.NORTHWEST) { 
    			d = Direction.SOUTHWEST;
    			xloc -= xIncr;
    			yloc += yIncr;
    		}
    	}
    	else if(yloc == frameHeight) { //if touch the bottom edge
    		if(d == Direction.SOUTH) {
    			d = Direction.NORTH;
    			xloc = xloc;
    			yloc -= yIncr;
    		}
    		else if(d ==Direction.SOUTHEAST) {
    			d = Direction.NORTHEAST;
    			xloc += xIncr;
    			yloc -= yIncr;
    		}
    		else if (d == Direction.SOUTHWEST) {
    			d = Direction.NORTHWEST;
    			xloc -= xIncr;
    			yloc -= yIncr;
    		}
    	}
    	if(xloc == 0) {//if reach the left side edge
    		if(d == Direction.WEST) {//if current direction is west
    			d = Direction.EAST; //chance the direction to east
    			xloc += xIncr; // make it move east
    			yloc = yloc; //do nothing w/ y location
    		}
    		else if(d ==Direction.SOUTHWEST) {//if currently moving in south west
    			d = Direction.SOUTHEAST; //change the direction to south east
    			xloc += xIncr; // still moving east
    			yloc += yIncr; //moving south vertically
    		}
    		else if (d == Direction.NORTHWEST) {  // if moving north west
    			d = Direction.NORTHEAST; //change to north east
    			xloc += xIncr; //increase x location
    			yloc -= yIncr; //decrease y location
    		}
    	}
    	else if(xloc == frameWidth) {//if reach the right side edge
    		if(d == Direction.EAST) {//if current direction is east
    			d = Direction.WEST; //chance the direction to west
    			xloc -= xIncr; // make it move west
    			yloc = yloc; //do nothing w/ y location
    		}
    		else if(d ==Direction.SOUTHEAST) {//if currently moving in south west
    			d = Direction.SOUTHWEST; //change the direction to south east
    			xloc -= xIncr; // still moving east
    			yloc += yIncr; //moving south vertically
    		}
    		else if (d == Direction.NORTHEAST) {  // if moving north west
    			d = Direction.NORTHWEST; //change to north east
    			xloc -= xIncr; //increase x location
    			yloc -= yIncr; //decrease y location
    		}
    	}
    	else {
    		xloc += xIncr;
    		yloc += yIncr;
    	}
    }
   
}
