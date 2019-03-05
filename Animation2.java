//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

	int direction = 3;			//change to test other directions
	String[] directions = new String[] {"north", "northeast", "east", "southeast", "south", "southwest", "west", "northwest"};
	  
    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8; //used as speed basically
    final int yIncr = 6;
    int xChange = xIncr;
    int yChange = yIncr;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
   

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {

    	if((xloc > frameWidth-imgWidth) | (xloc < 0) | (yloc > frameHeight-imgHeight) | (yloc < 0) ) {
    		
    		//finds random bounce direction within reasonable range
    		direction = (direction + (int) (Math.random()*3 + 3) ) % directions.length; 		
    		
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
    	}
    		changeDirectionAttributes();
    		picNum = (picNum + 1) % frameCount;
    		g.drawImage(pics[direction][picNum], xloc+=xChange, yloc+=yChange, Color.gray, this);
    	
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
		// Done: orc walks in opposite direction w/ correct sprites once hits edge.
    }

    
    //note: had to put in the numbers since cardinal directions set one x/yIncr to 0
    //otherwise, if not using cardinal, would multiply x/yIncr by -1 to change direction...
    public void changeDirectionAttributes() {
    	
    	if( directions[direction].equals("north")) {
    		xChange = 0; yChange = -yIncr;
    	} else if ( directions[direction].equals("south") ) {
    		xChange = 0; yChange = yIncr;
    	} else if(directions[direction].equals("east")) {
    		xChange = xIncr; yChange = 0;
    	} else if(directions[direction].equals("west")) {
    		xChange = -xIncr; yChange = 0;
    	} else if(directions[direction].equals("northeast")) {
    		xChange = xIncr; yChange = -yIncr;
    	} else if(directions[direction].equals("southwest")) {
    		xChange = -xIncr; yChange = yIncr;
    	} else if(directions[direction].equals("northwest")) {
    		xChange = -xIncr; yChange = -yIncr;
    	} else if(directions[direction].equals("southeast")) {
    		xChange = xIncr; yChange = yIncr;
    	}	
    }
    
    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new Animation());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	
    	pics = new BufferedImage[directions.length][frameCount]; //an array of BufferedImages

    	for(int i = 0; i < directions.length; i++) {
    		for(int j = 0; j < frameCount; j++) {
    			pics[i][j] = createImage(directions[i]).getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
    		}
    	}
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    	// Done: loads an array (pics) of BufferedImage arrays with 10 frames each
    }  
    
    //Read image from file and return
    private BufferedImage createImage(String d){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_forward_" + d +".png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    	// Done: accepts a direction d to find the file/image needed
    }
}



