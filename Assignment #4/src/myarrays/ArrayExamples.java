package myarrays;

public class ArrayExamples 
{
	   // finds and returns largest value in the array list.	  
	   // precondition: numElementsInArray >=1  and list.length >= 1
	   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
	   // Example call #1:   int theMax = ArrayExamples.findMax(someArrayOfInts, size);
	   // Example call #2:   int biggest  = ArrayExamples.findMax(myList, 10);
	   // Example call #3:   int aMax = ArrayExamples.findMax(yourList, 25);
	   public static int findMax(int [] list, int numElementsInArray) 
	   {
		   int max = list[0]; 
		   for (int i = 0; i < numElementsInArray; i++ )
		   {
			   if(list[i] > max)
			   {
				   max = list[i];
			   }
		   }
		   return max; 
		   
	   } //End of finding the largest value.  
	   
	   
	   // finds and returns the smallest value in the array list.
	   // precondition: numElementsInArray >= 1  and list.length >= 1
	   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
	   // Example call #1: int theMiN = ArrayExamples.findMin(someArrayOfInts, size); 
	   // Example call #2: int smallest = ArrayExamples.findMin(theList, 10); 
	   // Example call #3: int aMin = ArrayExamples.findMin(yourList, 34);
	   public static int findMin(int [] list, int numElementsInArray)
	   {
		   int min = list[0]; 
		   for (int a = 0; a < numElementsInArray; a++)
		   {
			   if(list[a] < min)
			   {
				   min = list[a];
				   
			   }
		   }
		   
		   return min; 
	   } // End of returning the smallest value in the array. 
	   
	   
	   // computes and returns average of all values in array list
	   // computes the average as a double
	   // precondition:  numElementsInArray >=0  and list.length >= 0
	   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
	   // Example call #1: double theAverage = ArrayExamples.computeAverage(someArrayOfInts, size);
	   // Example call #2: double average = ArrayExamples.computeAverage(myList, 10); 
	   // Example call #3:  double findAverage = ArrayExamples.computeAverage(list1, list1.length); 
	   public static double computeAverage(int [] list, int numElementsInArray)
	   {
		   int sum = 0; 
		   for(int i = 0; i <numElementsInArray; i++)
		   {
			   sum += list[i];
		   }
		   double ave = (double)sum / numElementsInArray; 
		   
		   return ave; 
		   
	   } //End of returning average. 
	   
	   
	   // 	increases EVERY value in array list by 10%.
	   //  	the array has numElementsInArray values stored in it currently.
	   // 	v if value in list is negative, increases negative value by 10% smaller 
	   // precondition:  numElementsInArray >=0  and list.length >= 0 and numElementsInArray <= list.length 
	   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
	   // Example call #1: ArrayExamples.raiseAll(list2, list2.length);
	   // Example call #2: ArrayExamples.raiseAll(myList, 20); 
	   // Example call #3: ArrayExamples.raiseAll(list3, list3.length); 
	   public static void raiseAll(double [] list, int numElementsInArray)
	   {
		   for (int x = 0; x < numElementsInArray; x++ )
		   {
			   list[x] = list[x] *1.1; 

		   }
		   
	   } //End of raiseAll method. 
	   
	   
	   // counts the number of times the received String, valueToMatch, 
	   //  appears in the String array list, ignores case.
	   //  returns that count.
	   // receives: list - an array of Strings to examine, int numElementsInArray, and the String, valueToMatch
	   // Example call #1: int theMatch = ArrayExamples.countMatches(list1, list1.length, matchString);
	   // Example call #2: int match = ArrayExamples.countMatches(list3, list3.length, aString); 
	   // Example call #3: int findMatch = ArrayExamples.countMatches(list2, 40, theString); 
	   public static int countMatches(String [] list, int numElementsInArray, String valueToMatch)
	   {
		   int count = 0; 
		   
		   for(int index = 0; index < numElementsInArray; index ++)
		   {
			   if(list[index].equals(valueToMatch))
			   {
				   count++; 
			   }
			   
		   }
		   
		   return count; 
	   } // End of countMatches. 
	   
	   
	   // returns index of received String, valueToMatch in array of String, list, if found, returns -1 if not found
	   // precondition: if duplicate Strings exist, returns index of first match found
	   // receives: list - an array of Strings to examine, numElementsInArray, and the valueToMatch
	   // Example call #1: int index = ArrayExamples.findIndexOf(list3, list3.length, theString); 
	   // Example call #2: int find = ArrayExamples.findIndexOf(list1, list2.length, aString); 
	   // Example call #3: int i = ArrayExamples.findIndexOf(list4, list4.length, matchString); 
	   public static int findIndexOf(String []list, int numElementsInArray, String valueToMatch)
	   {
		  String match = valueToMatch.toLowerCase();
		  
		  int count = 0; 
		  
		  for (int c = 0; c <numElementsInArray; c++) 
		  {
			 String compare = list[c].toLowerCase(); 
			 if (compare.equals(match))
			 {
				 count = c;
				 break;
	
			 }
			 
			 else
			 {
				 count = -1; 
			 }
			
		  }
		  
		  return count; 
		   
	   }  // end of findIndexOf. 
	   
	  
	   // populates received integer array with all zero values
	   // precondition: 
	   // receives: array of integers that will have all locations set to zero
	   // Example call #1: 		ArrayExamples.resetArray(myArray); 
	   // Example call #2: 		ArrayExamples.resetArray(letterCount);
	   // Example call #3:  	ArrayExamples.resetArray(list); 
	   public static void resetArray(int [] list) 
	   {
		   for (int a = 0; a <list.length; a++)
		   {
			   list[a] = 0; 
		   }
		   
	   } //End of the populating the array.
	   
	   
	   // populates received integer array with count of each letter of alphabet in received String (case-insensitive)
	   // size of int array is 26 exactly and is zeroed out.
	   // receives: String to count letters in, and an array of integers of size 26
	   //  Example :  given "cats and dogs"  as the String, list[0] = 2, list[1] = 0, list[2] = 1, list[3]=2 etc.
	   //             each array location corresponds to a letter of the alphabet, 'a' is location 0, 'b' is location 1 etc.
	   // Example call #1:  ArrayExamples.countLetters(testString, letterCount2);
	   // Example call #2:  ArrayExamples.countLetters(testString, letterCount);
	   // Example call #3:  ArrayExamples.countLetters(testString, letterCount2);
	   public static void countLetters(String aString, int [] list) 
	   {
		   String lString = aString.toLowerCase(); 
		   for(int e = 0; e < lString.length(); e++)
		   {	
			   char ch = lString.charAt(e);
			   if(Character.isLetter(ch))
			   {
				  int lNumber = (int)ch - 97; 
				  list[lNumber]++; 
	
			   }
		   }
		   
	   } //end of countLetters method. 
	   
	   
	   // returns a String in described format of current letters in array
	   // receives the int array of letter counts
	   // Example: Assume: letterCount[1] = 4, letterCount[5] = 2,letterCount[6] = 3, with 0's all other locations returns: "[bbbbffggg]"
	   // Example call #1: String result = ArrayExamples.getLetters(letterCount);
	   // Example call #2: String result1 = ArrayExamples.getLetters(letterCount); 
	   // Example call #3:  result = ArrayExamples.getLetters(letterCount);
	   public static String getLetters(int []letterCount)
	   {
		 String str = "["; 
		 
		  
		  for(int v = 0; v < letterCount.length; v++) 
		  {
			  int num = letterCount[v];
			  if(num != 0)
			  {
				  for(int x = 0; x < num; x++)
				  {
					  int cNum = v + 97;
					  str += (char)cNum;
				  }
			  }
		  }
		  return str+"]";
			 
	   }// End of getLetters method. 
	  
	   
	   // Adds contents of 2 letterCount arrays received, returns an array with sum of each corresponding row.
	   // receives: 2 integer arrays of letterCounts, both of size 26
	   // returns an integer array with the sum of both letterCount arrays in each row.
	   // Example call #1:  int [] sumArray = ArrayExamples.getArraySum(letterCount, letterCount2);
	   // Example call #2:  int [] resultArray = ArrayExamples.getArraySum(array1, array2);
	   // Example call #3:  int [] newArray = ArrayExamples.getArraySum(array1, array2);
	   public static int [] getArraySum(int [] array1, int []array2) 
	   {
		   int [] letterSum = new int[26];
		   for(int j = 0; j < array1.length; j++)
		   {
			  letterSum[j] = array1[j] + array2[j]; 
			   
		   }
		   
		   return letterSum; 
		   
	   } //End of getArraySum method. 
	  
	   //  Gets value in a "letterCount" array in which each index corresponds to a letter of the alphabet, case-insensitive
	   //  so the letterCount array has 26 indexes, 0 to 25.
	   // receives: letterCount array and specific letter 
	   // returns: count of corresponding letter
	   // if invalid (non-letter) character received, returns 0.
	   public static int getCount(int []countArray, char ch)
	   { 
		   char ch1 = Character.toLowerCase(ch);
		   if(Character.isLetter(ch1))
		   {
			   int value = (int)ch1; 
			   value = value - 97; 
			   return countArray[value];
		   }
		   
		   else
		   {
			   return 0;
		   }
		   
	   } //End of getCount method. 
	  
} //End of assignment 4. 
