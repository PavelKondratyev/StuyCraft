class Archer extends Character{
    //Mages are only a hair weaker than warrios, do a decent amount of regular damage, but their SP attacks obliterate
    //Their special attack does Their Attack * their SP attack and thus is their primary source of damage
  
    public Archer( String name ){
	Name = name;
	HP = maxHP = 90;
	MP = maxMP = 10;
	Attack = 8;
	Defense = 7;
	SPAttack = 3;
	SPDefense = 7;
	Accuracy = 10;
	Speed = .6;
    }
    //Formula for attack is taget.HP -= (Attack*SPAttack - target.SPDefense)
    public static void attackSP( Character target ){
	System.out.println("By Gandalf!");
	if (missHit() == true){
	    System.out.println( Name + "'s special attack missed!";
	    MP -= 1;
	}
	else{
	    System.out.println("NYEAAAH!");
	    target.HP -= (Attack * SPAttack - target.SPDefense);
	    MP -=1;
	}
    }
}

