class Archer extends Character{
    //Archers are squishy but do a lot of damage
    //Their Special attack is a bow attack that does regular damage + SP attack. It ignored defense and only looks at SPDefense
  
    public Archer( String name ){
	Name = name;
	HP = maxHP = 80;
	MP = maxMP = 5;
	Attack = 15;
	Defense = 7;
	SPAttack = 6;
	SPDefense = 5;
	Accuracy = 6;
	Speed = .7;
    }
    //Formula for Special attack is enemy.Defense = enemy.Defense - (SPAttack - enemy.SPDefense) and it costs 1 MP
    public static void attackSP( Character target ){
	System.out.println("I'm charging my bow");
	if (missHit() == true){
	    System.out.println( Name + "'s special attack missed!";
	    MP -= 1;
	}
	else{
	    System.out.println("AHA!");//that's what archers say when they fire
	    target.HP -= (Attack + SPAttack - target.SPDefense);
	    MP -=1;
	}
    }
}

