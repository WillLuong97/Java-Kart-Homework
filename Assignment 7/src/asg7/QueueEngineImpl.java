package asg7;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class QueueEngineImpl implements QueueEngine 
{

	private QueueList <String> queue;
	private String actionText;
	private EventListenerList eventListenerList;
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);

	//default constructor that sets the maxSize of the model queue to DEFAULT_MAX_SIZE from interface
	public QueueEngineImpl()
	{
		this.queue = new QueueListImpl<String>(QueueEngine.DEFAULT_MAX_SIZE);
		this.eventListenerList = new EventListenerList();  // create the listener list so we can add listeners to the model
		this.actionText = "Queue is EMPTY";
	}
	// constructor that receives a maxSize for the queue model
	public QueueEngineImpl(int maxSize)
	{
		this.queue = new QueueListImpl<String>(maxSize);

		this.eventListenerList = new EventListenerList();  // create the listener list so we can add listeners to the model
		this.actionText = "Queue is EMPTY";
	}

	//as expected, override of toString() so that we can see the current engine's status
	public String toString()
	{
		return this.queue.toString();
	}

	//pre: none
	// post: current queue has 1 or more element on it if it is not full
	//       if current stack is full, no changes made, sets actionText appropriately
	public void add(String element)
	{
		if(queue.isFull())
		{
			this.actionText = "Queue is Full NO room to ADD";

		}
		else
		{
			this.actionText = "ADDED: " + element;
			this.queue.add(element);
		}
		this.fireChangeEvent(CHANGE_EVENT);

	}
	@Override
	public void remove() 
	{
		if(queue.isEmpty())
			actionText = "EMPTY Queue  NO REMOVE";
		else
		{
			String result = queue.remove();
			actionText = "REMOVE: " + result;
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}

	// pre: none
	// post:  current Queue is popped and value returned, if stack is empty no pop occurs and actionText states that
	//        otherwise actionText contains result of pop and current stack contents
	public void  showFront()
	{
		if(this.queue.isEmpty())
		{
			this.actionText = "EMPTY Queue NO FRONT";
		}
		else
		{
			String front = this.queue.getFront();
			this.actionText = "FRONT: " + front;
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}


	public int getSize()
	{
		return this.queue.getSize();
	}
	//pre: none
	// post: returns max size for current stack 
	public void showSize()
	{
		if(this.queue.isEmpty())
		{
			this.actionText = "Empty Queue!";
			
		}
		
		else
		{
			int size = this.queue.getSize();
			this.actionText = "Queue Size: " + size;
			
		}
	

		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre: none
	// post: returns max size for current stack 
	public void showMaxSize()
	{
		
			int max = this.queue.getMaxSize();
			this.actionText = "Queue Max: " + max;
					
		this.fireChangeEvent(CHANGE_EVENT);
	}
	
	public int getMaxSize()
	{
		return this.queue.getMaxSize();
	}

	// pre: none
	// post:  front (or first) item in Queue returned, if queue is empty actionText states that
	//        otherwise actionText contains result of peek and current stack contents
	public void showRear() 
	{
		if(this.queue.isEmpty())
		{
			this.actionText = "Empty Queue! No Rear!";

		}
		
		else
		{
			String rear = this.queue.getRear();
			this.actionText = "REAR: " + rear;
		}

		this.fireChangeEvent(CHANGE_EVENT);
	}
	
	//pre:  none
	//post: returns true if the current stack is empty false if its not.
	public void testEmpty()
	{
		if (this.queue.isEmpty())
		{
			this.actionText = "Queue is EMPTY";
		}
		else
		{
			this.actionText =  "Queue is NOT EMPTY";
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre:  none
	//post: returns true if the current stack is full false if its not.
	public void testFull()
	{
		if(queue.getSize() ==  DEFAULT_MAX_SIZE)
		{
			actionText = "The queue is full";
			
		}
		
		else
		{
			actionText = "The queue is not full";
		}

		this.fireChangeEvent(CHANGE_EVENT);			
	}
	// pre: none
	// post: current stack is empty
	public void clear()
	{
		this.queue.clear();
		actionText = "The queue is empty!";
		

		this.fireChangeEvent(CHANGE_EVENT);
	}
	public String getActionText()
	{
		return this.actionText;
	}
	//standard boilerplate method for change events
	public void addChangeListener(ChangeListener changeListener)
	{
		eventListenerList.add(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	public void removeChangeListener(ChangeListener changeListener)
	{
		eventListenerList.remove(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	// used when we need to notify the view that a change to the model has taken place
	// so that the view can update itself.
	public void fireChangeEvent(ChangeEvent changeEvent) {
		// Guaranteed to return a non-null array
		Object[] listeners = eventListenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) 
		{
			if (listeners[i]==ChangeListener.class) 
			{
				((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
			}
		}

	}

}// end of QueueEngineImpl.java


