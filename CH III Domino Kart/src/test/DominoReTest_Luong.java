package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominoes.Domino;
import dominoes.DominoHighLowSetImpl_Luong;

class DominoReTest_Luong {

	//main running program
	public void test()
	{
		System.out.println("Begin Testing for Will Luong");
		System.out.println(" ");
		//testDominoHighLowImpl1();
		testDominoHighLowSetImpl1();
		//testDominoLowDifferenceString1();
		System.out.println("ALL TEST WERE PASSED!");
		
	}//end of test.
	
	public void testDominoHighLowImpl1()
	{
		System.out.println("TESTING: DominoHighLowImpl_Luong");
		System.out.println("END Testing for DominoHighLowImpl_Luong");
		
	}
	
	public void testDominoHighLowSetImpl1()
	{
		System.out.println("TESTING: DominoHighLowSetImpl_luong");
		Domino d = new DominoHighLowSetImpl_Luong(6,1);
		//Domino d2 = new DominoHighLowSetImpl_Luong(0,0);
		Domino d3 = new DominoHighLowSetImpl_Luong(42);
		Domino d4 = new DominoHighLowSetImpl_Luong(0);
		Domino d5 = new DominoHighLowSetImpl_Luong(7,1);
		Domino d6 = new DominoHighLowSetImpl_Luong(0,0);
		
		System.out.println("End Of Testing for DominoHighLowSetImpl_Luong");
	}

}//end testing.