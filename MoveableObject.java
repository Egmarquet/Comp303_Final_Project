package Simulation;

/**
 * Child class of WorldObject that can be moved
 * @author Etienne Guillot-Marquet
 *
 */
public class MoveableObject extends WorldObject {

	public MoveableObject(char token, String name) {
		super(token, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAutonomous() {
		return false;
	}

}
