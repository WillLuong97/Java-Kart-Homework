package housepet;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class HousePet {
	public static final String DEFAULT_NAME = "$$$$";
	public static final String DEFAULT_CHIP_ID = "AAAA";
	public static final GregorianCalendar DEFAULT_BIRTH_DATE = new GregorianCalendar(1900, 1, 1);
	private String name;
	private GregorianCalendar birthDate;
	private String chipId;


	// override of default constructor
	// sets name to default, sets birth date to default
	// sets chip id to default
	public HousePet()
	{
		this.setPetName(DEFAULT_NAME);
		this.setBirthDate(DEFAULT_BIRTH_DATE);
		this.setChipId(DEFAULT_CHIP_ID);

	}

	// constructor that receives chipId only
	// sets name to default, sets birth date to default
	public HousePet(String aChipId)
	{

		this.setPetName(DEFAULT_NAME);
		this.setBirthDate(DEFAULT_BIRTH_DATE);
		this.setChipId(aChipId);
	}

	//override of toString(), returns a readable String
	// of name, age, chip id of a pet
	public String toString()
	{
		String temp="";
		int age = this.getAge();
		temp +=  "Chip Id: " + this.getChipId()+ " ";
		temp += age + ((age>1)? " years old" : " year  old") + " born: " + this.getBirthDateAsString();
		temp +=  "  " + this.getPetName() + " " ;
		

		return temp;   
	}
	//receives: nothing
	// returns the chip id of this pet
	public String getChipId() 
	{
		return this.chipId;
	}
	//receives: nothing
	// returns the age of this pet, if less than 1, returns age as 1
	public int getAge()
	{
		int year = 0;
		GregorianCalendar today = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		int birthYear = this.birthDate.get(Calendar.YEAR);
		int age = year - birthYear;
		if(age == 0)
			age = 1; // always 1 even if less - cannot be 0.
		return age;

	}
	//receives: nothing
	// returns the name of this pet
	public String getPetName() 
	{
		return this.name;
	}
	//receives: aName - to use for this pet's name
	// attempts to set pet name to aName, proper formats aName
	//  if aName is empty uses DEFAULT_NAME
	// returns: nothing
	public void setPetName(String aName)
	{
		aName = utils.MyUtils.properFormat(aName);
		if(aName.equals(""))
			aName="$$$$";
		this.name=aName;
	}
	//receives: aBirthDate, value to set pet's birth day to
	// if aBirthDate is earlier than DEFAULT_BIRTH_DATE, uses default
	// returns: nothing
	public void setBirthDate(GregorianCalendar aBirthDate) 
	{

		if(aBirthDate.compareTo(DEFAULT_BIRTH_DATE) < 0) // no dates below Jan. 1, 1900 
		{
			aBirthDate = DEFAULT_BIRTH_DATE;
		}
		this.birthDate = aBirthDate;

	}
	//receives: aDate, value to set pet's birth day to as a String in MM/DD/YYYY format
	// if aBirthDate is earlier than DEFAULT_BIRTH_DATE, uses default
	// returns: nothing
	public void setBirthDate(String aDate)
	{
		GregorianCalendar someDate = utils.MyUtils.stringToDate(aDate);// convert to calendar type
		if(someDate.compareTo(DEFAULT_BIRTH_DATE) < 0) // no dates below Jan. 1, 1900 
		{
			someDate = DEFAULT_BIRTH_DATE;
		}
		this.birthDate = someDate;
	}
	//receives: aChipId - to use for this pet's chip id
	// attempts to set pet to chip id
	//  if invalid (not alphanumeric and not length 4, uses default chip id)
	// returns: nothing
	public void setChipId(String aChipId) 
	{
		boolean valid = utils.MyUtils.isValid(aChipId); // is the chip id all letters/digits?
		int len = aChipId.length(); // check length
		if(len == 4 && valid) // rule must be 4 chars all letters and digits
		{
			this.chipId = aChipId.toUpperCase();
		}
		else
		{
			this.chipId = DEFAULT_CHIP_ID;
		}

	}
	//receives: nothing
	//returns: String of this pet's birth date, in format mm/dd/yyyy
	public String getBirthDateAsString()
	{
		String date = utils.MyUtils.dateToString(this.birthDate);
		return date;
	}
	
	//receives nothing
	// returns the date of this pet, as a GregorianCalendar value
	public GregorianCalendar getBirthDate()
	{
		return this.birthDate;
	}
	
	//override of equals - compares chipId, petName, birthDate
	// if all match, returns true
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof HousePet))
			return false;
		HousePet pet = (HousePet) obj;
		if(!(this.getChipId().equals(pet.getChipId())))
			return false;
		if(!(this.getBirthDate().equals(pet.getBirthDate())))
				return false;
		if(!(this.getPetName().equals(pet.getPetName())))
			return false;
		return true;
	}
	//override of hashCode - uses same attributes as equals to
	// create an int from the attributes - hopefully unique for each HousePet instance
	//  note: if 2 instances are equal, they should also have the same hashCode.
	public int hashCode()
	{
		int code = 31;
		int mult = 133;
		code = code * mult + this.getChipId().hashCode();
		code = code * mult + this.getPetName().hashCode();
		code = code * mult + this.getBirthDateAsString().hashCode();
		return code;
	}
}
