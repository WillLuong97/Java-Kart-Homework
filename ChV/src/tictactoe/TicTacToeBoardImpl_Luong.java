package tictactoe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicTacToeBoardImpl_Luong implements TicTacToeBoard
{
	//Symbolics:
	protected static final int NO_MOVE = -1;
	protected static final int NO_MATCH = -1;

	protected int[] movesArray; //set of moves


	//cell constructor.
	public TicTacToeBoardImpl_Luong()
	{
		final int CELL_COUNT = ROW_COUNT*COLUMN_COUNT;
		movesArray = new int[CELL_COUNT];
		for(int i = 0 ; i< CELL_COUNT; i++)
		{
			movesArray[i] = NO_MOVE;
		}
	}//end of TicTacToeImpl()

	//Helper method to check if the move is the O mark
	public boolean isO(int index)
	{
		boolean oOrNot = false;
		if(index > 0 && index%2==1)		//condition: the index in the board has to be greater than 0 and odd
		{
			oOrNot = true; //O only shows up in the odd index of the board.
		}

		return oOrNot;
	}//end of isO()

	//helper method to check if the move is an X
	public boolean isX(int index)
	{
		boolean xOrNot = false;
		if(index >= 0 && index % 2 ==0)
		{
			xOrNot = true;		//x only shows up in the even index of the board
		}

		return xOrNot;
	}//end of isX()

	//helper method to convert a row and column into the grid position on the board
	public int rowAndColumnToInt(int row, int column)
	{
		//grid position representation
		int grid = 0;
		
		if(row == 0)
		{
			grid = column;
		}

		if(row == 1)
		{
			grid = column + 3;

		}

		if(row == 2)
		{
			grid = column + 6;
		}

		return grid;
	}//end of rowAndColumnToInt().

	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of post: rv == null <==> the (row, column) spot on the board is empty
	//this function to determine what mark will return on the tictactoe board from the set of moves
	public Mark getMark(int row, int column)
	{
		//Executable pre-condition:
		assert row >= 0: "Row has to be greater or equals to 0";
		assert row < ROW_COUNT: "Row has to be lesser than ROW_COUNT";
		assert column >=0: "Column has to be greater than 0";
		assert column < COLUMN_COUNT: "Column has to be lesser than COLUMN_COUNT";

		int gridPosition = rowAndColumnToInt(row, column); //converting row and column into the grid position on the board for easier manipulation
		int indexOfMoves = -1;		//intial index
		Mark retMark = null;	//initial mark
		//loop through the movesArray
		for(int i = 0; i<movesArray.length; i++)
		{
			if(movesArray[i] == gridPosition)		//checking if the current element in the movesArray equals to the grid position on the board.
			{
				indexOfMoves = i;		//translate the particular move from the movesArray onto the tic tac toe board.
				break;
			}//end if.

		}//end for.

		//getting the mark
		if(indexOfMoves != -1)	//if there is a move, check if it is an O or X
		{
			if(isO(indexOfMoves))	//check if O
			{
				retMark = Mark.O;

			}
			
			else					//check for X
			{
				retMark = Mark.X;
			}
		}//end if.

		return retMark;

	}//end of getMark(int row, int column)

	//helper method to check if the grid position of the row and column contains the moves
	public boolean setMarkPreparation(int numericalRep)
	{
		boolean isMark = false;
		//loop through the moves array
		for(int i = 0; i < movesArray.length; i++)
		{
			if(movesArray[i] == numericalRep)		//the moves matches the row and column numerical representation.
			{
				isMark = true;
			}
		}//end for.

		return isMark;
	}//end of setMarkPreparation(int numericalRep)

	//part of pre: 0<= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of pre: getMark(row, column) = null
	//part of pre: !isGameOver()
	public void setMark(int row, int column)
	{	//assertion:
		assert row >= 0:"Row has to be greater than 0";
		assert row < ROW_COUNT:"Row has to be lesser than ROW_COUNT";
		assert column >=0:"Column has to be greater than or equal to 0";
		assert column < COLUMN_COUNT:"Column has to be lesser than COLUMN_COUNT";
		assert getMark(row, column) == null;
		assert !isGameOver();	//the game cannot end
		//assert getMark(row, column) == null;
		int gridPosition = rowAndColumnToInt(row, column); //converting row and column into an integer
		assert !setMarkPreparation(gridPosition);

		//for loop to walk through the movesArray
		for(int i = 0; i <movesArray.length; i++)
		{
			if(movesArray[i] == NO_MOVE)		//if there is no move being played 
			{
				movesArray[i] = gridPosition;	//set moves to the grid position
				break;
			}
		}// end of for loop
	}//end of setMark(int row, int column)

	//part of post: rv==null <==> it is neither player's turn (i.e. game is over)
	//part of post: "number of Marks on board is even" -> rv == Mark.X
	//part of post: "number of Marks on board is odd" -> rv == Mark.o
	//function: returning the mark on the board.
	public Mark getTurn()
	{
		Mark markVal = null;
		int index = -2;
		//loop through the movesArray
		for(int i = 0; i < movesArray.length; i++)
		{
			if(movesArray[i]== NO_MOVE)
			{
				index = i;
				break;
			}
		}

		//if the index is within the valid moves
		if(index!=-2)
		{
			if(isO(index))	//check if O wins
			{
				markVal = Mark.O;
			}
			else			//check if X wins
			{
				markVal = Mark.X;
			}
		}
		//the two player ties
		if(isGameOver())
		{
			markVal = null;
		}

		return markVal;

	}//end of getTurn()

	//helper method to determine the possibilities of winning the game
	//rv: True if win and False if not
	public boolean winOrNot(ArrayList<Integer>listOfMoves)
	{
		boolean foundWinner = false;
		//possible ways to win the game
		ArrayList<Set<Integer>> possibleWin = new ArrayList<Set<Integer>>(); //list to hold the possible way to win the game
		Set<Integer> winByAcrossUp = new HashSet<>(Arrays.asList(0, 1, 2));
		Set<Integer> winByAcrossBottom = new HashSet<>(Arrays.asList(6, 7, 8));
		Set<Integer> winByAcrossMiddle = new HashSet<>(Arrays.asList(3, 4, 5));
		Set<Integer> winByDiagonal1 = new HashSet<>(Arrays.asList(0, 4, 8));
		Set<Integer> winByDiagonal2 = new HashSet<>(Arrays.asList(2, 4, 6));
		Set<Integer> winByDown1= new HashSet<>(Arrays.asList(0, 3, 6));
		Set<Integer> winByDown3 = new HashSet<>(Arrays.asList(2, 5, 8));
		Set<Integer> winByDown2 = new HashSet<>(Arrays.asList(1, 4, 7));

		//adding the possible win into a list
		possibleWin.add(winByAcrossUp);
		possibleWin.add(winByAcrossBottom);
		possibleWin.add(winByAcrossMiddle);
		possibleWin.add(winByDown1);
		possibleWin.add(winByDown2);
		possibleWin.add(winByDown3);
		possibleWin.add(winByDiagonal1);
		possibleWin.add(winByDiagonal2);

		//loop through the list of possible winning moves
		for(int i = 0; i< possibleWin.size(); i++)
		{
			if(listOfMoves.containsAll(possibleWin.get(i)))		//if the moves in the list contains the winning move, then the winner is found.
			{
				foundWinner = true;
			}
		}

		return foundWinner;

	}//end of winOrNot()

	//part of post: rv is True if the game is over and False if the game is not
	public boolean isGameOver()
	{
		boolean isOver = false;
		//creating two lists that hold O and X
		ArrayList<Integer> listOfO = new ArrayList<Integer>();
		ArrayList<Integer> listOfX = new ArrayList<Integer>();

		//loop through the movesArray
		for(int i = 0; i < movesArray.length; i++)
		{
			if(isO(i) && movesArray[i] != NO_MOVE)			//if the index returns an O and there is a move in the board
			{
				listOfO.add(movesArray[i]);		// then we add the index into the list
			}

			else if(isX(i) && movesArray[i] != NO_MOVE)		// if the index returns an X and there is a move in the board
			{
				listOfX.add(movesArray[i]);		//then we add the index into the list.
			}
		}//end for loop.

		//if X win or O win, the game is over
		if(winOrNot(listOfO) || winOrNot(listOfX))
		{
			isOver = true;
		}

		//if two players tie, and the grid limit is reached, the game is also over
		else if(movesArray[8]!= NO_MOVE)
		{
			isOver = true;
		}

		return isOver;

	}//end of isGameOver();

	//part of pre: isGameOver()
	//part of post: rv <==> neither player won (the game ended in a tie)
	public Mark getWinner()
	{
		assert isGameOver();
		Mark finalWinner = null; //two player ties
		//list that hold the marks
		ArrayList<Integer> listX = new ArrayList<Integer>();
		ArrayList<Integer> listO = new ArrayList<Integer>();

		//loop through the movesArray
		for(int i = 0; i < movesArray.length; i++)
		{
			if(isX(i) && movesArray[i] != -1)	//if there is a move and the move is an X.
			{
				listX.add(movesArray[i]);	//add that mark into the list of X marks
			}//end if

			if(isO(i) && movesArray[i] != -1)	//if there is a move and the mark is an O
			{
				listO.add(movesArray[i]);	//add the move into the list that hold the O
			}//end if
		}//end for

		//if the winner is X
		if(winOrNot(listX))
		{
			finalWinner = Mark.X;
		}

		//if the winner is O
		else if(winOrNot(listO))
		{
			finalWinner = Mark.O;
		}

		return finalWinner;


	}//end of getWinner

	//return a nicely formatted version of the string
	public String toString()
	{
		String retStr = "";

		for(int i = 0; i < movesArray.length; i++)
		{
			retStr += movesArray[i] + ",";
		}
		return retStr;
	}//end of toString()

}//end of TicTacToeBoardImpl()
