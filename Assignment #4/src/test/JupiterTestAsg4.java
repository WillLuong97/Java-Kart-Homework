package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myarrays.ArrayExamples;

class JupiterTestAsg4 {
	@Test
	public void test() {
		String sName="";
		sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Assignment #4 Testing for : " + sName);
		utils.MyUtils.printTimeStamp("BEGINS");
		int [] list1 = {122,22,333,43,100,200,300,400,-1, 35};
		int [] list1a = {100};
		double [] list2 = { 100.0, 200.0, 100.0, -50.75, 1000.0, 0.05 };
		double [] list2a = { -1.5 };
		String [] list3 = { "Joe Mark", "Terri Lynn", "Kim S.", "Joe Mark", "Joe Mark", "Michael James", "Amy",};
		String [] list3a = { "Joe Mark"};
		int expInt =0, actInt=0, size=0, count=0;
		double expD=0.0, actD=0.0, allowDiff = 0.0005, diff = 0;
		String expString="", actString="", matchString="";

		System.out.println("**** Now testing findMax *****");
		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);

		expInt = 400;
		actInt = ArrayExamples.findMax(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		expInt = -1;
		actInt = ArrayExamples.findMin(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMin returns: " + actInt);
		list1[0]=1000;
		list1[list1.length-1] = -100;

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);
		actInt = ArrayExamples.findMax(list1, list1.length);
		expInt = 1000;
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		actInt = ArrayExamples.findMin(list1, list1.length);
		expInt = -100;
		assertEquals(expInt, actInt);
		System.out.println("findMin() returns: " + actInt);
		list1[list1.length-1]=1000;
		list1[0] = -200;
		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);
		expInt = 1000;
		actInt = ArrayExamples.findMax(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMax() returns: " + actInt);
		expInt = -200;
		actInt = ArrayExamples.findMin(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMin() returns: " + actInt);
		expD = 219.7;
		actD = ArrayExamples.computeAverage(list1, list1.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 219.7;

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1a, list1a.length);
		actInt = ArrayExamples.findMax(list1a, list1a.length);
		expInt = 100;
		assertEquals(expInt, actInt);
		System.out.println("findMax() returns: " + actInt);
		actInt = ArrayExamples.findMin(list1a, list1a.length);
		expInt = 100;
		assertEquals(expInt, actInt);
		System.out.println("findMin() returns: " + actInt);
		actD = ArrayExamples.computeAverage(list1, list1.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 100.0;
		actD = ArrayExamples.computeAverage(list1a, list1a.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		System.out.println("Array of doubles: ");
		utils.MyUtils.showDoubleArray(list2, list2.length);
		double d1 = list2[0];
		double d1Raise = d1*1.1;
		double d2 = list2[list2.length-1];
		double d2Raise = d2*1.1;

		System.out.println("Now calling raiseAll() on array of double");
		ArrayExamples.raiseAll(list2, list2.length);
		expD = 1.10*d1;
		actD = list2[0];
		diff = Math.abs(actD-expD);
		assertTrue(diff <= allowDiff);
		expD = d2*1.1;
		actD = list2[list2.length-1];
		diff = Math.abs(actD-expD);
		assertTrue(diff <= allowDiff);
		utils.MyUtils.showDoubleArray(list2, list2.length);
		System.out.println("\nSecond array of double: ");
		utils.MyUtils.showDoubleArray(list2a, list2a.length);

		System.out.println("\nNow calling raiseAll() on second array of double");


		ArrayExamples.raiseAll(list2a, list2a.length);
		expD = 1.10*d1;
		actD = list2[0];
		diff = Math.abs(actD-expD);

		assertTrue(diff <= allowDiff);
		expD = d2*1.1;
		actD = list2[list2.length-1];
		diff = Math.abs(actD-expD);
		assertTrue(diff <= allowDiff);
		System.out.println("After raiseAll() on second array of double");
		utils.MyUtils.showDoubleArray(list2a, list2a.length);
		
		System.out.println("\nNow testing countMatches() with Strings ");
		utils.MyUtils.showStringArray(list3,  list3.length);
		matchString = "Joe Mark";
		actInt = ArrayExamples.countMatches(list3, list3.length, matchString);
		expInt = 3;
		assertEquals(expInt, actInt);
		System.out.println("\n" + matchString + " appears " + actInt + " time(s)." );
		//String [] list3 = { "Joe Mark", "Terri Lynn", "Kim S.", "Joe Mark", "Joe Mark", "Michael James", "Amy",};
		matchString = "Ally E";
		actInt = ArrayExamples.countMatches(list3, list3.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println("\n" +matchString + " appears " + actInt + " time(s)." );
		matchString = "Susan Elizabeth";
		actInt = ArrayExamples.countMatches(list3, list3.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println("\n" +matchString + " appears " + actInt + " time(s)." );
		System.out.println("\nTesting countMatches on an array with length: "+list3a.length);
		utils.MyUtils.showStringArray(list3a,  list3a.length);
		matchString = "Joe Mark";
		actInt = ArrayExamples.countMatches(list3a, list3a.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		System.out.println("\n" + matchString + " appears " + actInt + " time(s)." );
		//	String [] list3 = { "Joe Mark", "Terri Lynn", "Kim S.", "Joe Mark", "Joe Mark", "Michael James", "Amy",};
		matchString = "Ally E";
		actInt = ArrayExamples.countMatches(list3a, list3a.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println(matchString + " appears " + actInt + " time(s)." );
		matchString = "Susan Elizabeth";
		actInt = ArrayExamples.countMatches(list3a, list3a.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println(matchString + " appears " + actInt + " time(s)." );
		
		System.out.println("\nNow testing findIndexOf() with Strings ");
		utils.MyUtils.showStringArray(list3,  list3.length);
		matchString = "Joe Mark";
		actInt = ArrayExamples.findIndexOf(list3, list3.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears at index: " + actInt );
		//	String [] list3 = { "Joe Mark", "Terri Lynn", "Kim S.", "Joe Mark", "Joe Mark", "Michael James", "Amy",};
		matchString = "TERRI LYNN";
		actInt = ArrayExamples.findIndexOf(list3, list3.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears at index: " + actInt );
		matchString = list3[6];
		actInt = ArrayExamples.findIndexOf(list3, list3.length, matchString);
		expInt = 6;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears at index: " + actInt );
		matchString = "MiCHaeL JAMES";
		actInt = ArrayExamples.findIndexOf(list3, list3.length, matchString);
		expInt = 5;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears at index: " + actInt );
		matchString = "Not A NAME";
		actInt = ArrayExamples.findIndexOf(list3, list3.length, matchString);
		expInt = -1;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " not found so index is -1" );
		System.out.println("Now testing letterCounts...");
		

		int [] letterCount = new int [26];  // 26 letters in the alphabet
		int [] myArray = new int[2];
		ArrayExamples.resetArray(myArray); 
		assertEquals(0, myArray[0]);
		assertEquals(0, myArray[1]);
		ArrayExamples.resetArray(letterCount); 
		for(int i=0; i<letterCount.length; i++)
		{
			assertEquals(0, letterCount[i]);
		}
		
		String testString = "Welcome";
		ArrayExamples.countLetters(testString, letterCount); 
		String result = ArrayExamples.getLetters(letterCount); // result should be "[ceelomw]"
		String correct = "[ceelmow]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		count = ArrayExamples.getCount(letterCount, 'e');   // should be 2
		assertEquals(2, count);
		ArrayExamples.resetArray(letterCount);
		testString = "123#$%^&*(";
		ArrayExamples.countLetters(testString, letterCount);
		result = ArrayExamples.getLetters(letterCount); // result should be "[]"
		correct = "[]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		ArrayExamples.resetArray(letterCount);
		testString = "dogs and cats";
		ArrayExamples.countLetters(testString, letterCount);
		result = ArrayExamples.getLetters(letterCount); // result should be "[aacddgno]"
		correct = "[aacddgnosst]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		char testLetter = 'z';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - z appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);
		testLetter = 'a';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - z appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(2, count);
		testLetter = 't';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - z appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(1, count);
		testLetter = 's';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - z appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(2, count);
		testLetter = '&';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - & appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);
		testLetter = '4';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - & appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);
	
		ArrayExamples.resetArray(list1);
		assertEquals(0, list1[0]);
		assertEquals(0, list1[list1.length-1]);
		ArrayExamples.resetArray(list1a);
		assertEquals(0, list1[list1a.length-1]);
		assertEquals(0, list1a[0]);
	
		int [] letterCount2 = new int [26];  // another array for counting letters
		ArrayExamples.resetArray(letterCount2);
		testString = "Welcome to computer science all !!";
		ArrayExamples.countLetters(testString, letterCount2);  // get a second letter count for a different string
		result = ArrayExamples.getLetters(letterCount2); // result should be "[acccceeeeeilllmmnoooprsttuw]"
		correct = "[acccceeeeeilllmmnoooprsttuw]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		ArrayExamples.resetArray(letterCount);
		testString = "dogs and cats";
		ArrayExamples.countLetters(testString, letterCount);
	    ArrayExamples.resetArray(letterCount2);
	    ArrayExamples.countLetters(testString, letterCount2);
	    System.out.println("Testing getArraySum()");
	    int [] sumArray = ArrayExamples.getArraySum(letterCount, letterCount2);
		assertEquals(4, sumArray[0]);
		assertEquals(2, sumArray[2]);
		assertEquals(0, sumArray[25]);
		System.out.println("sumArray[0]:" + sumArray[0]);
		System.out.println("sumArray[2]:" + sumArray[2]);
		System.out.println("sumArray[25]:" + sumArray[25]);
		
		int [] array1 = {1, 100};
		int [] array2 = {2, 200};
		int [] resultArray = ArrayExamples.getArraySum(array1, array2);
		expInt = 3;
		actInt = resultArray[0];
		assertEquals(expInt, actInt);
		expInt = 300;
		actInt = resultArray[1];
		utils.MyUtils.showIntArray(array1, array1.length);
		utils.MyUtils.showIntArray(array2, array2.length);
		utils.MyUtils.showIntArray(resultArray, resultArray.length);
		assertEquals(expInt, actInt);
		utils.MyUtils.printTimeStamp("ENDS");
		System.out.println("End of Assignment #4 Testing for : " + sName);
	}


}
