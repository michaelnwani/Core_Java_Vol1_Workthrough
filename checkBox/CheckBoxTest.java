package checkBox;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;

//Being a cunt
public class CheckBoxTest
{

	public static void main(String... args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new CheckBoxFrame();
				frame.setTitle("Eh");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class CheckBoxFrame extends JFrame
{
	//Fuck this

	private JPanel butterPanel;
	private JCheckBox bold;
	private JCheckBox italic;
	private JLabel stupidLabel;
	int mode = 0;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public CheckBoxFrame()
	{
		butterPanel = new JPanel();
		bold = new JCheckBox("Bold this bitch");
		italic = new JCheckBox("Italic this bitch");
		stupidLabel = new JLabel("Hello there");
		
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

		bold.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				if (bold.isEnabled()) mode += Font.BOLD;
				if (italic.isEnabled()) mode += Font.ITALIC;
				stupidLabel.setFont(new Font("Serif", mode, 18));
			}
		});
		
		
		
		
		
		butterPanel.add(stupidLabel);
		butterPanel.add(bold);
		butterPanel.add(italic);
		
		add(butterPanel);
		
		
	}
}
