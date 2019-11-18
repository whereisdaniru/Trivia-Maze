package game;

public class Player {
	
	private String name;
	private int hintCount;
	private Location location;
	
	public Player(String name, int hintCount, Location location) {
		this.setName(name);
		this.setHintCount(hintCount);
		this.setLocation(location);
	}
	
	public Player() {
		this.setName("New Player");
		this.setHintCount(4);
		this.setLocation(new Location(0,0));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHintCount() {
		return hintCount;
	}

	public void setHintCount(int hintCount) {
		this.hintCount = hintCount;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
