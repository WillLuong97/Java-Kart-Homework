package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rationalnumbers.RationalNumber;
import rationalnumbers.RationalNumberImpl_Luong;
import rationalnumbers.RationalNumberUtils_Luong;

public class RationalNumberTest_Luong {

	public static void test_getNumerator_2_4() 
	{
		int a = 2;
		int b = 4;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 1;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_2_4()
	{
		int a = 2;
		int b = 4;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 2;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getNumerator_5_10()
	{
		int a = 5;
		int b = 10;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 1;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_5_10()
	{
		int a = 5;
		int b = 10;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 2;
		assertEquals(answer, STUDENT_ANSWER);

	}
	
	public static void test_getNumerator_0_5()
	{
		int a = 0;
		int b = 5;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 0;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_0_5()
	{
		int a = 0;
		int b = 5;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 1;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getNumerator_24_36()
	{
		int a = 24;
		int b = 36;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 2;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_24_36()
	{
		int a = 24;
		int b = 36;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 3;
		assertEquals(answer, STUDENT_ANSWER);
	}

	public static void test_getNumerator_neg4_neg4()
	{
		int a = -4;
		int b = -4;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 1;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_neg4_neg4()
	{
		int a = -4;
		int b = -4;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 1;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getNumerator_neg32_pos24()
	{
		int a = -32;
		int b = 24;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = -4;
		assertEquals(answer, STUDENT_ANSWER);
	}

	public static void test_getDenominator_neg32_pos24()
	{
		int a = -32;
		int b = 24;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 3;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getNumerator_77_58()
	{
		int a = 77;
		int b = 58;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getNumerator();
		int answer = 77;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getDenominator_77_58()
	{
		int a = 77;
		int b = 58;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		int STUDENT_ANSWER = q.getDenominator();
		int answer = 58;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getValue_2_4()
	{
		int a = 2;
		int b = 4;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = 0.5;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getValue_3_5()
	{
		int a = 3;
		int b = 5;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = 0.6;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getValue_neg12_neg6()
	{
		int a = -12;
		int b = -6;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = 2;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getValue_neg12_24()
	{
		int a = -12;
		int b = 24;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = -0.5;
		assertEquals(answer, STUDENT_ANSWER);
	}

	public static void test_getValue_77_58()
	{
		int a = 77;
		int b = 58;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = 1.327586207;
		assertEquals(answer, STUDENT_ANSWER);
	}
	
	public static void test_getValue_0_5()
	{
		int a = 0;
		int b = 5;
		RationalNumber q = new RationalNumberImpl_Luong(a,b);
		double STUDENT_ANSWER = q.getValue();
		double answer = 0;
		assertEquals(answer, STUDENT_ANSWER);

	}
	public static void equalTest_1_2_2_4()
	{
		int a = 1;
		int b = 2;
		int c = 2;
		int d = 4;
		RationalNumber q1 = new RationalNumberImpl_Luong(a,b);
		RationalNumber q2 = new RationalNumberImpl_Luong(c,d);
		Boolean STUDENT_ANSWER = RationalNumberUtils_Luong.equal(q1,q2);
		boolean answer = true;
				
		assertTrue(answer == STUDENT_ANSWER);

	}
	
	public static void equalTest_3_5_4_6()
	{
		int a = 3;
		int b = 5;
		int c = 4;
		int d = 6;
		RationalNumber q1 = new RationalNumberImpl_Luong(a,b);
		RationalNumber q2 = new RationalNumberImpl_Luong(c,d);
		Boolean STUDENT_ANSWER = RationalNumberUtils_Luong.equal(q1,q2);
		boolean answer = false;
		assertTrue(answer == STUDENT_ANSWER);
	}
	
	public static void equalTest_4_77_13_13()
	{
		int a = 4;
		int b = 77;
		int c = 13;
		int d = 13;
		RationalNumber q1 = new RationalNumberImpl_Luong(a,b);
		RationalNumber q2 = new RationalNumberImpl_Luong(c,d);
		Boolean STUDENT_ANSWER = RationalNumberUtils_Luong.equal(q1,q2);
		boolean answer = false;
		assertTrue(answer == STUDENT_ANSWER);

	}
	
	public static void equalTest_neg34_neg48_63_25()
	{
		int a = -34;
		int b = -48;
		int c = 63;
		int d = 25;
		RationalNumber q1 = new RationalNumberImpl_Luong(a,b);
		RationalNumber q2 = new RationalNumberImpl_Luong(c,d);
		Boolean STUDENT_ANSWER = RationalNumberUtils_Luong.equal(q1,q2);
		boolean answer = false;
		assertTrue(answer == STUDENT_ANSWER);

	}
	
	
	public static void main(String[] args)
	{
		System.out.println("!!!!!TESTING: RationalNumberImpl_Luong!!!!!!");
		System.out.println("----------------------TESTING GET NUMERATOR-------------");
		test_getNumerator_2_4(); 
		test_getNumerator_5_10();
		test_getNumerator_0_5();
		test_getNumerator_24_36();
		test_getNumerator_neg4_neg4();
		test_getNumerator_77_58();
		//test_getNumerator_neg32_pos24();
		System.out.println("****Passed!!!****");
		System.out.println("----------------------TESTING GET DENOMINATOR------------");
		test_getDenominator_2_4();
		test_getDenominator_5_10();
		test_getDenominator_0_5();
		test_getDenominator_24_36();
		test_getNumerator_neg4_neg4();
		test_getDenominator_77_58();
		//test_getDenominator_neg32_pos24();
		System.out.println("****Passed!!!******");
		System.out.println("---------------------TESTING GET VALUE--------------------");
		test_getValue_2_4();
		test_getValue_3_5();
		test_getValue_0_5();
		test_getValue_neg12_neg6();
		test_getValue_neg12_24();
		//test_getValue_77_58();
		System.out.println("*****Passed!!!******");
		System.out.println("");
		System.out.println("--------------------------------------------------------------");
		System.out.println("!!!!!TESTING: RationalNumberUtils_Luong!!!!!!");
		System.out.println("---------------------TESTING EQUAL()--------------------");
		equalTest_1_2_2_4();
		equalTest_3_5_4_6();
		equalTest_4_77_13_13();
		equalTest_neg34_neg48_63_25();
		System.out.println("*****Passed!!!******");
		System.out.println("---------------------TESTING ADD()--------------------");

	}

}
