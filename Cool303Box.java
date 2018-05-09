package JavaCool303;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

/**
 * Cool303Box is a blank rectangle that holds text. It acts as a JLabel wrapper in the Cool303 package
 * @author Etienne Guillot-Marquet
 *
 */
public class Cool303Box implements Cool303Component {

	/**
	 *  Underlying swing component JLabel
	 */
	private JLabel mainBox;
	
	/**
	 *  Instantiates a new Cool303Box without text 
	 */
	public Cool303Box() {
		this.mainBox = new JLabel();
	}
	
	/**
	 *  Instantiates a new Cool303Box with text
	 * @param text Text that is displayed within the box
	 */
	public Cool303Box(String text) {
		this.mainBox = new JLabel();
		setText(text);
	}

	/** Sets the text inside of the box
	 * @param text Text that is displayed within the box
	 */
	public void setText(String text) {
		this.mainBox.setText(text);
	}
	
	/* {@inheritDoc}
	 * @see JavaCool303.Cool303Component#getSwingObject()
	 */
	@Override
	public Cool303Clone getSwingObject() {
		Cool303Clone clone = new Cool303Clone(this.mainBox);
		return clone;
	}

	/* {@inheritDoc}
	 * @see JavaCool303.Cool303Component#applyTheme(JavaCool303.Cool303Theme)
	 */
	@Override
	public void applyTheme(Cool303Theme theme) {
		this.mainBox.setBorder(theme.setBoxShape());
		this.mainBox.setBackground(theme.setBoxColor());
	}

}
