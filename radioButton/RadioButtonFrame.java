package radioButton;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * A frame with a sample text label and radio buttons for selecting font sizes
 * @author michaelnwani
 *
 */
public class RadioButtonFrame extends JFrame
{
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;
	
	public static void main(String... args) //it doesn't think it contains a main method unless you include 'static'
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new RadioButtonFrame();
				frame.setTitle("Please Work");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public RadioButtonFrame()
	{
		//add the sample text label
		label = new JLabel("The quick brown fox jumps over the lazy dog");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		//add the radio buttons
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra large", 36); //it started as extra large because selected = true because 36 == default_size
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
	}
	
	/**
	 * Adds a radio button that sets the font size of the sample text.
	 * @param name the string to appear on the button
	 * @param size the font size that this button sets
	 */
	public void addRadioButton(String name,final int size)
	{
		boolean selected = size == DEFAULT_SIZE; //selected = (size == DEFAULT_SIZE)
		JRadioButton button = new JRadioButton(name, selected); //so just have a default selection...
		group.add(button); //ButtonGroup does nothing but behind-the-scenes link the buttons. It can't display them.
		buttonPanel.add(button);
		
		//this listener sets the label font size
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//size refers to the final parameter of the addRadioButton method
				label.setFont(new Font("Serif", Font.PLAIN, size));
			}
		}; //needs a semicolon for some reason...
		
		button.addActionListener(listener);
	}
}
