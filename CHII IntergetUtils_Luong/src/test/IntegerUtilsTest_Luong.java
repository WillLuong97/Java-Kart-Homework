package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.IntegerUtils_Luong;

//Does not run this as a JUnit test case. 
public class IntegerUtilsTest_Luong 
{
	private static void test_isEven_Pro()
	{
		//testing for straightforward case. 
		System.out.println("***********TESTING EVEN!*************");
		System.out.print("TESTING FOR STRAIGHTFORWARD CASE! 2, 4, 17 \n");
		System.out.println(IntegerUtils_Luong.isEven(2));
		System.out.println(IntegerUtils_Luong.isEven(4));
		System.out.println(IntegerUtils_Luong.isEven(17));
		System.out.println("Testing for Bizare CASE! 0");
		System.out.println(IntegerUtils_Luong.isEven(0));
		System.out.println("TESTING for EXTREME CASE! -2, -7, -21");
		System.out.println(IntegerUtils_Luong.isEven(-2));
		System.out.println(IntegerUtils_Luong.isEven(-7));
		System.out.println(IntegerUtils_Luong.isEven(-21));


		//testing for extreme and bizzare case. 
	}
	
	private static void test_isOdd()
	{
		System.out.println("***********TESTING ODD!**************");
		System.out.print("TESTING FOR STRAIGHTFORWARD CASE! 3, 5, 2 \n");
		System.out.println(IntegerUtils_Luong.isOdd(3));
		System.out.println(IntegerUtils_Luong.isOdd(5));
		System.out.println(IntegerUtils_Luong.isOdd(2));
		System.out.println("Testing for EXTREME CASE! -21, -7, -2, -17, -28");
		System.out.println(IntegerUtils_Luong.isOdd(-21));
		System.out.println(IntegerUtils_Luong.isOdd(-7));
		System.out.println(IntegerUtils_Luong.isOdd(-2));
		System.out.println(IntegerUtils_Luong.isOdd(-17));
		System.out.println(IntegerUtils_Luong.isOdd(-28));
		System.out.println("Testing for Bizare case! 0");
		System.out.println(IntegerUtils_Luong.isOdd(0));

	}
	
	public static void test_isPrime()
	{
		System.out.println("***********TESTING PRIME NUMBERS!***********");
		System.out.println("TESTING FOR STRAIGHTFORWARD CASE! 1, 23, 4, 77, 29");
		System.out.println(IntegerUtils_Luong.isPrime(1));
		System.out.println(IntegerUtils_Luong.isPrime(23));
		System.out.println(IntegerUtils_Luong.isPrime(4));
		System.out.println(IntegerUtils_Luong.isPrime(77));
		System.out.println(IntegerUtils_Luong.isPrime(29));

		System.out.println("TESTING FOR EXTREME CASE! 1049, -77, -11, -17, -2");
		System.out.println(IntegerUtils_Luong.isPrime(1049));
		System.out.println(IntegerUtils_Luong.isPrime(-77));
		System.out.println(IntegerUtils_Luong.isPrime(-11));
		System.out.println(IntegerUtils_Luong.isPrime(-17));
		System.out.println(IntegerUtils_Luong.isPrime(-2));
		System.out.println("TESTING FOR BIZARE CASE! 0");
		System.out.println(IntegerUtils_Luong.isPrime(0));
	}
	
	private static void test_isSorted()
	{
		System.out.println("*********************TESTING SORTED STRING********************");
		int intArray[] = {0 , 1, 0, 1, 2};
		System.out.println("Testing for srtaightforward case");
		System.out.println(IntegerUtils_Luong.isSorted(intArray));
		int arr[] = {0, 1, 2, 3, 4};
		System.out.println(IntegerUtils_Luong.isSorted(arr));
		int a[] = {0, 1, 2, 3, 4, 3, 2, 1, 0};
		System.out.println(IntegerUtils_Luong.isSorted(a));
		System.out.println("Testing for extreme case!");
		int x[] = {3, 2, 1};
		System.out.println(IntegerUtils_Luong.isSorted(x));
		int b[] = {7, 7, 7};
		System.out.println(IntegerUtils_Luong.isSorted(b));
		int c[] = {};
		System.out.println("**********Testing for bizare case*********");
		System.out.println(IntegerUtils_Luong.isSorted(c));
	}
	
