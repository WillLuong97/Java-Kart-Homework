package rationalnumbers;

public class RationalNumberImpl_Luong implements RationalNumber
{
	//variables that represent numerator and denominator
	private int numerator;
	private int denominator;
	
	//default constructor:
	public RationalNumberImpl_Luong(int numerator, int denominator) 
	{
		//executable pre-condition:
		assert denominator != 0:"Invalid Fraction! Denominator cannot be a 0";
		
		int gcf = greatestCommonFactor(numerator, denominator);
		assert numerator % gcf == 0 && denominator % gcf == 0:"No Valid Greatest Common Factor!";
		this.numerator = numerator / gcf;
		this.denominator = denominator / gcf;
		
	}//end of RationalNumberImpl_Luong().
	
	//Helper method: finding the Greatest Common Factor between 2 number
	public static int greatestCommonFactor(int m, int n)
	{
		if(n == 0)
		{
			return m;
		}
		
		return greatestCommonFactor(n, m%n);
		
	}//end of greatestCommonFactor().

	//rv is the numberator of the reduced form of this rational number
	// Ex: Since 5/3 is the reduced form of 10/6, (10/6).getNumerator() = 5
	public int getNumerator() 
	{
		return numerator;
	}//getNumerator()
	

	//rv is the denominator of the reduced form of this rational number
	//Ex: since 5/3 is the reduced form of 10/6. (10/6)/getDenominator() = 3
	public int getDenominator() 
	{
		//Special Case Catcher:
		if(numerator == 0)
		{
			denominator = 1;
		}
		
		return denominator;
		
	}//end of getDenominator()
	
	
	//rv is the double equivalent of this rational number
	//Ex: (5/10).getValue() = 0.5
	//This returns float or decimal of the rational number
	public double getValue() 
	{
		//executable precondition:
		double decimal = 0.0;
		decimal = (double)numerator/denominator;
		return decimal;
	}//end of getValue()
}//end of RationalNumberImpl_Luong
