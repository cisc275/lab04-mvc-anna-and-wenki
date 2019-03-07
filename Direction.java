

public enum Direction {

	NORTH("north"),
	NORTHEAST("northeast"),
	EAST("east"),
	SOUTHEAST("southeast"),
	SOUTH("south"),
	SOUTHWEST("southwest"),
	WEST("west"),
	NORTHWEST("northwest");
	
	private String name = null;
	private int length = 8;
	
	private Direction(String s){
		name = s;
	}
	public String getName() {
		return name;
	}

	public int length(){
	    return length;
	}

}
