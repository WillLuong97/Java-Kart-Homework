package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import housepet.Bird;
import housepet.BirdType;
import housepet.Cat;
import housepet.CatColor;
import housepet.Dog;
import housepet.DogSize;
import housepet.HousePet;
import housepet.HousePetUtilsImpl;
import housepetlist.HousePetList;

class HousePetTest {

	@Test
	void test() 
	{
		String sName = "";
		//sName= utils.MyUtils.getNameFromStudent();
		System.out.println("Begin testing of HousePetTest for " + sName);
		utils.MyUtils.printTimeStamp("BEGINS");
		dogTest();
		catTest();
		birdTest();
		housePetTest();
		utilsTest();
		utils.MyUtils.printTimeStamp("ENDS");
		System.out.println("End of testing of HousePetTest for " + sName);		
	}
    void housePetTest()
    {
    	System.out.println("Testing comparison of HousePets ....");
    	Dog dog1 = new Dog("992A");
    }
	
	void utilsTest()
	{
		System.out.println("read/write method testing....");
		String fileNameIn = "housepetOne.txt";
		String fileNameOut = "housepetOneOUT.txt";
		System.out.println("Testing input of " + fileNameIn + " and output to: " + fileNameOut);
		Scanner inFile = null;
		PrintWriter outFile = null;
		int expCount=0;
		int retCount=0;
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		try {
			outFile = new PrintWriter(new FileWriter(fileNameOut));
		}catch(IOException e)
		{
			System.out.println("Error, cannot open output file: " + fileNameOut + " Exiting ");
			assertTrue(outFile != null, "Failure on purpose");
			return;
		}
		HousePet pet = null;
		expCount = 1;
		retCount = 0;

		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet);
				HousePetUtilsImpl.writeToFile(outFile, pet);
			}
		}
		inFile.close();
		outFile.close();
		assertEquals(expCount, retCount, " should have read 1 pet from file: " + fileNameIn);
		// now try to read from just written outFile, housepetOneOUT.txt
		fileNameIn = "housepetOneOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		expCount = 1;
		retCount = 0;
		System.out.println("\nBegin reading from: " + fileNameIn);
		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet );
			}
		}
		System.out.println("End of reading from " + fileNameIn + "\n");
		assertEquals(expCount, retCount, " should have read 1 pet from file: " + fileNameIn);
		
		fileNameIn = "housepet.txt";
		fileNameOut = "housepetOUT.txt";
		System.out.println("Testing input of " + fileNameIn + " and output to: " + fileNameOut);
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		try {
			outFile = new PrintWriter(new FileWriter(fileNameOut));
		}catch(IOException e)
		{
			System.out.println("Error, cannot open output file: " + fileNameOut + " Exiting ");
			assertTrue(outFile != null, "Failure on purpose");
			return;
		}
		 pet = null;
		expCount = 7;
		retCount = 0;

		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet);
				HousePetUtilsImpl.writeToFile(outFile, pet);
			}
		}
		inFile.close();
		outFile.close();
		assertEquals(expCount, retCount, " should have read " + expCount + " pet(s) from file: " + fileNameIn);
		fileNameIn = "housepetOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		expCount = 7;
		retCount = 0;
		System.out.println("\nBegin reading from: " + fileNameIn);
		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet );
			}
		}
		System.out.println("End of reading from " + fileNameIn + "\n");
		assertEquals(expCount, retCount, " should have read " + expCount + " pet(s) from file: " + fileNameIn);
	
		fileNameIn = "housepetExtra.txt";
		fileNameOut = "housepetExtraOUT.txt";
		System.out.println("Testing input of " + fileNameIn + " and output to: " + fileNameOut);
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		try {
			outFile = new PrintWriter(new FileWriter(fileNameOut));
		}catch(IOException e)
		{
			System.out.println("Error, cannot open output file: " + fileNameOut + " Exiting ");
			assertTrue(outFile != null, "Failure on purpose");
			return;
		}
		 pet = null;
		expCount = 21;
		retCount = 0;

		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet);
				HousePetUtilsImpl.writeToFile(outFile, pet);
			}
		}
		inFile.close();
		outFile.close();
		assertEquals(expCount, retCount, " should have read " + expCount + " pet(s) from file: " + fileNameIn);
		fileNameIn = "housepetExtraOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		expCount = 21;
		retCount = 0;
		System.out.println("\nBegin reading from: " + fileNameIn);
		while(inFile.hasNext()) 
		{
			pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				retCount++;
				System.out.println("Just read: " + pet );
			}
		}
		System.out.println("End of reading from " + fileNameIn + "\n");
		assertEquals(expCount, retCount, " should have read " + expCount + " pet(s) from file: " + fileNameIn);
	
		System.out.println("End of read/write method testing....");

	}
	void dogTest()
	{
		System.out.println("Dog class testing....");
		String expString = "";
		String retString = "";
		DogSize expSize = DogSize.TINY;
		DogSize retSize = DogSize.TINY;
		Dog dog1 = new Dog("11aa");
		System.out.println("dog1: " + dog1);
		expString = "11AA";
		retString = dog1.getChipId();
		assertEquals(expString, retString);
		expSize = DogSize.MEDIUM;
		retSize = dog1.getDogSize();
		assertTrue( expSize.equals(retSize));
		retString = dog1.toString();
		assertTrue(retString.contains("MEDIUM"));
		assertTrue(retString.contains("DOG"));
		assertTrue(retString.contains("$$$$"));
		assertTrue(retString.contains("118"));

		dog1.setLeashTrained(true);
		assertTrue(dog1.isLeashTrained());
		dog1.setDogSize(DogSize.TINY);
		assertTrue(dog1.getDogSize().equals(DogSize.TINY));
		dog1.setBirthDate(new GregorianCalendar(2013, 3, 4));
		dog1.setPetName("Luckiest DOG eVEr");
		retString = dog1.toString();
		System.out.println("dog1: " + dog1);
		assertTrue(retString.contains("TINY"));
		assertTrue(retString.contains("DOG"));
		assertTrue(retString.contains("Luckiest Dog Ever"));
		assertTrue(retString.contains("5"));
		assertFalse(retString.toUpperCase().contains("NOT"));
		System.out.println("End of Dog class testing....");

	}
	void catTest()
	{
		System.out.println("Cat class testing....");
		String expString = "";
		String retString = "";
		Cat cat1 = new Cat("kkkdddrr44");
		retString = cat1.toString();
		System.out.println("cat1: " + cat1);
		assertTrue(cat1.getCatColor().equals(CatColor.BLACK));
		assertTrue(retString.contains("$$$$"));
		assertTrue(retString.contains("118"));
		assertTrue(retString.contains("BLACK"));
		cat1.setBirthDate(new GregorianCalendar(2014,1,22));
		cat1.setPetName("Count DRaKe");
		cat1.setChipId("111z");
		retString = cat1.toString();
		System.out.println("cat1: " + cat1);
		assertTrue(retString.contains("4"));
		assertTrue(retString.contains("Count Drake"));
		assertTrue(retString.contains("111Z"));
		System.out.println("End of Cat class testing....");
	}

	void birdTest()
	{
		System.out.println("Bird class testing....");
		String expString = "";
		String retString = "";
		Bird bird1 = new Bird("kkkdddrr44");
		retString = bird1.toString();
		System.out.println("bird1: " + bird1);
		assertTrue(bird1.getBirdType().equals(BirdType.PARROT));
		assertTrue(retString.contains("$$$$"));
		assertTrue(retString.contains("118"));
		assertTrue(retString.contains("PARROT"));
		bird1.setBirthDate(new GregorianCalendar(2015,3,15));
		bird1.setPetName("TWeety tweet");
		bird1.setChipId("jkab");
		retString = bird1.toString();
		System.out.println("bird1: " + bird1);
		assertTrue(retString.contains("3"));
		assertTrue(retString.contains("Tweety Tweet"));
		assertTrue(retString.contains("JKAB"));
		System.out.println("End of Bird class testing....");
	}
}
