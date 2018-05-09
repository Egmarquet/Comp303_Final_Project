package JavaCool303;
import java.awt.*;
import javax.swing.border.Border;

/**
 * Interface for Cool303Theme's
 * Cool303Theme methods output modifiers that can be applied to java objects
 * The developer can specify the colors and shapes applied to each Cool303Component
 * @author Etienne Guillot-Marquet
 *
 */
public interface Cool303Theme {
	
	/**
	 * @return Color User specified background color
	 */
	public Color setBackgroundColor();
	/**
	 * @return Color User specified box color
	 */
	public Color setBoxColor();
	/**
	 * @return Color User specified box border shape
	 */
	public Border setBoxShape();
	/**
	 * @return Color User specified button color
	 */
	public Color setButtonColor();
	/**
	 * @return Color User specified button border shape
	 */
	public Border setButtonShape();
}
