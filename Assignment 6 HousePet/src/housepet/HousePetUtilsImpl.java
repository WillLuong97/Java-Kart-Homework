package housepet;

import java.io.PrintWriter;
import java.util.Scanner;

public class HousePetUtilsImpl 
{
		//receives: inFile, a Scanner instance already open and ready for reading 
       // tries to read one HousePet-derived instance from file, 
	   // if successful, creates proper HousePet-derived instance, populates it, returns it, assumes data in order expected
	  //   returns null if no data on inFile to read, returns populated HousePet-derived instance otherwise
		public static HousePet readFromScanner(Scanner inFile)
		{
			//if the file is empty and cannot be read.
			if(!inFile.hasNext())
			
				return null;
				
			
			String kindOfPet = inFile.next().trim();
			String chipID = inFile.next().trim();
			String name = inFile.nextLine();
			String birthDate = inFile.next();
			
			// if the kind of pet is cat.
			if(kindOfPet.equals("CAT"))
			{
				String catColor = inFile.next();
				
				Cat newCat = new Cat();
				newCat.setChipId(chipID);
				newCat.setPetName(name);
				newCat.setBirthDate(birthDate);
				newCat.setCatColor(CatColor.valueOf(catColor));
				
				return newCat;
			} //end of cat type.
			
			//if the kind of pet is dog.
			if(kindOfPet.equals("DOG"))
			{
				String leashTrained = inFile.next();
				String dogSize = inFile.next();
				
				Dog newDog = new Dog();
				newDog.setChipId(chipID);
				newDog.setPetName(name);
				newDog.setBirthDate(birthDate);
				//check for leash trained status.
				if(leashTrained.equals("yes"))
				{
					newDog.setLeashTrained(true);
				}
				
				else
				{
					newDog.setLeashTrained(false);
					
				}
				
				newDog.setDogSize(DogSize.valueOf(dogSize));
				
				return newDog;
				
			} // end of checking for dog type.
			
			//if the kind of pet is bird.
			if(kindOfPet.equals("BIRD"))
			{
				String birdType = inFile.next();
				Bird newBird = new Bird();
				newBird.setChipId(chipID);
				newBird.setPetName(name);
				newBird.setBirthDate(birthDate);
				newBird.setBirdType(BirdType.valueOf(birdType));
				
				return newBird;
				
			} //end of checking bird type.
			
			return null;
			
		} // end of readFromScanner(Scanner inFile).

		// receives: HousePet instance to write, outFile, already open and ready to be written to 
//		    writes received HousePEt instance to file in same format as read in with 
//		    including leading DOG or CAT or BIRD on first line of output
		//  returns: nothing
		public static void writeToFile(PrintWriter outFile, HousePet housePet)
		{
			String retStr = "";
			
			if(housePet instanceof Dog)
			{
				retStr += "DOG ";
				
			}
			
			else if (housePet instanceof Bird)
			{
				retStr += "BIRD ";
				
			}
			
			else if (housePet instanceof Cat)
			{
				retStr += "CAT ";
				
			}
			
			String id = housePet.getChipId();
			retStr += id + " ";
			
			String name = housePet.getPetName();
			retStr += name + "\n";
			
			String date = housePet.getBirthDateAsString();
			retStr += date + " ";
			
			if(housePet instanceof Dog)
			{
				Dog dog = (Dog)housePet;
				
				if(dog.isLeashTrained())
				{
					retStr += "yes ";
					
				}
				
				else
				{
					retStr += "no ";
					
				}
				
				String size = dog.getDogSize().toString();
				retStr += size;
				
			}
			
			else if(housePet instanceof Cat)
			{
				Cat cat = (Cat)housePet;
				String color = cat.getCatColor().toString();
				retStr += color;
			}
			
			else if(housePet instanceof Bird)
			{
				Bird bird = (Bird)housePet;
				
				String kindOfBird = bird.getBirdType().toString();
				retStr += kindOfBird;
				
			}
			
			
			//writing to the file.
			outFile.println(retStr);

			
		} //end of writeToFile(PrintWriter outFile, HousePet housePet).

} // end of HousePetUtilsImpl().
