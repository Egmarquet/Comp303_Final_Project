package Simulation;

public abstract class WorldObject {
	
	/**
	 *  World Objects X coordinate
	 */
	private int posX;
	/**
	 *  World Objects Y coordinate
	 */
	private int posY;
	/**
	 *  World Objects token character
	 */
	private char token;
	/**
	 *  World Objects name
	 */
	private String name;
	
	
	/** Create's new world object. It's default coordinates are null until set by the user
	 * @param token The token char representing the object
	 * @param name The objects name
	 */
	public WorldObject(char token, String name){
		this.name = name;
		this.token = token;	
	}
	
	/** Returns the objects name
	 * @return The Object's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the objects X coordinate
	 * @return The object's X coordinate
	 */
	public int getPosX() {
		return this.posX;
	}
	
	/**
	 * Returns the objects Y coordinate
	 * @return The object's Y coordinate
	 */
	public int getPosY() {
		return this.posY; 
	}
	
	/** Modifies the X coordinate of the object
	 * @param setX X coordinate modifier
	 */
	public void setPosX(int setX) {
		this.posX += setX;
	}
	
	/** Modifies the Y coordinate of the object
	 * @param setY Y coordinate modifier
	 */
	public void setPosY(int setY) {
		this.posY += setY;
	}

	/**Returns the token on the object
	 * @return The objects's token
	 */
	public char getToken() {
		return this.token;
	}
	
	/**
	 * Attempts to move the object in by the moveX,moveY modifier. move() queries
	 * the board to check if the move if possible, and updates the position of the objects if so.
	 * 
	 * @param moveX Movement on the x axis
	 * @param moveY Movement on the y axis 
	 * @param world The world that the objects inhabit
	 * @return True if the object was moved successfully, false otherwise
	 */
	public boolean move(int moveX, int moveY, World world) {
		//If the object can according to the world
		if(world.moveObject(this, moveX, moveY)) {
			this.setPosX(moveX);
			this.setPosY(moveY);
			return true;
		}
		//Else, return false
		else {
			return false;
		}
	}
	
	/**
	 * Abstract method that returns true if the object is autonomous
	 * @return True if autonomous, false if not
	 */
	public abstract boolean isAutonomous();

}
