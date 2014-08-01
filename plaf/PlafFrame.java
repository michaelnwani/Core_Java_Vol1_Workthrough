package plaf;
import java.awt.event.*;
import javax.swing.*;

public class PlafFrame extends JFrame
{
	private JPanel buttonPanel;
	public PlafFrame()
	{
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos)
		{
			makeButton(info.getName(), info.getClassName());
			add(buttonPanel);
			pack();
		}
	}
	
	public static void main(String... args)
	{
		JFrame frame = new PlafFrame();
		frame.setTitle("PlafFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Makes a button to change the pluggable look-and-feel
	 * @param name the button name
	 * @param plafName the name of the look-and-feel class
	 */
	
	void makeButton(String name, final String plafName)
	{
		//add button to panel
		
		JButton button = new JButton(name);
		buttonPanel.add(button);
		
		//set button action
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//button action: switch to the new look-and-feel
				try
				{
					
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
