package asg3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankAccountUtilsImpl 
{
	// receives:  inFile - a Scanner instance that is open and ready to read data from
	 //     file format: account number {newline} last name {newline} first name {newline},
	 //                  account type {space} business type {newLine} balance {newline}
	 // returns:  a single populated BankAccount instance with data from inFile if all data is there,
	 //      returns null if no data found (end of input) for a bank account or if
	 //     any mismatch of data or missing expected data
	 public static BankAccount readFromScanner(Scanner inFile)
	 {
		String accNumber = ""; 
		String lname = ""; 
		String fname = "";
		double baLance = 0.0; 
		String accType = "";  
		String busType="";  
		 
		 if (inFile.hasNext()) 
		 {
			 accNumber = inFile.nextLine().trim(); // reading the first line in the text file. 
			 
		 }
		 
		 else
		 {
			 return null; 
		 }
		 
		 if(inFile.hasNext()) 
		 {
			 lname = inFile.nextLine().trim(); // reading the next line from the text file. 
			 
		 }
		 
		 else
		 {
			 return null; 
		 }
		 
		 
		 if(inFile.hasNext()) 
		 {
			 fname = inFile.nextLine().trim(); // so on... 
			 
		 }
		 
		 else
		 {
			 return null; 
			 
		 }
		 
		 if(inFile.hasNext())
		 {
			 accType = inFile.next().trim();
			 
		 }
		 
		 else
		 {
			 return null; 
			 
		 }
		 
		 if(inFile.hasNext()) 
		 {
			 busType = inFile.nextLine().trim(); 
			 
			 
		 }
		 
		 else
		 {
			 return null;
			 
		 }
		 
		 if(inFile.hasNextDouble()) 
		 {
			 baLance = inFile.nextDouble(); // reading until the next double in the text file. 
			 inFile.nextLine();  // after reading through the double, move on to the next line in the file. 
		 }
		 
		 
		 else
		 {
			 return null; 
		 }
		 
			
		BankAccount account = new BankAccount(accNumber, lname, fname, AccountType.valueOf(accType), BusinessType.valueOf(busType), baLance);
		return account;
		 
	 } // end of reading to the file 
	 
	 // receives: outFile- a PrintWriter instance that is already open and ready to receive output
	 //           bankAccount - the instance of a bankAccount that is to be written to the output
	 // task: received bankAccount is written to outFile in  readable format by readFromScanner method
	 //       (so that it could be read back in later)
	 //writes in exact same order and format as readFromScanner uses:
	 //    file format:  account number {newline} 
	 //                  last name {newline} 
	 //                  first name {newline},
	 //                  account type {space} business type {newLine} 
	 //                  balance {newline} 
	 
	 public static void writeToFile(PrintWriter outFile, BankAccount bankAccount) 
	 {
		 outFile.println(bankAccount.getAccountNumber());   
		 outFile.println(bankAccount.getLastName());
		 outFile.println(bankAccount.getFirstName());
		 outFile.println(bankAccount.getAccountType()+" "+bankAccount.getBusinessType());
		 outFile.println(bankAccount.getBalance());
		 
	 } // end of writing the text file. 
	

} //End of the program. 
