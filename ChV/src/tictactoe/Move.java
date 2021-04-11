package tictactoe;

public interface Move 
{
	//part of post: 0 <= rv
	//part of post: rv <= ROW_COUNT
	public int getRow();
	//part of post:0 <= rv
	//part of post: rv <= COLUMN_COUNT
	public int getColumn();
	//part of post: rv != null
	public Mark getMark();

}
