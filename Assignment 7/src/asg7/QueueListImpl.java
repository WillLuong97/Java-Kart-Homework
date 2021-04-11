package asg7;

public class QueueListImpl<T> implements QueueList<T>
{
	private Node<T> first;
	private	Node<T> last;
	private int count;
	private int maxSize;
	
	//default constructor
	public QueueListImpl()
	{
		this.maxSize = DEFAULT_MAX_SIZE;
		this.count = 0;
		this.first = null;
		this.last = null;

	}// end of default constructor.
	
	//second default constructor.
	public QueueListImpl(int aMaxSize)
	{
		if(aMaxSize < 0 || aMaxSize > LARGEST)
		{
			maxSize = DEFAULT_MAX_SIZE;
		}
		
		else
		{
			maxSize = aMaxSize;
		}
		
	} //end of default constructor.
	
	//toString
	public String toString()
	{
		String retStr = "";
		
		for(Node<T>curr=this.first; curr != null; curr = curr.link)
		{
			retStr += curr.data + "\n";
		}
		
		return retStr;
	} //end of toString

	/** receives: nothing
	 *  task:  tests to see if this QueueList has 0 elements
	 *  returns: true if this QueueList is empty (has 0 elements) false otherwise;
	 */
	public boolean isEmpty() 
	{
		if(this.getSize() == 0)
		{
			return true;
		}
		return false;
	} //end of isEmpty().

	  /** receives: nothing
		 *  task:  tests to see if this QueueList has getMaxSize() elements
		 *  returns: true if this QueueList is full (has getMaxSize() elements) false otherwise;
		 */
	public boolean isFull() 
	{
		if(this.getSize() == this.getMaxSize())
		{
			return true;
		}
		
		return false;
	}//end of isFull().
	

	/** receives: nothing
	 * returns:  number of elements in this QueueList
	 */
	public int getSize() 
	{
		return this.count;

	} //end of getSize().
	

	  /** receives: nothing
		 * returns:  max allowable number of elements in this QueueList
		 */
	public int getMaxSize() 
	{
		return this.maxSize;

	} //end of getMaxSize().

	/** places item at the REAR of this QueueList
	 *receives: nothing
	 * returns: nothing
	 * task:  element is placed at the REAR or END of this QueueList if it is NOT full
	 *throws: RuntimeException if this QueueList is full
	 */
	public void add(T element) 
	{
		if(this.isFull())
		{
			throw new RuntimeException("Error! Cannot Add!");
		}
		
		Node<T>node = new Node<T>();
		node.data = element;
		node.link = null;
		if(last == null)
		{
			first = node;
			last = node;
		}
		else
		{
			last.link = node;
			last = node;
		}
		this.count++;
		
	} //end of add().

	/** receives: nothing
	   returns:  removes and returns the FRONT item from this QueueList if it is NOT empty
	 * @throws - RuntimeException if attempt to remove from an empty QueueList
	
	 */
	public T remove() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Error! Cannot remove!");
		}
		//calling the first value in the list.
		T retVal = this.first.data;

		if(this.first == this.last) //check if there's only one value in the list.
		{
			this.first = null; 
			this.last = null;
			this.count = 0;
		}
		else
		{
			
			first = first.link;
			this.count--;
		}
		
		return retVal;
	} //end of remove().
	

	/** receives: nothing
	 * returns: the FRONT item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 */
	public T getFront() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Error! Empty Queue! Cannot show!");
			
		}
		
		return this.first.data;
	} //end of getFront().

	/** receives: nothing
	 * returns: the REAR (or last)  item from this QueueList if it is
	 *      not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 */
	public T getRear() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Error! Empty Queue! Cannot show!");
		}
		
		return this.last.data;

	}//end of getRear().
	

	/** receives: nothing
    task: removes all items from this QueueList making it empty.
    returns: nothing
 */
	public void clear() 
	{
		this.count = 0;
		this.first = null;
		this.last = null;
	} //end of clear().

}//end of QueueListImpl().
