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
import housepetlist.HousePetList;
import housepetlist.HousePetListImpl;
import housepetlist.HousePetListUtilsImpl;

class HousePetListTest {

	private Dog dog1;
	private Dog dog2;
	private Cat cat1;
	private Cat cat2;
	private Bird bird1;
	private Bird bird2;
	@Test
	void test() 
	{
		String sName = "";
		sName= utils.MyUtils.getNameFromStudent();
		System.out.println("Begin testing of HousePet and HousePetList for " + sName);
		utils.MyUtils.printTimeStamp("BEGINS");
		dogTest();
		catTest();
		birdTest();
		initPets();
		listTestConstructorAddtoString();
		listTestFindGetAll();
		listTestNamesAges();
		listTestRemoveClear();
		listTestUtils();
		utils.MyUtils.printTimeStamp("ENDS");
		System.out.println("End of testing of HousePet and HousePetList for " + sName);		
	}
	private void listTestRemoveClear() {
		System.out.println("Testing remove and clear");
		HousePetList list2 = new HousePetListImpl();
		list2.add(dog1);
		assertEquals(1, list2.getSize());
		Dog d1 = (Dog) list2.remove(dog1);
		assertEquals(0, list2.getSize());
		assertEquals(null, list2.remove(dog1));
		list2 = new HousePetListImpl();
		list2.add(dog1);
		list2.clear();
		assertEquals(0, list2.getSize());
		assertEquals(0, utils.MyUtils.numberLines(list2.toString()));

		HousePetList list1 = new HousePetListImpl("housepet.txt");
		String retString = list1.toString();
		System.out.println("Current list before removals: \n" + list1);
		Dog aDog = new Dog("33bf");
		aDog.setBirthDate("1/21/2002");
		aDog.setPetName("Sweety Bones");

		Dog remDog = (Dog)list1.remove(aDog);
		assertEquals(6, list1.getSize());
		assertEquals(null, list1.remove(aDog));

		Bird aBird = new Bird("44gt");
		aBird.setBirthDate("11/30/2016");
		aBird.setPetName("Skippy DOO BOY");
		Bird remBird = (Bird)list1.remove(aBird);
		assertTrue(remBird != null);
		assertEquals(null, list1.remove(aBird));
		assertEquals(5, list1.getSize());

		Cat aCat = new Cat("55wq");
		aCat.setBirthDate("4/3/2016");
		aCat.setPetName("ZIPPITY Doo");
		Cat remCat = (Cat)list1.remove(aCat);
		assertTrue(remCat != null);
		assertEquals(4, list1.getSize());
		assertEquals(null, list1.remove(aCat));
		System.out.println("after removals with size: " + list1.getSize() + " \n" +list1);
		list1.clear();
		assertEquals(0, list1.getSize());
		assertEquals(0, utils.MyUtils.numberLines(list1.toString()));
		assertEquals(null, list1.remove(aDog));
		assertEquals(null, list1.remove(aBird));
		assertEquals(null, list1.remove(aCat));
		System.out.println("End of testing remove and clear ");
	}

