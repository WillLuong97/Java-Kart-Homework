//package test;

//public class Asg2Test 
//{
package test;

import java.util.Scanner;

import asg2.Asg2Methods;

public class Asg2Test {
	public static void main(String[] args) 
	{
		String yourName = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name: ");
		yourName = in.nextLine();
		System.out.println("Begin Testing Assignment #2 for " + yourName);
		System.out.println("*****Now testing getDiscountPrice method*****");
		char code = 'P';
		double price = 100.00;
		double retPrice = 0.00;
		double expPrice = 75.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 's';
		price = 100.00;
		expPrice = 90.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 'S';
		price = 10.00;
		expPrice = 9.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 'p';
		price = 10.00;
		expPrice = 7.50;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 'P';
		price = 10.00;
		expPrice = 7.50;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);

		code = 'z';
		price = 10.00;
		expPrice = 6.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = '4';
		price = 10.00;
		expPrice = 10.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = ';';
		price = 10.00;
		expPrice = 10.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 'p';
		price = -10.00;
		expPrice = 0.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);
		code = 's';
		price = 0.00;
		expPrice = 0.00;
		retPrice = Asg2Methods.getDiscountPrice(code, price);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discountPrice to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discountPrice was: " + retPrice);

		System.out.println("***** Now testing sillyString() method*****");
		String orgString ="";
		String retString ="";
		String expString="";
		orgString ="Hello There";
		expString = "hEllO thErE";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="Lots of Vowels here haaaaaaaaa";
		expString = "lOts Of vOwEls hErE hAAAAAAAAA";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = " DJK RST ";
		expString = " djk rst ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "";
		expString = "";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " (empty string) received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " (empty string) WRONGLY received " + retString);
		orgString = ";**&&%$#@ ";
		expString = ";**&&%$#@ ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		System.out.println("*****Now testing isValid()*****");	
		String string = "";
		boolean expBool = false;
		boolean retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "thisIsAValid233String999";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "12345678900";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEaabb FGHIJ22K33 ddLMNOPQRSTUVWXYZ";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string="";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		System.out.println("***** Now testing countNewLines() *****");
		string ="Hello there!!!";
		int expVal = 0;
		int retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
		string ="";
		expVal = 0;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
		string ="\n\n \n ee \n\n\n";
		expVal = 6;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal); 
		string ="\ntestingtestingtesting";
		expVal = 1;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
		System.out.println("*****Now testing getWeatherMessage()*****");
		String m1 = Asg2Methods.getWeatherMessage(10);
		String  tempString = m1.toLowerCase();
		expString = "cold";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " in received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(30);
		tempString = m1.toLowerCase();
		expString = "cold";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(31);
		tempString = m1.toLowerCase();
		expString = "chilly";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received  String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(50);
		tempString = m1.toLowerCase();
		expString = "chilly";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " receivedString (after lowercase)  " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(51);
		tempString = m1.toLowerCase();
		expString = "warm";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);

		m1 = Asg2Methods.getWeatherMessage(70);
		tempString = m1.toLowerCase();
		expString = "warm";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(71);
		tempString = m1.toLowerCase();
		expString = "hot";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(100);
		tempString = m1.toLowerCase();
		expString = "hot";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);
		m1 = Asg2Methods.getWeatherMessage(0);
		tempString = m1.toLowerCase();
		expString = "freezing";
		if(tempString.contains(expString))
			System.out.println("SUCCESS  expected:" + expString + " received String (after lowercase) " + tempString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received String (after lowercase) " + tempString);

		System.out.println("*****Now testing removeSpaces()*****");
		orgString ="   Lots of Vowels here haaaaaaaaa    ";
		expString = "LotsofVowelsherehaaaaaaaaa";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="     ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="\t\t  \t\n\n\n  \n\n\n";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="   a  b     c 3 ; #    d  F  K  qqqq   ! ";
		expString = "abc3;#dFKqqqq!";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		System.out.println("*****Now testing getFirstLast()*****");
		orgString ="Lots of Vowels here haaaaaaaaa";
		expString = "La";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="St. Edward's University";
		expString = "Sy";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="aabbaa";
		expString = "aa";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="Q";
		expString = "Q";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="";
		expString = "";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		System.out.println("*****Now testing toCelsius()*****");
		double expDouble=0.0;
		double retDouble = 0.0;
		double orgDouble = 0.0; 
		orgDouble = 212.0;
		expDouble = 100.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		double diff = 0.0;
		double allowableDiff = 0.0001;  // if we are within 1/10000 we'll accept...
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);

		orgDouble = 32.0;
		expDouble = 0.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = 100.0;
		expDouble = 37.77777777777778;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = -100.0;
		expDouble = -73.33333333333334;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		System.out.println("****Now testing getLetterGrade()****");
		char expChar = 'A';
		char retChar='A';
		orgDouble=89.9999;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=104.0;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=105.01;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=111.9999;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=-100.0;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=79.9999;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=80.0;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=59.9999;
		expChar = 'F';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=69.9999;
		expChar = 'D';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=77.7777;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=99.9999;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);

		System.out.println("End of Testing Assignment #2 for " + yourName);

	}
}

//}
