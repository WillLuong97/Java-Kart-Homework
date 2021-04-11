//Name: Tri (Will) Luong
//Professor Kart
//COSC 2329
//Assignment 2.
//02/08/2019

package utils;

import java.util.Set;

public interface IntegerUtils_Luong 
{	
	//This method will check if an assigned integer is even or not. 
	//Return true if is even and false if it is not even. 
	// Straightforward case: 2 => Return: True
	// Extreme case: -2 => Return: True
	// Bizare case:  0 => Return: False
	public static boolean isEven(int k)
	{
		boolean checkEven = true;
		if(k % 2 != 0)
		{
			checkEven = false; 
		}

		return checkEven;
		
	} //end of isEven()
	
	//This method will check if an assigned integer is odd or not
	// Return true if odd and false if not odd. 
	// Straightforward case: 3 => Return: True
	// Extreme case: -3 => True
	// Bizare case: 0 => False
	public static boolean isOdd(int k)
	{
		boolean checkOdd = false;
		if(k % 2 != 0)
		{
			checkOdd = true;
		}
		
		return checkOdd;
	} //end of isOdd()
	
	// This method will check if a number is a prime number.
	// Return true for a prime number and false if it is not a prime number
	// Straightforward case: 3 => Return True
	// Extreme case: 0 => Return false
	// Bizare case: -2 => Return false
	public static boolean isPrime(int k)
	{
		if(k <= 1)
		{
			return false;
		}
		for (int i = 2; i <= k/2; ++i)
		{
			if(k % i == 0)
			{
				return false;
			}
		}
		
		return true;
	}//end of isPrime()
	
	// This method will find the greatest common factor between two integers that are passed into 
	// Return an integer that will be the greatest common factor
	// Straightforward case: (0, 11) => Return: 11
	// Extreme case: (5, -10) => Return: 5
	// Bizare case: (0, 1) => Return: 1
	public static int greatestCommonFactor(int m, int n)
	{
		if(n == 0)
		{
			return m;
		}
		
		return greatestCommonFactor(n, m%n);
		
	}//end of greatestCommonFactor().
	
	
	// This method will find the greatest constrained multiple from the 2 integers that are passed into
	// Return an interger that will be the greatest common factor
	// Straightforward case: (7, 50) => Return: 49
	// Extreme case: (-7, -2) => Return: 0
	// Bizare case:	(0, 0)	=> Return: null
	public static int getGreatestConstrainedMultiple(int k, int maximum)
	{
		int multiple = maximum/k;
		return k*multiple;
		
	} // end of getGreatestConstrainedMultiple().
	
	
	// This program will return the number whose product comes from a quotient of 3 and a remainder of 5
	// Straightforward case: (2, 2) => Return: 7
	// Extreme case: (-7. -3) => Return: -23
	// Bizare case: (0, 0) => Return: 0
	public static int getIntegerH(int h_q_3, int h_r_5)
	{
		int result = 0;
		
		while(result/3 != h_q_3 || result% 5 != h_r_5)
			
		{
			
			result++;
			
		}
		
		return result;

	} //end of getIntegerH()
	
	// This method will find the maximum values in a set
	// Return an integer that will be the maximum in a set
	// Straightforward case: (1, 2, 3, 4,5) => Return: 5
	// Extreme case: (-2, 3, 1, -4) => Return: 3
	// Bizare case: (7, 7, 7) => Return: 7
	public static int getMaximum(Set<Integer> integerSet)
	{
		int max = Integer.MIN_VALUE; //VALUE TO BE TESTED.
		for(int i: integerSet)   //loop through the Set to find the maximum values.
		{
			if(i > max)
			{
				max = i;
			}
		}
		
		return max;
	} //end of getMaximum().
	
	// This method will find the minimum value in an array 
	// Return an integer that will be the minimum
	// Straightfoward case: (2, 3, 1, 5) => Return: 1
	// Extreme case: (1, 2, 3, 5, 1) => Return: 1
	// Bizare case: (-1, 3, 4, -5) => Return: -5
	public static int getMinimum(int[] intArray)
	{
		int smallest = intArray[0];
		for(int i = 0; i<intArray.length; i++)
		{
			if(intArray[i] < smallest)
			{
				smallest = intArray[i]; //if the element is smaller than the assigned smallest value, then that value is the new smallest
			}
		}
		return smallest;
	} //end of getMinimum().
	
	
	//This method will check if an assigned array is sorted or not
	//Return True if it is sorted and False if it is not.
	//Straightforward case:  (1, 2, 3, 4, 5) => Return: True
	//Extreme case: (6, 6, 6) => Return: true
	//Bizare case: [] => Return: True
	public static boolean isSorted(int[] intArray)
	{		
		if(intArray.length == 0)
		{
			return true;
		}
		for(int i = 0; i < (intArray.length)-1; ++i)
		{
			if(intArray[i]<=(intArray[i+1]))
			{
				return true;
			}
		}
		return false;
		
	} //end of isSorted()
	
	// This method will find the smallest index of a value in an array that matched up with the target match
	// Return an integer that will be the index of the match
	// Straightforward case: ((1, 2, 2, 4, 5), 2) => Return: 1
	// Extreme case: (1, 2, 3, 7, 5), 4) => Return: -1
	// Biazzare case: ((7, ,7 ,7), 7) => Return: 0
	public static int getSmallestIndexOfMatch(int[] intArray, int target)
	{
		//if the list is empty, return -1
		if(intArray.length == 0)
		{
			return -1;   
		}
		
		//Loop through the list to find the value.
		for(int index = 0; index < intArray.length; index++)
		{
			if(intArray[index] == target)
			{
				return index;
			}
		}
		
		return -1; //if can't find the right index or index does not exist.

	} //end of getSmallestIndexOfMatch()
	
	//This method will reverse any integers that will be passed into the method
	//Return an int that will be the reversed version of the assigned integers
	// Straightforward case: 45 => Return: 54
	// Extreme case: 32100 => Return: 123
	// Bizare case: 0 => Return: 0
	public static int reverse(int k)
	{
		String revNum = Integer.toString(k);  //string that hold original number. 
		String result = "";  //string that will hold the reversed number
		
		for(int i = revNum.length()-1; i>= 0; i--) //walk through the loops and reverse the digits.
		{
			result += revNum.charAt(i);
			
		}
		
		return Integer.parseInt(result);
	} //end of reverse()
	
	//This method will return the sum of each digit in a number.
	//Return an integer values that will be the value of the sum
	// Straightforward case: 23 => Return: 5
	// Extreme case: 20 => Return: 2
	// Bizare case: -11 => Return: -2
	public static int sumthing(long k)
	{
		int result = 0;
		
		while(k != 0)
		{
			result = (int) (result + k % 10);
			k = k/10;
		}
		
		return result;
		
	}//end of sumthing().
	
	

} //end of IntegerUtils_Luong()
