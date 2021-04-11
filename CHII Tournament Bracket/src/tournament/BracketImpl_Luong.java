package tournament;

import static tournament.FIFASoccerTeam.ALGERIA;
import static tournament.FIFASoccerTeam.ARGENTINA;
import static tournament.FIFASoccerTeam.BELGIUM;
import static tournament.FIFASoccerTeam.BRAZIL;
import static tournament.FIFASoccerTeam.CHILE;
import static tournament.FIFASoccerTeam.COLOMBIA;
import static tournament.FIFASoccerTeam.COSTA_RICA;
import static tournament.FIFASoccerTeam.FRANCE;
import static tournament.FIFASoccerTeam.GERMANY;
import static tournament.FIFASoccerTeam.GREECE;
import static tournament.FIFASoccerTeam.MEXICO;
import static tournament.FIFASoccerTeam.NETHERLANDS;
import static tournament.FIFASoccerTeam.NIGERIA;
import static tournament.FIFASoccerTeam.SWITZERLAND;
import static tournament.FIFASoccerTeam.URUGUAY;
import static tournament.FIFASoccerTeam.USA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BracketImpl_Luong<P> extends BracketAbstract<P>
{
	public BracketImpl_Luong(List<P> participantMatchups)
	{
		//super() call to the BracketAbstract() values.
		super(participantMatchups);
	}

	//pre: true
	//part of post: getGroupings(rv).size() == 1
	//Purpose: Returning the highest or last position of a node in the tree.
	public int getMaxLevel()
	{
		//predictions.size() contains the # of node in this tree
		//if there are n nodes in a binary tree, then find the height by log2(n)
		int maxLevel = (int)(Math.log10(predictions.size())/Math.log10(2));
		return maxLevel;

	}//end of getMaxLevel().

	//part of pre: 0 <= level <= getMaxLevel()
	//part of post: rv != null
	//part of post: !rv.contains(null)
	//part of post: rv.contains(s) ==> (s != null)
	//part of post: rv.contains(s) ==> (!s.contains(null))
	//part of post: rv.contains(s) ==> (s.size() == 2^(level))
	//part of post: (rv.contains(s) && rv.contains(t)) ==> (s.equals(t) || (s.removeAll(t).size() == t.removeAll(s).size() == 0))
	//part of post: (rv.contains(s) && level > 0) ==> s.equals(a.addAll(b)) for some a, b in getGroupings(level-1)
	public Set<Set<P>> getGroupings(int level)
	{
		//executable pre-condition:
		assert level >= 0;
		assert level <= getMaxLevel();
		Set<Set<P>> setOfGroups = new HashSet<Set<P>>();
		//the number of elements to be put into a set is 2^level being passed in.
		int numOfElementToBeGrapped = (int) Math.pow(2,level);
		//Index to only include valid participants, i.e, non-null elements.
		int	validParticipantsIndex = ((int) Math.pow(2, getMaxLevel())) - 1;
		
		//The size of each inner set would be changed based on the level being passed in
		// level = 4 => innerSetSize = 2^(4-4) = 1 => there would be one set, which contains the participants
		// level  = 2 => innerSetSize = 2^(4-3) = 2 => there would be 2 inner set, which contains the participants
		int innerSetSize = (int) Math.pow(2, (getMaxLevel() - level));
		//magic number to control the loop:
		int count = 0;
		
		for(int i = 0; i < innerSetSize; i++)
		{
			Set<P> innerSet = new HashSet<P>();
			//magic variable to control the while loop:
			int count2 = 0;
			while(count2 < numOfElementToBeGrapped) 
			{
				innerSet.add(predictions.get(validParticipantsIndex + count));
				count++; 
				count2++;
			}
			setOfGroups.add(innerSet);
						
		}		
		return setOfGroups;
	}//end of getGroupings(int level)

	//part of pre: getGroupings(level).contains(grouping) for some 0 <= level <= getMaxLevel()
	//part of post: rv != null
	//part of post: rv.size() > 0
	//part of post: grouping.containsAll(rv)
	//part of post: For each participant t:
	//				[(0 < level)
	//				&& (g in getGroupings(level - 1) ==> !getViableParticipants(g).contains(t))]
	//						==> !rv.contains(t)
	//Set<P> grouping is the rv of getGroupings().
	public Set<P> getViableParticipants(Set<P> grouping)
	{
		//Executable preconditions:
		assert grouping != null;
		assert !(grouping.contains(null));
		assert grouping.size() > 0;
		boolean isFound = false;
		for(int i = 0; i <= getMaxLevel(); i++)
		{
			if(getGroupings(i).contains(grouping))
			{
				isFound = true;
			}
		} 
		assert isFound;
		
		//Finding the level of a particular node by finding the grouping size
		//since grouping is a return value from getGroupings(int level) 
		int level = (int) (Math.log(grouping.size()) / Math.log(2));
		assert level <= getMaxLevel(); //level can only be from 0-4
		assert getGroupings(level).contains(grouping):"!!!Grouping is not in getGroupings()!!!!";
			
		Set<P> viableParticipantSet = new HashSet<P>();
		
		for(P member: grouping)
		{
			if(hasLostYet(level, member) == false)
			{
				viableParticipantSet.add(member);
			}
		}
		
		assert grouping.containsAll(viableParticipantSet);
		assert viableParticipantSet != null;
		return viableParticipantSet;
		
	}//end of getViableParticipants(Set<P> grouping)
	
	
	
	//part of pre: participant != null
	//part of pre: participant is in getGroupings(getMaxLevel()).iterator().next())
	//part of pre: 0 <= winCount
	//part of pre: winCount <= getMaxLevel()
	//part of post: (0 < level <= winCount())) ==>
	//						getViableParticipants(getGrouping(level)).contains(participant)
	//part of post: (getViableParticipants(getGrouping(exactWinCount)).contains(t) &&
	//					(winCount < level <= getMaxLevel())) ==>
	//						!getViableParticipants(getGrouping(level)).contains(t)
	public void setWinCount(P participant, int winCount)
	{
		//executable precondition:
		assert participant != null :"Participant set cannot equal to a null";
		assert winCount >= 0 :"winCount has to be greater than 0";
		assert winCount <= getMaxLevel() : "The number of win cannot exceed the max level of node in the tree";
		assert getGroupings(getMaxLevel()).iterator().next().contains(participant) :"The participants must be a member of getGrouping()";
		
		int participantIndex = getParticipantIndex(participant);
		assert participantIndex != -1 :"The participant is not the list!";
		int parentOfParticipantIndex = getParentIndex(participantIndex);
		//loop through the levels:
		for (int i = 0; i < getMaxLevel(); i++)
		{
			// inserting the participant to its parent nodes.
			// until winCount is reached 
			if(i < winCount)
			{
				predictions.set(parentOfParticipantIndex,participant);
			}
			
			//should return null, the participant should not be added to its parent nodes -> it has not yet won!
			else if( i == winCount )
			{
				predictions.set(parentOfParticipantIndex, null);
			}
			//the current nodes now become the parent nodes.
			participantIndex = getParentIndex(participantIndex);
		}
	}//end of setWinCount().

	//Helper method:
	//Find two groupings a and b at a lower level such that a U b = grouping with a INT b = empty
	private Set<Set<P>> getSubordinateGroupings(Set<P> grouping)
	{
		assert grouping.size() > 1 : "grouping.size() = " + grouping.size() + " <= 1!: grouping = " + grouping;
		throw new RuntimeException("NOT IMPLEMENTED!");
	}


	private int getParticipantIndex(P participant)
	{
		int participantIndex = 0;
		int	validParticipantsIndex = ((int) Math.pow(2, getMaxLevel())) - 1;
		//Making sure that particiapnt is in the set
		for(int i = validParticipantsIndex; i < predictions.size(); i++)
		{
			//execute the participant are in the node
			if(predictions.get(i).equals(participant))
			{
				participantIndex = i;
			}
		}
		return participantIndex;
	}

	private static int getParentIndex(int childIndex)
	{
		int parentIndex = 0;
		parentIndex = ((childIndex +1)/2) - 1;

		return parentIndex;
	}//end of getParentIndex(int childIndex)

	
	private int getFirstParticipantIndex(P participant)
	{
		int target = 1;
		for (int i = 30; i > 14; i--)
		{	
			if(predictions.get(i).equals(participant)) 
			{
				target = i;
			}
		
		}
		
		return target;
		
	}
//	getViableParticipant() helper method:
	private boolean hasLostYet(int level, P participant)
	{
		boolean isLost = false;
		assert level >= 0;
		assert level < 5;
		int index = 0;
		int indexAtLevelZero = getFirstParticipantIndex(participant);
		int indexAtLevelOne =  getParentIndex(indexAtLevelZero);
		int indexAtLevelTwo = getParentIndex(indexAtLevelOne);
		int indexAtLevelThree = getParentIndex(indexAtLevelTwo);
		int indexAtLevelFour = getParentIndex(indexAtLevelThree);
		
		if(level == 0)
		{
			index = indexAtLevelZero;
		}
		
		if(level == 1)
		{
			index = indexAtLevelOne;
		}
		
		if(level == 2)
		{
			index = indexAtLevelTwo;
		}

		if(level == 3)
		{
			index = indexAtLevelThree;
		}

		if(level == 4)
		{
			index = indexAtLevelFour;
		}
		
		//index is now a parent of each index at level:
		//if the participant is the same as the 
		if(participant.equals(predictions.get(index)))
		{
			isLost = false;
		}
		
		else if(!participant.equals(predictions.get(index)) && !(predictions.get(index) == null))
		{
			isLost = true;
		}
		
		else if((predictions.get(index) == null))
		{
			if(hasLostYet(level - 1, participant) == true)
			{
				isLost = true;
			}
		}
		
		return isLost;
		
		
	}//end of hasLostYet().
	

}//end of BracketImpl_Luong.java
