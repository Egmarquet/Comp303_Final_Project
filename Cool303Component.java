package JavaCool303;
import java.io.Serializable;

/**
 * Interface for all Cool303Components. All Cool303Components must be able to return the underlying swing objects they house
 * and be able to apply a theme to itself
 *  * @author Etienne Guillot-Marquet
 *
 */
public interface Cool303Component extends Serializable{

	/**
	 * Returns a clone of the swing object that is wrapped by the Cool303Component
	 * @return Cool303Clone Returns the cloned swing object
	 */
	public abstract Cool303Clone getSwingObject();
	/**
	 * Applies a theme to the component
	 * @param theme Cool303Theme A theme to be applied
	 */
	public abstract void applyTheme(Cool303Theme theme);
}
