package JavaCool303;
import java.awt.*;
import javax.naming.LimitExceededException;
import javax.swing.*;

/**
 * 
 * Root class of all Cool303Components.
 * Acts as a wrapper for Java swing components 
 * It requires a Cool303Theme for instantiation.
 * Cool303Components can be added to this class. 
 * The theme being used for this class will be applied to all components
 * 
 * @author Etienne Guillot-Marquet
 *
 */
public class Cool303Root {
	
	/**
	 *  Theme that is applied to all components
	 */
	private Cool303Theme mainTheme; 
	/**
	 *  Cool303Container that contains all components
	 */
	private Cool303Container container;
	/**
	 *  JFrame swing component
	 */
	private JFrame mainFrame;
	
	/**
	 * Initializes a new Cool303Root with a given theme and an automatic resizing window
	 * @param theme A theme to be applied to all components 
	 */
	public Cool303Root(Cool303Theme theme) {
		this.mainTheme = theme;
		this.mainFrame = new JFrame();
		this.mainFrame.setLayout(new FlowLayout());
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * Initializes a new Cool303Root with a given theme and window size x by y.
	 * @param theme A theme to be applied to all components
	 * @param sizeX	Horizontal window size in pixels
	 * @param sizeY	Vertical window size in pixels
	 */
	public Cool303Root(Cool303Theme theme, int sizeX, int sizeY) {
		this.mainTheme = theme;
		this.mainFrame = new JFrame();
		this.mainFrame.setPreferredSize(new Dimension(sizeX,sizeY));
		//this.mainFrame.setLayout(new Flowlay());
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Applies the theme to all components being held
	 * Only called when the user wishes to show the gui
	 */
	private void applyTheme() {
		this.container.applyTheme(mainTheme);
	}

	/**
	 * Adds a container of components. This overwrites any previously added Cool303Container's
	 * @param container Cool303Container that houses Cool303Components
	 */
	public void addContainer(Cool303Container container) {
		this.container = container;
	}
			
	/**
	 * Changes the theme for this object
	 * @param theme Cool303Theme to be set to all objects
	 */
	public void changeTheme(Cool303Theme theme){
		this.mainTheme = theme;
		
	}
	/**
	 * Launches a GUI of the users added containers and components
	 */
	public void launch() {
		if(this.container == null) {
			throw new NullPointerException("Container not found");
		}
		else {
			applyTheme();
			Cool303Clone cloneContainer = container.getSwingObject();
			JComponent clonePanel = cloneContainer.getClone();
			mainFrame.add(clonePanel);
			mainFrame.pack();
			this.mainFrame.setVisible(true);
		}
	}	
}
