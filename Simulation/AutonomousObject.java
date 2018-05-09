package Simulation;
import java.util.concurrent.ThreadLocalRandom;

/**
 * AutonomousObject is a child class of WorldObject. It sets isAutonomous to be true.
 * It contains a unique method step() that attempts to move the object
 * 
 * @author Etienne Guillot-Marquet
 *
 */
public class AutonomousObject extends WorldObject{

	
	/**
	 *  Set of legal moves that the autonomous object can make
	 */
	private static int[][] legalMoves = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public AutonomousObject(char token, String name) {
		super(token, name);
	}

	@Override
	public boolean isAutonomous() {
		return true;
	}
	
	/** Chooses a random legal move and calls move() to move the object
	 * @param world The world that the object inhabits
	 */
	public void step(World world) {
		int[] move = legalMoves[ThreadLocalRandom.current().nextInt(0, 4)];
		move(move[0],move[1],world);
	}

}
