package slider;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * A frame with many sliders and a text field to show slider values
 * @author michaelnwani
 *
 */
public class SliderFrame extends JFrame
{
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public static void main(String... args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new SliderFrame();
				frame.setTitle("Slider Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public SliderFrame()
	{
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		//common listener for all sliders
		listener = new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
				
				
			}
			
		};
		
		//add a plain slider
		JSlider slider = new JSlider();
		addSlider(slider, "Plain");
		
		//Apparently re-assigning an object to a different location in memory like this doesn't cause any issues. cool.
		
		//add a slider with major and minor ticks
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		
		//add a slider that snaps to ticks
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap to ticks");
		
		//add a slider with no track
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "No track");
		
		//add an inverted slider
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		
		//add a slider with numeric labels
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");
		
		
		//add a slider with alphabetic labels
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom labels");
		
		//add a slider with icon labels
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		labelTable = new Hashtable<Integer, Component>(); //same here...
		labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon labels");
		
		//add the text field that displays the slider value
		textField = new JTextField();
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		pack();
	}
	
	public void addSlider(JSlider s, String description)
	{
		//a panel is created for each slider and jlabel together.
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = sliderPanel.getComponentCount();
		gbc.anchor = GridBagConstraints.WEST;
		sliderPanel.add(panel, gbc);
	}
}
