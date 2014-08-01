package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class InnerClassTest 
{
	public static void main(String[] args)
	{
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		
		//Keep program running until user selects "Ok"
		JOptionPane.showMessageDialog(null, "Quit Program?", "Testing Inner Classes", JOptionPane.QUESTION_MESSAGE);
		System.exit(0);
	}
}

class TalkingClock
{
	private int interval;
	private boolean beep;
	
	/**
	 * Constructs a talking clock
	 * @param interval the interval between messages (in msecs)
	 * @param beep true if the clock should beep
	 */
	public TalkingClock(int interval, boolean beep)
	{
		this.interval = interval;
		this.beep = beep;
	}
	
	/**
	 * Starts the clock.
	 */
	public void start()
	{
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
