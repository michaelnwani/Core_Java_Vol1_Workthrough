package text;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TextComponentFrame extends JFrame
{
	public static final int TEXTAREA_ROWS = 8;
	public static final int TEXTAREA_COLUMNS = 40;
	
	public TextComponentFrame()
	{
		//by default, they're editable
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("User Name: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		add(northPanel, BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane, BorderLayout.CENTER);
		
		//add button to append text into the text area
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				textArea.append("User name: " + textField.getText() + " Password: " + new String(passwordField.getPassword()) + "\n");
			}
		});
		
		add(southPanel, BorderLayout.SOUTH);
		pack();
	}
	
	public static void main(String... args)
	{
		JFrame frame = new TextComponentFrame();
		frame.setTitle("Testing TextFields, TextAreas, and PasswordFields");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	

}
