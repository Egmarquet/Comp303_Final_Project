package JavaCool303;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

/**
 * Cool303Button that acts as a JButton wrapper in the Cool303 package
 * @author Etienne Guillot-Marquet
 *
 */
public class Cool303Button implements Cool303Component {

	/**
	 *  Underlying swing component Jbutton
	 */
	private JButton mainButton;
	private int buttonNumber;
	
	/**
	 * Takes a button number as input. The number will be displayed on the button.
	 * @param buttonNumber The number to be displayed on the button
	 */
	public Cool303Button(int buttonNumber) {
		this.mainButton = new JButton();
		this.buttonNumber = buttonNumber;
		this.mainButton.setText(""+buttonNumber);	
		this.mainButton.addActionListener(new ButtonListener());
	}
	
	/**
	 * Private Serialized action listener
	 *
	 */
	private class ButtonListener implements ActionListener,Serializable{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}
	}
	/* 
	 * @see JavaCool303.Cool303Component#getSwingObject()
	 */
	@Override
	public Cool303Clone getSwingObject() {
		Cool303Clone clone = new Cool303Clone(this.mainButton);
		return clone;
	}

	/* Applies both shape and color to the button
	 * @see JavaCool303.Cool303Component#applyTheme(JavaCool303.Cool303Theme)
	 */
	@Override
	public void applyTheme(Cool303Theme theme) {
		this.mainButton.setBackground(theme.setButtonColor());
		this.mainButton.setBorder(theme.setButtonShape());
	}

}
