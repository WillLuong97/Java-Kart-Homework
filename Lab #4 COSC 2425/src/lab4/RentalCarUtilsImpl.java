package lab4;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RentalCarUtilsImpl {
	
	//receives: inFile, an ALREADY set up Scanner, ready to be read from
	// precondition: inFile is connected to a Scanner and is not null
	//returns: a populated RentalCar instance with values of 1 single car
	// read from the inFile. If values are not there to read, returns null.
	public static RentalCar readFromScanner(Scanner inFile)
	{
		String rentVin;
		int rentYear = 0; 
		String rentMake; 
		
		if(inFile.hasNext()) 
		{
			rentVin = inFile.next().trim();  // reading the vin number in the text file. 
			
		}
		
		else 
		{
			return null;
			
		}
		
		if(inFile.hasNext())
		{
			
			rentYear = inFile.nextInt(); // reading the year in the text file. 
			
		}
		
		
		else
		{
			return null; 
			
		}
		
		if (inFile.hasNext()) 
		{
			rentMake =inFile.nextLine().trim();  //reading the car make from the text file
			
		}
		
		else 
		{
			return null; 
		}
		
		RentalCar car1 = new RentalCar(rentVin, rentYear, CarMake.valueOf(rentMake));

		return car1; 
	}
	
	//receives: outFile an ALREADY set up PrintWriter, ready to be written to
	// car: a RentalCar instance to write out to outFile
	// precondition: outFile is connected to a PrintWriter and is not null
	// car is not null
	public static void writeToFile(PrintWriter outFile, RentalCar car)
	{
		outFile.println(car.getVin() + " " + car.getYear() + " " + car.getMake());
	
	}
	
	

}
