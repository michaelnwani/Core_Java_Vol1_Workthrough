package dialog;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A sample modal dialog that displays a message and waits for the user to click the Ok button.
 * @author michaelnwani
 *
 */
public class AboutDialog extends JDialog 
{
	public AboutDialog(JFrame owner)
	{
		super(owner, "About DialogTest", false);
		
		//add HTML label to center
		add(
				new JLabel(
						"<html><h1><i>Core Java</i></h1><hr>By Michael Nwani</html>"), BorderLayout.CENTER);
		
		//Ok button closes the dialog
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}
		});
		
		//add Ok button to southern border
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		
		pack();
		
	}
}
