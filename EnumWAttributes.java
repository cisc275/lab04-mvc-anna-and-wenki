
import java.util.HashMap;

public class EnumWAttributes {

	//DON'T USE THIS FILE, this is just some examples of how to use our enumerated type.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int data[] = {1,2,3,4,5,6,7,8};
		
		Direction d = Direction.NORTHEAST;

		System.out.println("integer types with associated strings!: " + d.getName());

		System.out.println("integer types: " + d.ordinal());
		
		
		HashMap<Direction, String> temps = new HashMap<Direction, String>();
		temps.put(d, "cold");

		System.out.println("works as a key: " + temps.get(d));
		
		System.out.println(d);
		System.out.println(d.getName());

		switch (d){		
		case NORTH:
			System.out.println("enum types work in switch statements!");
		}
		Controller c = new Controller();
		c.start();

	}

}
