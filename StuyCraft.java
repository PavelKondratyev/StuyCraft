import java.util.*;


public class StuyCraft{
    

    public static void main(String[]args){
	System.out.println("\n\nWelcome to StuyCraft\n\nWhere myths come to life! \n\nPlease choose your character: \nSabetour: Caster who specializes in debuff. \nDualBlade: Brutal fighter that slashes enemies \n \n"); 
	String Choice;
	Scanner Choose = new Scanner(System.in); //Choosing options in cmd
	Choice = Choose.next(); //Waiting in cmd for response
	
	if ((Choice).equals("Sabetour") || (Choice).equals("DualBlade") ){
	    System.out.println( Choice + " " + "has been initialized");
	}
	
	else{
	    System.out.println( Choice +" "+ "is not a recongnized keyword");
	    System.out.println("Error: Character Not Recognized \n Please restart StuyCraft");
	    System.exit(1); //Ends the CMD.
	}	    

	System.out.println("\n\nWould you like to start a new game or load a save file? \n\nNew Game          Load Game\n\n");

	Choice = Choose.next();

	if ((Choice).equals ("Load Game")){ //Save 
	    System.out.println("Enter save file keyword\n");
	    Choice = Choose.next();
	    if ((Choice).equals( "STAGE1") || (Choice).equals( "STAGE2")){
		System.out.println(Choice +" "+ "has been initialized");
	    }
	    else{
		System.out.println(Choice + "is not a recognized keyword \n Please try again.");
		System.exit(1); //Ends the CMD
	    }
	}
    }
}
