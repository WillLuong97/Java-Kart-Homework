package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChickenPlayerUtils_Luong 
{
	private ChickenPlayerUtils_Luong()
	{
		throw new RuntimeException("Do not instantiate!");
	}
	
	//returning the random play moves of the random chicken on the Tic-Tac-Toe board.
	//generating a list of random move for the random chicken
	public static List<Integer> getRandomLocationList()
	{
	    ArrayList<Integer> listOfMove = new ArrayList<Integer>();

		Random randMov = new Random(); //random move that the chicken will play
		for(int i = 0; i < 9; i++)
		{
			listOfMove.add(i);
		}
		
		return listOfMove;
	}//end of getRandomLocationList()
	
	//
	public static List<Integer> getTerribleChickenPlayerLocationList()
	{
		throw new RuntimeException("Not implemented yet!");
	}

}//end of ChickenPlayerUtils_Luong()
