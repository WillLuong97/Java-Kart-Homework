package asg1;

import java.util.Scanner;

public class Asg1Part1 
{
	public static void main (String[] args)
	{
	Scanner scanner = new Scanner(System.in); 
	
	//Asking for the user age. 
	System.out.print("How old are you? ");
	int age = scanner.nextInt();
	
	// Age description 
	if (age >= 18) 
	{
		System.out.println("You are old enough to vote(must be 18 or older) " + " You are " + age +" years old" );
	}
	
	if (age >= 35) 
	{
		System.out.println("You are old enough to run for president (must be 35 or older) " + " You are " + age + " years old");
		
	}
	
	if (age >= 65)
	{
		System.out.println("You are old enough to recieve Medicaid benefit (must be 65 or older) " + " You are " + age + " years old ");
	}
	
	if ((age >= 16) && (age <= 25)) 
	{
		System.out.println("You are paying extra for your car insurance (between 16 to 25) " + " You are " + age + " years old ");
	}

	
	//Asking for the user GPA
	System.out.print("What is your gpa? ");
	double gpa = scanner.nextDouble();
	scanner.nextLine();
	
	// Checking the status of the GPA. 
	if ((gpa < 0.0) || (gpa > 4.0)) 
	{
		System.out.println("Error input, we cannot process this request at the moment ");
		
	}
	
	else if (gpa >= 3.25) 
	{
		System.out.println("You are elgible to be on the Dean's list " + "Your gpa is " + gpa);
	}
	
	else if (gpa < 2.0)
	{
		System.out.println("Your GPA is low enough to cause a probationary status " + "Your gpa is " + gpa);
	}
	
	else if (gpa >= 2.5) 
	{
		System.out.println("Your GPA is at least satisfactory " + "Your gpa is " + gpa);
	}
	
	else {
		System.out.println("Your GPA is: " + gpa);
	}
	
	
	
	
	// Asking the user for his or her home town.
	System.out.println("Where is your hometown? ");
	String homeTown = scanner.nextLine();
	
	
	System.out.println("Your hometown is: " + homeTown + " Welcome!");
	
	// Capitalizing all letters in the home town name.
	String upperTown = homeTown.toUpperCase();
	System.out.println("Your hometown in capital letters: " + upperTown);
	// Counting the letter in the home town. 
	int len = homeTown.length(); 
	System.out.println(len);
	
	} // End of part 1. 

}


