package asg2;

public class Asg2Methods {
	
	public static double getDiscountPrice(char discountCode, double price) 
	{
		double retValue = 0.0; 
		double price2 = 0.0; 
		double price3 = 0.0; 
		double price4 = 0.0;
		
		
		if (price <= 0)
		{
			retValue = 0.0; 

		}
		
		else if (discountCode == 'S' || discountCode == 's') 
		{
			price2 = (price * 0.1);
			retValue = price - price2; 
			
		}
		
		else if (discountCode == 'P' || discountCode == 'p') 
		{
			price3 = (price * 0.25);
			retValue = price - price3;
			
		}
		
		else if (discountCode == 'Z' || discountCode == 'z')
		{
			price4 = (price * 0.4);
			retValue = price - price4;
		}
		
		else 
		{
			retValue = price; 
			
		}
		
		return retValue; 
		
		
	} // End of method 1. 
	
	public static String sillyString(String aString1) 
	{
		String retValue1 = "";
		
		for (int index = 0; index < aString1.length(); index++) 
		{
			char ch = aString1.charAt(index);
			char ch1 = Character.toLowerCase(ch);
			
			if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') 
			{
				 ch1 = Character.toUpperCase(ch1);  
				
			}
		retValue1 += ch1; 
		}
		
	return retValue1; 
	
	} // End of method 2 
	
	
	public static boolean isValid(String aString)
	{
		boolean retValue2 = true; 
		char string; 
		for (int index = 0; index < aString.length(); index++) 
		{
			string = aString.charAt(index);
			if(!(Character.isLetterOrDigit(string))) 
			{
				retValue2 = false;
				break; 
				
			}
		}
		
		if (aString.length() == 0)
		{
			retValue2 = false; 
		}
	return retValue2; 
	} // End of method 3. 
	
	
	
	public static String removeSpaces(String word) 
	{
		String withoutSpace = "";
		
		for (int t = 0; t < word.length(); t++) 
		{
			withoutSpace = word.replaceAll("\\s", "");
			
		}
		
		return withoutSpace;
	} // End of removing space method. 
	
	
	
	public static double toCelsius(double temperature)
	{
		double conversedValue = 0.0;
		
		conversedValue = ((temperature - 32) * 5)/9;
		
		return conversedValue; 
	
	} // End of temperature conversion method. 
	
	
	public static char getLetterGrade(double gradeAvg) 
	{
		char letterGrade = '\0'; 
		
		if (gradeAvg < 0.0 || gradeAvg > 105.0) 
		{
			letterGrade = 'X'; 
			
		}
		
		else if (gradeAvg >= 90.0 && gradeAvg < 105.0) 
		{
			letterGrade = 'A';
		}
		
		else if (gradeAvg >= 80.0 && gradeAvg < 90.0) 
		{
			letterGrade = 'B';
		}
		
		else if (gradeAvg >= 70.0 && gradeAvg < 80.0) 
		{
			letterGrade = 'C';
			
		}
		
		else if (gradeAvg >= 60.0 && gradeAvg < 70.0) 
		{
			letterGrade = 'D';
			
		}
		
		else if ( gradeAvg < 60.0) 
		{ 
			letterGrade = 'F';
			
		}
		
		return letterGrade; 
		
	} // End of getting a letter grade. 
	
	
	public static String getFirstLast(String aString) 
	{
		
		String firstLast = ""; 
		char getCharacter;
		
		for(int e = 0; e < aString.length(); e++) // For Loop to watch for each character in the string. 
		{
			if (e == 0 || e == aString.length()-1) // Check for the first and last character in the string. 
			{
				getCharacter = aString.charAt(e);
				firstLast += getCharacter; 
			} // Getting the fist and last characters and append them to the return string. 

		} 
		return firstLast; 
		
	} // End of getting the first and last of a string. 
	
	
	
	public static int countNewLines(String someString) 
	{
		int newLines = 0; 
		for (int index = 0; index < someString.length(); index++) 
		{
			char ch = someString.charAt(index);
			if(ch == '\n') // checking for the new lines. 
			{
				newLines ++;
			}
		}

			return newLines;
		
	} // End of counting new lines. 
	
	
	public static String getWeatherMessage(int temp) 
	{
		String weatherMessage = ""; 
		
		if (temp < 10) 
		{
			weatherMessage = "Temperature is: " + temp + " degrees and it is freezing";
			
		}
		
		else if (temp >= 10 && temp <= 30) 
		{
			weatherMessage = "Temperature is: " + temp + " degrees and it is cold, very cold";
			
		}
		
		else if (temp >= 31 && temp <= 50)
		{
			weatherMessage = "Temperature is: " + temp + " degrees and it is Chilly chilly";
		}
		
		else if (temp >= 51 && temp <= 70) 
		{
			weatherMessage = "Temperature is: " + temp + " degrees and it is warm";
			
		}
		
		else if ( temp > 70) 
		{
			weatherMessage = "Temperature is: " + temp + " degrees and it is getting hot"; 
			
			
		}
		
	return weatherMessage; 
	
	} // End of weather message method. 
}
