package example;

import java.util.Arrays;
import java.util.Random;

public class ComplexityExamples {
	private final static boolean VERBOSE = false;

	public static int example1(int n)
	{
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			if(VERBOSE) System.out.println(String.format("i = %s", i));
			count++;
		}

		return count;
	}

	public static int example2(int n)
	{
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(VERBOSE) System.out.println(String.format("(i, j) = (%s, %s)", i, j));
				count++;
			}
		}
		return count;
	}

	public static int example3(int n)
	{
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n*n; j++)
			{
				if(VERBOSE) System.out.println(String.format("(i, j) = (%s, %s)", i, j));
				count++;
			}
		}
		return count;
	}

	public static int example4(int n)
	{
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(VERBOSE) System.out.println(String.format("(i, j) = (%s, %s)", i, j));
				count++;
			}
		}
		return count;
	}

	public static int example5(int n)
	{
		int count = 0;
		//i can take on n value.
		for(int i = 0; i < n; i++)
		{
			//j can take on n^2 values.
			for(int j = 0; j < i*i; j++)
			{
				//k can take on n^2 values
				for(int k = 0; k < j; k++)
				{
					if(VERBOSE) System.out.println(String.format("(i, j, k) = (%s, %s, %s)", i, j, k));
					count++;
				}
			}
		}
		return count;
	}

	public static int example6(int n)
	{
		int[] intArray = getRandomArray(n, -n, n);
		return getIndex_LinearSearch(intArray, 0);
	}

	public static int example7(int n)
	{
		int[] intArray = getRandomArray(n, -n, n);
		Arrays.sort(intArray);
		return getIndex_BinarySearch(intArray, 0);
	}

	public static int example8(int n)
	{
		int[] intArray = getRandomArray(n, -n, n);
		return getIndex_LinearSearch(intArray, 2*n);
	}

	public static int example9(int n)
	{
		int[] intArray = getRandomArray(n, -n, n);
		Arrays.sort(intArray);
		return getIndex_BinarySearch(intArray, 2*n);
	}

	public static int example10(int n)
	{
		int[] intArray = getFirstNEvenIntegers(n);
		return getIndex_BinarySearch(intArray, 4*n);
	}

	public static int whatHappens()
	{
		int[] intArray = new int[]{99, 48, 32, 10, -1, 22, 62};
		return getIndex_BinarySearch(intArray, 22);
	}

	private final static int NOT_FOUND = -1;
	public static int getIndex_LinearSearch(int[] intArray, int value)
	{
		int count = 0;

		boolean foundMatch = false;
		int i = 0;
		while(!foundMatch && i < intArray.length)
		{
			foundMatch = (intArray[i] == value);
			count++;
			if(!foundMatch) i++;
		}
		int index = (foundMatch ? i : NOT_FOUND);

		assert (index == NOT_FOUND || intArray[index] == value) : String.format("index = %s, but intArray[%s] <> %s = value!", index, index, value);
		return index;
	}

	public static int getIndex_BinarySearch(int[] intArray, int value)
	{
		assert isSorted(intArray) : String.format("intArray is not sorted! : intArray = %s", Arrays.toString(intArray));

		int index = getIndex_BinarySearchHelper(intArray, value, 0, intArray.length - 1, 0);

		assert (index == NOT_FOUND || intArray[index] == value) : String.format("index = %s, but intArray[%s] <> %s = value!", index, index, value);
		return index;
	}

	private static int getIndex_BinarySearchHelper(int[] intArray, int value, int lowArrayIndex, int highArrayIndex, int count)
	{
		assert lowArrayIndex <= highArrayIndex + 1 : String.format("lowArrayIndex = %s > %s = (highArrayIndex + 1)!", lowArrayIndex, (highArrayIndex + 1));
		assert isSorted(intArray) : String.format("intArray is not sorted! : intArray = %s", Arrays.toString(intArray));

		int indexOfMatch = NOT_FOUND;

		if(lowArrayIndex < highArrayIndex + 1)
		{
			int middleArrayIndex = (highArrayIndex - lowArrayIndex)/2 + lowArrayIndex;
			boolean foundMatch = (intArray[middleArrayIndex] == value);

			if(foundMatch)
			{
				indexOfMatch = middleArrayIndex;
				System.out.println(String.format("intArray = %s" + "\n" + "value = %s n = %s count = %s", Arrays.toString(intArray), value, intArray.length, count));
			}
			else
			{
				if(intArray[middleArrayIndex] < value) indexOfMatch = getIndex_BinarySearchHelper(intArray, value, middleArrayIndex + 1, highArrayIndex, count + 1);
				else indexOfMatch = getIndex_BinarySearchHelper(intArray, value, lowArrayIndex, middleArrayIndex - 1, count + 1);
			}
		}
		else
		{
			System.out.println(String.format("intArray = %s" + "\n" + "value = %s n = %s count = %s", Arrays.toString(intArray), value, intArray.length, count));
		}

		return indexOfMatch;
	}

	//pre: true
	//post: rv <==> (intArray[0] <= intArray[1] <= intArray[2] <= ... <= intArray[intArray.length - 1])
	private static boolean isSorted(int[] intArray)
	{
		boolean foundOutOfOrderPair = false;
		int i = 0;
		while(!foundOutOfOrderPair && i < intArray.length - 1)
		{
			foundOutOfOrderPair = (intArray[i] > intArray[i + 1]);
			if(!foundOutOfOrderPair) i++;
		}
		return !foundOutOfOrderPair;
	}

	//pre: true
	//post: For i = 0 to n, rv[i] = 2*i
	private static int[] getFirstNEvenIntegers(int n)
	{
		int[] intArray = new int[n];
		for(int i = 0; i < intArray.length; i++)
		{ 
			intArray[i] = 2*i;
		}
		return intArray;
	}

	//pre: true
	//post: For i = 0 to n, lowestElementPossible <= rv[i] <= highestElementPossible
	private static int[] getRandomArray(int n, int lowestElementPossible, int highestElementPossible)
	{
		Random random = new Random();

		int[] intArray = new int[n];
		for(int i = 0; i < intArray.length; i++)
		{ 
			int value = lowestElementPossible + random.nextInt((highestElementPossible + 1) - lowestElementPossible);
			assert lowestElementPossible <= value : String.format("lowestElementPossible = %s > %s = value!", lowestElementPossible, value);
			assert value <= highestElementPossible: String.format("value = %s > %s = highestElementPossible!", value, highestElementPossible);
			intArray[i] = value;
		}
		return intArray;
	}

	public static void main(String[] args)
	{
		for(int n = 0; n < 25; n++)
		{
//			System.out.println(String.format("n = %s count = %s", n, example4(n)));
			
//			System.out.println(whatHappens());
//			//Before assertion:
////			intArray = [99, 48, 32, 10, -1, 22, 62]
////					value = 22 n = 7 count = 1
////					5
			
//			System.out.println(String.format("n = %s count = %s", 100, example8(100)));

			
//			System.out.print(" ");
//			System.out.println(String.format("n = %s count = %s", n, example7(n)));
//			System.out.print(" ");
//
//			System.out.println(String.format("n = %s count = %s", n, example8(n)));
//			System.out.print(" ");
//
//			System.out.println(String.format("n = %s count = %s", n, example9(n)));
//			System.out.print(" ");
//
			System.out.println(String.format("n = %s count = %s", n, example4(n)));
//			System.out.print(" ");



		}
	}
}
