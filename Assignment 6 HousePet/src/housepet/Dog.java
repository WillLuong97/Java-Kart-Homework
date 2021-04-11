package housepet;

public class Dog extends HousePet
{
	private DogSize size; 
	private boolean leashTrained;
	
	public Dog()
	{
		super(); 
		this.leashTrained = false; 
		this.size = DogSize.MEDIUM; 
	} //end of dog. 
	
	
	public Dog(String aChipId) // use size Medium, and false for leash trained 
	{
		super(aChipId); 
		this.leashTrained = false; 
		this.size = DogSize.MEDIUM; 
		
	} //end of the constructor
	
	
	//Getters. 
	public Boolean isLeashTrained()
	{
		return this.leashTrained; 
	} //
	
	public DogSize getDogSize()
	{
		return this.size; 
		
	} //end of DogSize
	
	
	//Setters
	public void setLeashTrained(boolean isTrained)
	{
		this.leashTrained = isTrained; 
	} //end of setLeashTrained. 
	
	

	public void setDogSize(DogSize aSize)
	{
		this.size = aSize;
	} //end of setDogSize(DogSize aSize). 
	
	
	//toString
	public String toString()
	{
		String str = ""; 
		str += "DOG " + super.toString() + this.leashTrained + this.size;
		
		return str; 

	} // end of toString.
	
	
} //end of Dog.java
