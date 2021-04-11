package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Luong implements ChangeMaker
{	
	//denomination list as a private List<Integer>:
	private List<Integer> denominationList;
	
	//denomination constructor.
	public ChangeMakerImpl_Luong(Set<Integer> denominations)
	{
		//denomination restriction
		assert denominations != null;
		assert !denominations.contains(0);
		assert !denominations.contains(null);
		
		denominationList = new ArrayList<Integer>(denominations); //throwing the assinged denomination into a denomination list.
		Collections.sort(this.denominationList, Collections.reverseOrder()); //extracting java built-in method from Collection framework.

	}//end of ChangeMakerImpl_Luong.
	
	//getter
	//part of post: i in [0, rv.size() -1] => rv.get(i) > rv.get(i+1)
	public List<Integer> getDenominations()
	{
		return this.denominationList;
	}//end of getDenominations().
	
	//checking the change validity:
	//part of pre: denominationList.contains(null)!=true
	//part of pre: denominationList != null
	//post:canMakeExactChange(int valueInCents) is True or False.
	public boolean canMakeExactChange(int valueInCents)
	{
		//denominationList assertion:
		assert denominationList.contains(null)!=true;
		assert denominationList != null;
		assert denominationList.contains(0)!=true;
		
		if(valueInCents < 0)
		{
			return false;
		}
		
		for(int i = 0; i < this.denominationList.size(); i++)
		{
			while(valueInCents >= this.denominationList.get(i))
			{
				valueInCents = valueInCents - this.denominationList.get(i);
			}
		}
		
		if(valueInCents == 0)
		{
			return true;
		}
		
		return true;
		
	}//end of canMakeExactChange().
	
	//part of pre: changeList != null
	//part of pre: !changeList.contains(null)
	//part of pre: changeList.size() = getDenominations().size()
	//part of post: an int that represents the value of the change.
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		//changeList and denominationList restriction
		assert changeList !=  null;
		assert !changeList.contains(null);
		assert changeList.size() == getDenominations().size();
		assert denominationList != null;
		assert !denominationList.contains(null);
		assert denominationList.contains(0)!=true;
		
		int valueOfChange = 0;
		for(int i = 0; i < denominationList.size(); i++)
		{
			valueOfChange += denominationList.get(i) * changeList.get(i);			//valueOfChangeList calculation.
		}
		
		return valueOfChange;
	}//end of calculateValueOfChangeList(List<Integer> changeList)
	
	//part of pre: canMakeExactChange(valueInCents)
	//part of post: calculateValueOfChangeList(rv) == valueInCents
	//part of post: i in [0, rv.size() - 1] => getDenominations.get(i) > rv.get(i+1)*getDenominations.get(i+1)
	public List<Integer> getExactChange(int valueInCents)
	{
		assert canMakeExactChange(valueInCents);
		
		//the exact change will be returned stored in a string.
		List <Integer> retChangeList = new ArrayList<Integer>();
		
		int tmp = valueInCents;
		
		//Return 0 when no exact changed being demanded.
		if(tmp == 0)
		{
			for(int i = 0; i < denominationList.size(); i++)
			{
				retChangeList.add(0);
				 
			}
			
		}//end for
		
		else
		{
			for(int i = 0; i < denominationList.size(); i++)
			{
				int count = denominationList.get(i);	//getting the denomination at i position.
				int finalChange = tmp / count;			// getting the change from the denomination list.
				retChangeList.add(finalChange);			//exact change list being constructed.
				tmp = tmp % count;						//getting the remainder of the valueInCent

			}//end for loop.

		} //end else.
		
		return retChangeList;
	}//end of getExactChange(int valueInCents)
	
}//end of ChangeMakerImpl_Luong().
