package rationalnumbers;

public class RationalNumberUtils_Luong 
{
	//!!!!r1 and r2 are two rational numbers (NOT INTEGER)
	//rv is true <==> r1 = r2 as rational numbers
	//Pre-condition: Denominator cannot be a zero
	public static boolean equal(RationalNumber r1, RationalNumber r2) 
	{
		if(r1.getValue() == r2.getValue())
		{
			return true;
		}
		
		return false;
	} //end of equal()
	
	//Helper method_1: finding the Greatest Common Factor between 2 number
	public static int greatestCommonFactor(int m, int n)
	{
		if(n == 0)
		{
			return m;
		}
		
		return greatestCommonFactor(n, m%n);
		
	}//end of greatestCommonFactor().

	//Helper method_2: finding the least common factor between 2 number
	public static int lowestCommonFactor(int a, int b)
	{
		return (a * b) / greatestCommonFactor(a, b);
	}//end of helper method_2
	
	//rv = r1 + r2, where + is regular numerical addition 
	public static RationalNumber add(RationalNumber r1, RationalNumber r2)
	{
		//Executable pre-condition: Stopping the wrong form of Fraction.
		assert r1.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		assert r2.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		
		//sum of the numerator storage:
		int sumOfNum = 0;
		
		//Extracting the numerator from the instances.
		int num1 = r1.getNumerator();
		int num2 = r2.getNumerator();
		//finding the greatest common denominator:
		int lowestCommon = lowestCommonFactor(r1.getDenominator(), r2.getDenominator());
		
		//Adding the numerator:
		num1 *= (lowestCommon / r1.getDenominator());
		num2 *= (lowestCommon / r2.getDenominator());
		sumOfNum = num1 + num2;	//NUMERATOR SUM ALONE!
		//converting from an integer into a fraction
		RationalNumber ans = new RationalNumberImpl_Luong(sumOfNum,lowestCommon);
		return ans;
	}//end of add().
	
	//rv = r1 - r2, - is regular substraction
	public static RationalNumber substract(RationalNumber r1, RationalNumber r2) 
	{	
		//Executable pre-condition: Stopping the wrong form of Fraction.
		assert r1.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		assert r2.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		int numeratorSubtraction = 0;
		
		//Extracting the numerator from the instances:
		int num1 = r1.getNumerator();
		int num2 = r2.getNumerator();
		//finding the greatest common denominator:
		int lowestCommon = lowestCommonFactor(r1.getDenominator(), r2.getDenominator());
		
		//Substracting the numerator:
		num1 *= (lowestCommon / r1.getDenominator());
		num2 *= (lowestCommon / r2.getDenominator());
		
		//Substration process:
		numeratorSubtraction = num1 - num2;
		
		//converting from an integer into a fraction:
		RationalNumber answer = new RationalNumberImpl_Luong(numeratorSubtraction,lowestCommon);
		return answer;
	} //end of substract()
	
	//rv = r1 * r2, * is regular multiplication
	public static RationalNumber multiply(RationalNumber r1, RationalNumber r2) 
	{
		//Executable pre-condition: Stopping the wrong form of Fraction.
		assert r1.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		assert r2.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		
		
		int multiplyNum = 0;
		int multiplyDeno = 0;
		
		//Extracting the numerator and denominator from each instances:
		int num1 = r1.getNumerator();
		int num2 = r2.getNumerator();
		int deno1 = r1.getDenominator();
		int deno2 = r2.getDenominator();
		
		//Fraction multiplication:
		multiplyNum = num1 * num2;
		multiplyDeno = deno1 * deno2;
		
		//converting from an integer into a fraction:
		RationalNumber answer = new RationalNumberImpl_Luong(multiplyNum,multiplyDeno);
		return answer;
	}//end of multiply(RationalNumber r1, RationalNumber r2)
	
	//rv = r1 + r2, + is regular division
	public static RationalNumber divide(RationalNumber r1, RationalNumber r2)
	{
		//Executable pre-condition: Stopping the wrong form of Fraction.
		assert r1.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		assert r2.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		
		//Numerator and Denominator initialization
		int divNum;
		int divDeno;
		
		//Extracting variables: 
		int num1 = r1.getNumerator();
		int num2 = r2.getNumerator();
		int deno1 = r1.getDenominator();
		int deno2 = r2.getDenominator();

		//Division process: 
		divNum = num1 * deno2;
		divDeno = num2 * deno1;
		
		//converting from an integer into a fraction:
		RationalNumber answer = new RationalNumberImpl_Luong(divNum,divDeno);
		return answer;

	}//end of divide().
	
	//rv = -r1. where - is regular numerical negation
	public static RationalNumber negate(RationalNumber r1) {
		//Executable pre-condition: Stopping the wrong form of Fraction.
		assert r1.getDenominator() != 0: "Invalid Fraction! Denominator cannot equal to 0";
		//Numerator and Denominator initialization
		int negateNum;
		int negateDeno;
		
		//Extracting variables:
		int num1 = r1.getNumerator();
		int deno1 = r1.getDenominator();

		//negation process:
		negateNum = num1 * -1;
		negateDeno = deno1;
		
		//converting from an integer into a fraction:
		RationalNumber answer = new RationalNumberImpl_Luong(negateNum,negateDeno);
		return answer;
	} //end of negate()
}//end of RationalNumberUtils_Luong()
