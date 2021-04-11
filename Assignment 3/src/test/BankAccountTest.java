package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import asg3.AccountType;
import asg3.BankAccount;
import asg3.BankAccountUtilsImpl;
import asg3.BusinessType;

public class BankAccountTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sName="";
		String expString="";
		String retString="";
		double expBalance=0.0;
		double actualBalance = 0.0;
		double diff = 0.0;
		double allowDiff = 0.0005;
		sName = utils.MyUtils.getNameFromStudent();
		AccountType expActType = AccountType.CHECKING;
		BusinessType expBusType = BusinessType.PERSONAL;
		AccountType actualActType = AccountType.CHECKING;
		BusinessType actualBusType = BusinessType.PERSONAL;
		BankAccount b1 = new BankAccount();
		utils.MyUtils.printTimeStamp("Begin");
		System.out.println("Bank Account Test for: " + sName);
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		if(b1.getAccountNumber().equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		if(b1.getLastName().equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getFirstName();
		if(b1.getFirstName().equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		
		expActType = AccountType.CHECKING;
		actualActType = b1.getAccountType();
		if(b1.getAccountType().equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		if(b1.getBusinessType().equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		b1 = new BankAccount("kkdd22"," jones", "matthew ", AccountType.CHECKING, BusinessType.PERSONAL, 100.0);
		expString = "kkdd22";
		retString = b1.getAccountNumber();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = "Jones";
		retString = b1.getLastName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = "Matthew";
		retString = b1.getFirstName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		
		expActType = AccountType.CHECKING;
		actualActType = b1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		expBalance = 100.0;
		actualBalance = b1.getBalance();
		if(actualBalance!= (expBalance))
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
		
	    b1  = new BankAccount("111111", "  LopeZ  garza", "SusaN ", AccountType.SAVINGS, BusinessType.LLC, 50.0);
	    expString = "111111";
		retString = b1.getAccountNumber();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = "Lopez Garza";
		retString = b1.getLastName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		expString = "Susan";
		retString = b1.getFirstName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		
		expActType = AccountType.SAVINGS;
		actualActType = b1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		expBusType = BusinessType.LLC;
		actualBusType = b1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		expBalance = 50.0;
		actualBalance = b1.getBalance();
		if(actualBalance!= (expBalance))
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
		System.out.println("Now testing setters....");
		b1.setAccountNumber("KKK222");
		expString = "kkk222";
		retString = b1.getAccountNumber();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setAccountNumber("hhh9;2");
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setAccountNumber("bbbcccddd");
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setLastName("  LoPez MarTIN  ");
		expString = "Lopez Martin";
		retString = b1.getLastName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setLastName("    ");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setLastName("");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setFirstName("");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getFirstName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setFirstName(" ann MarIE");
		expString = "Ann Marie";
		retString = b1.getFirstName();
		if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
		b1.setAccountType(AccountType.SAVINGS);
		expActType = AccountType.SAVINGS;
		actualActType = b1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		b1.setAccountType(AccountType.MONEY_MARKET);
		expActType = AccountType.MONEY_MARKET;
		actualActType = b1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		b1.setBusinessType(BusinessType.CORPORATE);
		expBusType = BusinessType.CORPORATE;
		actualBusType = b1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		b1.setBusinessType(BusinessType.LLC);
		expBusType = BusinessType.LLC;
		actualBusType = b1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		b1.setBusinessType(BusinessType.PERSONAL);
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
	    b1.setBalance(100.00);
	    expBalance = 100.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		if(diff > allowDiff)
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
		b1.setBalance(-100.00);
	    expBalance = -100.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		if(diff > allowDiff)
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
	    retString = b1.toString();
	    int actualCount = utils.MyUtils.numberLines(retString);
	    int expCount = 0;
	    if(actualCount == expCount)
	    	System.out.println("SUCCESS expected " + expCount );
		else
			System.out.println("SUCCESS expected " + expCount + " but got: " + actualCount + " too many newlines in toString()");
		System.out.println("toString() of b1: " + b1.toString());
        System.out.println("Now Testing 2nd constructor for BankAccount class");
        BankAccount act1 = new BankAccount("8899DF","JONES SMILEY", "AMY",  AccountType.MONEY_MARKET, BusinessType.CORPORATE, 100.00);
        expString = "Jones Smiley";
        retString = act1.getLastName();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expString = "Amy";
        retString = act1.getFirstName();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expString = "8899df";
        retString = act1.getAccountNumber();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expBalance = 100.0;
		actualBalance = act1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		if(diff > allowDiff)
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
		expBusType = BusinessType.CORPORATE;
		actualBusType = act1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		expActType = AccountType.MONEY_MARKET;
		actualActType = act1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		act1 = new BankAccount(";*ffff"," ", "Kim ANN  ",  AccountType.SAVINGS, BusinessType.LLC, -100.00);
        expString = BankAccount.DEFAULT_NAME;
        retString = act1.getLastName();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expString = "Kim Ann";
        retString = act1.getFirstName();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
        retString = act1.getAccountNumber();
        if(retString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + retString);
        expBalance = -100.0;
		actualBalance = act1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		if(diff > allowDiff)
			System.out.println("FAILURE expected " + expBalance + " but got: " + actualBalance);
		else
			System.out.println("SUCCESS expected " + expBalance );
		expBusType = BusinessType.LLC;
		actualBusType = act1.getBusinessType();
		if(actualBusType.equals(expBusType))
			System.out.println("SUCCESS expected " + expBusType );
		else
			System.out.println("FAILURE expected " + expBusType + " but got: " + actualBusType);
		expActType = AccountType.SAVINGS;
		actualActType = act1.getAccountType();
		if(actualActType.equals(expActType))
			System.out.println("SUCCESS expected " + expActType );
		else
			System.out.println("FAILURE expected " + expActType + " but got: " + actualActType);
		System.out.println("\n***** now testing toString(); ");
		BankAccount someAct = new BankAccount("AAbb12", "LAWREnCE ", " BoB", AccountType.CHECKING, BusinessType.LLC, 100.00);
		retString = someAct.toString();
		System.out.println("toString() of someAct: " + retString);
		expString = "aabb12";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
	
		else
			System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
		expString = "Bob";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
	
		else
			System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
		expString = "Lawrence";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
	
		else
			System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
		expString = "100.";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
		else
			System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
		expString = "CHECKING";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
			else
			System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
		expString = "LLC";
		if(retString.contains(expString))
			System.out.println("SUCCESS expected " + expString + " to be part of toString() of someAct");
			else
		System.out.println("FAILURE expected " + expString + " to be part of toString() but got: " + retString);
        int numLines = utils.MyUtils.numberLines(retString);
        int expLines = 0;
        expString = "aabb12";
		if(numLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " newLines to be in toString() of someAct");
	
		else
			System.out.println("FAILURE expected " + expLines + " newLines to be in toString() of someAct but instead got: " + 
		         numLines );
      
        
		//expString =
	
		System.out.println("\n********Now Testing readFromScanner in BankAccountUtilsImpl********");
        Scanner in = new Scanner(System.in);
        String fileName = "";
        Scanner inFile = null;
        fileName= "bankaccountEmpty.txt";
        try 
        {
        	inFile = new Scanner(new File(fileName));
        	 System.out.println("****Output of " + fileName + ":");
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("error, cannot open file: " + fileName +
        			           " now exiting....");
        	return;
        }
        while(inFile.hasNext())
        {
           BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
           if(b2 != null)
        	   System.out.println("bank account:  " + b2);
        }//end while
        inFile.close();
        
        fileName= "bankaccount1.txt";
        try 
        {
        	inFile = new Scanner(new File(fileName));
        	 System.out.println("****Output of " + fileName + ":");
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("error, cannot open file: " + fileName +
        			           " now exiting....");
        	return;
        }
        while(inFile.hasNext())
        {
           BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
           if(b2 != null)
        	   System.out.println("bank account:  " + b2);
        }//end while
        inFile.close();
        
        fileName= "bankaccount.txt";
        try 
        {
        	inFile = new Scanner(new File(fileName));
        	 System.out.println("****Output of " + fileName + ":");
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("error, cannot open file: " + fileName +
        			           " now exiting....");
        	return;
        }
        PrintWriter outFile = null;
        fileName = "out1.txt";
        try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
        while(inFile.hasNext())
        {
           BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
           if(b2 != null)
        	   System.out.println("bank account:  " + b2);
           BankAccountUtilsImpl.writeToFile(outFile,  b2);
        }//end while
        inFile.close();
        outFile.close();
        System.out.println("\n*******Now testing that writeToFile method worked...********");
        fileName = "out1.txt";
        try 
        {
        	inFile = new Scanner(new File(fileName));
        	 System.out.println("****Output of " + fileName + " should be a copy of bankaccount.txt:****");
    
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("error, cannot open file: " + fileName +
        			           " now exiting....");
        	return;
        }
        while(inFile.hasNext())
        {
           BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
           if(b2 != null)
        	   System.out.println("bank account:  " + b2);
        }//end while
        
        fileName= "bankaccountError.txt";
        try 
        {
        	inFile = new Scanner(new File(fileName));
        	 System.out.println("****Output of " + fileName + ":");
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("error, cannot open file: " + fileName +
        			           " now exiting....");
        	return;
        }
  
        while(inFile.hasNext())
        {
           BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
           if(b2 != null)
        	   System.out.println("FAILURE should not correctly read:  " + b2 + " from " + fileName);
           else
        	   System.out.println("SUCCESS -- Correctly finding error in file: " + fileName);
        }//end while
        inFile.close();
        
		System.out.println("Ending Bank Account Test for: " + sName);
		utils.MyUtils.printTimeStamp("End");
     
    }

	public static void test(String acct, BankAccount act)
	{
		System.out.println("Testing " + acct + " account: ");
		System.out.println("act's number:"+ act.getAccountNumber());
		System.out.println("act's First Name: " + act.getFirstName());
		System.out.println("act's Last Name: " + act.getLastName());
		System.out.println("act's Balance: " + act.getBalance());
		System.out.println("act's AccountType: " + act.getAccountType());
		System.out.println("act's BusinessType: " + act.getBusinessType());
		return;
	}
}
