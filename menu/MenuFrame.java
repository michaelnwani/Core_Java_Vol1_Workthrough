package menu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 * A frame with a sample menu bar.
 * @author michaelnwani
 *
 */
public class MenuFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	/**
	 * A sample action that prints the action name to System.out
	 * @param args
	 */
	public static void main(String... args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new MenuFrame();
				frame.setTitle("Testing Menu's");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	class TestAction extends AbstractAction
	{
		public TestAction(String name)
		{
			super(name); //it's super is AbstractAction, and this matches the Action.NAME table slot
		}
		
		public void actionPerformed(ActionEvent event)
		{
			System.out.println(getValue(Action.NAME) + " selected.");
		}
	}
	
	public MenuFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));
		
		//demonstrate accelerators
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		fileMenu.addSeparator();
		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		fileMenu.addSeparator();
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit")
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		//demonstrate check box and radio button menu's
		readonlyItem = new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				boolean saveOk = !readonlyItem.isSelected(); //if read-only isn't set, it's ok to save.
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		//demonstrate icons
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		//demonstrate nested menus
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		//demonstrate mnemonics
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		//you cna also add the mnemonic key to an action
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		//add all top-level menus to menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		//demonstrate pop-ups
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		
		
		panel.setInheritsPopupMenu(true);
		add(panel);
		
		
		
		
		pack();
		
		//the following line is a workaround for bug 4966109
		panel.addMouseListener(new MouseAdapter() {});
		
	}
}
