package asg7;
/**  implementation of the view of two different stack implementations
 *   modeled with a stack engine
 *  that models/uses two stacks and allows a few operations on those stacks
 *  @author: LJBaker
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StackQueueViewImpl extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton pushButton;
	JButton popButton;
	JButton clearStackButton;
	JButton frontButton;
	JButton addButton;
	JButton removeButton;
	JButton fullButton;
	//new button added to GUI.
	JButton peekButton;
	JButton getMaxSize;
	JButton checkIfEmpty;
	JButton getRear;
	JButton clearQueue;
	JButton checkQueueSize;
	
	
	JPanel stackButtonPanel ;
	JPanel queueButtonPanel;
	StackPanel stackPanel;
	QueuePanel queuePanel;
	StackEngine stackEngine;
	QueueEngine queueEngine;

	ChangeListener stackEngineListener;
	ChangeListener queueEngineListener;

	// default constructor, receives the stack engine model it is displaying and controlling
	public StackQueueViewImpl(StackEngine aStackEngine, QueueEngine aQueueEngine)
	{
		super();
		this.setPreferredSize(new Dimension(StackQueueFrame.FRAME_WIDTH-20, StackQueueFrame.FRAME_HEIGHT - 100));
		this.setLayout(new BorderLayout());
		this.stackEngine = aStackEngine;
		this.queueEngine = aQueueEngine;
		//create a "listener" for the stack engine, so if that engine changes, it can respond
		stackEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.stackEngine.addChangeListener(stackEngineListener); // add listener to stackEngine for notification
		queueEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		//create a "listener" for the queue engine, so if that engine changes, we can respond
		this.queueEngine.addChangeListener(queueEngineListener);
		init();
	}
	// initializes the view - all the widgets and listeners, sets up the view
	private void init() 
	{
		this.pushButton = new JButton("Push");
		this.popButton = new JButton("Pop");
		this.frontButton = new JButton("Get Front");
		this.addButton = new JButton("Add to Queue");
		//new button added to the GUI.
		this.removeButton = new JButton("Remove from Queue");
		this.peekButton = new JButton("Peek");
		this.clearStackButton = new JButton("Clear Stack");
		this.getRear = new JButton("Get Rear");
		this.clearQueue = new JButton("Clear the Queue!");
		this.checkQueueSize = new JButton("Check Queue Size!");
		

		this.fullButton = new JButton("Check Full(both)");
		this.getMaxSize = new JButton("Get Max Size(both)");
		this.checkIfEmpty = new JButton("Check If Empty(both)");
		
		this.stackPanel = new StackPanel(stackEngine);  // create a Stack Panel (view) and send it the engine it is "modeling"
		this.queuePanel = new QueuePanel(queueEngine);  // create a Queue Panel (view) and send it the engine it is "modeling"

		stackButtonPanel = new JPanel();		  // used to hold all stack operation buttons
		stackButtonPanel.setLayout(new GridLayout(2,4));  // 1 row of 6 (change as more or less buttons are used)
		stackButtonPanel.add(pushButton);			// now add buttons to the panel
		stackButtonPanel.add(popButton);
		stackButtonPanel.add(fullButton);
		//new button added to the GUI.
		stackButtonPanel.add(peekButton);
		stackButtonPanel.add(clearStackButton);
		stackButtonPanel.add(getMaxSize);
		stackButtonPanel.add(checkIfEmpty);

		queueButtonPanel = new JPanel();			// used to hold all queue operation buttons - currently 3 but more should be added
		queueButtonPanel.setLayout(new GridLayout(2,4));
		queueButtonPanel.add(addButton);
		queueButtonPanel.add(removeButton);
		queueButtonPanel.add(frontButton);
		queueButtonPanel.add(getRear);
		queueButtonPanel.add(clearQueue);
		queueButtonPanel.add(checkQueueSize);

	
		this.add(stackButtonPanel, BorderLayout.NORTH);  // this is the controller panel, add the stack button panel to the top across
		this.add(queuePanel,  BorderLayout.EAST);		  // add remaining components to this controller panel
		this.add(stackPanel, BorderLayout.WEST);
		this.add(queueButtonPanel,  BorderLayout.SOUTH);  // add queue button panel to the bottom

		pushButton.addActionListener(this); 
		popButton.addActionListener(this);
		peekButton.addActionListener(this);
		frontButton.addActionListener(this);
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		fullButton.addActionListener(this);
		checkIfEmpty.addActionListener(this);
		clearStackButton.addActionListener(this);
		getMaxSize.addActionListener(this);
		getRear.addActionListener(this);
		clearQueue.addActionListener(this);
		checkQueueSize.addActionListener(this);

	}
	//method called when an ChangeEvent is fired in the model
	// updates data on the view which will reflect any changes made to the model
	private void update() 
	{
		// repaint all models (engines)
		repaint();
	}

	// HANDLES all button actions, listeners for each button
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(pushButton))
		{  
			String item = JOptionPane.showInputDialog(this, "Enter value to push", "");
			if(item != null&& item.length() != 0)
				stackEngine.push(item);
		}
		else if (e.getSource().equals(popButton))
		{
			stackEngine.pop();  // note we popped the engine and it recovers the value popped	
		}

		else if (e.getSource().equals(addButton))
		{
			String item = JOptionPane.showInputDialog(this, "Enter value to add to queue:", "");
			if(item != null && item.length() != 0)
			     queueEngine.add(item);
		}
		else if (e.getSource().equals(removeButton))
		{
			queueEngine.remove();  // note we remove
		}
		else if (e.getSource().equals(frontButton))
		{
			queueEngine.showFront();
		}
		else if (e.getSource().equals(fullButton))
		{
			queueEngine.testFull();  
			stackEngine.testFull();
		}
		
		else if (e.getSource().equals(peekButton))
		{
			stackEngine.peek();
		}
		
		else if (e.getSource().equals(clearStackButton))
		{
			stackEngine.clear();

		}
		
		else if (e.getSource().equals(getMaxSize))
		{
			stackEngine.showMaxSize();
			queueEngine.showMaxSize();
		}
		
		else if (e.getSource().equals(checkIfEmpty))
		{
			stackEngine.testEmpty();
			queueEngine.testEmpty();
		}
		
		else if(e.getSource().equals(getRear))
		{
			queueEngine.showRear();
		}
		
		else if (e.getSource().equals(clearQueue))
		{
			queueEngine.clear();
		}
		
		else if (e.getSource().equals(checkQueueSize))
		{
			queueEngine.showSize();
		}
	
		//stackArea.setText(actionText);
	}

} // end of StackQueueViewImpl class


