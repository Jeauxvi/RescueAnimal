import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    private static ArrayList<String> validSpecies = new ArrayList<>(Arrays.asList("capuchin", "guenon", "macaque", "marmoset",
    		"squirrel monkey", "tamarin")); // array list of the valid monkey species
    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	
    	boolean programDone = false; //boolean to continue the loop
    	

        initializeDogList();
        initializeMonkeyList();

        	//while loop to continue running program 
        while (!programDone) {
        	displayMenu(); //  displays menu options when loop starts/ restarts
        	String menuOption = scnr.nextLine(); //assigns menuOption to user input
        	
        	if (menuOption.equals("q")) {  // ends program when user inputs q by changing programDone from false to true
        		System.out.println("End Program");
        		programDone = true;
        	}
        	//adds dog if user inputs 1 and calls intakeNewDog method to assign attributes and add animal to array list
        	else if (menuOption.equals("1")) {
        		System.out.println("Intake new dog.\n"); 
        		intakeNewDog(scnr);
        		promptEnterKey();
        	} 
        	// adds monkey if user inputs 2 and calls intakeNewMonkey method  to assign attributes and add animal to array list
        	else if (menuOption.equals("2")) {
        		System.out.println("Intake a new monkey\n");
        		intakeNewMonkey(scnr);
        		promptEnterKey();
        	} 
        	// calls reserveAnimal method if user inputs 3 
        	else if (menuOption.equals("3")) {
        		System.out.println("Reserve an animal");
        		reserveAnimal(scnr);
        		promptEnterKey();
        	}	
        	// calls printAnimals method to print a list of all dogs if user inputs 4
        	else if (menuOption.equals("4")) {
        		System.out.println("print list of all dogs.");
        		printAnimals("dogs");
        		promptEnterKey();
        	}
        	// calls printAnimal method to print a list of all monkeys if user inputs 5
        	else if (menuOption.equals("5")){
        		System.out.println("Print list of all monkeys");
        		printAnimals("monkies");
        		promptEnterKey();
        	}
        	// calls printAnimals method to print all animals that are not reserved if user inputs 6
        	else if (menuOption.equals("6")) {
        		System.out.println("Print list of all animals that are not reserved");
        		printAnimals("service");
        		promptEnterKey();
        	}
        }
        


    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
   public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Test 1", "Male", "-1", "-1", "-1", "-1", "-1", "capuchin", "mm/dd/yyyy", "location", "training", false, "USA");
    	Monkey monkey2 = new Monkey("Test 2", "Female", "-1", "-1", "-1", "-1", "-1", "guenon", "mm/dd/yyyy", "location", "training", false, "Canada");
    	Monkey monkey3 = new Monkey("Test 3", "Male", "-1", "-1", "-1", "-1", "-1", "macaque", "mm/dd/yyyy", "location", "training", false, "France");
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }


   
    // The input validation to check that the dog is not already in the list
    public static void intakeNewDog(Scanner scanner) {
    	RescueAnimal animal = new RescueAnimal();
        System.out.println("Enter dog's name: ");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
          
        animal.setAnimalType("Dog");
          
        System.out.print("Enter dog breed: ");
        String breed = scanner.next();
        System.out.print("Enter dog gender: ");
        String gender = scanner.next();
        System.out.print("Enter dog age: ");
        String age = scanner.next();
        System.out.print("Enter dog weight: " );
        String weight = scanner.next();
        System.out.print("Enter dog's aquisition date: (mm/dd/yyyy) ");
        String aquisitionDate = scanner.next();
        System.out.print("Enter dog aquisition location: ");
        String aquisitionLocation = scanner.next();
        System.out.print("Enter dog training status: ");
        String trainingStatus = scanner.next();
        System.out.print("Is dog reserved? (yes/no) ");
        boolean reserved;
        if (scanner.next().equalsIgnoreCase("yes")) {
        	reserved = true;  // sets reserved to boolean depending on user input
        }
        else {
           reserved = false;
        }
        System.out.print("Enter in service country: ");
       String  inServiceLocation = scanner.next();
       // new dog object with variables from above
        Dog dog = new Dog(name, breed, gender, age, weight, aquisitionDate, aquisitionLocation,
        		trainingStatus, reserved, inServiceLocation);
        dogList.add(dog);// adds new dog object to dog array list
        
        System.out.println("\n\t\t\tDog added to system");
        System.out.println("\n" + "Name: " + dog.getName().toUpperCase() + "\tBreed: " + dog.getBreed().toUpperCase() + "\tGender: " + dog.getGender().toUpperCase()
        		+ "\tAge: " + dog.getAge() + "\tWeight: " + dog.getWeight() + "\nAquisition date: " + dog.getAcquisitionDate() +
        		"\tAquisition location: " + dog.getAcquisitionLocation().toUpperCase() + "\nTraining status: " + dog.getTrainingStatus().toUpperCase() + 
            	"\tReserved: " + dog.getReserved() + " \tIn service country: " +  dog.getInServiceLocation().toUpperCase());
        return;      
    }


     // intakes new monkey
        public static void intakeNewMonkey(Scanner scanner) {
        	 System.out.print("Enter monkey's name: ");
             String name = scanner.nextLine();
             System.out.print("Enter monkey species: ");
             String species = scanner.nextLine();
             for(Monkey monkey: monkeyList) {			//only accepts monkeys of valid species from array list
                 if ((monkey.getName().equalsIgnoreCase(name)) && (monkey.getSpecies().equals(species))) {
                     System.out.println("\n\nThis monkey is already in our system\n\n");
                     return; //returns to menu
                 }
             }
                         	
           if (validSpecies.contains(species.toLowerCase())) {
        	   RescueAnimal animal = new RescueAnimal();
        	   animal.setAnimalType("Monkey");
            					
        	   System.out.print("Enter monkey gender: ");
        	   String gender = scanner.next();
        	   System.out.print("Enter monkey age: ");
        	   String age = scanner.next();
        	   System.out.print("Enter monkey weight: " );
        	   String weight = scanner.next();	
        	   System.out.print("Enter monkey tail length: ");
        	   String tailLength = scanner.next();
        	   System.out.print("Enter monkey height: ");
        	   String height = scanner.next();
        	   System.out.print("Enter monkey body length: ");
        	   String bodyLength = scanner.next();
        	   System.out.print("Enter monkey's aquisition date: (mm/dd/yyyy) ");
        	   String aquisitionDate = scanner.next();
        	   System.out.print("Enter monkey aquisition Location: ");
        	   String aquisitionLocation = scanner.next();
        	   System.out.print("Enter monkey training status: ");
        	   String trainingStatus = scanner.next();
        	   System.out.print("Is Monkey reserved? (yes/no)");
        	   boolean reserved;
        	   if (scanner.next().equalsIgnoreCase("yes")) {	
        		   reserved = true;
        	   }
        	   else {
        		  reserved = false;
        	   }
        	   System.out.print("Enter monkey in service country: ");
        	   String inServiceCountry = scanner.next();
        	   
        	   Monkey monkey = new Monkey(name, species, gender, age, weight, tailLength, height, bodyLength, aquisitionDate, 
        			   aquisitionLocation, trainingStatus, reserved, inServiceCountry);
        			   
        	   monkeyList.add(monkey);
        	   System.out.println("\n\t\t\tAdded monkey to system");
        	   System.out.println("Name: " + monkey.getName().toUpperCase() + "\tSpecies: " + monkey.getSpecies().toUpperCase() + "\tGender: " +
        			   monkey.getGender().toUpperCase() + "\tWeight: " + monkey.getWeight() + "\nTail length: " + monkey.getTailLength()
        			   + "\tHeight: " + monkey.getHeight() + "\tBody length: " + monkey.getBodyLength()  + "\nAquisition date: "
        			   + monkey.getAcquisitionDate() + "\tAquisition location: " + monkey.getAcquisitionLocation().toUpperCase() + "\nTraining ststus: "
        			   + monkey.getTrainingStatus().toUpperCase() + "\tReserved: " + monkey.getReserved() + "\tIn service Country: " + monkey.getInServiceLocation().toUpperCase());
             		return;
            	}
            else { //exits method if the species is not valid
            	System.out.println("Error: Invalid monkey species.");
            	return;
            }
           
                
            
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
        	System.out.println("Enter animal type to reserve.");
        	String animalType = scanner.next();
        	System.out.print("Enter service country: ");
			String serviceCountry = scanner.next();
        	
        	if (animalType.equalsIgnoreCase("dog")) {
        		for (Dog dog: dogList) { // iterates through arraylist
        			if ((dog.getInServiceLocation().equalsIgnoreCase(serviceCountry)) && (dog.getReserved() == false) &&
        				(dog.getTrainingStatus().equalsIgnoreCase("in-service"))){ //finds animal with matching attributes 
        				dog.setReserved(true);
        				System.out.println(dog.getName() + "was reserved.");
        				return; // returns to only reserve one animal
        			}
        		}
        	}
        	if (animalType.equalsIgnoreCase("monkey")) {
        		for (Monkey monkey: monkeyList) {
        			if ((monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry))
        					&& (monkey.getReserved() == false) && (monkey.getTrainingStatus().equalsIgnoreCase("in-service"))) {
        				monkey.setReserved(true);
        				System.out.println(monkey.getName() + "was reserved.");
        				return;
        			}

        		}
        	
        	}
        	System.out.println("No matching animal found.");

        }

       
        public static void printAnimals(String listType) {
        	if (listType.equalsIgnoreCase("dogs")){
        		for (Dog dog : dogList) {  // outputs only objects from dog arraylist
        			System.out.println("\nName: " + dog.getName().toUpperCase() + "\tTraining status: " + dog.getTrainingStatus().toUpperCase() + "\tReserved: " + dog.getReserved());
        		}
        	}
        	if (listType.equalsIgnoreCase("monkies")) {
        		for (Monkey monkey : monkeyList) { //outputs only objects from monkey array list
        			System.out.println("\n"
        					+ "Name: " + monkey.getName().toUpperCase() + "\tTraining status: " + monkey.getTrainingStatus().toUpperCase() + "\tReserved: " + monkey.getReserved());
        		}
        	}
        	if (listType.equalsIgnoreCase("service")) { // only outputs inservice animals that are not reserved
        		System.out.println("\nAvailable dogs and in-service location:");
        		for (Dog dog : dogList) {
        			if ((dog.getTrainingStatus().equalsIgnoreCase("in-service")) && ((dog.getReserved() == false))){
        				System.out.println("Name: " + dog.getName().toUpperCase() + "\tService location: " + dog.getInServiceLocation().toUpperCase());
        				
        			}
        		}
        		System.out.println("\nAvailable monkeys and in-service location:");
        		for (Monkey monkey: monkeyList) {
        			if ((monkey.getTrainingStatus().equalsIgnoreCase("in-service")) && (monkey.getReserved() == false)) {
        				System.out.println("Name: " + monkey.getName().toUpperCase()+ "\tSpecies:  " + monkey.getSpecies().toUpperCase() + "\tService location: " + monkey.getInServiceLocation().toUpperCase());
        			}
        		}
        				
        	}
        }
        //makes user press enter before restarting menu loop
		public static void promptEnterKey() {
			Scanner scanner = new Scanner(System.in);
    		System.out.print("\n\nPress \"ENTER\" to continue...");
    		scanner.nextLine();
		}
		
}

