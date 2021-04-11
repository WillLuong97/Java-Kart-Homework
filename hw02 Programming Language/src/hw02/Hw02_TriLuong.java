package hw02;


//Library imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hw02_TriLuong 
{
	public static ArrayList<ArrayList<Integer>>multiLevelArrayImpl(int size)
	{
		//Creating a new variable row that would create the row of the array.
		ArrayList<ArrayList<Integer>> row = new ArrayList<ArrayList<Integer>>();
		//loop through the array with the unique input for size.
		for(int index = 0; index<size+1; index++)
		{
			//add a new row at each instances
			row.add(new ArrayList<Integer>());
			
			for(int j = 0; j<index+1; j++)
			{
				//populate those new rows.
				row.get(index).add(j,0);
			}
		}//end for
		
		return row;
	}//end of ArrayList<ArrayList<Integer>>multiLevelArrayImpl(int size)
	
	//main function to run the code:
	public static void main(String[] args)
	{
		Scanner id = new Scanner(System.in);
		System.out.println("Enter a size: ");
		//scan through each memeber of the array after it is creatd.
		int scan = id.nextInt();
		//Displaying the multi level array.
		System.out.println(multiLevelArrayImpl(scan));
		
	}//end of main().

}//end of Hw02_TriLuong.java
