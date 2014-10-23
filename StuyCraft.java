import java.util.*;


public class StuyCraft{

    //Instance Variables 
    private int wave, level, money;
    private boolean gameOver, bossLevel;
    private Character player, enemy;
    //There are 3 waves with 4 levels each - each 4th level is the boss match
    //gameOver is used to signify if the game is over or not, bossLevel signifies if the current level is a boss level



    //Constructor for StuyCraft
    public StuyCraft(){
	wave = 1;
	level = 1;
	money = 100;
	gameOver = false;
	initGame();
    }

    public void initGame(){
	String welcomeMessage = "";
	welcomeMessage+= "============================\n";
	welcomeMessage+= "Welcome to StuyCraft!\n";
	welcomeMessage+= "Where myths come to life!\n";
	welcomeMessage+= "Please choose your character(case sensitive) :\n";
	welcomeMessage+= "\tSabetour: Caster who specializes in debuff\n";
	welcomeMessage+= "\tDualBlade: Brutal fighter that slashes enemies and\n";
	welcomeMessage+= "\tRanger: Archer with the ability to critically strike\n";
	welcomeMessage+= "============================";
      	System.out.println(welcomeMessage);
	
	String Choice;
	Scanner Choose = new Scanner(System.in); //Choosing options in cmd
	Choice = Choose.next();

	while(!((Choice).equals("Sabetour") || (Choice).equals("DualBlade") || (Choice).equals("Ranger"))){
	    System.out.println("Invalid selection, please try again");
	    System.out.println("Select your character:");
	    Choice = Choose.next();
	}
	  
	System.out.println( Choice + " " + "has been initialized");
	if(Choice.equals("Sabetour")){
	    player = new Sabetour();
	}
	else if(Choice.equals("DualBlade")){
	    player = new DualBlade();
	}
	else if(Choice.equals("Ranger")){
	    player = new Ranger();
	}
    }

    public static void enemyEncounter(){
	enemy = new Skeleton();

    }

    public static void bossEncounter(){
    }
    
    public static void main(String[] args){

    }
	

	
}
