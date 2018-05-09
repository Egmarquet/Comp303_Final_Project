package JavaCool303;

import java.util.LinkedList;
import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;

/**
 * A container of Cool303Components.
 * The container holds Components in a grid. The number of components that can be held is limited by the grid size - 1.
 * The dimensions of the grid are specified in the constructor
 * Cool303Components that are added are placed on the grid in a left to right, top to bottom ordering. 
 * @author Etienne Guillot-Marquet
 *
 */

public class Cool303Container implements Cool303Component{
		
	/**
	 *  The limit to the number of Cool303Components that Cool303Container can house
	 */
	private int componentLimit;
	/**
	 *  The current number of components that have been added
	 */
	private int numComponents;
	/**
	 *  The name of the component
	 */
	private String name;
	/**
	 *  The list of Cool303Components that have been added
	 */
	private LinkedList<Cool303Component> componentList;
	/**
	 *  The underlying JPanel swing component that houses other swing components
	 */
	private JPanel mainPanel;
	
	
	/**
	 * Cool303Container constructor.
	 * @param rows	Number of rows on the grid.
	 * @param collumns	Number of columns on the grid.
	 */
	public Cool303Container(int rows, int collumns) {
		this.numComponents = 0;
		this.componentLimit = rows * collumns - 1;
		componentList = new LinkedList<Cool303Component>();
		this.mainPanel = new JPanel();
		GridLayout layout = new GridLayout(rows, collumns);
		layout.setHgap(20);
		layout.setVgap(20);
		mainPanel.setLayout(layout);
	}
	
	/**
	 * The name of the container. If specified, the name will appear on the top left corner of the container. 
	 * @param name The name of the container.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds a Cool303Component to the container.
	 * @param component A Cool303Component.
	 * @throws LimitExceededException Throws exception if more Cool303Components are added then this container can fit.
	 */
	public void add(Cool303Component component) throws LimitExceededException{
		if(this.numComponents < componentLimit) {
			this.componentList.add(component);
			this.numComponents++;
		}
		
		else {
			throw new LimitExceededException("Component Limit Exceeded");
		}
	}
		
	/* 
	 * Packs the underlying swing components of the Cool303Components, then returns a clone of the underlying JPanel of this container.
	 * @see JavaCool303.Cool303Component#getSwingObject()
	 * @return Cool303Clone Returns a clone of the underlying JPanel that houses other components.
	 */
	@Override
	public Cool303Clone getSwingObject() {
		Cool303Clone cloner; 
		//Add the name to the top left if specified
		if(this.name != null) {
			this.mainPanel.add(new JLabel(this.name));
		}
		//Get all underlying swing objects and add them to the JPanel 
		for(Cool303Component component : this.componentList) {
			cloner = component.getSwingObject();
			this.mainPanel.add(cloner.getClone());
		}
		//Return a Cool303Clone that houses the JPanel containing all swing representations of Cool303Components
		cloner = new Cool303Clone(this.mainPanel);	
		return cloner;
	}

	/* 
	 * Applies a Theme to this container and all Cool303Components being held.
	 * @see JavaCool303.Cool303Component#applyTheme(JavaCool303.Cool303Theme)
	 */
	@Override
	public void applyTheme(Cool303Theme theme) {
		this.mainPanel.setBackground(theme.setBackgroundColor());
		for(Cool303Component component : this.componentList) {
			component.applyTheme(theme);
		}
	}
}
