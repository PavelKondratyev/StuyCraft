//Pavel Kondratyev, Aiden Lui, Andy Tu, Max
import java.util.*;


public class StuyCraft{

    //Instance Variables 
    private int wave, level, money, hpPots, mpPots;
    private boolean gameOver;
    private  Character player, enemy;
    //There are 3 waves with 4 levels each - each 4th level is the boss match
    //gameOver is used to signify if the game is over or not, bossLevel signifies if the current level is a boss level

    //Constructor for StuyCraft
    public StuyCraft(){
	wave = 1;
	level = 1;
	money = 0;
	gameOver = false;
	initGame();
    }

    public void initGame(){
	String welcomeMessage = "";
	welcomeMessage+= "============================\n";
	welcomeMessage+= "Welcome to StuyCraft!\n";
	welcomeMessage+= "Where myths come to life!\n";
	welcomeMessage+= "Please choose your character(case sensitive) :\n";
	welcomeMessage+= "\tWarrior: Brutal fighter that slashes enemies\n";
	welcomeMessage+= "\tMage: Caster who can obliterate enemies with spells";
	welcomeMessage+= "\tArcher: Ranger who can Do extra damage with his special attack\n";
	welcomeMessage+= "============================\n";
      	System.out.println(welcomeMessage);
	
	String Choice = "";
	Scanner Choose = new Scanner(System.in); //Choosing options in cmd
	System.out.println("Please enter the character:");
	Choice = Choose.next();

	while(!((Choice).equals("Warrior") || (Choice).equals("Mage") || (Choice).equals("Archer"))){
	    System.out.println("Invalid selection, please try again\n");
	    System.out.println("Select your character:");
	    Choice = Choose.next();
	}
	System.out.println("Please enter your name:");
	String Name = "";
	Name = Choose.next();

	while(Name.length() == 0){
	    System.out.println("Error!\n Please enter a valid name:");
	    Name = Choose.next();
	}

	System.out.println( Choice + " " + "has been initialized");
	if(Choice.equals("Warrior")){
	    player = new Warrior(Name);
	}
	else if(Choice.equals("Mage")){
	    player = new Mage(Name);
	}
	else if(Choice.equals("Archer")){
	    player = new Archer(Name);
	}
    }

    public void enemyEncounter(){
	enemy = new Skeleton( wave );
	Scanner move = new Scanner(System.in);
	System.out.println("You have run into a skeleton");
	while (enemy.isAlive() && player.isAlive()){
	    System.out.println("What will you do:");
	    System.out.println("Attack\nSpecial Attack \nShop");
	    System.out.println("Please input your action:");
	    move.next();
	    if (move.equalsIgnoreCase("Attack") || move.equalsIgnoreCase("Special Attack") || move.equalsIgnoreCase("Shop")){
		if (move.equalsIgnoreCase("Attack")){
		    if (player.Speed > enemy.Speed){
			player.attack( enemy );
			enemy.attack( player );
		    }
		    else{
			enemy.attack( player );
			player.attack( enemy );
		    }
		}
		else if (move.equalsIgnoreCase("Special Attack")){
		    if (player.Speed > enemy.Speed){
			player.attackSP(enemy);
			enemy.attack( player );
		    }
		    else{
			enemy.attack( player );
			player.attackSP( enemy );
		    }
		}
		else if ( wave > 1 && move.equalsIgnoreCase("Shop")) {
			Shop();
		}
		else {
			System.out.println("The shop is not open yet");
		}
		    
	    }
	    else{
		System.out.println("Invalid move, try again!");
	    }
	}

    }

    public void bossEncounter(){
	enemy = new FrostWyrm( wave );

    }

    public  void youWin(){
	System.out.println("You have beaten the game!");
    }



    public void playGame(){
	if(wave > 3){
	    youWin();
	}
	else if(level == 4){
	    if(bossEncounter() == true){//true meaning that you defeated the boss
		level =1;
		wave +=1;
		money += 100;
		System.out.println("You have slain the mighty Frost Wyrm! He dropped 100 money!");
	    } 
	}
	else{
	    if( enemyEncounter() == true){//true means that you defeated the enemy
		level += 1;
		money += 50;
		System.out.println("You have slain the skeleton! He dropped 50 money!");
	    }
	}
    }

    
    public static void main(String[] args){
	System.out.println("Prepare for an adventure");
	StuyCraft main = new StuyCraft();
	while(gameOver == false){
	    while(player.isAlive()){
		playGame();
	    }
	}
    }		
}
