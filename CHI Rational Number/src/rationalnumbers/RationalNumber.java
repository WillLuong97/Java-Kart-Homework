package rationalnumbers;

import java.lang.Math;

public interface RationalNumber 
{
	//rv is the numberator of the reduced form of this rational number
	// Ex: Since 5/3 is the reduced form of 10/6, (10/6).getNumerator() = 5
	public int getNumerator();
	
	//rv is the denominator of the reduced form of this rational number
	//Ex: since 5/3 is the reduced form of 10/6. (10/6)/getDenominator() = 3
	public int getDenominator();
	
	//rv is the double equivalent of this rational number
	//Ex: (5/10).getValue() = 0.5
	//This returns float or decimal of the rational number
	public double getValue();
}
