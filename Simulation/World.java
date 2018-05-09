package Simulation;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * The World class is a container for WorldObjects. It is instantiated as a n by m grid of user specification. 
 * The world class is able to simulate the movement of objects in its world, and display them in a GUI. 
 * @author Etienne Guillot-Marquet
 *
 */
public class World {
	/**
	 *  2D array that houses world objects
	 */
	private WorldObject[][] worldMap;
	/**
	 *  List of autonomous objects
	 */
	private LinkedList<AutonomousObject> autoObjectList;
	/**
	 *  JFrame for gui window 
	 */
	private JFrame mainFrame;
	/**
	 * JPanel for gui display and container for other componetns
	 */
	private JPanel mainPanel;
	
	/**
	 *  World width
	 */
	private int sizeX;
	
	/**
	 * World length
	 */
	private int sizeY;
	
	/**
	 * Instantiates a new world of the users specified size
	 * @param sizeX Width of world
	 * @param sizeY Height of world
	 */
	public World(int sizeX, int sizeY) {
		this.worldMap = new WorldObject[sizeX][sizeY];
		autoObjectList = new LinkedList<AutonomousObject>();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		displaySetup(sizeX,sizeY);
	}
	
	/**
	 * Called only by the constructor. Handles the creation of swing objects.
	 * In particular, creates a JPanel decorated with a GridLayout, and fills it with
	 * n by m JLabels, representing the World Objects. 
	 * @param sizeX Width of world
	 * @param sizeY Height of world
	 */
	private void displaySetup(int sizeX,int sizeY) {
		this.mainFrame = new JFrame();
		this.mainPanel = new JPanel();
		this.mainFrame.setSize(500, 500);
		//Gridlayout
		this.mainPanel.setLayout(new GridLayout(sizeX,sizeY));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creating JLabels and adding to JPanel
		for(int x = 0; x < sizeX; x++) {
			for(int y = 0; y < sizeY; y++) {
				JLabel tempLabel = new JLabel();
				tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
				tempLabel.setVerticalAlignment(SwingConstants.CENTER);
				tempLabel.setBorder(new LineBorder(Color.BLACK));
				tempLabel.setOpaque(true);
				tempLabel.setBackground(new Color(66, 194, 244));
				this.mainPanel.add(tempLabel);
			}
		}
		//Adding panel to JFrame
		this.mainFrame.add(mainPanel);
		//Launch GUI
		this.mainFrame.setVisible(true);

	}
	/**
	 * Returns a reference to a WorldObject held at position x,y
	 * @param posX WorldObjects x position
	 * @param posY WorldObjects y position
	 * @return WorldObject reference
	 */
	private WorldObject getObjectAt(int posX, int posY) {
		return this.worldMap[posX][posY];
	}
	
	/**
	 * Checks if the object is at the correct position in the world
	 * @param obj Object to be checked
	 * @throws IllegalStateException
	 */
	private void checkPositions(WorldObject obj) throws IllegalStateException {
		int posxObj = obj.getPosX();
		int posyObj = obj.getPosY();
		if(getObjectAt(posxObj,posyObj) != obj) {
			throw new IllegalStateException();
		}
	}

	/**
	 *  Populates the world with assignment specified objects at random locations
	 */
	private static void buildWorld(World world) {
		boolean addedToMap;

		WorldObject[] objectsToAdd = 		{
				
		new ImmoveableObject('i',"imoA"), 
		new ImmoveableObject('i',"imoB"),
		new ImmoveableObject('i',"imoB"),
		new ImmoveableObject('i',"imoC"),
		new ImmoveableObject('i',"imoD"),
		new ImmoveableObject('i',"imoE"),
		new MoveableObject('m',"mo1"),
		new MoveableObject('m',"mo2"),
		new MoveableObject('m',"mo3"),
		new AutonomousObject('a',"auto1"),
		new AutonomousObject('a',"auto1")	};
				
		//Adds world objects to random positoins
		for(WorldObject wo : objectsToAdd) {
			addedToMap = false;
			while(!addedToMap) {
				int posX = ThreadLocalRandom.current().nextInt(0, world.getSizeX());
				int posY = ThreadLocalRandom.current().nextInt(0, world.getSizeY());
				addedToMap = world.add(wo, posX,posY);
			}
		}
		//System.out.println("Objects added sucessfully");
	}

		
	//
	// API
	//

