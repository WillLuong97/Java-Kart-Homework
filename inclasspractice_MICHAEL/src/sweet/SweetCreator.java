//Tri (Will) Luong
//Professor Micheals
//COSC 3336-01
//In-class practice
package sweet;

import java.util.*;

abstract class SweetProducer 
{
    public abstract void produceSweet();
    
    //this only works using "protected" type since it can still be accessed by other methods that are 
    //the descendant of SweetProducer()
    //"Private" would not work in this case because the data is locked into to the class and
    //cannot be accessible by other descended methods. 
    protected int total;

    public abstract void printTotal();
}

class CakeProducer extends SweetProducer 
{
	int count;
    @Override
    public void produceSweet() 
	{
        System.out.println("Cake produced");
        total++;
        count++;
    }

	@Override
	public void printTotal() 
	{
		System.out.println(total);
		
	}
	
}

class ChocolateProducer extends SweetProducer 
{
	int count;
    @Override
    public void produceSweet() 
	{
        System.out.println("Chocolate produced");
        total++;
        count++;

    }

	@Override
	public void printTotal() {
		System.out.println(total);
		
	}
}

class CookieProducer extends SweetProducer 
{
	int count;
    @Override
    public void produceSweet() 
	{
        System.out.println("Cookie produced");
        total++;
        count++;

    }
    
    //print method:
    public void myCookies()
    {
       System.out.println("All your cookies are belong to us!");
  	
    }

	@Override
	public void printTotal() {
		System.out.println(total);
		
	}

}

class SugarCookieProducer extends CookieProducer 
{
	int count;
    @Override
    public void produceSweet() 
	{
        System.out.println("Sugar Cookie produced");
        total++;
        count++;

    }
    
	public void printTotal() {
		System.out.println(total);
		
	}


}


class SweetCreator 
{
   //private sweetProducer;
	//container:
	private List<SweetProducer> sweetList = new ArrayList<SweetProducer>();
	
	//default constructor:
    public SweetCreator(List<SweetProducer> listOfSweet) 
	{
    	//Copying the data from the container into the new list.
    	sweetList.addAll(listOfSweet);
    }//end of sweetCreator()
    
    public void createSweets() 
	{
    	//iterating through the container:
    	for(int i = 0; i<sweetList.size(); i++) 
    	{
    		//extracting produceSweet() object
    		sweetList.get(i).produceSweet();
    		sweetList.get(i).printTotal();
    	}
    }//end of createSweets()
    
    //iterating through the collection, and if the current item is a CookieProducer, have it call myCookies.
    public void cookieIterator()
    {
    	//iterating through the collection/container:
    	for (int i = 0; i<sweetList.size(); i++)
    	{
    		//if the current item belongs to CookieProducer, it will call the 
    		//myCookie.
    		if(sweetList.get(i) instanceof sweet.CookieProducer)
    		{
    			
    			CookieProducer cookie = (CookieProducer)sweetList.get(i);
    			cookie.myCookies();
    		}
    	}
    }//end of cookieIterator().
    
	
}//end of SweetCreator().


class SweetCreatorTest 
{
	// Instead of String args[] here we use varargs to allow for 0 or more inputs
    public static void main(String... args) 
	{
		SweetProducer a = new CakeProducer();
		SweetProducer b = new ChocolateProducer();
		SweetProducer c = new CookieProducer();
		SweetProducer d = new SugarCookieProducer();
		a.produceSweet();
		b.produceSweet();
		c.produceSweet();
		d.produceSweet();
    }//end of main()
}