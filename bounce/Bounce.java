package bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows an animated bouncing ball.
 * @author michaelnwani
 *
 */
public class Bounce 
{
	public static void main(String... args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * The frame with ball component and buttons
 * @author michaelnwani
 *
 */
class BounceFrame extends JFrame
{
	private BallComponent comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	/**
	 * Constructs the frame with the component for showing the bouncing ball and Start and Close buttons
	 */
	public BounceFrame()
	{
		setTitle("Bounce");
		
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				addBall();
			}
		});
		
		addButton(buttonPanel, "Close", new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
	}
	
	/**
	 * Adds a button to a container.
	 * @param c the container
	 * @param title the button title
	 * @param listener the action listener for the button
	 */
	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	/**
	 * Adds a bouncing ball to the panel and makes it bounce 1,000 times
	 */
	public void addBall()
	{
		try
		{
			Ball ball = new Ball();
			comp.add(ball);
			
			for (int i = 1; i <= STEPS; i++)
			{
				ball.move(comp.getBounds()); //getBounds() is a Rectangle method that returns the height, width, and location of this component in the form of a Rectangle object
				comp.paint(comp.getGraphics()); //alternative to comp.repaint() (saying comp, re-paint your Graphics context) because otherwise it'd have to wait for the method to finish to redraw
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException e)
		{
			//
		}
	}
}
