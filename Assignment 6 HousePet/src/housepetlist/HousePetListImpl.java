package housepetlist;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import housepet.HousePet;

public class HousePetListImpl implements HousePetList
{

	private int count; 
	private Node<HousePet> first; //first attribute in the linked list.
	
	// default constructor.
	public HousePetListImpl()
	{
		this.count = 0; 
		this.first = null; 
	} //end of the default constructor.
	
	// receives a fileName of type string
	// return: nothing
	// task: create a Scanner that can read from the fileName. Read through the content of this scanner. Initialize all private data. Create Scanner with given fileName
	// read house pet from scanner, populate array(hint: use add()). Use HousePetListUtilsImpl.readFromScanner(). 
	// while more data on input file.
	//		read 1 HousePet
	//		if(HousePet  is not null)
	//			add that HousePet to this instance. 
	//	end while (when there is no more data to read). 
	public HousePetListImpl(String fileName)
	{
		this.first = null;
		this.count = 0;
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the file: "+fileName);
			
		}
		
		//sending the inFile to scanner. 
		HousePetListUtilsImpl.readFromScanner(inFile, this);
	} //end of HousePetListImpl(String fileName).
	
	//toString method overridden. 
	public String toString()
	{
		String retValue = ""; 
		for(Node<HousePet> curr = this.first; curr!=null; curr= curr.link)
		{
			retValue += curr.data +"\n"; 
			
		}
		
		return retValue;
	} //end of toString

	// returns number of HousePets in the current HousePetList instance
	public int getSize() 
	{
		return this.count;
		
	} //end of getSize()
	

	// returns a String containing each pet in current HousePetList instance that is the given age.
	// each pet is on a separate line
	// returns an empty String if no pets in the list match the given age.
	// example #1: 
	//   HousePetList myList = new HousePetListImpl();
	//   fileName = "housepetExtra.txt";
	//   myList.populateFromFile(fileName);
	//	 int age = 4;
	//	 String result = myList.getPetsByAge(age);
	//   System.out.println("Here are all of the pets at age " + age + ":\n" + result);
	public String getPetsByAge(int aAge) 
	{
		String catAge = "";
		
		for(Node<HousePet> curr = this.first; curr!= null; curr = curr.link)
		{
			if(curr.data.getAge() == aAge)
			{
				catAge += curr.data + "\n";
			}
			
		}
		return catAge; 

	} //end of getPetsByAge().
	

	//receives: a HousePet instance that is NOT null
	//task:   housePet  is added to this list if not already contained in this list
	//      (house pets must be unique for each chip id)
	//returns:  true if housePet  was added, false if no room in the list or duplicate
	//      housePet is found in the list
	//      a housePet is a duplicate if it has the same chip id for our purposes
	//      Example use:
	//        HousePetList list = new HousePetListImpl();
	//		  Dog dog= new Dog("rr43");
	//	      dog.setPetName("georgie");
	//		  dog.setBirthDate(new GregorianCalendar(2017, 3, 21));
	//        boolean result = list.add(dog);
	//        assertTrue(result == true);
	public boolean add(HousePet housePet) 
	{
		if(this.getSize() >= MAX_PETS)
		{
			return false; 
		}
		
		int index = this.find(housePet);
		if(index != -1)
		{
			return false; //already in the list.
		}
		
		Node<HousePet> node = new Node<HousePet>();
		node.data = housePet; //populate node with housePet. 
		Node<HousePet> curr = this.first; 
		Node<HousePet> prev = null; // trails current by 1 node. 
		while(curr!= null)
		{
			if(curr.data.getBirthDate().compareTo(housePet.getBirthDate()) > 0)
			{
				break;
			}
			
			prev = curr; 
			curr = curr.link;
			
		}
		
		if (prev == null)
		{
			node.link = this.first; 
			this.first = node;
			
		}
		
		else
		{
			node.link = prev.link;
			prev.link = node;
		}
		
		this.count++;
		return true;
	}  //end of add().

	
	// receives: a positon (int) in this house pet list
	// returns: the house pet instance in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first house pet in the list
	//       returns null if received position is out of range (0 to less than size of list.)
	//  Example use:
	//       HousePetList list = new HousePetListImpl();
	//        Dog dog= new Dog("rr43");
	//	      dog.setPetName("georgie");
	//		  dog.setBirthDate(new GregorianCalendar(2017, 3, 21));
	//		  list.add(dog);
	// 		  Dog foundDog = list.get(0);
	//        assertTrue(foundDog.equals(dog));
	public HousePet get(int position) 
	{
		if(position < 0 || position >= this.getSize())
		{
			return null; // out of range. 
		}
		
		int location = 0; 
		for (Node<HousePet> curr = this.first; curr!= null; curr = curr.link)
		{
			if(location == position)
			{
				return curr.data; 
				
			}
			
			location++;
		}
		
		return null;
	} //end of get().
	

	// receives: a HousePet instance (not null)
	// returns:  the position of received house pet in the list (0 based positioning)
	//       (uses overloaded equals when matching)
	//       returns -1 if received house pet is not found in current list at any position
	 //HousePetList list = new HousePetListImpl();
		//        Dog dog= new Dog("rr43");
		//	      dog.setPetName("georgie");
		//		  dog.setBirthDate(new GregorianCalendar(2017, 3, 21));
	// 		  list.add(dog);
	//		  int position = list2.find(dog);
	//	      assertTrue(position == 0);
	public int find(HousePet housePet) 
	{
		int position = 0; 
		//walk through the list.
		for(Node<HousePet> curr = this.first; curr!= null; curr = curr.link)
		{
			if(curr.data.equals(housePet))
			{
				return position;
			}
			
			position++;
		}
		return -1;
	}// end of find

	// receives: nothing
	// returns: a String containing a list 1 HousePet per line
	//      that is an instance of a Cat
	//      returns an EMPTY String if NO cats are in the list
	//	    Example use: 		
	public String getAllCats() 
	{
		String allCat = "";
		for (Node<HousePet> curr = this.first; curr!= null; curr = curr.link)
		{
			if(curr.data instanceof housepet.Cat) //check to see if the data is an instance of Cat()
			{
				allCat += curr.data +"\n";
			}
			
		}
		return allCat;
	} //end of getAllCats().

	// receives: nothing
	// returns: a String containing a list (1 pet per line) of every dog in the current list
	//      returns an EMPTY String if NO dogs are in the list
	public String getAllDogs() 
	{
		String getDog = "";
		for(Node<HousePet>curr = this.first; curr!= null; curr = curr.link)
		{ 
			if(curr.data instanceof housepet.Dog) //check for an instance of Dog().
			{
				getDog += curr.data + "\n";
				
			}
		}
		return getDog;
	} //end of getAllDogs().

	
	// receives: nothing
	// returns: a String containing a list (1 pet per line) of every bird in the current list
	//      returns an EMPTY String if NO birds are in the list
	//    Example use: 
	public String getAllBirds() 
	{
		String getBird = ""; 
		for(Node<HousePet>curr = this.first; curr!= null; curr = curr.link)
		{
			if(curr.data instanceof housepet.Bird)
			{
				getBird += curr.data + "\n";
			}
		}
		
		return getBird;
	} //end of getAllBirds().

	
	// receives: a pet's name (String)
	// returns: a String containing a list (1 pet per line) of house pets
	//      with name matching  received (case in-sensitive) String
	//      if no matches exist, returns empty string
	//  Example use: 
	//	HousePet list = new HousePetListImpl();
	//      HousePet b2 = new HousePet(" Tiny  Cat ", CatColor.TIGER, 250);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 		String catNames = list.getHousePetsWithMatchingName("  TINY   CAT   ");
	//      assertTrue(MyUtils.numberLines(catNames) == 1);
	public String getHousePetsWithMatchingName(String aName) 
	{
		aName = utils.MyUtils.properFormat(aName); 
		String matchName = "";
		
		for(Node<HousePet>curr = this.first; curr!= null; curr = curr.link)
		{
			if(curr.data.getPetName().equals(aName)) //check for the matching name
			{
				matchName += curr.data +"\n";
			}
		}
		
		return matchName;
	} //end of getHousePetsWithMatchingName().

	// receives: a HousePet instance, not null
	// returns:   a HousePet instance  in this list that is found that MATCHES the
	//      received house pet instance (assume equals is overloaded for HousePet)
	//      the HousePet instance in the list that matched received house pet is removed
	//       from this list AND RETURNED.
	//       If no HousePet instance is found that matches received house pet
	//       then null is RETURNED
	//    Example use: remCat = list.remove(b2);
	//					assertTrue(remCat == null);
	public HousePet remove(HousePet housePet) 
	{
		int location = this.find(housePet);
		
		if(location == -1)
		{
			return null; //if no match
			
		}
		
		
		Node<HousePet> curr = this.first;
		Node<HousePet> prev = null; //trails current by 1 node.
		
		while(curr!= null)
		{
			if(curr.data.equals(housePet))
			{
				break;
			}
			
			prev = curr;
			curr = curr.link; 
			
		} //end of while loop.
		
		if(prev == null)
		{
			this.first = curr.link;
			
		}
		
		else
		{
			prev.link = curr.link; 
			
		}
		
		this.count--;
		return housePet;
		
	} //end of remove().

	
	// receives: nothing
	// returns: nothing
	// task:  this HousePetList instance is cleared of all pets.
	//        size of list is 0 when completed.
	public void clear() 
	{
		this.first = null;
		this.count = 0;
		
	} //end of clear().
	

} //end of HousePetListImpl.java
