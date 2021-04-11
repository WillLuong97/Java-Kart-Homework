package dominoes;

import java.util.List;

public class DominoLowDifferenceStringImpl_Luong implements Domino
{
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	
	public DominoLowDifferenceStringImpl_Luong(int lowPlus8TimesHigh)
	{
		//finding the low and high pip count from the array
        int lowPipCount = lowPlus8TimesHigh % 8;
        int highPipCount = lowPlus8TimesHigh / 8;
        //necessary check to maintain a valid domino.
        assert MINIMUM_PIP_COUNT <= highPipCount : "Invalid Domino: MINIMUM_PIP_COUNT > highPipCount";
        assert MINIMUM_PIP_COUNT <= lowPipCount: "Invalid Domino: MINIMUM_PIP_COUNT > lowPipCount ";
        assert lowPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: lowPipCount > MAXIMUM_PIP_COUNT ";
        assert highPipCount <= MAXIMUM_PIP_COUNT: "Invalid Domino: highPipCount > MAXIMUM_PIP_COUNT";
        assert lowPipCount <= highPipCount: "Invalid Domino: lowPipCount > highPipCount ";
        //output format.
        this.lowDifferenceString = "" + lowPipCount + LOW_DIFFERENCE_DELIMITER + (highPipCount - lowPipCount);

	}//end of DominoLowDifferenceStringImpl(int lowPlus8TimesHigh).
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_SUM = 1; 
	
	public DominoLowDifferenceStringImpl_Luong(List<Integer> highSum)
	{
		assert highSum != null;
		//initialization:
        int high = highSum.get(INDEX_OF_HIGH);
        int sum = highSum.get(INDEX_OF_SUM);
        int low = (sum - high);
        
        //executable pre-condition:
        assert MINIMUM_PIP_COUNT <= high: "Invalid Domino: MINIMUM_PIP_COUNT > high ";
        assert high <= MAXIMUM_PIP_COUNT: "Invalid Domino: high > MAXIMUM_PIP_COUNT ";
        assert high <= sum: "Invalid Domino: high > sum ";
        assert sum <= (2*high): "Invalid Domino: sum > (2*high) ";
        assert low <= high: "Invalid Domino: low > high ";
        assert MINIMUM_PIP_COUNT <= low: "Invalid Domino: MINIMUM_PIP_COUNT > low ";
        assert low <= MAXIMUM_PIP_COUNT: "Invalid Domino: low > MAXIMUM_PIP_COUNT";
        assert highSum.size() == 2: "Invalid Domino: highSum.size() != 2 ";

        this.lowDifferenceString = "" + (sum - high) + LOW_DIFFERENCE_DELIMITER + (high - (sum - high));
	}//end of DominoLowDifferenceStringImpl_Luong(List<Integer> highSum).

	//getter
	public int getHighPipCount() 
	{
        int lowP = Integer.parseInt(lowDifferenceString.substring(0, 1));
        int diff = Integer.parseInt(lowDifferenceString.substring(2,3));
        return diff + lowP;

	}//end of getHighPipCount().

	//getter
	public int getLowPipCount() 
	{
        int lowpip = Integer.parseInt(lowDifferenceString.substring(0, 1));
        return lowpip;
	}//end of getLowPipCount()
	
	
}//end of DominoLowDifferenceStringImpl_Luong().
