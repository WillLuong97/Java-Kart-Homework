package lab4;

	public class RentalCar {
		private String vin;
		private CarMake carMake;
		private int year; 
		
		public static final String DEFAULT_VIN = "0000";
		public static final int DEFAULT_YEAR = 2018; 
		
		public RentalCar() //Default Constructor. 
		{
			this.carMake = CarMake.TOYOTA; 
			this.vin = DEFAULT_VIN;
			this.year = DEFAULT_YEAR;
		}
		
		public RentalCar(String aVin, int aYear, CarMake aMake) //Create a rental car with given data values. 
		{
			setYear(aYear);
			setVin(aVin);
			setMake(aMake);
			
		}
		
		public String toString() //returns a String for this rental car that contains the vin, year, and make with short descriptions - NO NEWLINES in String.
		{
			String retValue = ""; 
			
			retValue += "The car you enter has these information " + "Car make: " + this.carMake + " year: " + this.year + " vin " + this.vin;
			
			return retValue; 
			
		}
		
		public String getVin() 
		{ //returns the vin of this car
			return this.vin;
			
		}
		
		public CarMake getMake()
		{ //returns the make of this car)
			return this.carMake;
			
		}
		
		public int getYear() //returns the year of this car
		{
			return this.year;
			
		}
		
		public void setVin(String aVin) //sets this car's vin to given vin if its a valid VIN 
		{
			boolean valid = true;  // check if 4 digit.
			
			if (aVin.length()!= 4) 
			{
				valid = false;
			}
			
			else 
			{
				for (int i = 0; i < aVin.length(); i++ ) 
				{
					char ch = aVin.charAt(i);
					if(!Character.isLetterOrDigit(ch)) 
					{
						valid = false;
						break;
					}
				} // end of for loop. 
				
				
				
			}
			if (valid == true) 
			{
				this.vin = aVin.toLowerCase();
				
			}
			
			else 
			{
				this.vin = DEFAULT_VIN; 
						
			}  
			
		}
		
		public void setMake(CarMake aMake) //sets the make of this car to the received make
		{
			this.carMake = aMake;
		}
		
		public void setYear(int aYear) //sets the year of this car to the received year
		{
			 
			if(aYear >= 2013 && aYear <= 2018)
			{
				this.year = aYear;
			}
			
			else 
			{
				this.year = DEFAULT_YEAR;
			}
			
			
		}
		

	}








