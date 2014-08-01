package mouse;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * A frame containing a panel for testing mouse motions
 * @author michaelnwani
 *
 */
public class MouseFrame extends JFrame 
{
	public MouseFrame()
	{
		add(new MouseComponent());
		pack();
	}
	
	public static void main(String... args)
	{
		JFrame frame = new MouseFrame();
		frame.setTitle("Awesome examples of Mouse Movement");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
