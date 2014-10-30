//Pavel Kondratyev, Aiden Lui, Andy Tu, Max Kong
import java.util.*;


public class StuyCraft{

    //Instance Variables 
    private int wave, level;
    private  int  money;
    private static boolean gameOver;
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
	welcomeMessage+= "Please choose your character:\n";
	welcomeMessage+= "\tWarrior: Brutal fighter that slashes enemies\n";
	welcomeMessage+= "\tMage: Caster who can obliterate enemies with spells\n";
	welcomeMessage+= "\tArcher: Ranger who can Do extra damage with his special attack\n";
	welcomeMessage+= "============================\n";
      	System.out.println(welcomeMessage);
	
	String Choice = "";
	Scanner Choose = new Scanner(System.in); //Choosing options in cmd
	System.out.println("Please enter the character:");
	Choice = Choose.nextLine();

	while(!((Choice).equalsIgnoreCase("Warrior") || (Choice).equalsIgnoreCase("Mage") || (Choice).equalsIgnoreCase("Archer"))){
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
	if(Choice.equalsIgnoreCase("Warrior")){
	    player = new Warrior(Name);
	}
	else if(Choice.equalsIgnoreCase("Mage")){
	    player = new Mage(Name);
	}
	else if(Choice.equalsIgnoreCase("Archer")){
	    player = new Archer(Name);
	}
    }

    public Boolean enemyEncounter(){
	enemy = new Skeleton( wave );
	Scanner moveChoice = new Scanner(System.in);
	String move;
	System.out.println("You have run into a skeleton");
	while (enemy.isAlive() && player.isAlive()){
	    System.out.println("====================");
	    System.out.println("What will you do:");
	    System.out.println("\tAttack\n\tSpecial \n\tShop \n\tStats");
	    System.out.println("Please input your action:");
	    move = moveChoice.next();
	    if (move.equalsIgnoreCase("Attack") || move.equalsIgnoreCase("Special") || move.equalsIgnoreCase("Shop") ||  move.equalsIgnoreCase("Stats")){
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
		else if (move.equalsIgnoreCase("Special")){
		    if (player.Speed > enemy.Speed){
			player.attackSP(enemy);
			enemy.attack( player );
		    }
		    else{
			enemy.attack( player );
			player.attackSP( enemy );
		    }
		}
		else if(move.equalsIgnoreCase("Shop")){
		    shop();
		}
		else{
		    player.printStats();
		}
	    }

	    else{
		System.out.println("Invalid move, try again!");
	    }
	}	    
	return true;
    }

    public Boolean  bossEncounter(){
	enemy = new FrostWyrm( wave );
	Scanner moveChoice = new Scanner(System.in);
	String move;
	System.out.println("You have run into a Frost Wyrm!");
	while (enemy.isAlive() && player.isAlive()){
	    System.out.println("====================");
	    System.out.println("What will you do:");
	    System.out.println("\tAttack\n\tSpecial \n\tShop \n\tStats");        
	    System.out.println("Please input your action:");
	    move = moveChoice.next();
	    if (move.equalsIgnoreCase("Attack") || move.equalsIgnoreCase("Special") || move.equalsIgnoreCase("Shop") ||  move.equalsIgnoreCase("Stats")){
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
		else if (move.equalsIgnoreCase("Special")){
		    if (player.Speed > enemy.Speed){
			player.attackSP(enemy);
			enemy.attack( player );
		    }
		    else{
			enemy.attack( player );
			player.attackSP( enemy );
		    }
		}
		else if(move.equalsIgnoreCase("Shop")){
		    shop();
		}
		else{
		    player.printStats();
		}
	    }

	    else{
		System.out.println("Invalid move, try again!");
	    }
	}	    
	return true;

    }

    public void youWin(){
	System.out.println("You have beaten the game!");
	System.exit(0);
    }

    public void shop() {
	Boolean shop = true;
	Scanner buy = new Scanner(System.in);
	
	while ( shop == true) {
	    String choice = "";
	    System.out.println("====================");
	    System.out.println("What would you like to buy?");
	    System.out.println("\tHealthPot - 50  \n\tManaPot - 50 \n\tAttackBoost -150 \n\tDefenseBoost -150 \n\tExit");
	    choice = buy.next();
	    if(choice.equalsIgnoreCase("HealthPot")||choice.equalsIgnoreCase("ManaPot")||choice.equalsIgnoreCase("AttackBoost")||choice.equalsIgnoreCase("DefenseBoost")||choice.equalsIgnoreCase("Exit")){
		if(choice.equalsIgnoreCase("HealthPot")){
		    if(money >= 25){
			player.HP = player.maxHP;
			money -= 25;
			System.out.println("You have succesfully healed");
		    }
		    else{
			System.out.println("Insufficent funds");
		    }
		}
	      	else if(choice.equalsIgnoreCase("ManaPot")){
		    if(money >= 25){
			player.MP = player.maxMP;
			money -= 25;
			System.out.println("Succesfully restored Mana");
		    }
		    else{
			System.out.println("Insufficent funds");
		    }	
		}
		else if(choice.equalsIgnoreCase("AttackBoost")){
		    if(money >= 150){
		        player.Attack += 3;
			player.SPAttack += .5;
			System.out.println("Raised attack by 3 and SP attack by .5");
			money -= 150;
		    }
		    else{
			System.out.println("Insufficent funds");
		    }
		}
		else if(choice.equalsIgnoreCase("DefenseBoost")){
		    if(money >= 150){
			player.Defense += 3;
		        player.SPDefense += 1;
			System.out.println("Increased Defense by 3 and SP Defense by 1");
		    }
		    else{
			System.out.println("Insufficent funds");
		    }
		}
		else {
		    shop = false;
		}
	    }
	}
	    
	System.out.println("Have a nice day!");
    }
    





    public Boolean playGame(){
	while (player.isAlive()){
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
	return false;
    }
    
    public static void main(String[] args){
	System.out.println("Prepare for an adventure");
	StuyCraft main = new StuyCraft();
	while(main.playGame()){
	    
	}
	System.out.println("The game is over, you have perished");
    }		   
    
}
