package JavaCool303;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.border.Border;

/**
 * Pastel theme for Cool303Components. Uses pastel colors and round border shapes
 * @author Etienne Guillot-Marquet
 *
 */
public class Cool303PastelTheme implements Cool303Theme {

	private static class RoundBorder implements Serializable, Border {

	    public RoundBorder() {}

		@Override
		public Insets getBorderInsets(Component arg0) {
			return new Insets(10,10,10,10);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawOval(x, y, width, height);			
		}
		
	}

	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setBackgroundColor() {
		return new Color(255,248,220);
	}
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setBoxColor() {
		return new Color(255,182,193);
	}
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Border setBoxShape() {
		return new RoundBorder();	
	}
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setButtonColor() {
		return new Color(255,182,193);
	}
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Border setButtonShape() {
		return new RoundBorder();	
	}
}
