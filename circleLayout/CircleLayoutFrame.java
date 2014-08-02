package circleLayout;

import java.awt.*;

import javax.swing.*;

public class CircleLayoutFrame extends JFrame 
{
	
	public static void main(String... frame)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new CircleLayoutFrame();
				frame.setTitle("CircleLayoutFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public CircleLayoutFrame()
	{
		//the concept of a layout manager is that it's always listening and structuring its attached container
		setLayout(new CircleLayout());
		add(new Button("Yellow"));
		add(new Button("Blue"));
		add(new Button("Red"));
		add(new Button("Green"));
		add(new Button("Orange"));
		add(new Button("Fuchsia"));
		add(new Button("Indigo"));
		
		pack();
		
		
	}
	
}
