package colorChooser;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ColorChooserFrame extends JFrame 
{
	public static void main(String... args)
	{
		JFrame frame = new JFrame();
		frame.add(new ColorChooserPanel());
		frame.setTitle("Color Chooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
