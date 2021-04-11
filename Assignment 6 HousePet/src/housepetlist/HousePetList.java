package housepetlist;

import housepet.HousePet;

public interface HousePetList {
	
	// an interface (set of method DECLARATIONS ONLY) that describe methods to that CAN be used with a HousePetList instance.

		// a constant in Java that states max number of pets allowed in the list at any given time
		public static final int MAX_PETS = 10;

		// returns number of HousePets in the current HousePetList instance
		public int getSize();

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
		public String getPetsByAge(int aAge);
		

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
		public boolean add(HousePet	housePet);

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
		public HousePet get(int position);

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
		public int find(HousePet housePet);


		// receives: nothing
		// returns: a String containing a list 1 HousePet per line
		//      that is an instance of a Cat
		//      returns an EMPTY String if NO cats are in the list
		//	    Example use:		
		public String getAllCats();

		// receives: nothing
		// returns: a String containing a list (1 pet per line) of every dog in the current list
		//      returns an EMPTY String if NO dogs are in the list
		//    Example use:
		public String getAllDogs();
		
		// receives: nothing
		// returns: a String containing a list (1 pet per line) of every bird in the current list
		//      returns an EMPTY String if NO birds are in the list
		//    Example use:
		public String getAllBirds();

		// receives: a pet's name (String)
		// returns: a String containing a list (1 pet per line) of house pets
		//      with name matching  received (case in-sensitive) String
		//      if no matches exist, returns empty string
		//  Example use:
		public String getHousePetsWithMatchingName(String aName);


		// receives: a HousePet instance, not null
		// returns:   a HousePet instance  in this list that is found that MATCHES the
		//      received house pet instance (assume equals is overloaded for HousePet)
		//      the HousePet instance in the list that matched received house pet is removed
		//       from this list AND RETURNED.
		//       If no HousePet instance is found that matches received house pet
		//       then null is RETURNED
		//    Example use:
		
		public HousePet remove(HousePet housePet);

		// receives: nothing
		// returns: nothing
		// task:  this HousePetList instance is cleared of all pets.
		//        size of list is 0 when completed.
		public void clear();

}
