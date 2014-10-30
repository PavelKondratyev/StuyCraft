class Mage extends Character{
    //Mages are only a hair weaker than warrios, do a decent amount of regular damage, but their SP attacks obliterate
    //Their special attack does Their Attack * their SP attack and thus is their primary source of damage
  
    public Mage( String name ){
	Name = name;
	HP = maxHP = 90;
	MP = maxMP = 10;
	Attack = 12;
	Defense = 5;
	SPAttack = 2;
	SPDefense = 7;
	Accuracy = 10;
	Speed = .6;
    }
    //Formula for attack is taget.HP -= (Attack*SPAttack - target.SPDefense)
    public  void attackSP( Character target ){
	if(MP>0){
	    System.out.println("=====================");
	    System.out.println("By Gandalf!");
	    if (missHit() == true){
		System.out.println( Name + "'s special attack missed!");
		MP -= 1;
	    }
	    else{
		System.out.println("NYEAAAH!");
		System.out.println( Name + " did " + (Attack * SPAttack - target.SPDefense) + " damage to the "+ target.Name);
		target.HP -= (Attack * SPAttack - target.SPDefense);
		MP -=1;
	    }
	}
	else{
	    System.out.print("Not enough mana!");
	}
    }

}