	private static void test_reverse()
	{
		//testing for straightforward case
		System.out.println("*******************TESTING REVERSE**********");
		System.out.println(IntegerUtils_Luong.reverse(45));
		System.out.println(IntegerUtils_Luong.reverse(32100));
		System.out.println(IntegerUtils_Luong.reverse(0));
	} //need to write more test cases!!!!
	
	private static void test_smallestIndex()
	{
		System.out.println("***********TESTING GetSmallestIndex!*************");
		System.out.println("TESTING FOR STRAIGHTFORWARD CASE");
		int [] numbers = new int[] {0, 1, 0, 1, 2, 0, 1, 2, 3};
		System.out.println(IntegerUtils_Luong.getSmallestIndexOfMatch(numbers, 2));
		int [] numbers2 = new int[] {0, 1, 0, 1, 2, 0, 1, 2, 3};
		System.out.println(IntegerUtils_Luong.getSmallestIndexOfMatch(numbers2, 3));
		int [] numbers3 = new int[] {23, 4, 14, 54, 5, 6};
		System.out.println(IntegerUtils_Luong.getSmallestIndexOfMatch(numbers3, 6));
		System.out.println("TESTING FOR EXTREME CASE");
		int [] numbers4 = new int[] {0, 1, 0, 1, 2, 0, 1, 2, 3};
		System.out.println(IntegerUtils_Luong.getSmallestIndexOfMatch(numbers4, 0));
		System.out.println("TESTING FOR BIZARE CASE");
		int[] numbers5 = new int[]{0, 1, 0, 1, 2, 0, 1, 2, 3};
		System.out.println(IntegerUtils_Luong.getSmallestIndexOfMatch(numbers5, 4));

	}
	
