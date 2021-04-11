package asg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankAccountListImpl implements BankAccountList
{
	private BankAccount [] array; 
	private int count = 0; 
	
	//Default constructor. 
	//Recieves: nothing. 
	//Return: nothing 
	//Task: initialize the array and its size. 
	public BankAccountListImpl() 
	{
		this.array = new BankAccount[BankAccountList.MAX_SIZE];
		this.count = 0;
	} //End of default constructor. 
	
	// receives a fileName of type string
	// return: nothing
	// task: create a Scanner that can read from the fileName. Read through the content of this scanner. Initialize all private data. Create Scanner with given fileName
	//read bank account from scanner, populate array(hint: use add()). Use BankAccountUtilsImpl.readFromScanner(). 
	// while more data on input file. (the loop?)
	//		read 1 BankAccount
	//		if(BankAccount is not null)
	//			add that BankAccount to this instance. 
	//	end while (when there is no more data to read). 
	public BankAccountListImpl(String fileName)
	{
		
		this.array = new BankAccount[BankAccountList.MAX_SIZE];
		this.count = 0;

		Scanner inFile = null; 
		try
		{
			inFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e)
		{
			System.out.println("Cannot open file : " +fileName + "return");
			return; 
		}
		
		while(inFile.hasNext())
		{
			BankAccount act = BankAccountUtilsImpl.readFromScanner(inFile);
			if (act != null) 
			{
				this.add(act);
				
			}
		} // End of while loop. 
		
		inFile.close();
		
	} //end of BankAccountListImple(String filename). 
	
	
	//Return: nothing
	//Receives: nothing
	//Tasks: make sure that the return values are always a string. 
	public String toString()
	{
		String retValue = ""; 
		for(int i = 0; i < this.count; i++)
		{
			retValue += array[i] + "\n";
		}
		return retValue; 
	} //End of toString method. 

	
	//receives: nothing
	// returns: number of BankAccounts currently in the list
	//  Example use
	//  BankAccountList list = new BankAccountListImpl();  // create empty list
	//   assertTrue(list.getSize() == 0);   // size should be 0
	//  boolean result = list.add(new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL));
    //  assertTrue(list.getSize() == 1);

	public int getSize() 
	{
		return this.count;
		
	} //End of getSize. 

	
	// receives: a BankAccount instance that is NOT null
	// returns:  true if received bankaccount matches any bankaccount in this list, 
    //          assumes equals is overloaded in BankAccount class 
	//          returns false if received bankaccount is not currently in this list

	public boolean contains(BankAccount bankaccount) 
	{
		for (int index = 0; index < count; index++)
		{
			if(array[index].equals(bankaccount))
			{
				return true;
			}
		}
		return false; 
	} // end of contains method. 
	

	//receives: a BankAccount instance that is NOT null
	//task:   bankaccount is added to this list if not already contained in this list
	//      (bank accounts must be unique for each account number)
	//returns:  true if bankaccount was added, false if no room in the list or duplicate
	//      bankaccount is found in the list
	//      a bankaccount is a duplicate if it has the same account number for our purposes
	//      Example use:
	//        BankAccountList list = new BankAccountListImpl();
	//        boolean result = list.add(new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL));
	//        assertTrue(result == true);

	public boolean add(BankAccount bankaccount) 
	{
		if(this.getSize() == BankAccountList.MAX_SIZE)
		{
			return false; 
		}
		
		int location = this.find(bankaccount);
		if(location!= -1) 
		{
			return false; 
			
		}
		
		this.array[count] = bankaccount;
		this.count++; 
		
		return true; 
	} //end of add method. 

	// receives: a positon (int) in this bank account list
	// returns: the bankaccount in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first bank account in the list
	//       returns null if received position is out of range (0 to less than size of list.)
	//  Example use:
	//        BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	// 		  BankAccount b1 = list.get(0);
	//        assertTrue(b1.equals(b2));
	public BankAccount get(int position) 
	{
		if(position >= 0 && position < count)
		{
			return array[position];
		}
		
		return null; 
	} //end of get(). 

	
	// receives: a BankAccount instance (not null)
	// returns:  the position of received bankaccount in the list (0 based positioning)
	//       (uses overloaded equals when matching)
	//       returns -1 if received bankaccount is not found in current list at any position
	//        BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	//		  int position = list2.find(b2);
	//	      assertTrue(position == 0);
	public int find(BankAccount bankaccount) {
		for(int index = 0; index < count; index++)
		{
			if(array[index].equals(bankaccount)) 
			{ 
				return index; 
				
			}
		}
		
		return -1; 
	}//end of find(). 

	// receives: nothing
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//      that have a balance below 0.0
	//      returns an EMPTY String if NO bank accounts have a balance less than 0.0
	//	    Example use:
	//	    BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	//        assertTrue(result == true);
	// 		String list1 = list.getBankAccountsDeficient();
	//      assertTrue(list1.equals(""));
	public String getBankAccountsDeficient() 
	{
		String accountDef = ""; 
		for(int index = 0; index < count; index++)
		{
			if(array[index].getBalance() < 0.0)
			{
				accountDef += array[index] + "\n"; 
				
			}
		}
		return accountDef;
	} //end of getBankAccountsDefficiency().

	// receives: aAccountType, a bank account type
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//       that are of the received account type.
	//    Example use:
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 		String list1 = list.getBankAccountsWithAccountType(AccountType.CHECKING);
	//      assertTrue(MyUtils.numberLines(list1) == 1);
	public String getBankAccountsWithAccountType(AccountType aAccountType) 
	{ 
		String type = ""; 
		for (int i = 0; i < count; i++)
		{
			if(array[i].getAccountType().equals(aAccountType))
			{
				type += array[i] + "\n"; 
			}
		}

		return type;
	} // end of getBankAccountsWithAccountType(). 

	// receives: a last name (String)
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//      with name matching  received (case in-sensitive) String
	//      if no matches exist, returns empty string
        //  Example use:
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 		String accountNames = list.getBankAccountsWithMatchingLastName("GARCIA");
	//      assertTrue(MyUtils.numberLines(accountNames) == 1);

	public String getBankAccountsWithMatchingLastName(String aName) 
	{
		aName = utils.MyUtils.properFormat(aName);
		String matchName = ""; 
		
		for(int index = 0; index < count; index++)
		{
			if(array[index].getLastName().equals(aName))
			{
				matchName += array[index] + "\n";
			}
		}
		
		return matchName; 
		
	}// End of getBankAccountsWithMatchingLastName(). 

	// receives: nothing
	// returns: nothing
        // task:   this BankAccountList is sorted by account number from lowest to highest (alphabetically)
	//  Example use (give 2 more):
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
        //      BankAccount b3 = new BankAccount("ddKK33"," ROGERS MetCALF","Mary Louise ",0.0,AccountType.SAVINGS, BusinessType.PERSONAL); 
        //      boolean result = list.add(b3);
	//      assertTrue(result == true);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 	list.sort();
	//      System.out.println("here is the sorted list:\n" + list);  // should be in appropriate order smallest acct number to largest
	//       should output: 1122aa  Garcia, Joey 0.0 CHECKING -- PERSONAL
	//                      ddkk33  Rogers Metcalf, Mary Louise  0.0 SAVINGS -- PERSONAL
	public void sort() 
	{
		for(int index = 0; index < count; index++)
		{
			int min = index; 
			for(int k = index + 1; k < count; k++)
			{
				if(array[k].getAccountNumber().compareTo(array[min].getAccountNumber()) < 0)
				{
					min = k; 
					
				}
				
			} // end for k. 
			
			BankAccount temp = array[index]; 
			array[index] = array[min]; 
			array[min] = temp; 
		} // end for index. 
	} //End of sort(). 

	
	// receives: a BankAccount instance, not null
  	// returns:   a BankAccount instance  in this list that is found that MATCHES the
	//      received bankaccount (assume equals is overloaded for BankAccount)
	//      the BankAccount instance in the list that matched received bankaccount is removed
	//       from this list AND RETURNED.
	//       If no BankAccount instance is found that matches received bankaccount
	//       then null is RETURNED
        //    Example use:
        //      BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
        //     a BankAccount b3 = new BankAccount("ddKK33"," ROGERS MetCALF","Mary Louise ",0.0,AccountType.SAVINGS, BusinessType.PERSONAL);
	//      boolean result = list.add(b3);
	//      assertTrue(result == true);
        //      boolean result = list.add(b2);
        //      assertTrue(result == true);
        //      assertTrue(list.getSize() ==2);
        //      BankAccount remAct = list.remove(b2);
        //      assertTrue(remAct.equals(b2));
        //      assertTrue(list.getSize() == 1);
        //     Example use #2:
        //        remAct = list.remove(b2);
        //        assertTrue(remAct == null);
	public BankAccount remove(BankAccount bankaccount) 
	{
		int location = this.find(bankaccount);
		if(location == -1)
		{
			return null; //if no match. 
		}
		
		BankAccount remAccount = array[location]; 
		array[location] = array[count - 1]; 
		count --; 
		
		return remAccount; 
	} //End of remove(). 

    // receives: nothing
    // returns: nothing
    // task:  this BankAccountList instance is made to be empty
    //        clear out all bank accounts from this instance

	public void clear() 
	{
		count = 0; 
	} //End of clear(). 
	
	

} //End of BankAccountListImpl. 