	/**
	 * @return Worlds width
	 */
	public int getSizeX() {
		return this.sizeX;
	}
	/**
	 * @return Worlds lenght
	 */
	public int getSizeY() {
		return this.sizeY;
	}
	
	
	/**
	 * Checks if there exists a world object at a specified location
	 * @param posX Queried X coordinate
	 * @param posY Queried Y coordinate
	 * @return True if there exists and object, false otherwise
	 */
	public boolean isOpen(int posX, int posY) {
		boolean openPosition = true;
		if(getObjectAt(posX,posY) == null) {
			openPosition = true;
		}
		
		else {
			openPosition = false;
		
		}
		return openPosition; 
	}

		
	/**
	 * Updates swing components to the current state of the world
	 */
	public void display() {
		//For all cells of the world
		JPanel j = (JPanel) this.mainFrame.getContentPane().getComponent(0);
		for(int row = 0; row < this.worldMap.length; row++) {
			for(int col = 0; col < this.worldMap[row].length; col++) {
				//get the JLabel at that cell
				JLabel l = (JLabel) j.getComponent((row*this.worldMap[row].length)+col);
				//update text if there is an object at that cell
				if (getObjectAt(row,col) != null){
					l.setText(Character.toString(getObjectAt(row,col).getToken()));
				}
				else {
					l.setText("");
				}
			}
		}
	}
		
	/**
	 * Calls step() on all autonomous objects
	 */
	public void step() {
		for(AutonomousObject auto : this.autoObjectList) {
			auto.step(this);
		}
	}
	
	/**
	 * Simulates the world for a set number of iterations
	 * @param iterations Number of simulation iterations
	 * @param sleeptime Sleep time in (ms) between each iteration of the simulation
	 */
	public void simulate(int iterations, int sleeptime) {
		Scanner s = new Scanner(System.in);
		boolean commandValid = false;
		for(int iter = 0; iter < iterations; iter++) {
			step();
			display();
			try {
				Thread.sleep(sleeptime);
			}
			catch(InterruptedException e){
				System.exit(1);
			}
		}
		
		//user parsing
		String input = "y";
		while(!input.equals("n")) {
			System.out.println("Simulate again? [y/n]");
			input = s.nextLine();
			if(input.equals("y")) {
				commandValid = true;
				simulate(iterations,sleeptime);
			}
			else if(input.equals("n")) {
				System.exit(1);
			}
			else {
				System.out.println("Unknown command");
			}
		}
	}
	
	/**
	 * Moves an object in the world
	 * @param wobj The object to be moved
	 * @param moveX X coordinate modifier 
	 * @param moveY Y coordinate modifier
	 * @return True if the object was successfully moved, false otherwise
	 */
	public boolean moveObject(WorldObject wobj, int moveX, int moveY) {
		checkPositions(wobj);
		int oldPosX = wobj.getPosX();
		int oldPosY = wobj.getPosY();
		int newPosX = oldPosX + moveX;
		int newPosY = oldPosY + moveY;

		//If spot is open, update the board state
		try {
			if(isOpen(newPosX,newPosY)){
				this.worldMap[oldPosX][oldPosY] = null;
				this.worldMap[newPosX][newPosY] = wobj;
				return true;
			}
			else {
				//Try to move the object directly in the path of the object
				//Recursive call on all other objects in the same path 
				boolean moved = getObjectAt(newPosX,newPosY).move(moveX, moveY, this);
				if(moved == true) {
					//If successful, move this object
					this.worldMap[oldPosX][oldPosY] = null;
					this.worldMap[newPosX][newPosY] = wobj;
					return true;
				}
				return false;
			}
		}
		
		//Returns false if out of bounds of the board
		catch(IndexOutOfBoundsException e){
			//System.out.println("Out of bounds");
			return false;
		}
	}	
		
	
	
	/**
	 * Attempts to add an object at a location in the world.
	 * @param newObject Object to be added
	 * @param posX Initial x coordinate
	 * @param posY Initial y coordinate
	 * @return True if object was added successfully, false otherwise
	 */
	public boolean add(WorldObject newObject, int posX, int posY) {
		
		boolean sucessfullyAdded = false;
		try {
			if(isOpen(posX,posY)) {
				newObject.setPosX(posX);
				newObject.setPosY(posY);
				this.worldMap[posX][posY] = newObject;
				if(newObject.isAutonomous()) {
					autoObjectList.add((AutonomousObject) newObject);
				}
				sucessfullyAdded = true;
			}
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("Out of bounds");
			sucessfullyAdded = false;
		}
		
		return sucessfullyAdded;
	}
	
	
	//Main
	public static void main(String[] args) {
		World newWorld = new World(6,6);	
		buildWorld(newWorld);
		newWorld.simulate(100,50);
	}
}
