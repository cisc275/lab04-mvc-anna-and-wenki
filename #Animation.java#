
//Kelly Mi
//Wenki Liang
 
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
// import javax.imageio.ImageIO;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

public class Animation extends JPanel {

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
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    /*final */ static int frameWidth = 500;
    /*final */static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    boolean East = true;
    boolean South = true;
    String dir = "southeast";

    //Override this JPanel's paint method to cycle through picture array and draw images
    public void paint(Graphics g) {
    	frameHeight = this.getHeight(); //update height, width
    	frameWidth = this.getWidth();
    	
    	picNum = (picNum + 1) % frameCount;
    	if (this.dir == "east") { //draw east
        	g.drawImage(picsEast[picNum], xloc+=xIncr, yloc, Color.gray, this);
    	}
    	else if (this.dir == "west") { //draw west
        	g.drawImage(picsWest[picNum], xloc-=xIncr, yloc, Color.gray, this);
    	}
    	else if (this.dir == "north") { // draw north
        	g.drawImage(picsNorth[picNum], xloc, yloc -= yIncr, Color.gray, this);
    	}
    	else if (this.dir == "south") { // draw south
        	g.drawImage(picsSouth[picNum], xloc, yloc += yIncr, Color.gray, this);
    	}
    	else if (this.dir == "southeast") { // draw south-east
        	g.drawImage(picsSEast[picNum], xloc +=xIncr, yloc += yIncr, Color.gray, this);
    	}
    	else if (this.dir == "southwest") { // draw south-west
        	g.drawImage(picsSWest[picNum], xloc -= xIncr, yloc += yIncr, Color.gray, this);
    	}
    	else if (this.dir == "northeast") { // draw north-east
        	g.drawImage(picsNEast[picNum], xloc +=xIncr, yloc -= yIncr, Color.gray, this);
    	}
    	else if (this.dir == "northwest") { // draw north-west
        	g.drawImage(picsNWest[picNum], xloc -= xIncr, yloc -= yIncr, Color.gray, this);
    	}

    	touchingWall();
    	// TODO: Keep the orc from walking off-screen, turn around when bouncing off walls.
		//Be sure that animation picture direction matches what is happening on screen.
    }
    
    //find if animation is touching wall and changes direction
    public String touchingWall() {
    	
    	int frameXSize = frameWidth - imgWidth; //adjust for size of image
    	int frameYSize = frameHeight - imgHeight;
    	
    	if (this.xloc >= frameXSize) {//touch the right-side frame
    		if (this.dir == "east") { //straight east
    			this.dir = "west";    //bounce to west
    		}
    		if (this.dir == "southeast") {//from south-east
    			this.dir = "southwest";   //bounce to south-west
    		}
    		if (this.dir == "northeast") {//from north-east
    			this.dir = "northwest";   //bounce to north-west
    		}
    	} 
    	else if (this.xloc <= 0){ //touch the left-side frame
    		if (this.dir == "west") { //straight west
    			this.dir = "east";    //bounce to east
    		}
    		if (this.dir == "southwest") { //from south-west
    			this.dir = "southeast";    //bounce to south-east
    		}
    		if (this.dir == "northwest") { //from north-west
    			this.dir = "northeast";    //bounce to north-east
    		}
    	}
    	if (this.yloc >= frameYSize) {//touch the down-side frame
    		if (this.dir == "south") { //straight south
    			this.dir = "north";    //bounce to north
    		}
    		if (this.dir == "southwest") {// from south-west
    			this.dir = "northwest";   //bounce to north-west
    		}
    		if (this.dir == "southeast") {//from south-east
    			this.dir = "northeast";   //bounce to north-east
    		}
    	} 
    	else if (this.yloc <= 0){//touch the up-side frame
    		if (this.dir == "north") {//straight north
    			this.dir = "south";   //bounce to south
    		}
    		if (this.dir == "northeast") { //from the north-east
    			this.dir = "southeast";    //bounce to north-west
    		}
    		if (this.dir == "northwest") { //from the north-west
    			this.dir = "southwest";    //bounce to south-west
    		}
    	}
    	return this.dir;
    	
    }

    //Make frame, loop on repaint and wait
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new Animation());
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
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	BufferedImage img = createImage("west"); //for west direction
    	picsWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsWest[i] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img2 = createImage("east"); //for east direction
    	picsEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsEast[i] = img2.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img3 = createImage("north"); //for north direction
    	picsNorth = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNorth[i] = img3.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    	
    	BufferedImage img4 = createImage("south"); //for south direction
    	picsSouth = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSouth[i] = img4.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img5 = createImage("southwest"); //for south-west direction
    	picsSWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSWest[i] = img5.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img6 = createImage("southeast"); //for south-east direction
    	picsSEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsSEast[i] = img6.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img7 = createImage("northwest"); //for north-west direction
    	picsNWest = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNWest[i] = img7.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	BufferedImage img8 = createImage("northeast"); // for north-east direction
    	picsNEast = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		picsNEast[i] = img8.getSubimage(imgWidth*i, 0, imgWidth, imgHeight); 
    	
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    }  
    
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
}



