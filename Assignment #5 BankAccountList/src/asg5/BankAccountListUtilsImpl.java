package asg5;

import java.io.PrintWriter;
import java.util.Scanner;

import asg5.AccountType;
import asg5.BusinessType;

public class BankAccountListUtilsImpl{
	// receives: inFile, a Scanner instance that is open and ready to read data from
    //          aList, a BankAccountList instance that is populated with bank accounts from received Scanner
    //           
    // task:  populates aList with any bank accounts found on scanner (adds to aList as it reads accounts)
//   invalid data on scanner stops reading 
//   stops reading when end of input or when aList reaches MAX_SIZE
//   or when attempting to read an account and bad data is found
// Example use: Scanner infile = new Scanner(new File("test.txt"));
//              BankAccountList myList = new BankAccountList();
//              readFromScanner(infile, myList);  
public static void readFromScanner(Scanner inFile, BankAccountList aList)
{
	while(inFile.hasNext())
	{
		BankAccount act = BankAccountUtilsImpl.readFromScanner(inFile);
		if(act != null)
		{
			aList.add(act);
		}
	}
} //end of readFromScanner method. 

//receives: out, a PrintWriter that is open and ready to write to,
//aList, a BankAccountList instance to write out to the given PrintWriter
// 
// task:  out contains current bank account list in program readable format
//algorithm: for each BankAccount in received list, use get method to get each account. Call writeToFile sending, out, account. 
public static void writeToFile(PrintWriter out, BankAccountList aList)
{
	for(int account = 0; account < aList.getSize(); account++)
	{
		BankAccountUtilsImpl.writeToFile(out,aList.get(account));
		
	}
} //end of writeToFile().

} //end of BankAccountListUtilsImpl(). 
