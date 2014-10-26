class Character{
    protected String Name;
    protected int HP, maxHP , MP, maxMP , Attack, SPAttack, Defense, SPDefense, Accuracy;
    protected double Speed;
 
    
    public boolean isAlive(){
	if(HP <= 0){
	    return false}
	else{
	    return true}
    }

    public boolean  missHit(){ //This sees if you miss the hit
	Random rand = new Random();
	int intRand = rand.nextInt(Accuracy);
	if (intRand != 0){
	    return false
		//returns false if the hit goes through
		}
    }

    public int  calcDamage( Character target ){
	int Damage = 0;
	if (missHit() == false){
	    Damage += Strength - target.Defense;
	    System.out.println( name + " attacked " + target.Name + " for " + Damage + " damage!");
	} 
	else {
	    System.out.println( name+ "'s attack missed!" );
	}
	return Damage;
    }
    
    public void attack( Character target ){
	int Damage = calcDamage(target);
	target.HP -= Damage;
    }


}
