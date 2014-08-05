package applet;

import java.awt.*;
import javax.swing.*;

public class NotHelloWorld extends JApplet
{
	public void init() //use init() for applets, also destroy(), and start()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
				add(label);
			}
		});
	
	}
}
