/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 */
import java.io.*;
import java.util.*;

class View extends JPanel{

    final int frameWidth = 500;
    final int frameHeight = 300;
    final int imgWidth = 165;
    final int imgHeight = 165;

    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[] picsWest;
    BufferedImage[] picsEast;
    BufferedImage[] picsNorth;
    BufferedImage[] picsSouth;
    BufferedImage[] picsSWest;
    BufferedImage[] picsSEast;
    BufferedImage[] picsNWest;
    BufferedImage[] picsNEast;

    //(view.getWidth(), view.getHeight()), view.getImageWidth(), view.getImageHeight());
    public int getWidth(){return frameWidth;}
    public int getHeight(){return frameHeight;}
    public int getImageWidth(){return imageWidth;}
    public int getImageHeight(){return imageHeight;}

    //Read image from file and return
    private BufferedImage createImage(String dir){
    	String orcFileString = "images/orc/orc_forward_" + dir + ".png";
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(orcFileString));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    
    //View.update(model.getX(), model.getY(), model.getDirect());
    public void update(int x, int y, int d){}

}

