package JavaCool303;

import javax.swing.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Cool303Clone creates and holds clones of JComponents.
 * All other objects being held by JComponents must be serializable
 * 
 * @author Etienne Guillot-Marquet
 *
 */
public class Cool303Clone implements Serializable{
	
	
	/**
	 * JComponent clone being held
	 */
	private JComponent jComponentClone;

	
	/**
	 * Initializes a new Cool303Clone holding a clone of the JComponent passed as an argument
	 * @param component The component to be cloned and stored
	 */
	public Cool303Clone(JComponent component) {
		setDeepClone(component);
	}
	
	/**Returns the JComponent clone being held
	 * @return JComponent A clone of a JComponent 
	 */
	public JComponent getClone() {
		return this.jComponentClone;
	}
	
	/**
	 * Called only by the constructor. Clones any serializable Java object via a ByteArray.
	 * @param component JComponent the user wishes to clone
	 */
	private void setDeepClone(JComponent component) {

		try {
			//Writes object to byte stream then re-casts the object back to a JComponent
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(component);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			this.jComponentClone = (JComponent) ois.readObject();
			
		}
		//Usually done if object being cloned is not serializable
		catch (IOException e) {
			System.out.println("IOexception");
			System.out.println(e.getMessage());
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			System.out.println(e.getMessage());
		}
	}
}
