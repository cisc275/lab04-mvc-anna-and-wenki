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

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


class View extends JPanel{

    JFrame frame;
    Dimension windowSize;
    
    int frameWidth = 500;
    int frameHeight = 300;
    int imgWidth = 165;
    int imgHeight = 165;

    private int xloc = 0;
    private int yloc = 0;
    private Direction d = Direction.NORTH;

    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][]pics;


    //(view.getWidth(), view.getHeight()), view.getImageWidth(), view.getImageHeight());
    public int getWidth(){return frameWidth;}
    public int getHeight(){return frameHeight;}
    public int getImageWidth(){return imgWidth;}
    public int getImageHeight(){return imgHeight;}


    public View() {
			
	frame = new JFrame();
	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	windowSize  = new Dimension(frameWidth, frameHeight);   	
    	frame.setSize(windowSize);
    	frame.setMinimumSize(windowSize);
    	frame.setMaximumSize(windowSize);
    		
	pics = new BufferedImage[d.length()][frameCount];
    	for(int i = 0; i < d.length(); i++) {
    		for(int j = 0; j < frameCount; j++) {
		    pics[i][j] = createImage(d.getDirections(i)).getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
    		}
    	}
    	frame.setVisible(true);


    }
    
     private BufferedImage createImage(Direction d){
    	BufferedImage bufferedImage;
    	try {
	    bufferedImage = ImageIO.read(new File("images/orc/orc_forward_" + d.getName() +".png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}return null;
     }


    public void paint(Graphics g){
	picNum = (picNum + 1) % frameCount;
	g.drawImage(pics[d.getIndex()][picNum], xloc, yloc, Color.gray, this); 
    }
   
    
    //View.update(model.getX(), model.getY(), model.getDirect()); basically 
    public void update(int x, int y, Direction direction){

    	frame.setSize(windowSize);

	xloc = x;
    	yloc = y;
    	d = direction;

    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
               	this.repaint();

    }

}
