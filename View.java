/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.animation.Animation;

class View extends JPanel{

    final int frameWidth = 500;
    final int frameHeight = 300;
    final int imgWidth = 165;
    final int imgHeight = 165;
    private int xloc = 0;
	private int yloc = 0;
	int xIncr;
	int yIncr;
    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[] pics;
    BufferedImage[] picsEast;
    BufferedImage[] picsNorth;
    BufferedImage[] picsSouth;
    BufferedImage[] picsSWest;
    BufferedImage[] picsSEast;
    BufferedImage[] picsNWest;
    BufferedImage[] picsNEast;
    Direction d = Direction.SOUTH;

    //(view.getWidth(), view.getHeight()), view.getImageWidth(), view.getImageHeight());
    public int getWidth(){return frameWidth;}
    public int getHeight(){return frameHeight;}
    public int getImageWidth(){return imgWidth;}
    public int getImageHeight(){return imgHeight;}
    
    //View.update(model.getX(), model.getY(), model.getDirect()); basically 
    public void update(int x, int y, Direction direction){
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(this);
    	
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Dimension windowSize = new Dimension(frameWidth, frameHeight);   	
    	frame.setSize(windowSize);
    	frame.setMinimumSize(windowSize);
    	frame.setMaximumSize(windowSize);
    	
    	frame.setVisible(true);
    	
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		}
    	xloc = x;
    	yloc = y;
    	d = direction;
    }
    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount;
 
		g.drawImage(pics[picNum],xloc,yloc,Color.gray,this);
	}
    public View() {
	BufferedImage img = createImage(d); //for west direction
	pics = new BufferedImage[10];
	for(int i = 0; i < frameCount; i++)
		pics[i]= img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
}
    
    //Read image from file and return
    private BufferedImage createImage(Direction dir){
    	String orcFileString = "images/orc/orc_forward_" + dir.getName() + ".png";
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
    
   
    
}
