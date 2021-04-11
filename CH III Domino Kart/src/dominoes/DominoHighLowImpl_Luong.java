package dominoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DominoHighLowImpl_Luong implements Domino
{
	private int highPipCount;
	private int lowPipCount;

	//getter
	public int getHighPipCount() 
	{
		return this.highPipCount;
	}

	//getter
	public int getLowPipCount() 
	{
		return this.lowPipCount;
	}
	
	public DominoHighLowImpl_Luong(int highPipCount, int lowPipCount) 
	{
		//checking if the pip count fits the requirement 
		assert MINIMUM_PIP_COUNT <= lowPipCount : "Invalid Domino: Low Pip Count is LOWER than MINIMUM_PIP_COUNT!"; 
		assert lowPipCount <= MAXIMUM_PIP_COUNT : "Invalid Domino: lowPipCount is GREATER than MAXIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= highPipCount: "Invalid Domino: highPipCount is LESSER than MINIMUM_PIP_COUNT!";
		assert highPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount is GREATER than MAXIMUM_PIP_COUNT!";
		assert lowPipCount <= highPipCount: "Invalid Domino: lowPipCount is GREATER than highPipCount!";
		
		
		//constructing a domino.
		this.highPipCount = highPipCount;
		this.lowPipCount = lowPipCount;
		
	}//end of DominoHighLowImpl_Luong(int highPipCount, lowPipCount)
	
	
	public static final char HIGH_LOW_STRING_SEPARATOR = ':';
	
	// function will recieve a pair of number that is in the domino format
	// example: 3:2 => True 
	// Example: 12 => False.
	//Takes in a string and return a boolean.
	public static boolean isHighLowString(String str)
	{
//		if( str == null || str.length() !=3 || str == " ")
//		{
//			return false;   //invalid string.
//		}
		assert !(str == null);
		assert !(str.length() == 3);
		assert !(str == " ");
		
		char high = str.charAt(0); // the high pip count will stay on the left
		char low = str.charAt(2); // the low pip count will stay on the right
		int lowPipCount = Character.getNumericValue(low);				//passed in the value of low pip count into low
		int highPipCount = Character.getNumericValue(high);				// passed in the value of high pip count into high
		if(str.charAt(1) != HIGH_LOW_STRING_SEPARATOR)
		{
			return false; 			//does not match the format. 
		}
		
		if(lowPipCount > MAXIMUM_PIP_COUNT || highPipCount > MAXIMUM_PIP_COUNT || lowPipCount > highPipCount || lowPipCount < MINIMUM_PIP_COUNT || highPipCount < MINIMUM_PIP_COUNT)
		{
			return false; 		//does not return the right format.
		}
		else
		{
			return true;
		}
		
	}// end of isHighLowString(String str)
	
//	part of pre: MINIMUM_PIP_COUNT <= highP;
//	part of pre: MINIMUM_PIP_COUNT <= lowP;
//	part of pre: lowP <= MAXIMUM_PIP_COUNT;
//	part of pre: highP <= MAXIMUM_PIP_COUNT;
//	part of pre: lowP <= highP;
//  part of pre: highLowString must pass the test from method: isHighLowString(String str)
	public DominoHighLowImpl_Luong(String highLowString) 
	{
		//this boolean will check if the string matches the domino format.
		boolean highLowString_IS_VALID=isHighLowString(highLowString);
		
		assert (highLowString_IS_VALID);  //if the string is valid, then do the following
		
		int highP=Integer.parseInt(highLowString.substring(0,1));
		int lowP=Integer.parseInt(highLowString.substring(2,3));
			
		//executing the pre-condition.
		assert MINIMUM_PIP_COUNT <= highP:"Invalid Domino: highPipCount is LESSER than MINIMUM_PIP_COUNT!";
		assert MINIMUM_PIP_COUNT <= lowP: "Invalid Domino: lowPipCount is LESSER than MINIMUM_PIP_COUNT!";
		assert lowP <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount is GREATER than MAXIMUM_PIP_COUNT";
		assert highP <= MAXIMUM_PIP_COUNT:"Invalid Domino: highPipCount is GREATER than MAXIMUM_PIP_COUNT!";
		assert lowP <= highP:"Invalid Domino: lowPipCount is GREATER than highPipCount!";
			
		//extracting lowPipCount and highPipCount from the string.
		this.highPipCount=highP;
		this.lowPipCount=lowP;
			
		
	} //end of DominoHighLowImpl_Luong().
	
	public static final int INDEX_OF_SUM = 0;
	public static final int INDEX_OF_DIFFERENCE = 1; 
	
	//part of pre: SumDifference.length == 2
	//part of pre: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]
	//	part of pre: sumDifference != null;
	//	part of pre: sumDifference.length == 2; 
	//	part of pre: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE];
	//	part of pre: MINIMUM_PIP_COUNT <= high;
	//	part of pre: MINIMUM_PIP_COUNT <= low;
	//	part of pre: low <= MAXIMUM_PIP_COUNT;
	//	part of pre: high <= MAXIMUM_PIP_COUNT;
	//	part of pre: low <= high;
	//	part of pre: 2*MINIMUM_PIP_COUNT <= sum;
	//	part of pre: sum <= 2*MAXIMUM_PIP_COUNT;
	//	part of pre: -(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <= difference;
	//	part of pre: difference <= (MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT);
	//	part of pre: difference <= sum;
	public DominoHighLowImpl_Luong(int[] sumDifference)
	{
		//executing the pre-condition
		assert sumDifference != null :"Failure to construct the valid domino: sumDifference is null!";
		assert sumDifference.length == 2 :"Failure to construct the valid domino: sumDifference.length != 2";
		assert sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE] : "Failure to construct the Domino: INDEX_OF_SUM is LESSER than INDEX_OF_DIFFERENCE";
		// setting the calculation for sum and difference.
		int sum = sumDifference[INDEX_OF_SUM];					 //initializing value for sum
		int difference = sumDifference[INDEX_OF_DIFFERENCE];		// initializing value for difference.
		//constructing a new high and low pip counts from the sum and difference
		int high = (int)(0.5*(sum + difference));
		int low = (int)(0.5*(sum - difference));
		
		//executing the pre-condition.
		assert MINIMUM_PIP_COUNT <= high: "Invalid Domino: highPipCount is LESSER than MINIMUM_PIP_COUNT";
		assert MINIMUM_PIP_COUNT <= low: "Invalid Domino: lowPipCount is LESSER than MINIMUM_PIP_COUNT";
		assert low <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount is GREATER than MAXIMUM_PIP_COUNT!";
		assert high <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount is GREATER than MAXIMUM_PIP_COUNT!";
		assert low <= high: "Invalid Domino: lowPipCount is GREATER than highPipCount!";
		assert 2*MINIMUM_PIP_COUNT <= sum: "Invalid Domino: highPip + lowPip is LESSER than 2*MINIMUM_PIP_COUNT!";
		assert sum <= 2*MAXIMUM_PIP_COUNT: "Invalid Domino: highPip + lowPip is GREATER than 2*MAXIMUM_PIP_COUNT2!";
		assert -(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) <= difference: "Invalid Domino:-(MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT) > difference";
		assert difference <= (MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT): "Invalid Domino:difference > (MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT)";
		assert difference <= sum: "Invalid Domino: highPip + lowPip > highPip - lowPip";
		
		//assigning values for highPipCount and lowPipCount.
		highPipCount = high;
		lowPipCount = low;
		
	}//end of DominoHighLowImpl_Luong(int [] sumDiffernce)
	
	
	//part of pre: 1 <= highLowSet.size() <= 2
	//part of pre: !highLowSet.contains(null)
	//	part of pre: MINIMUM_PIP_COUNT <= max;
	//	part of pre: MINIMUM_PIP_COUNT <= min;
	//	part of pre: min <= MAXIMUM_PIP_COUNT;
	//	part of pre: max <= MAXIMUM_PIP_COUNT;
	//	part of pre: min <= max;
	public DominoHighLowImpl_Luong(Set<Integer> highLowSet)
	{
		assert highLowSet != null;
	    // Set<Integer> highLowSet = new HashSet<>(Arrays.asList(1,2,3,4,4,-9));
		List<Integer> list= new ArrayList<Integer>(highLowSet);
		boolean isHighLowSize2 = (list.size() == 2);
		int max = 0;
		int min = 0;
		if(isHighLowSize2)
		{
			min = list.get(0);
			max= list.get(1);	
			if(min >= max)
			{
				int temp=max;
				max=min;
				min=temp;
			}
		}
		else
		{
			min = list.get(0);
			max= list.get(0);
		}
		 
		assert MINIMUM_PIP_COUNT <= max: "Invalid Domino: max is LESSER than MINIMUM_PIP_COUNT";
		assert MINIMUM_PIP_COUNT <= min: "Invalid Domino: min is GREATER than MINIMUM_PIP_COUNT";
		assert min <= MAXIMUM_PIP_COUNT: "Invalid Domino: min is GREATER than MAXIMUM_PIP_COUNT!";
		assert max <= MAXIMUM_PIP_COUNT: "Invalid Domino: max is GREATER than MAXIMUM_PIP_COUNT!";
		assert min <= max: "Invalid Domino: max is LESSER than MINIMUM_PIP_COUNT";
		
		highPipCount=max;
		lowPipCount=min; 
	} //end of DominoHighLowImpl_Luong(Set<Integer> highLowSet)
	
	
	
	public DominoHighLowImpl_Luong(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	{
		
			//executing the pre-condition.
			assert (MINIMUM_PIP_COUNT/2) <= highPipCountDivisionBy2Quotient : "Invalid Domino: (MINIMUM_PIP_COUNT/2) > highPipCountDivisionBy2Quotient ";
			assert highPipCountDivisionBy2Quotient <= (MAXIMUM_PIP_COUNT/2): "Invalid Domino:highPipCountDivisionBy2Quotient > (MAXIMUM_PIP_COUNT/2) ";
			assert 0 <= highPipCountDivisionBy3Remainder: "Invalid Domino: 0 > highPipCountDivisionBy3Remainder ";
			assert	highPipCountDivisionBy3Remainder < 3: "Invalid Domino: highPipCountDivisionBy3Remainder > 3 ";
			assert (MINIMUM_PIP_COUNT/2) <= lowPipCountDivisionBy2Quotient: "Invalid Domino:(MINIMUM_PIP_COUNT/2) > lowPipCountDivisionBy2Quotient ";
			assert lowPipCountDivisionBy2Quotient<=(MAXIMUM_PIP_COUNT/2): "Invalid Domino: lowPipCountDivisionBy2Quotient > (MAXIMUM_PIP_COUNT/2) ";
			assert 0 <= lowPipCountDivisionBy3Remainder: "Invalid Domino:0 > lowPipCountDivisionBy3Remainder ";
			assert lowPipCountDivisionBy3Remainder < 3: "Invalid Domino: lowPipCountDivisionBy3Remainder > 3 ";
			
		
			
			//necessary variables to construct the domino in this case. 
			List<Integer> highDo1 = new ArrayList<Integer>();
			List<Integer> highDo2 = new ArrayList<Integer>();
			List<Integer> lowDo1 = new ArrayList<Integer>();
			List<Integer> lowDo2 = new ArrayList<Integer>();
			List<Integer> highCount = new ArrayList<Integer>();
			List<Integer> lowCount  = new ArrayList<Integer>();
			List<Integer> endDomino = new ArrayList<Integer>();
			
			//Domino restriction.
			for(int i = MINIMUM_PIP_COUNT; i<= MAXIMUM_PIP_COUNT; i++) 		
			{
				if(i/2 == highPipCountDivisionBy2Quotient)
				{
					highDo1.add(i);
					
				}
				
				if(i%3 == highPipCountDivisionBy3Remainder)
				{
					highDo2.add(i);
					
				}
				
				if(i/2 == lowPipCountDivisionBy2Quotient)
				{
					lowDo1.add(i);
					
				}
				
				if(i%3 == lowPipCountDivisionBy3Remainder)
				{
					lowDo2.add(i);
				}
				
			}
			
			//Domino construction
			for(int e:highDo1)
			{
				if(highDo2.contains(e)) 
				{
					highCount.add(e);
				}
			}
			
			for (int x:lowDo1)
			{
				if(lowDo2.contains(x)) 
				{
					lowCount.add(x);
				}
			}
			//Final domino's placeholders:
			endDomino.addAll(highCount);		//this set will hold all the valid highPipCount values.
			endDomino.addAll(lowCount);			//this set will hold all valid lowPipCount values.
			
			//must contain only highpipcount and lowpipcount.
			assert endDomino.size() == 2 : "Failure to construct the Domino!!! highPipCount and lowPipCount are both out of bound!";
			
			
			int highPipCount = endDomino.get(0);
			int lowPipCount =  endDomino.get(1);
			//extracting domino's attributes.
			assert lowPipCount <= highPipCount: "lowPipCount is invalid because it is greater than highPipCount!";
			this.highPipCount = highPipCount; 
			this.lowPipCount = lowPipCount;
			System.out.println("High: " + this.highPipCount + " Low: " + this.lowPipCount);


	}//end of DominoHighLowImpl_Luong(int highPipCountDivisionBy2Quotient, int highPipCountDivisionBy3Remainder, int lowPipCountDivisionBy2Quotient, int lowPipCountDivisionBy3Remainder)
	
}//end of DominoHighLowImpl_Luong
