package tictactoe;

import java.util.List;

public class DeterministicPlayerImpl implements Player
{
	private List<Integer> rankedLocations;
	
	//constructor: 
	//part of pre: none
	//part of post: this is to determine which ones is a terrible and random chicken
	public DeterministicPlayerImpl(List<Integer> rankedLocations)
	{
		
		this.rankedLocations = rankedLocations;
	}//end of DeterministicPlayerImpl()
	@Override
	public Move getNextMove(TicTacToeBoard ticTacToeBoard) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
