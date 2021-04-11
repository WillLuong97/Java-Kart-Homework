package housepetlist;

import java.io.PrintWriter;
import java.util.Scanner;

import housepet.HousePet;
import housepet.HousePetUtilsImpl;

public class HousePetListUtilsImpl 
{
	//receives: inFile, a Scanner already open and ready to read from
	//  housePetList, a list of house pet instances to add to from inFile if any housepets are found
	//reads from inFile as many house pets as it can, puts each one into the received house pet list instance 
	//pre: inFile is open and ready to read from
	//all house pets found on inFile are added to house pet list using add method in HousePetList interface
	//returns: nothing
	public static void readFromScanner(Scanner inFile, HousePetList petList)
	{
		while(inFile.hasNext())
		{
			HousePet pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet != null)
			{
				petList.add(pet);
			}

		}
	} //end of readFromScanner().



	//receives: outFile, an open and ready to write to PrintWriter instance
	//  petList, a list to be written to outFile in data format (so it can be read back in later)
	//writes received house pet list to received outFile in same format as read in with descriptor 
	//on each line describing which type of house pet is on the line
	//pre: outFile is open and ready to print to
	//post: outFile contains entire contents of list written in same format
	//as input format
	public static void writeToFile(PrintWriter outFile, HousePetList petList)
	{
		for(int p = 0; p < petList.getSize(); p++)
		{
			HousePetUtilsImpl.writeToFile(outFile,petList.get(p));
			
		}

		
	} //end of writeToFile().


} //end of HousePetListUtilsImpl.java
