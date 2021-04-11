package asg5;

// receives: lastName (possibly has spaces in it), firstName(possibly has spaces in it), accountNumber(String - digits and lowercase letters exactly 6 chars for each accountNumber), balance(double - can be positive or negative), accountType(AccountType is an enumerated type that has only 3 possible values: CHECKING, SAVINGS, MONEY_MARKET), and businessType(BusinessType is an enumerated type that has only 3 possible values - PERSONAL, CORPORATE, LLC)
// return: attributes that would be tested in the given test program. 

public class BankAccount {
	public final static String DEFAULT_ACCOUNT_NUMBER ="xxxxxx"; 
	public final static String DEFAULT_NAME = "$$$$";
	private String lastName; 
	private String firstName; 
	private String accountNumber; 
	private double balance; 
	private AccountType accountType;
	private BusinessType businessType; 
	
	public BankAccount() 
	{ //// default constructor, creates a default BankAccount instance
		this.accountNumber = "xxxxxx"; 
		this.firstName = "$$$$"; 
		this.lastName = "$$$$"; 
		this.accountType = AccountType.CHECKING; 
		this.businessType = BusinessType.PERSONAL;
		
	}
	
	public BankAccount(String aAccountNumber, String aLastName, String aFirstName,AccountType aAccountType, BusinessType aBusinessType, double aBalance)
	{
		setLastName(aLastName); 
		setFirstName(aFirstName); 
		setAccountNumber(aAccountNumber); 
		setBalance(aBalance); 
		setAccountType(aAccountType); 
		setBusinessType(aBusinessType); 
		
	} //public method to set all the attributes. 
	
	public String toString() 
	{
		String retValue =""; 
		retValue += "The banking information is: " + this.lastName + " " + this.firstName + " " + this.accountNumber + " " + this.accountType + " " + this.balance + " " + this.businessType + " ";
		return retValue; 
		
	} //Creating a string from the attributes. 
	
	 public void setLastName(String aName)	 
	 {
		 aName = utils.MyUtils.properFormat(aName);
			
			if (aName.equals(""))
			{
				aName = DEFAULT_NAME; 
				this.lastName = aName; 

			}
			
			else 
			{
				this.lastName = aName; 

			}
		 
		 
	 } //Modifying the last name. 
	 
	 public void setFirstName(String aName)
	 {
		 aName = utils.MyUtils.properFormat(aName);
			
			if (aName.equals(""))
			{
				aName = DEFAULT_NAME; 
				this.firstName = aName; 

			}
			
			else 
			{
				this.firstName = aName; 

			} 
	 } //Modifying the first name. 
	 
	 public void setAccountNumber(String aAccountNumber)
	 {
		 boolean valid = true;  // check if 6 chars
			
			if (aAccountNumber.length()!= 6) 
			{
				valid = false;
			}
			
			else 
			{
				for (int i = 0; i < aAccountNumber.length(); i++ ) 
				{
					char ch = aAccountNumber.charAt(i);
					if(!Character.isLetterOrDigit(ch)) 
					{
						valid = false;
						break;
					}
				} // end of for loop. 
				

			}
			if (valid == true) 
			{
				this.accountNumber = aAccountNumber.toLowerCase();
				
			}
			
			else 
			{
				this.accountNumber = DEFAULT_ACCOUNT_NUMBER; 
						
			} 
			
	 } //End of account number handling. 
	 
	 
	 //Setter for each attributes. 
	 public void setBalance(double aBalance)
	 {
		 this.balance = aBalance; 
		 
	 }
	 
	 public void setAccountType(AccountType aType)
	 {
		 this.accountType = aType; 
	 }
	
	 public void setBusinessType(BusinessType aType)
	 {
		 this.businessType = aType; 
		 
	 }
	
	 
	 //Getter to access each mentioned attributes from the given test program. 
	 public String getFirstName()
	 {
		 return this.firstName;
		 
	 }
	 
	 public String getLastName() 
	 {
		 return this.lastName;
		 
	 }
	 
	 public String getAccountNumber()
	 {
		 return this.accountNumber;
		 
	 }
	 
	 public double getBalance() 
	 {
		 return this.balance;
		 
		 
	 }
	 
	 public AccountType  getAccountType()
	 {
		 return this.accountType; 
		 
	 }
	 
	 public BusinessType getBusinessType()
	 {
		 return this.businessType; 
		 
		 
	 }
	 
	 public boolean equals (Object obj)
	 {
		if (this == obj)
		{
			return true;
		}
		
		if(!(obj instanceof BankAccount))
		{
			return false;
		}
		
		if(!this.getFirstName().equals(((BankAccount) obj).getFirstName())) 
		{
			return false; 
			
		}
		
		if(!this.getLastName().equals(((BankAccount) obj).getLastName())) 
		{
			return false; 
			
		}

		if(!this.getAccountNumber().equals(((BankAccount) obj).getAccountNumber())) 
		{
			return false; 
			
		}

		if(!this.getAccountType().equals(((BankAccount) obj).getAccountType())) 
		{
			return false; 
			
		}

		if(!this.getBusinessType().equals(((BankAccount) obj).getBusinessType())) 
		{
			return false; 
			
		}
		
		return true; 
		
	 }
	 
     //override of hashCode that should be corresponding to override of equals since
	// if 2 BankAccounts are equal then their respective hashCodes should match as well
	public int hashCode()
	{
		int retValue = 0;
		final int multiplier = 23;  // use prime numbers to spread out hash values
		int code = 133;
		
		code = multiplier * code + this.getAccountNumber().hashCode();
		code = multiplier * code + this.getLastName().hashCode();
		code = multiplier * code + this.getFirstName().hashCode();
		code = multiplier * code + this.getAccountType().hashCode();
		code = multiplier * code + this.getBusinessType().hashCode();
		retValue = code;

		return retValue;
	}
	 

	 
}
