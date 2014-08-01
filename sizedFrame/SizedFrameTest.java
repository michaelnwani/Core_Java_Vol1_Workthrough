package sizedFrame;

import java.awt.*;
import javax.swing.*;

public class SizedFrameTest 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SizedFrame extends JFrame
{
	public SizedFrame()
	{
		//get screen dimensions
		
		/*The Toolkit is a dumping ground class 
		 * for using methods to gather information a
		 * bout the current (native) windowing system*/
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//set frame width, height and let platform pick screen location
		//these are JFrame (Component class) methods
		setSize(screenHeight / 2, screenWidth / 2 );
		setLocationByPlatform(true);
		
		//set frame icon
		//the icon.gif didn't appear even with the source code v1ch07
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
		
	}
}
