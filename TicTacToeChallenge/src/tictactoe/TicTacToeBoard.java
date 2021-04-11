package tictactoe;

public interface TicTacToeBoard 
{
	public final static int ROW_COUNT = 3;
	public final static int COLUMN_COUNT = 3;
	
	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of post: rv == null <==> the(row, column) spot on the board is empty
	public Mark getMark(int row, int column);
	
	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of pre: getMark(row, column) == null
	public void setMark(int row, int column);
	
	public Mark getTurn();
	
	public boolean isGameOver();
	
	public Mark getWinner();

}

