
//
//public class expressionImpl_Luong 
//{
//	//this method will evaluate any particular simple expression.
//	//each expression is expected to follow this format: 5 + 2 = 7
//	public static int expressionEvaluation(String expression)
//	{
//		//the expression is empty
//		if(expression.length() == 0)
//		{
//			return -1;
//		}
//		
//		//The first character is an operand in a typical expression
////		char firstOperand = valueOfOperand(expression.charAt(0));
//		char firstOperand = expression.charAt(0);
//		//extracting the value of each operand
//		int firstOperandValue = valueOfOperand(firstOperand);
//		//looping through the string to check for each char and check for their purpose 
//		// in an expression
//		for(int i = 1; i < expression.length(); i+=2)
//		{
//			//the second character must be an operators 
//			char operator = expression.charAt(i);
//			//checking for the other operand in the expression
//			char secondOperand = expression.charAt(i+1);
//			//extracting the value of each operand.
//			int secondOperandValue = valueOfOperand(secondOperand);
//			//if the next character is not and operand, then the expression is incorrect
//			if(isValidOperand(secondOperand) == false)
//			{
//				return -1;
//			}
//			
//			//creating operator and math expression
//			if(operator == '+')
//			{
////				result = firstOperandValue + secondOperandValue;
//				firstOperandValue += secondOperandValue;
//			}
//			
//			else if(operator == '-')
//			{
////				result = firstOperandValue - secondOperandValue;
//				firstOperandValue -= secondOperandValue;
//
//			}
//			
//			else if(operator == '*')
//			{
////				result = firstOperandValue * secondOperandValue;
//				firstOperandValue *= secondOperandValue;
//
//			}
//			
//			else if(operator == '/')
//			{
////				result = firstOperandValue / secondOperandValue;
//				firstOperandValue /= secondOperandValue;
//
//			}
//			
//			else
//			{
//				return -1; //invalid operators
//			}
//			
//		} //end for
//		
//		return firstOperandValue;
//		
//	} //end of expressionEvaluation().
//	
//	//helper method to find the value of an operand in a mathematical expression
//	private static int valueOfOperand(char x)
//	{
//		int value = 0;
//		value = (int)(x - '0');
//		return value;
//	}//end of valueOfOperand().
//	
//	//helper method to check if their is an operand in an expression
//	private static boolean isValidOperand(char c)
//	{
//		boolean isValid = true;
//		if( c <'0' || c > '9' )
//		{
//			isValid = false;
//		}
//		
//		return isValid;
//	}//end of isValidOperand().
//	
//	
//	//Main function
//	public static void main(String [] args)
//	{
//		//test codes:
//	    String exp1 = "3-2";  
//	    int res = expressionEvaluation(exp1);  
//	    if(res == -1) System.out.println(exp1+" is an invalid expression");  
//	    else     System.out.println("Value of "+exp1+" is "+res);  
//
//	}
//
//}
