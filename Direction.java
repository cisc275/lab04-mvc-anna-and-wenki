

public enum Direction {

    NORTH("north", 0),
    NORTHEAST("northeast", 1),
    EAST("east", 2),
    SOUTHEAST("southeast", 3),
    SOUTH("south",4),
    SOUTHWEST("southwest",5),
    WEST("west",6),
    NORTHWEST("northwest",7);
	
    private String name = null;
    private int index;
    private int length = 8;
	
    private Direction(String s, int i){
		name = s;
		index = i;
	}
    
	public String getName() {
		return name;
	}

    public Direction getDirections(int i){
	if(i == 0){return NORTH;}
	else if(i == 1){return NORTHEAST;}
	else if(i == 2){return EAST;}
	else if(i == 3){return SOUTHEAST;}
	else if(i == 4){return SOUTH;}
	else if(i == 5){return SOUTHWEST;}
	else if(i == 6){return WEST;}
	else if(i == 7){return NORTHWEST;}
	else return null;
    }

	public int length(){
	    return length;
	}

	public int getIndex(){
	    return index;
	}

}
