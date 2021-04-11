package tournament;

import java.util.ArrayList;
import java.util.List;

public abstract class BracketAbstract<P> implements Bracket<P>
{
	protected List<P> predictions;	//instance variable
	
	public BracketAbstract(List<P> participantMatchups)
	{
		//Calculating log2.
		double logBase2 = (Math.log10(participantMatchups.size())/Math.log10(2));
		//the input array size should be a power of 2
		boolean participantMatchupsSizeIsAPowerOf2 = (logBase2 == (int)logBase2);
		//executable pre-condition:
		assert participantMatchupsSizeIsAPowerOf2 : "participantMatchups.size() = " + participantMatchups.size() + " is not a power of 2!";
		//total node in a tree
		int nodeCount = participantMatchups.size() + (participantMatchups.size() - 1);
		predictions = new ArrayList<P>(nodeCount);
		//some spot can be null 
		for(int i = 0; i < participantMatchups.size() - 1; i++)
		{
			predictions.add(null);
		}
		
		//some will have values
		for(int i = 0; i < participantMatchups.size(); i++)
		{
			predictions.add(participantMatchups.get(i));
		}
		assert predictions.size() == nodeCount : "predictions.size() = " + predictions.size() + " <> " + nodeCount + " = nodeCount!";
	}
}
