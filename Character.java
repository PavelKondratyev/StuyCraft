class Character{
    protected String Name;
    protected int HP, MP, Attack, SpAttack, Defense, SPDefense, Accuracy;
    protected double Speed;
 
    
    public Character( String name ){
	Name = name;
	HP = 100;
	Strength = 10;
	Defense = 10;
	Speed = 1.0;
	Accuracy = 8;
    }

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
    
    public int calcSPDamage( Character target ){//calculates damage from special attack
	int Damage = 0;
	if (missHit() == false){
	    Damage += SPAttack - target.SPDefense;
	    System.out.println( name + " attacked " + target.Name + " for " + Damage + " damage!");
	}
	else {
	    System.out.println( name + "'s attack missed!");
	}
	return Damage;
    }
    
    public void attack( Character target ){
	int Damage = calcDamage(target);
	target.HP -= Damage;
    }

    public void SPAttack( Character target ){
	int Damage = calcSPDamage(target);
	target.HP -= Damage;

}
