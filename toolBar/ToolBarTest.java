package toolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBarTest 
{
	public static void main(String... args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new ToolBarFrame();
				frame.setTitle("ToolBar Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	
}

class ToolBarFrame extends JFrame
{
	public ToolBarFrame()
	{
		JToolBar bar = new JToolBar();
		bar.add(new JButton("Eh"));
		bar.setToolTipText("Weeeeee");
		
		add(bar, BorderLayout.NORTH);
		pack();
	}
}