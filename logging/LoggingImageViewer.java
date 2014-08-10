package logging;

import java.awt.*;
import java.util.logging.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/**
 * A modification of the image viewer program that logs various events.
 * @author michaelnwani
 *
 */
public class LoggingImageViewer 
{
	public static void main(String... args)
	{
		if (System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null)
		{
			try
			{
				Logger.getLogger("welcome.logging").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
				Logger.getLogger("welcome.logging").addHandler(handler);
				
			}
			catch (IOException e)
			{
				Logger.getLogger("welcome.logging").log(Level.SEVERE, "Can't create log file hander", e);
			}
		}
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Handler windowHandler = new WindowHandler();
				windowHandler.setLevel(Level.ALL);
				Logger.getLogger("welcome.logging").addHandler(windowHandler);
				
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("LoggingImageViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				Logger.getLogger("window.logging").fine("Showing frame");
				frame.setVisible(true);
			}
		});
	}
}

/**
The frame that shows the image.
*/
class ImageViewerFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	private JLabel label;
	private static Logger logger = Logger.getLogger("welcome.logging");
	
	public ImageViewerFrame()
	{
		logger.entering("ImageViewerFrame", "<init>");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				logger.fine("Exiting.");
				System.exit(0);
			}
		});
		
		//use a label to display the images
		label = new JLabel();
		add(label);
		logger.exiting("ImageViewerFrame", "<init>"); //method's name was <init> huh...
	}
	
	private class FileOpenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);
			
			//set up file chooser
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			//accept all files ending with .gif
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
			{
				public boolean accept(File f)
				{
					return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
				}
				public String getDescription()
				{
					return "GIF Images";
				}
			});
			
			//show file chooser dialog
			int r = chooser.showOpenDialog(ImageViewerFrame.this);
			
			// if image file accepted, set it as icon of the label
			if (r == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath(); //we're not using a File object for getSelectedFile(), so we use getPath() to get a String of its path
				logger.log(Level.FINE, "Reading file {0}", name);
				label.setIcon(new ImageIcon(name));
			}
			else
			{
				logger.fine("File open dialog canceled.");
				logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
			}
		}
	}
}

/**
 * A handler for displaying log records in a window.
 */
class WindowHandler extends StreamHandler
{
	private JFrame frame;
	
	public WindowHandler()
	{
		frame = new JFrame();
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream()
		{
			public void write(int b)
			{
			}//not called
			
			public void write(byte[] b, int off, int len)
			{
				output.append(new String(b, off, len));
			}
		});
	}
	
	public void publish(LogRecord record)
	{
		if (!frame.isVisible()) return;
		super.publish(record);
		flush();
	}
}


