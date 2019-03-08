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

    Direction d = Direction.NORTH;
    
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
    
    int xloc;
    int yloc;
    final int xIncr = 8; //used as speed basically
    final int yIncr = 6;
    int xChange = xIncr;
    int yChange = yIncr;


    
    Model(int w, int h, int iw, int ih){
	frameWidth = w;
	frameHeight = h;
	imgWidth = iw;
	imgHeight = ih;
	xloc = 0;
	yloc = 0;
    }

    //model.getX(), model.getY(), model.getDirect());
    public int getX(){return xloc;}
    public int getY(){return yloc;}
    public Direction getDirect(){return d;}
 
    
    public void updateLocationAndDirection(){

	//System.out.println(d);
	this.changeDirectionAttributes();
	this.changeLocation();


    }

    public void changeLocation(){
		if((xloc > frameWidth-imgWidth) | (xloc < 0) | (yloc > frameHeight-imgHeight) | (yloc < 0) ) {
    		
		    //finds random bounce direction within reasonable range
		    d = d.getDirections(((d.getIndex() + (int) (Math.random()*3 + 3) ) % d.length())); 		
    		
		    //to make sure there's no random stuck in corner glitching
		    if(xloc > frameWidth-imgWidth) {
    			xloc = frameWidth-imgWidth;
		    }else if(xloc < 0) {
    			xloc = 0;
		    }   		
		    if(yloc > frameHeight-imgHeight) {
    			yloc = frameHeight-imgHeight;
		    }else if(yloc < 0){
    			yloc = 0;
		    }
		}else{
		    xloc += xChange;
		    yloc += yChange;
		}
    }
    
    public void changeDirectionAttributes() {
    	
    	if( d == Direction.NORTH) {
    		xChange = 0; yChange = -yIncr;
    	} else if ( d == Direction.SOUTH ) {
    		xChange = 0; yChange = yIncr;
    	} else if(d == Direction.EAST) {
    		xChange = xIncr; yChange = 0;
    	} else if(d == Direction.WEST) {
    		xChange = -xIncr; yChange = 0;
    	} else if(d == Direction.NORTHEAST) {
    		xChange = xIncr; yChange = -yIncr;
    	} else if(d == Direction.SOUTHWEST) {
    		xChange = -xIncr; yChange = yIncr;
    	} else if(d == Direction.NORTHWEST) {
    		xChange = -xIncr; yChange = -yIncr;
    	} else if(d == Direction.SOUTHWEST) {
    		xChange = xIncr; yChange = yIncr;
    	}	
    }
       



    
}