	private void listTestNamesAges() {
		System.out.println("Testing name matches and pet ages");
		HousePetList list1 = new HousePetListImpl("housepetExtra.txt");
		String retString ="";
		retString = list1.getHousePetsWithMatchingName("  SuPERMan    ");
		assertEquals(2, utils.MyUtils.numberLines(retString));
		retString = list1.getHousePetsWithMatchingName("  silly    pet ");
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list1.getHousePetsWithMatchingName("  MISS   PEarl ");
		assertEquals(1, utils.MyUtils.numberLines(retString));
		assertTrue(retString.contains(""));
		retString = list1.getHousePetsWithMatchingName("   ");
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list1.getPetsByAge(2);
		System.out.println("Pets at age 2: \n" + retString);
		assertEquals(4, utils.MyUtils.numberLines(retString));
		retString = list1.getPetsByAge(15);
		System.out.println("Pets at age 15: \n" + retString);
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list1.getPetsByAge(8);
		System.out.println("Pets at age 8: \n" + retString);
		assertEquals(1, utils.MyUtils.numberLines(retString));
		System.out.println("End of Testing name matches and pet ages");
	}
	private void listTestFindGetAll() {
		System.out.println("Testing find, get, getAll");
		HousePetList list1 = new HousePetListImpl();
		list1.add(dog1);
		list1.add(cat1);
		System.out.println("list1 in testFindGetAll():\n" + list1);
		assertEquals(1, list1.find(dog1));
		assertEquals(-1, list1.find(dog2));
		assertEquals(0, list1.find(cat1));
		assertEquals(-1, list1.find(cat2));
		assertEquals(-1, list1.find(bird1));
		assertTrue(list1.add(cat2));
		assertTrue(list1.add(bird1));
		assertTrue(list1.add(bird2));
		assertTrue(list1.add(dog2));
		assertEquals(6, list1.getSize());
		assertEquals(cat2, list1.get(0));
		assertEquals(cat1, list1.get(2));
		assertEquals(dog1, list1.get(3));
		assertEquals(dog2, list1.get(1));
		assertEquals(bird1, list1.get(4));
		assertEquals(bird2, list1.get(5));
		assertEquals(0, list1.find(cat2));
		assertEquals(1, list1.find(dog2));
		assertEquals(2, list1.find(cat1));
		assertEquals(4, list1.find(bird1));
		assertEquals(5, list1.find(bird2));
		String retString = list1.getAllCats();
		assertEquals(2, utils.MyUtils.numberLines(retString));
		retString = list1.getAllDogs();
		assertEquals(2, utils.MyUtils.numberLines(retString));
		retString = list1.getAllBirds();
		assertEquals(2, utils.MyUtils.numberLines(retString));
		list1 = new HousePetListImpl();
		retString = list1.getAllDogs();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list1.getAllBirds();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list1.getAllCats();
		assertEquals("", retString);
		list1.add(cat1);
		retString = list1.getAllCats();
		assertEquals(1, utils.MyUtils.numberLines(retString));
		list1.add(dog1);
		retString = list1.getAllDogs();
		assertEquals(1, utils.MyUtils.numberLines(retString));
		list1.add(bird1);
		retString = list1.getAllBirds();
		assertEquals(1, utils.MyUtils.numberLines(retString));
		System.out.println("list1: \n" + list1);
		System.out.println("End of Testing find, get, getAll");
	}
	private void initPets()
	{
		dog1 = new Dog("dd11");
		dog1.setBirthDate("2/13/2014");
		dog1.setPetName("Zorro");
		dog1.setLeashTrained(true);
		dog1.setDogSize(DogSize.MEDIUM);
		dog2 = new Dog("dd22");
		dog2.setBirthDate("5/23/2011");
		dog2.setPetName("ollie");
		dog2.setLeashTrained(false);
		dog2.setDogSize(DogSize.TINY);
		bird1 = new Bird("bb11");
		bird1.setBirthDate("12/1/2017");
		bird1.setPetName("Super Tweety");
		bird1.setBirdType(BirdType.PARROT);
		bird2 = new Bird("bb22");
		bird2.setBirthDate("12/2/2017");
		bird2.setPetName("d SKIPPER ");
		bird2.setBirdType(BirdType.COCKATIEL);
		cat1 = new Cat("cc11");
		cat1.setBirthDate("6/3/2013");
		cat1.setPetName("prince charles");
		cat1.setCatColor(CatColor.TABBY);
		cat2 = new Cat("cc22");
		cat2.setBirthDate("1/12/2009");
		cat2.setPetName("tinker belle");
		cat2.setCatColor(CatColor.CALICO);		
	}

