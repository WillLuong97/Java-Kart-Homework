package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.Test;



	import asg5.AccountType;
	import asg5.BankAccount;
	import asg5.BankAccountList;
	import asg5.BankAccountListImpl;
	import asg5.BankAccountListUtilsImpl;
	import asg5.BusinessType;

	public class Asg5Test {

		
		@Test
		public void test()
		{  
			String sName = utils.MyUtils.getNameFromStudent();
			System.out.println("Begin Asg5 Testing for : " + sName);
			utils.MyUtils.printTimeStamp("BEGINS");
			testConstructorsAndtoString();
			testGetters();
			testContainsAndAdd();
			testGetFindAddRemoveSortMethods();
			testUtilsMethods();
			System.out.println("End of Asg5 Testing for : " + sName);
			utils.MyUtils.printTimeStamp("ENDS");
		}
		
		public void testConstructorsAndtoString() {
			System.out.println("\n***** testing constructors and getters *****");
			BankAccountList list1 = new BankAccountListImpl();
			BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
			BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
			BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");
		
			
			int expSize=0;
			int retSize=0;
			System.out.println("**** Testing getSize() **** ");
			retSize = list1.getSize();
			expSize=0;
			assertEquals(retSize, expSize);
			retSize = list2.getSize();
			expSize=1;
			assertEquals(expSize, retSize);
			retSize = list3.getSize();
			expSize=5;
			assertEquals(expSize, retSize);
			retSize = list4.getSize();
			expSize=15;
			assertEquals(expSize, retSize);
			
			String retString="";
		
			System.out.println("****Testing toString()****");
			System.out.println("Here is list1:  should be empty\n" + list1);
			expSize=0;
			retString = list1.toString();
			retSize=utils.MyUtils.numberLines(retString);
			assertEquals(expSize, retSize);
			System.out.println("Here is list2:  should have 1 account \n" + list2);
			expSize=1;
			retString = list2.toString();
			retSize=utils.MyUtils.numberLines(retString);
			assertEquals(expSize, retSize);
			System.out.println("Here is list3:  should have 5 accounts \n" + list3);
			expSize=5;
			retString = list3.toString();
			retSize=utils.MyUtils.numberLines(retString);
			assertEquals(expSize, retSize);
			System.out.println("Here is list4:  should have 15 (MAX_SIZE) accounts \n" + list4);
			expSize=15;
			retString = list4.toString();
			retSize=utils.MyUtils.numberLines(retString);
			assertEquals(expSize, retSize);
			
			System.out.println("**** End of testConstructorsAndtoString()****");
		}
		public void testGetters()
		{
			System.out.println("\n***** testing getters() *****");
			
			BankAccountList list1 = new BankAccountListImpl();
			BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
			BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
			BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");
			AccountType actualActType = AccountType.CHECKING;
			
			
			BankAccount b5 = new BankAccount();
			b5.setAccountNumber("300rre");
			
			String retString = "";
			String expString = "";
			String actString = "";
			
			System.out.println("****Testing getAccountsDeficient() ****");
			expString = list1.getBankAccountsDeficient();
			assertEquals(0, utils.MyUtils.numberLines(expString), "list1 should be an empty list");
			expString = list2.getBankAccountsDeficient();
			assertEquals(0, utils.MyUtils.numberLines(expString), "list2 should not have any deficient accounts ");
			expString = list3.getBankAccountsDeficient();
			System.out.println("Here are the deficient accounts in list3:\n" + expString);
			expString = list4.getBankAccountsDeficient();
			assertEquals(3, utils.MyUtils.numberLines(expString), "list4 should have 3 deficient accounts");
			System.out.println("Here are the deficient accounts in list4:\n" + expString);
			System.out.println("****Testing getBankAccountsDeficient()****");
		    retString = list1.getBankAccountsDeficient();
			assertEquals(0, utils.MyUtils.numberLines(retString));
			retString = list2.getBankAccountsDeficient();
			assertEquals(0, utils.MyUtils.numberLines(retString));
			retString = list3.getBankAccountsDeficient();
			assertEquals(1, utils.MyUtils.numberLines(retString));
			retString = list4.getBankAccountsDeficient();
			assertEquals(3, utils.MyUtils.numberLines(retString));
			
			System.out.println("****Testing getAccountsWithMatchingName() ****");
			actString = "GARcia";
			expString = list1.getBankAccountsWithMatchingLastName(actString);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list2.getBankAccountsWithMatchingLastName(actString);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list3.getBankAccountsWithMatchingLastName(actString);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list4.getBankAccountsWithMatchingLastName(actString);
			assertEquals(2, utils.MyUtils.numberLines(expString));
			actString = "   howard   ";
			expString = list1.getBankAccountsWithMatchingLastName(actString);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list2.getBankAccountsWithMatchingLastName(actString);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list3.getBankAccountsWithMatchingLastName(actString);
			assertEquals(1, utils.MyUtils.numberLines(expString));
			expString = list4.getBankAccountsWithMatchingLastName(actString);
			assertEquals(2, utils.MyUtils.numberLines(expString));

			System.out.println("****Testing getAccountsWithAccountType() ****");
			actualActType = AccountType.CHECKING;
			expString = list1.getBankAccountsWithAccountType(actualActType);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list2.getBankAccountsWithAccountType(actualActType);
			assertEquals(1, utils.MyUtils.numberLines(expString));
			expString = list3.getBankAccountsWithAccountType(actualActType);
			assertEquals(2, utils.MyUtils.numberLines(expString));
			expString = list4.getBankAccountsWithAccountType(actualActType);
			assertEquals(6, utils.MyUtils.numberLines(expString));
			actualActType = AccountType.SAVINGS;
			expString = list1.getBankAccountsWithAccountType(actualActType);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list2.getBankAccountsWithAccountType(actualActType);
			assertEquals(0, utils.MyUtils.numberLines(expString));
			expString = list3.getBankAccountsWithAccountType(actualActType);
			assertEquals(2, utils.MyUtils.numberLines(expString));
			expString = list4.getBankAccountsWithAccountType(actualActType);
			assertEquals(6, utils.MyUtils.numberLines(expString));	
			System.out.println("****End of testGetters()****");
		}
		
		public void testContainsAndAdd()
		{
			System.out.println("\n***** testing contains() and add() *****");
			BankAccountList list1 = new BankAccountListImpl();
			BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
			BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
			BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");
			
			BankAccount b1 = new BankAccount("jk3499", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
			BankAccount b2 = new BankAccount("mr34xv"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
			BankAccount b3 = new BankAccount("y200cs"," Jones", "linda marie  ", AccountType.SAVINGS, BusinessType.LLC, 1255.0);
			BankAccount b3New = new BankAccount("ge3343"," Anthony ", "linda marie  ", AccountType.SAVINGS, BusinessType.LLC, 1255.0);
			BankAccount b4 = new BankAccount("300rre", "martinez gOMEz",  "anna LISA  MaRIA", AccountType.CHECKING, BusinessType.CORPORATE, -300.00);
			BankAccount b5 = new BankAccount();
			b5.setAccountNumber("300rre");
			BankAccount b1Duplicate = new BankAccount("jk3499", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
			assertEquals(b1, b1Duplicate);
			assertEquals(b1Duplicate, b1);
			assertEquals(b1.hashCode(), b1Duplicate.hashCode());
			assertFalse(b5.hashCode()== b4.hashCode());
			assertFalse(b1.hashCode()== b4.hashCode());
			b1Duplicate.setAccountNumber(b2.getAccountNumber());
			b1Duplicate.setLastName(b2.getLastName());
			b1Duplicate.setFirstName(b2.getFirstName());
			b1Duplicate.setAccountType(b2.getAccountType());
			b1Duplicate.setBusinessType(b2.getBusinessType());
			assertEquals(b2, b1Duplicate);
			assertEquals(b1Duplicate,b2);
			System.out.println("Account b2 and b1Duplicate match: " + ((b2.equals(b1Duplicate))? " -- YES " : " -- NO "));
		
			b5.setAccountNumber("300rre");
			
			assertFalse(list1.contains(b1));
			assertTrue(list2.contains(b4));
			assertFalse(list2.contains(b5));
			assertFalse(list3.contains(b5));
			assertTrue(list3.contains(b3));
			assertTrue(list4.contains(b4));
			assertFalse(list4.contains(b5));
			b5.setAccountNumber("a500bc");
			assertFalse(list4.contains(b5));
			System.out.println("\n***** testing contains() completed *****");
			
	        assertTrue(list1.add(b1));
	        assertTrue(list1.getSize() == 1);
	        assertTrue(list1.add(b2));
	        assertTrue(list1.getSize() ==2);
	        assertFalse(list1.add(b1), "Should not be able to add same account again");
	        assertFalse(list1.add(b2), "Should not be able to add same account again");
	        assertTrue(list1.getSize() ==2);
	        assertTrue(list4.getSize() == BankAccountList.MAX_SIZE);
	        assertFalse(list4.add(b4), "Should not be able to add same account again");
	        assertTrue(list4.getSize() == BankAccountList.MAX_SIZE);
	        assertTrue(list3.add(b3New));
	        assertFalse(list3.add(b4));
	        assertTrue(list3.getSize() == 6);
	        assertTrue(list3.contains(b3));
	        assertTrue(list3.contains(b4));
	        assertFalse(list3.add(b4));
	        assertTrue(list3.getSize() == 6);
	        System.out.println("Size: " + list1.getSize() + " expected(2)  list1: \n" + list1);
	        System.out.println("Size: " + list2.getSize() + " expected(1) list2: \n" + list2);
			System.out.println("Size: " + list3.getSize() + " expected(6) list3: \n" + list3);
			System.out.println("Size: " + list4.getSize() + " expected(15) list4: \n" + list4);
			System.out.println("\n***** testing add() and contains() completed *****");	
		}	
		public void testGetFindAddRemoveSortMethods() {
			System.out.println("\n***** Add() Remove() Get() Find() Testing *****");
			BankAccountList list1 = new BankAccountListImpl();
			BankAccountList list2 = new BankAccountListImpl();
			
			
			BankAccount b1 = new BankAccount("dd623x", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
			BankAccount b2 = new BankAccount("aabb22"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
			BankAccount b3 = new BankAccount("aamf93"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, 1255.0);
		
			int expSize=0;
			int retSize=0;
			
			String expString="";
			String retString="";
			
			System.out.println("**** Testing getSize() **** ");
			retSize = list1.getSize();
			expSize=0;
			assertEquals(expSize, retSize);
			System.out.println("**** Testing contains() **** ");
			boolean expBool = false;
			boolean retBool = list1.contains(b1);
			assertEquals(expBool, retBool);
			expBool=false;
			retBool = list2.contains(b2);
			assertEquals(expBool, retBool);	
			list1.add(b1);
			expBool=true;
			retBool = list1.contains(b1);
			assertEquals(expBool, retBool);
			expSize=1;
			retSize = list1.getSize();
			assertEquals(expSize, retSize);
			
			System.out.println("**** Testing add() **** ");
			retBool = list1.add(b2);
			expBool=true;
			assertEquals(expBool, retBool);
			retBool = list1.contains(b2);
			expBool = true;
			assertEquals(expBool, retBool);
			retBool = list1.contains(b1);
			expBool = true;
			assertEquals(expBool, retBool);
			retBool = list1.add(b3);
			expBool=true;
			assertEquals(expBool, retBool);
			retBool = list1.contains(b3);
			expBool = true;
			assertEquals(expBool, retBool);
			expSize=3;
			retSize = list1.getSize();
			assertEquals(expSize, retSize);
			expBool=false;
			retBool = list1.add(b3);
			assertEquals(expBool, retBool);
			expBool=false;
			retBool = list1.add(b1);
			assertEquals(expBool, retBool);
			expBool=true;
			retBool = list1.contains(b2);
			assertEquals(expBool, retBool);
			System.out.println("***** Now testing toString()*****");
			expSize = list1.getSize();
			retSize =utils.MyUtils.numberLines(list1.toString());
			assertEquals(expSize, retSize);
			list2 = new BankAccountListImpl();
			expSize = list2.getSize();
			retSize = utils.MyUtils.numberLines(list2.toString());
			assertEquals(expSize, retSize);
			System.out.println("**** Testing find() **** ");
			int retLoc = list1.find(b1);
			int expLoc = 0;
			assertEquals(expLoc, retLoc);
			retLoc = list1.find(b2);
			expLoc = 1;
			assertEquals(expLoc, retLoc);
			retLoc = list1.find(b3);
			expLoc = 2;
			assertEquals(expLoc, retLoc);
			BankAccount b4 = new BankAccount("vbtr45", " GARCIA ", "JOHN ", AccountType.MONEY_MARKET, BusinessType.CORPORATE, 900.00);
			retLoc = list1.find(b4);
			expLoc = -1;
			assertEquals(expLoc, retLoc);
			expBool = true;
			retBool = list1.add(b4);
			assertEquals(expLoc, retLoc);		
			expBool = true;
			retBool = list1.contains(b4);
			assertEquals(expLoc, retLoc);
			retLoc = list1.find(b4);
			expLoc = 3;
			assertEquals(expLoc, retLoc);
			expSize=4;
			retSize = list1.getSize();
			assertEquals(expSize, retSize);
			System.out.println("**** Testing get() **** ");
			BankAccount retAct = list1.get(0);
			BankAccount expAct = b1;
			assertEquals(expAct, retAct);
			retAct = list1.get(1);
			expAct = b2;
			assertEquals(expAct, retAct);
			retAct = list1.get(2);
			expAct = b3;
			assertEquals(expAct, retAct);
			retAct = list1.get(3);
			expAct = b4;
			assertEquals(expAct, retAct);
			BankAccount b5 = new BankAccount("yy492x", " RogersStein", "MaRCOs", AccountType.CHECKING, BusinessType.CORPORATE, 3000.0);
			retAct = list1.get(-2);
			expAct = null;
			assertEquals(expAct, retAct);
			retAct = list1.get(4);
			expAct = null;
			assertEquals(expAct, retAct);
			System.out.println("Current List of BankAccounts: should be  5\n" + list1);
			expBool = true;
			retBool = list1.add(b5);
			assertEquals(expBool, retBool);
			System.out.println("Current List of Bank Accounts: should be 6\n" + list1);
			
			System.out.println("****Now testing sort() ****");
			list1.sort();
			System.out.println("Sorted list: \n" + list1);
			int position = 0;
			BankAccount b8 = list1.get(position);
			retString = b8.getAccountNumber();
			expString = "aabb22";
			assertEquals(retString, expString);
			position=1;
			b8 = list1.get(position);
			retString = b8.getAccountNumber();
			expString = "aamf93";
			assertEquals(retString, expString);
			position=2;
			b8 = list1.get(position);
			retString = b8.getAccountNumber();
			expString = "dd623x";
			assertEquals(retString, expString);
			position=3;
			b8 = list1.get(position);
			retString = b8.getAccountNumber();
			expString = "vbtr45";
			assertEquals(retString, expString);
			position=4;
			b8 = list1.get(position);
			retString = b8.getAccountNumber();
			expString = "yy492x";
			assertEquals(retString, expString);
			System.out.println("****\nNow testing remove(); ****");

			BankAccount remAccount=null;
			b8 = list1.get(0);
			remAccount = list1.remove(b8);
			if(remAccount != null && remAccount.getAccountNumber().equals(b8.getAccountNumber()))
			{
				System.out.println("SUCCESS Expected account " + remAccount + " to be removed " );
			}
			else
			{
				System.out.println("FAILURE Expected account " + b8 + " to be removed, it was not" );
			}
			position = list1.find(remAccount);
			assertEquals(position, -1);

			b8 = list1.get(3);
			remAccount = list1.remove(b8);
			if(remAccount != null && remAccount.getAccountNumber().equals(b8.getAccountNumber()))
			{
				System.out.println("SUCCESS Expected account " + remAccount + " to be removed " );
			}
			else
			{
				System.out.println("FAILURE Expected account " + b8 + " to be removed, it was not" );
			}
			position = list1.find(remAccount);
			assertEquals(position, -1);
			b8 = list1.get(1);
			remAccount = list1.remove(b8);
			if(remAccount != null && remAccount.getAccountNumber().equals(b8.getAccountNumber()))
			{
				System.out.println("SUCCESS Expected account " + remAccount + " to be removed " );
			}
			else
			{
				System.out.println("FAILURE Expected account " + b8 + " to be removed, it was not" );
			}
			position = list1.find(remAccount);
			assertEquals(position, -1);
			System.out.println("\n***** end of testing get() find() add() remove() sort()  *****");
		}

		public void testUtilsMethods()
		{
			BankAccountList list1 = new BankAccountListImpl();
			
			System.out.println("\n------------------------------------------------------");
			System.out.println("\n**** Now testing BankAccountListUtilsImpl methods ****");
			String fileName="";
			Scanner inFile = null;
			PrintWriter outFile = null;
			fileName= "bankaccountEmpty.txt";
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("****Output of " + fileName + ":");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			int size1 = list1.getSize();
			assertEquals(size1, 0);
			inFile.close();
			System.out.println("Contents of " + fileName + " after reading \n" + list1);
			fileName = "bankaccount1.txt";
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("****Output of " + fileName + ":");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			size1 = list1.getSize();
			assertEquals(size1, 1);
			fileName="bankaccount1out.txt";
			try {
				outFile = new PrintWriter(new File(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
				return;
			}
			BankAccountListUtilsImpl.writeToFile(outFile,  list1);
			outFile.close();
			list1.clear();
			assertTrue(list1.getSize() == 0);
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("SUCCESS opened file: " + fileName + " for reading...");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" for reading now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			int size2=list1.getSize();
			assertTrue(size1 == size2 && size1 != 0);

			System.out.println("Contents of previously written file: " + fileName + "\n" + list1);
			System.out.println("**** Now testing several accounts on a file - read and write ****");
			fileName= "bankaccount.txt";
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("SUCCESS opened for reading: " + fileName );
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" for reading now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			inFile.close();
			size1=list1.getSize();
			System.out.println("Contents of " + fileName + " after reading \n" + list1);
			fileName = "bankaccountout.txt";
			try {
				outFile = new PrintWriter(new File(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
				return;
			}
			BankAccountListUtilsImpl.writeToFile(outFile,  list1);
			outFile.close();
			list1.clear();
			assertTrue(list1.getSize() == 0);
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("SUCCESS opened file: " + fileName + " for reading...");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" for reading now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			inFile.close();
			size2=list1.getSize();
			assertTrue(size1 == size2 && size1 != 0);	
			System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
			fileName= "bankaccountExtra.txt";
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("SUCCESS opened for reading: " + fileName );
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" for reading now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			inFile.close();
			size1=list1.getSize();
			assertTrue(size1==BankAccountList.MAX_SIZE);
			System.out.println("Contents of " + fileName + " after reading \n" + list1);
			fileName = "bankaccountExtraout.txt";
			try {
				outFile = new PrintWriter(new File(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
				return;
			}
			BankAccountListUtilsImpl.writeToFile(outFile,  list1);
			outFile.close();
			list1.clear();
			assertTrue(list1.getSize() == 0);
			String expString = "";
			String actString = list1.toString();
			assertEquals(actString, expString);
			list1 = new BankAccountListImpl();
			try 
			{
				inFile = new Scanner(new File(fileName));
				System.out.println("SUCCESS opened file: " + fileName + " for reading...");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("FAILURE error, cannot open file: " + fileName +
						" for reading now exiting....");
				return;
			}
			BankAccountListUtilsImpl.readFromScanner(inFile, list1);
			inFile.close();
			size2=list1.getSize();
			assertTrue(size1 == size2 && size1 != 0);

			System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
			System.out.println("**** End of testUtilsMethods() **** \n");

		}
	}



