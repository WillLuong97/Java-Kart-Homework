package asg7;

public class StackListImpl<T> implements StackList<T>
{
	private Node<T> first;
	private int count;
	private int maxSize;
	
	//default constructor.
	public StackListImpl()
	{
		this.first = null;
		this.count = 0;
		this.maxSize = StackList.DEFAULT_MAX_SIZE;
	} //end of the default constructor.
	
	//default constructor.
	public StackListImpl(int aMaxSize)
	{
		if(aMaxSize < 0 || aMaxSize > StackList.LARGEST)
		{
			this.maxSize = StackList.DEFAULT_MAX_SIZE;
		}
		
		else
		{
			this.maxSize = aMaxSize;
		}
		
		this.first = null;
	} //end of StackListLinkedListImpl(int aMaxSize).
 
	   /**receives: nothing
     *  task:  tests to see if the Stack has 0 elements
     *  returns: true if this StackList is empty (has 0 elements) false otherwise;
  */
	public boolean isEmpty() 
	{
		if(this.count == 0)
		{
			return true;
			
		}
		return false;
	
	} // end of isEmpty().

	  /**receives: nothing
	   *  task:  tests to see if this StackList instance has getMaxSize() elements 
	   *  returns: true if this StackList is full (has getMaxSize() elements) false otherwise;
	*/
	public boolean isFull() 
	{ 
		if(this.getSize()==this.getMaxSize())
		{
			return true;
		}
		
		return false;

	} // end of isFull().

	/** receives: nothing
	 * returns: number of elements on this StackList (always <= to getMaxSize())
	 */
	public int getSize() 
	{
		return this.count;
	} //end of getSize()

	/** receives: nothing
	 * returns: max number of elements allowed on this StackList (always <= to getMaxSize())
	 */
	public int getMaxSize() 
	{
		return this.maxSize;
	}//end of getMaxSize().

	/** receives: element to place on top of this StackList
	 * task: received element is on top of this StackList instance if it is not full
	 * returns: nothing
	 *@throws RuntimeException if this StackList is full (has max size elements already)
	 */
	public void push(T element) 
	{
		if(this.isFull())
		{
			throw new RuntimeException("Full Stack! Cannot Push");
		}
		
		Node<T>curr = new Node<T>(element);
		curr.link = this.first; 
		this.first = curr;
		this.count++;
	} //end of push().

	/** receives: nothing
	   returns:  removes AND returns the top item from this StackList if  it is NOT empty. 
	 * @throws - RuntimeException if attempt to pop an empty StackList
	 */
	public T pop() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Empty Stack! Cannot Pop");
		}
		
		Node<T>curr = this.first;
		this.first = this.first.link;
		this.count--;
		
		return curr.data;
		
	}//end of pop().

	/** receives: nothing
	  *returns the top item from this StackList  if it is
	 *         not empty.  DOES NOT POP IT.
	 * @throws - RuntimeException if attempt to peek at an empty StackList instance
	 */
	public T peek() 
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Empty Stack! Cannot Peek");
		}
		
		return this.first.data;

	}//end of peek().

	/**receives: nothing
    returns: nothing
    task:  removes all items from this StackList, making it empty.
 */
	public void clear() 
	{
		this.first = null;
		this.count = 0;
				
	}//end of clear().
	
	
	//toString.
	public String toString()
	{
		String retValue = "";
		for(Node<T>curr = this.first; curr!=null; curr = curr.link)
		{
			retValue += curr.data + "\n";
			
		}
		
		return retValue;
	} //end of toString().

}//end of StackListImpl.java