	private void listTestConstructorAddtoString() {
		System.out.println("Testing constructor, add, toString");
		HousePetList list1 = new HousePetListImpl();
		assertEquals(0, list1.getSize());
		list1.add(bird1);
		assertEquals(1, list1.getSize());

		list1.add(bird2);
		assertEquals(2, list1.getSize());
		assertTrue(list1.add(dog1));
		assertFalse(list1.add(dog1));
		assertEquals(3, list1.getSize());
		assertTrue(list1.add(cat1));
		assertFalse(list1.add(cat1));
		assertEquals(4, list1.getSize());
		System.out.println("list of " + list1.getSize() + " pet(s)\n" + list1);

		String retString = list1.toString();
		assertTrue(retString.contains("PARROT"));
		assertTrue(retString.contains("COCKATIEL"));
		assertTrue(retString.contains("BB22"));
		assertTrue(retString.contains("BB11"));
		assertTrue(retString.contains("DD11"));	
		assertTrue(retString.contains("CC11"));

		list1 = new HousePetListImpl("housepet.txt");
		assertEquals(7, list1.getSize());
		System.out.println("new list of " + list1.getSize() + " pet(s) from housepet.txt\n" + list1);
		// test to see if petList is sorted by birthdate
		for(int index=0; index<list1.getSize()- 1; index++)
		{
			HousePet pet1 = list1.get(index);
			HousePet pet2 = list1.get(index +1);
			assertTrue(pet1.getBirthDate().compareTo(pet2.getBirthDate())<=0);
		}

		list1 = new HousePetListImpl("housepetExtra.txt");
		assertEquals(HousePetList.MAX_PETS, list1.getSize());
		System.out.println("new list of " + list1.getSize() + " pet(s) from housepetExtra.txt\n" + list1);
		for(int index=0; index<list1.getSize()- 1; index++)
		{
			HousePet pet1 = list1.get(index);
			HousePet pet2 = list1.get(index +1);
			assertTrue(pet1.getBirthDate().compareTo(pet2.getBirthDate())<=0);
		}

		list1 = new HousePetListImpl("housepetOne.txt");
		assertEquals(1, list1.getSize());
		System.out.println("new list of " + list1.getSize() + " pet(s) from housepetOne.txt\n" + list1);

		list1 = new HousePetListImpl("housepetEmpty.txt");
		assertEquals(0, list1.getSize());
		System.out.println("new list of " + list1.getSize() + " pet(s) from housepetEmpty.txt\n" + list1);
		System.out.println("End of Testing constructor, add, toString");
	}

	private void listTestUtils()
	{
		System.out.println("\nTesting read/write methods ....");
		String fileNameIn = "housepetOne.txt";
		String fileNameOut = "housepetOneOUT.txt";
		System.out.println("Testing input of " + fileNameIn + " and output to: " + fileNameOut);
		Scanner inFile = null;
		PrintWriter outFile = null;
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
		HousePetList petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		inFile.close();
		assertEquals(1, petList.getSize());
		HousePetListUtilsImpl.writeToFile(outFile, petList);
		outFile.close();
		fileNameIn = "housepetOneOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		assertEquals(1, petList.getSize());
		System.out.println("Contents of petList after reading from: " + fileNameIn + "\n" + petList);
		inFile.close();
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
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		// test to see if petList is sorted by birthdate
		for(int index=0; index<petList.getSize()- 1; index++)
		{
			HousePet pet1 = petList.get(index);
			HousePet pet2 = petList.get(index +1);
			assertTrue(pet1.getBirthDate().compareTo(pet2.getBirthDate())<=0);
		}
		inFile.close();
		assertEquals(7, petList.getSize());
		HousePetListUtilsImpl.writeToFile(outFile, petList);
		outFile.close();
		fileNameIn = "housepetOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		assertEquals(7, petList.getSize());
		System.out.println("Contents of petList after reading from: " + fileNameIn + "\n" + petList);
		inFile.close();

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
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		inFile.close();
		// test to see if petList is sorted by birthdate
		for(int index=0; index<petList.getSize()- 1; index++)
		{
			HousePet pet1 = petList.get(index);
			HousePet pet2 = petList.get(index +1);
			assertTrue(pet1.getBirthDate().compareTo(pet2.getBirthDate())<=0);
		}
		assertEquals(HousePetList.MAX_PETS, petList.getSize());
		HousePetListUtilsImpl.writeToFile(outFile, petList);
		outFile.close();
		fileNameIn = "housepetExtraOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		assertEquals(HousePetList.MAX_PETS, petList.getSize());
		System.out.println("Contents of petList after reading from: " + fileNameIn + "\n" + petList);
		inFile.close();

		fileNameIn = "housepetEmpty.txt";
		fileNameOut = "housepetEmptyOUT.txt";
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
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		inFile.close();
		assertEquals(0, petList.getSize());
		HousePetListUtilsImpl.writeToFile(outFile, petList);
		outFile.close();
		fileNameIn = "housepetEmptyOUT.txt";
		try {
			inFile = new Scanner(new File(fileNameIn));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error, cannot open input file: " + fileNameIn + " Exiting ");
			assertTrue(inFile != null, "Failure on purpose");
			return;
		}
		petList = new HousePetListImpl();
		HousePetListUtilsImpl.readFromScanner(inFile, petList);
		assertEquals(0, petList.getSize());
		System.out.println("Contents of petList after reading from: " + fileNameIn + "\n" + petList);
		inFile.close();


		System.out.println("End of read/write method testing....");

	}
	private void dogTest()
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
	private void catTest()
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

	private void birdTest()
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
