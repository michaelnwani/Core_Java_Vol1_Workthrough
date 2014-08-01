package timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
//to resolve conflict with java.util.Timer

public class TimerTest 
{
	public static void main(String[] args)
	{
		ActionListener listener = new TimePrinter();
		
		//construct a timer that calls the listener
		//once every 10 seconds
		Timer t = new Timer(1000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?", "Timer Test", JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}
}

class TimePrinter implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		Date now = new Date();
		System.out.println("At the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();
	}
}
