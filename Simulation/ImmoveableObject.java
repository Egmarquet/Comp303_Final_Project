package Simulation;

/**
 * Child class of WorldObject that cannot be moved
 * @author Etienne Guillot-Marquet
 *
 */
public class ImmoveableObject extends WorldObject{

	public ImmoveableObject(char token, String name) {
		super(token, name);
	}

	@Override
	public boolean isAutonomous() {
		return false;
	}

	/* 
	 * Overridden move(). Always returns false.
	 */
	@Override
	public boolean move(int moveX, int moveY, World world) {
		return false;
	}
}

