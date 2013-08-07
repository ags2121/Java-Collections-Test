package homework_4;

import java.util.Scanner;

public class CollectionsTestDriver {

	//FIELDS
	private static int nFinalNumObs;
	
	//MAIN METHOD
	public static void main(String[] args) {
		
		CollectionsTest tester = new CollectionsTest();
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Hi! Welcome to 'Collections Test', a simple program that \n" +
				"tests how long it takes for different data structures to \nadd or " +
				"retrieve elements. You can keep experimenting until \nyou type 'q' to quit.");
		
		System.out.println("========================================================");
		
		String strIn = "";
		
		System.out.println("\nWould you like to experiment with adding or retrieving?" +
				"\nType 'a' to add or 'r' to retrieve. " +
				"Type 'q' to quit.");
		
		strIn = scn.nextLine();
		
		while(!strIn.equalsIgnoreCase("q")){
			
			while(!strIn.equalsIgnoreCase("a") && !strIn.equalsIgnoreCase("r") && !strIn.equalsIgnoreCase("q")){
				System.out.println("\nWrong input. Please enter either 'a' or 'r' " +
						"or type 'q' to quit.");
				strIn = scn.nextLine();
			}
			
			String strAction = "";
			if(strIn.equalsIgnoreCase("a")){
				strAction = "add";
			}
			else{
				strAction = "retrieve";
			}
			
			System.out.println("\nHow many objects do you want to "+strAction+"? " +
							"\nEnter a value between 0 and 99999. " +
							"\n(In this program, objects are randomly generated Strings" +
							" between 1 and "+CollectionsTest.getMAX_STRING_LENGTH()+"). ");
			
			strIn = scn.nextLine();
			//number of objects to be tested
			inputCheck(strIn, scn);
			
			if(nFinalNumObs==-1){
				break;
			}
			
			System.out.println("\nComputing results...");
			
			if(strAction.equals("retrieve")){
				tester.retrieve(nFinalNumObs);
			}
			else{
				tester.add(nFinalNumObs);
			}
			
			System.out.println("\nWould you like to experiment with adding or retrieving?" +
					"\nType 'a' to add or 'r' to retrieve. " +
					"Type 'q' to quit.");
			
			strIn = scn.nextLine();
		
		//end while	
		}
		
		System.out.println("\nThanks! Goodbye.");
	
	}
	
	//input check for integer inputs 
	public static void inputCheck(String strIn, Scanner scn){
		
		if(strIn.equals("q")){
			nFinalNumObs = -1;
			return;
		}
	
		int nObs = -1;
		
		try{
			nObs = Integer.parseInt(strIn);
			
			if(nObs < 0 || nObs > 99999){
				System.out.println("\nThe number entered is out of range. Please enter an integer between 0 and 99999.");
				String strIn2 = scn.nextLine(); 
				inputCheck(strIn2, scn);
			}

			else{
				nFinalNumObs = nObs;
			}

		}
		
		catch(NumberFormatException nfe){

			System.out.println("\nYou did not enter an integer. Please enter an integer between 0 and 99999.");
			String strIn2 = scn.nextLine(); 
			inputCheck(strIn2, scn);

		}
			
	}

}
