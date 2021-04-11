package housepet;

public class Cat extends HousePet
{
	private CatColor color;
	
	
	// default constructor. 
	public Cat()
	{
		super(); 
		this.color = CatColor.BLACK; 
		
	} //end of Cat(). 
	
	//constructor. 
	public Cat(String aChipId)
	{
		super(aChipId);
		this.color = CatColor.BLACK; 
		
	} //end of Cat(String aChipId).
	
	//Getters
	public CatColor getCatColor()
	{
		return this.color; 
	} //end of CatColor(). 
	
	//setter
	public void setCatColor(CatColor aColor)
	{
		this.color = aColor; 
		
	}//end of setCatColor().
	
	
	//end of toString()
	public String toString()
	{
		String str = ""; 
		str += "CAT " + super.toString() + this.color; 
		
		return str; 

	} // end of toString(). 
	
}
