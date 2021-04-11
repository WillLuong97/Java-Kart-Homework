package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import lab4.CarMake;
import lab4.RentalCar;
import lab4.RentalCarUtilsImpl;

public class Lab4TestUtils {
	public static void main(String []args)
	{
		String expString="";
		String actualString="";

		int expInt = 0;
		int actualInt = 0;
		String sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Testing of Lab4Test for: " + sName);
		utils.MyUtils.printTimeStamp("BEGINS");
		System.out.println("****Testing Constructors and Accessors****");
		RentalCar car1 = new RentalCar();
		expInt = 2018;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);

		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		CarMake expMake = CarMake.TOYOTA;
		CarMake actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);


		car1 = new RentalCar("kk;8*", 2020, CarMake.CHRYSLER);
		expInt = 2018;
		actualInt = car1.getYear();
		if(car1.getYear()== expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		expMake = CarMake.CHRYSLER;
	    actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);
		car1 = new RentalCar("kkdd33", 2012, CarMake.HONDA);
		expInt = 2018;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1 = new RentalCar("kkdd33", 2013, CarMake.FORD);
		expInt = 2013;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);

		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		expMake = CarMake.FORD;
		 actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);
		System.out.println("**** Testing setters ****");
		car1.setYear(2020);
		expInt = 2018;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);
		car1.setYear(2014);
		expInt = 2014;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);
		car1.setYear(-1);
		expInt = 2018;
		actualInt = car1.getYear();
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt );
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt);

		car1.setVin("111");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("11122");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin(";dlkejeoierpoeijr");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);

		car1.setVin("");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("1#11");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("E99WWE");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("1");
		expString = "0000";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("cczz");
		expString = "cczz";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		car1.setVin("4477");
		expString = "4477";
		actualString = car1.getVin();
		if(actualString.equals(expString))
			System.out.println("SUCCESS expected " + expString );
		else
			System.out.println("FAILURE expected " + expString + " but got: " + actualString);
		CarMake aMake = CarMake.FORD;
		car1.setMake(aMake);
		expMake = CarMake.FORD;
		 actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);
		aMake = CarMake.HONDA;
		car1.setMake(aMake);
		expMake = CarMake.HONDA;
		 actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);
		aMake = CarMake.CHEVY;
		car1.setMake(aMake);
		expMake = CarMake.CHEVY;
		 actualMake = car1.getMake();
		if(actualMake.equals(expMake))
			System.out.println("SUCCESS expected " + expMake );
		else
			System.out.println("FAILURE expected " + expMake + " but got: " + actualMake);
	

		System.out.println("**** Testing toString() ****");
		actualString=car1.toString();
		if(actualString.contains(expString) && actualString.contains("2018"))
			System.out.println("SUCCESS RentalCar method toString() has proper attribute values in it");
		else
			System.out.println("FAILURE RentalCar method toString() is missing one or more attribute values for RentalCar class");

		System.out.println("Should Receive string such as: " + " VIN: " + car1.getVin() +  " Year: " + car1.getYear() +  
				  " Make: " + car1.getMake() +
				"\nActually Received Back string: " + actualString);
		expInt = 0;
		actualInt = utils.MyUtils.numberLines(actualString);
		if(actualInt == expInt)
			System.out.println("SUCCESS expected " + expInt +  " newlines in String returned from toString().");
		else
			System.out.println("FAILURE expected " + expInt + " but got: " + actualInt + " newlines in String returned from toString().");
        expString = "CHEVY";
        actualString = car1.toString();
        if(actualString.contains(expString) && actualString.contains("4477") && actualString.contains("2018"))
        	System.out.println("SUCCESS String returned from toString() has correct attribute values.");
		else
			System.out.println("FAILURE String returned from toString() missing 1 or more attributes.");
      
       
		System.out.println("****Now Testing readFromScanner and writeToFile methods****");

		String filename = "";
		Scanner inputFile = null;
		int count = 0;
		filename = "rentalcar1.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		count = 0;
		while(inputFile.hasNext()){
			car1 = RentalCarUtilsImpl.readFromScanner(inputFile);
			if(car1 != null)
				count ++;
			System.out.println(count + ")" + "car populated from file: " + car1);
		}
		inputFile.close();
		int expCount = 1;
		if(count == expCount)
			System.out.println("SUCCESS read " + count + " cars from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " car(s) from " + filename +
					    	   " instead read: " + count + " cars.");
		filename = "rentalcar6.txt";
		try {
			inputFile = new Scanner(new File(filename));		
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new File("out6.txt"));
		}catch (IOException e)
		{
			System.out.println("Cannot open file for output, returning...");
			
		}
		count = 0;
		while(inputFile.hasNext()){
			car1 = RentalCarUtilsImpl.readFromScanner(inputFile);
			if(car1 != null)
			{
				  count ++;
				  System.out.println(count + ")" + "car populated from file: " + car1);
				  RentalCarUtilsImpl.writeToFile(outFile, car1);
			}	 
			
		}
		inputFile.close();
		outFile.close();
		expCount = 6;
		if(count == expCount)
			System.out.println("SUCCESS read " + count + " cars from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " car(s) from " + filename +
					    	   " instead read: " + count + " cars.");
		System.out.println("Now testing writeToFile...");
		filename = "out6.txt";
		try {
			inputFile = new Scanner(new File(filename));		
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		count = 0;
		while(inputFile.hasNext())
		{
			car1 = RentalCarUtilsImpl.readFromScanner(inputFile);
			if(car1 != null)
			{	
				count ++;
				System.out.println(count + ")" + "car populated from file: " + car1);
			}
			
		}
		inputFile.close();
		expCount = 6;
		if(count == expCount)
			System.out.println("SUCCESS read " + count + " cars from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " car(s) from " + filename +
					    	   " instead read: " + count + " cars.");
		
		filename = "rentalcarEmpty.txt";
		try {
			inputFile = new Scanner(new File(filename));		
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		count = 0;
		while(inputFile.hasNext())
		{
			car1 = RentalCarUtilsImpl.readFromScanner(inputFile);
			if(car1 != null)
				count ++;
			System.out.println(count + ")" + "car populated from file: " + car1);
		}
		inputFile.close();
		expCount = 0;
		if(count == expCount)
			System.out.println("SUCCESS read " + count + " cars from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " car(s) from " + filename +
					    	   " instead read: " + count + " cars.");
		
		System.out.println("****Testing Complete****");
		utils.MyUtils.printTimeStamp("ENDS");
		System.out.println("End of Testing of Lab4Test for: " + sName);

	}


}
