class Warrior extends Character{
    //Warriors have higher Attack and Defense
    //Their Special attack reduces the oponents armor by the Special attack stat
  
    public Warrior( String name ){
	Name = name;
	HP = maxHP = 100;
	MP = maxMP = 5;
	Attack = 10;
	Defense = 10;
	SPAttack = 5;
	SPDefense = 3;
	Accuracy = 8;
	Speed = .5;
    }
    //Formula for Special attack is enemy.Defense = enemy.Defense - (SPAttack - enemy.SPDefense) and it costs 1 MP
    public void attackSP( Character target ){
	System.out.println("HEAR MY BATTLECRY!!!!!");
	if (target.SPDefense > SPAttack){
	    System.out.println( Name + "'s special attack was blocked by the enemy's special defense");
	    MP -= 1; 
	}
	else if(missHit() == true){
	    System.out.println( Name + "'s special attack missed");
	}

	else{
	    System.out.println("The foe's Defense dropped");
	    enemy.Defense -= (SPAttack - target.SPDefense);
	    MP -=1;
	}
    }
}

