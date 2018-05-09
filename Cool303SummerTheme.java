package JavaCool303;

import java.awt.*;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.border.Border; 

public class Cool303SummerTheme implements Cool303Theme {

	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setBackgroundColor() {
		return new Color(255,165,0);
	}	

	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setButtonColor() {
		return new Color(245,222,179);
	}
	
	/**
	  * {@inheritDoc}
	  */
	@Override
	public Border setButtonShape() {
		return null;
	}

	/**
	  * {@inheritDoc}
	  */
	@Override
	public Color setBoxColor() {
		return new Color(245,222,179);	}

	/**
	  * {@inheritDoc}
	  */
	@Override
	public Border setBoxShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
