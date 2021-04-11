package dominoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DominoHighLowSetImpl_Luong implements Domino
{
	private Set<Integer> highLowSet;
		
//	part of pre: MINIMUM_PIP_COUNT <= highPipCount;
//	
//	part of pre: MINIMUM_PIP_COUNT <= lowPipCount;
//	
//	part of pre: lowPipCount <= MAXIMUM_PIP_COUNT;
//	
//	part of pre: highPipCount <= MAXIMUM_PIP_COUNT;
//	
//	part of pre: lowPipCount <= highPipCount;
	public DominoHighLowSetImpl_Luong(int highPipCount, int lowPipCount)
	{
		//executable pre-condition:
		assert MINIMUM_PIP_COUNT <= highPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > highPipCount!";
		
		assert MINIMUM_PIP_COUNT <= lowPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > lowPipCount!";
		
		assert lowPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount > MAXIMUM_PIP_COUNT!";
		
		assert highPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount > MAXIMUM_PIP_COUNT!";
		
		assert lowPipCount <= highPipCount: "Invalid Domino: lowPipCount > highPipCount!";
		
		this.highLowSet= new HashSet<Integer>();

		highLowSet.add(highPipCount);
		
		highLowSet.add(lowPipCount);
		
		
	}//end of DominoHighLowSetImpl_Luong
	
	
	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	
	//To do: check if String str fits the domino format and construct the right domino format to be used in later constructor.
	//part of pre: none
	public static boolean isSumDifferenceString(String str)
	{ 
		boolean result = true;				//Boolean attribute to assist with the testing process.
		
		//The assigned string can't hold a null value.
		if(str == null)
		{
			result = false;
			
			return result;
		}
		
		//The assigned string cannot be empty
		if(str.equals(""))
			
		{
			result = false;
			
			return result;
		}//end if.
		
		//the string length must be 3. (1 digit value case)
		if(str.length() == 3)
		{
			//delimiter must be in a particular index to fit in the domino format.
			if(str.charAt(1) != SUM_DIFFERENCE_DELIMITER)
			{
				result = false;
				
				return result;
			}
		}//end if.
		
		//the string length must be 4 ( 2 digit value case)
		if(str.length() == 4)
		{
			//Delimiter must be in a particular index to fit in the domino format.
			if(str.charAt(2)!= SUM_DIFFERENCE_DELIMITER)
			{
				result = false;
				
				return result;
			}
		}//end if
		
		// delimeter check.
		int inDelim = str.indexOf(SUM_DIFFERENCE_DELIMITER);
		
		//check if indexOfDelim is in the string.
		if(inDelim == -1)    //delimeter is not in the string.
		{
			result = false;
			return result;
		}//end if.
		
		else			//delimiter is valid. 
		//Begin domino construction:
		{
			int count = 0;
			
			//for loop: finding the occurrence of delimiter in the assigned string.
			for(int i = 0; i < str.length(); i++)
			{
				char ch = str.charAt(i);
				if(ch == SUM_DIFFERENCE_DELIMITER)
				{
					count++;
				}
			} //end for loop.
			
			
			//Domino format
			//Delimiter must be in between highpipcount and lowpipcount
			if(count == 1)		
			{
				try 		//begin construction of domino.
				{
					//extracting sum and difference:
					int sum = Integer.parseInt(str.substring(0,inDelim));
					int difference = Integer.parseInt(str.substring(inDelim + 1, str.length()));
					
					//sum and difference calculation:
					int highPipCount = (int) (.5*(sum + difference));
					int lowPipCount = (int) (.5*(sum - difference));

					// restriction:
					if(MINIMUM_PIP_COUNT > highPipCount)
					{
						result = false; 
						return result;
						
					}//end if.
					
					if(MINIMUM_PIP_COUNT > lowPipCount)
					{
						result = false;
						return result;
					}//end if
					
					if(lowPipCount > MAXIMUM_PIP_COUNT)
					{
						result = false;
						return result;
					}//end if. 
					
					if(highPipCount > MAXIMUM_PIP_COUNT)
					{
						result = false;
						return result;
					}//end if.
					
					if(lowPipCount > highPipCount)
					{
						result = false;
						return result;
					}//end if
					
					if((highPipCount + lowPipCount) != sum)
					{
						result =  false;
						return result;
					}//end if.
					
					if((highPipCount - lowPipCount) != difference)
					{
						result = false;
						return result;
					}


				}//end try.
				
				catch(NumberFormatException e)
				{
					result = false;
				}

			}//end if
		}//end else.
		
		return result;
	
	}//end of isSumDifferenceString(String str)
	
	//Part of pre: sumDifferenceString must satisfy the condition in method: isSumDifferenceString(String str).
	public DominoHighLowSetImpl_Luong(String sumDifferenceString)
	{
		highLowSet = new HashSet<Integer>();			//set will hold the domino attribute.
		
			//Domino construction process once sumDifferenceString pass the checks in isSumDifferenceString method.
			assert (isSumDifferenceString(sumDifferenceString));
		
			int delIn = sumDifferenceString.indexOf(SUM_DIFFERENCE_DELIMITER);
			int sum = Integer.parseInt(sumDifferenceString.substring(0,delIn));
			int difference = Integer.parseInt(sumDifferenceString.substring(delIn + 1, sumDifferenceString.length()));
			int highPipCount = (int) (.5*(sum + difference));
			int lowPipCount = (int) (.5*(sum - difference));
			
			//assertion:
			assert MINIMUM_PIP_COUNT <= highPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > highPipCount! ";
			assert MINIMUM_PIP_COUNT <= lowPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > lowPipCount! ";
			assert lowPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount > MAXIMUM_PIP_COUNT! ";
			assert highPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount > MAXIMUM_PIP_COUNT! ";
			assert lowPipCount <= highPipCount: "Invalid Domino: lowPipCount > highPipCount!";
			assert (highPipCount + lowPipCount) == sum;
			assert (highPipCount - lowPipCount) == difference;
						
			//domino construction.
			this.highLowSet.add(highPipCount);
			this.highLowSet.add(lowPipCount);
		//end of if
	}//end of DominoHighLowSetImpl_Luong(String sumDifferenceString).
	
	//This method will test to see if int k passed return the right low and high pip count from the calculation
	//receive: int k.
	//part of pre: none.
	//return: boolean
	public static boolean isLowPlus8TimesHighInteger(int k)
	{
		{
			if(k % 8 >= 7 || k % 8 > k/8)    
				return false;				//The result domino would have out-of-bound low and high pip count
			
			if(k < 0 || k > 54)
				return false; 				//There is no dominos that could produce a negative	value.	
			
			return true;
			
		}

	} //end of isLowPlus8TimesHighInteger(int k)
	
	
	//Part of pre: int lowPlus8TimesHigh must be valid from method: isLowPlus8TimesHighInteger(int k)
	public DominoHighLowSetImpl_Luong(int lowPlus8TimesHigh)
	{
		highLowSet = new HashSet<Integer>();
		
		//domino construction once lowPlus8TimesHigh passes checks of isLowPlus8TimesHigh(int k)
		assert(isLowPlus8TimesHighInteger(lowPlus8TimesHigh));
		
		int lowPipCount = lowPlus8TimesHigh % 8;
		
		int highPipCount = lowPlus8TimesHigh / 8;
		
		//checks: lowPipCount and highPipCount must pass the following condition:
		assert MINIMUM_PIP_COUNT <= highPipCount: "Invalid Domino:MINIMUM_PIP_COUNT > highPipCount!";
		
		assert MINIMUM_PIP_COUNT <= lowPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > lowPipCount ";
		
		assert lowPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount > MAXIMUM_PIP_COUNT ";
		
		assert highPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount > MAXIMUM_PIP_COUNT ";
		
		assert lowPipCount <= highPipCount: "Invalid Domino: lowPipCount > highPipCount ";
		
		//sending lowPipCount and highPipCount into highLowSet.
		this.highLowSet.add(highPipCount);
		this.highLowSet.add(lowPipCount);
		
		 //end of if.
		
	}//end of DominoHighLowSetImpl_Luong(int lowPLus8TimesHigh).
	
	//getting the the highPipCount in the set.
	public static int getMaximum(Set<Integer> highLowSet)
	{
		int max = Integer.MIN_VALUE; //VALUE TO BE TESTED.
		for(int i: highLowSet)   //loop through the Set to find the maximum values.
		{
			if(i > max)
			{
				max = i;
			}//end if.
		} //end for.
		
		return max;
	} //end of getMaximum().
	
	
	//getting the the lowPipCount in the set.
	public static int getMinimum(Set<Integer> highLowSet)
	{
		ArrayList<Integer> set = new ArrayList(highLowSet);
		int smallest = set.get(0);
		
		for(int i = 1; i<set.size(); i++)
		{
			if(set.get(i) < smallest)
			{
				smallest = set.get(i); //if the element is smaller than the assigned smallest value, then that value is the new smallest
			}
		}
		return smallest;
		
	} //end of getMaximum().

	
	//highPipCount getter
	public int getHighPipCount() 
	{
		int high = getMaximum(highLowSet);
		return high;
	}//end of getHighPipCount().

	//lowPipCount getter.
	public int getLowPipCount() 
	{
		int low = getMinimum(highLowSet);
		return low;
	}//end of getLowPipCount()
	
}//end of DominoHighLowSetImpl_Luong.java