	public static void test_common_factor()
	{
		System.out.println("*******************TESTING GREATEST COMMON FACTOR****************");
		System.out.println("Testing for straightforward case");
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(0, 11));
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(21, 14));
		System.out.println("Testing for extreme case");
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(0, -11));
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(5, -10));
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(-12, -7));
		System.out.println("Testing for bizarre case");
		System.out.println(IntegerUtils_Luong.greatestCommonFactor(2023, 8993));
	}
	
	public static void test_maximum()
	{
		System.out.println("*********************TESTING MAXIMUM VALUES IN AN ARRAY******************");
		Set<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		System.out.println(IntegerUtils_Luong.getMaximum(set));
		
		Set<Integer> a =  new HashSet<Integer>();
		a.add(3);
		a.add(8);
		a.add(7);
		a.add(2);
		a.add(5);
		System.out.println(IntegerUtils_Luong.getMaximum(a));
		
		Set<Integer> b = new HashSet<Integer>();
		b.add(7);
		b.add(7);
		b.add(7);
		System.out.println(IntegerUtils_Luong.getMaximum(b));
	}
	
	public static void test_minimum()
	{
		System.out.println("***************************TESTING MINIMUM! **************************");
		System.out.println("Testing the cases!");
		int[] arr1 = new int[] {1, 2, 3, 2, 1};
		System.out.println(IntegerUtils_Luong.getMinimum(arr1));
		int[] arr2 = new int[] {3, 8, 7, 2, 5};
		System.out.println(IntegerUtils_Luong.getMinimum(arr2));
		int[] arr3 =  new int[] {7, 7, 7};
		System.out.println(IntegerUtils_Luong.getMinimum(arr3));
		int[] arr4 = new int[] {8, 6, 7, 5, 3, 0, 9};
		System.out.println(IntegerUtils_Luong.getMinimum(arr4));
		System.out.println("Testing out the bizare case");
		int [] arr5 = new int[] {-1, 2, -3, 4, -5};
		System.out.println(IntegerUtils_Luong.getMinimum(arr5));
		
	}
	
	public static void test_constrained_multiple()
	{
		System.out.println("******************TESTING CONSTRAINED MULTIPLE************************");
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(10, 125));
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(11, 92));
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(79, -200));
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(7, 50));
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(-15, 10));
		System.out.println(IntegerUtils_Luong.getGreatestConstrainedMultiple(-7, 23));

		
	}
	
	
	private static void test_sumthing()
	{
		System.out.println("***********TESTING SUMTHING!****************");
		System.out.println(IntegerUtils_Luong.sumthing(31));
		System.out.println(IntegerUtils_Luong.sumthing(32));
		System.out.println(IntegerUtils_Luong.sumthing(314));
		System.out.println(IntegerUtils_Luong.sumthing(51));
		System.out.println(IntegerUtils_Luong.sumthing(2));
		System.out.println(IntegerUtils_Luong.sumthing(90));
		System.out.println(IntegerUtils_Luong.sumthing(12));
		System.out.println(IntegerUtils_Luong.sumthing(-11));

	}
	private static void test_getIntegerH()
	{
		System.out.println("****************TESTING FOR GETINTEGER H*************");
		System.out.println(IntegerUtils_Luong.getIntegerH(0, 0));
		System.out.println(IntegerUtils_Luong.getIntegerH(15, 0));
		System.out.println(IntegerUtils_Luong.getIntegerH(2, 2));
		System.out.println(IntegerUtils_Luong.getIntegerH(3, 4));
		System.out.println(IntegerUtils_Luong.getIntegerH(7, 3));
		System.out.println(IntegerUtils_Luong.getIntegerH(-7, -3));

		
	}
	
	
	
	private static void checkAssertionsAreEnabled()
	{
		try
		{
			assert false;
			throw new RuntimeException("\nDr.Kart says: ASSERTION ARE NOT ENABBLED; ENABLE THEM!!!!!!!\n1. Recall that assertion being enabled is a property of the Run(or Debug) Configuration\n2. Try Googling Eclipse Java enable assertion \n3When assertion are enabled, you won't see this message.");
			
		}
		catch(AssertionError ae)
		{
			//DO NOTHING HERE
		}
	}
	
	private static Set<Integer> getFirstTenIntegersSet()
	{
		Set<Integer> integerSet = new HashSet<Integer>();
		assert integerSet.size() == 0;
		
		for(int i = 1; i <= 10; i++)
		{
			integerSet.add(i);
			
		}
		assert integerSet.size()==10; 
		
		//add them again:
		for(int i = 1; i<= 10; i++)
		{
			integerSet.add(i);
			//the size of the integerSet does not change
			assert integerSet.size() == 10;
			
		}
		
		assert integerSet.contains(1);
		assert integerSet.contains(2);
		assert integerSet.contains(3);
		assert integerSet.contains(4);
		assert integerSet.contains(5);
		assert integerSet.contains(6);
		assert integerSet.contains(7);
		assert integerSet.contains(8);
		assert integerSet.contains(9);
		assert integerSet.contains(10);
		
		//just for fun:
		integerSet.remove(3);
		assert integerSet.size() == 9;
		integerSet.add(3);
		assert integerSet.size() == 10; 
		
		return integerSet;
	
	}
	
	private static String toStringSetElements(Set<Integer> integerSet) 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		List<Integer> integerList = new ArrayList<Integer>(integerSet); 
		assert integerList.size() == integerSet.size();
		
		for(int i = 0; i < integerList.size(); i++)
		{
			Integer element = integerList.get(i);
			sb.append(element);
			boolean processingLastElement = (i==integerList.size() - 1);
			if(!processingLastElement) sb.append(",");
			
		}
		sb.append("}");
		
		return sb.toString();
		

		
	}
	
	
	private static void test_commonfactor()
	{
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(3);
		integerSet.add(45);

	}
	
	//main function
	public static void main(String[] args)
	{
		System.out.println("TESTING METHODS WRITTEN FROM INTGERUTILS_LUONG");
		//Student: Don't comment out or delete this line
		checkAssertionsAreEnabled(); 
		
		test_isEven_Pro(); 
		test_isOdd();
		test_isPrime();
		test_isSorted();
		test_smallestIndex();
		test_common_factor();
		test_minimum();
		test_maximum();
		test_getIntegerH();
		test_reverse();
		test_sumthing();
		test_constrained_multiple();
		
		
		Set<Integer> firstTenIntegers = getFirstTenIntegersSet();
		String stringRepresentation = toStringSetElements(firstTenIntegers); 
		System.out.println(stringRepresentation);
		
		//Make sure this line stays at the last line of main():
		System.out.println("Congratulations! Your program execution made it to the end of the main method!");
		
	}
}
