package housepetlist;
/** a typical node class for a linked list
 * single traditional linked list node
 * templated to hold any object-based type
 * @author LJBaker
 *
 * @param <T> the object based type stored in the node
 * all data is public as this is used internally by a linked list
 * never used in any public sense
 */

public class Node<T>
{
 // the attributes of a Node instance
 // public so we don't have to provide accessors/modifiers
    public T data; 
    public Node<T> link;

    //default constructor of a Node instance 
    public Node()
	{
	    this.data = null;
	    this.link = null;
	}//end of constructor

    // constructor that receives the data attribute to store in this instance
    public Node(T theData)
	{
	    this.data = theData;
	    this.link = null;
	}

    // constructor that receives the link attribute to store in this instance
    public Node(Node<T> theLink)
	{
	    this.data = null;
	    this.link = theLink;
	}

    //constructor that receives the data and the link attribute values to store in this instance
    public Node(T theData, Node<T> theLink)
	{
	    this.data = theData;
	    this.link = theLink;
	}

}//End of Node<T> public class. 