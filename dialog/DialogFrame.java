package dialog;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * A frame with a menu whose File->About action shows a dialog.
 */
import optionDialog.OptionDialogFrame;

public class DialogFrame extends JFrame 
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private AboutDialog dialog;
	
	public static void main(String... args)
	{
		//this notation might be something unique to interfaces
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new DialogFrame();
				frame.setTitle("DialogFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	public DialogFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//Construct a File menu.
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Add About and Exit menu items.
		
		//The About item shows the About dialog.
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if (dialog == null) //first time
				{
					dialog = new AboutDialog(DialogFrame.this);
				}
				dialog.setVisible(true); //pop up dialog
					
			}
		});
		
		fileMenu.add(aboutItem);
		
		//The EXIT item exits the program.
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
	}
}
