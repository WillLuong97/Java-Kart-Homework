package housepet;

public class Bird extends HousePet
{
	private BirdType type;
	
	//default constructor.
	public Bird()
	{
		super();
		this.type = BirdType.PARROT; 
		
	} //end of Bird(). 
	
	//constructor
	public Bird(String aChipId)
	{
		super(aChipId); 
		this.type = BirdType.PARROT; 
	} //End of Bird(String aChipId). 
	
	
	//Getter
	public BirdType getBirdType()
	{
		return this.type;
	} //end of Getter.
	
	
	//Setter
	public void setBirdType(BirdType birdType)
	{
		this.type = birdType;
	} //end of Setter 
	
	// toString() method overriden
	public String toString()
	{
		String str = "";
		
		str = "BIRD " + super.toString() + this.type;
		
		return str; 

	} //end of toString
	
} //end of Bird.java
