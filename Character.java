import java.util.Random;
class Character{
    public String Name;
    public int HP, maxHP , MP, maxMP , Attack, SPAttack, Defense, SPDefense, Accuracy;
    public double Speed;
 
    
    public boolean isAlive(){
	if(HP <= 0){
	    return false;}
	else{
	    return true;}
    }

    public boolean  missHit(){ //This sees if you miss the hit
	Random rand = new Random();
	int intRand = rand.nextInt(Accuracy);
	if (intRand != 0){
	    return false;
		//returns false if the hit goes through
		}
	else{
	    return true;
	}
    }

    public int  calcDamage( Character target ){
	int Damage = 0;
	System.out.println("=====================");
	if (missHit() == false){
	    Damage += Attack - target.Defense;
	    System.out.println( Name + " attacked " + target.Name + " for " + Damage + " damage!");
	} 
	else {
	    System.out.println( Name+ "'s attack missed!" );
	}
	return Damage;
    }
    
    public void attack( Character target ){
	int Damage = calcDamage(target);
	target.HP -= Damage;
    }

    public void attackSP( Character target ){
	System.out.println("If this prints, that means there's an error");
    }
    public void printStats(){
	System.out.println("=====================");
	System.out.println("Max HP:"+ maxHP);
	System.out.println("Current HP:"+ HP);
	System.out.println("Max MP:"+ maxMP);
	System.out.println("Current MP:"+ MP);
	System.out.println("Attack:"+Attack);
	System.out.println("SP Attack:"+ SPAttack);
	System.out.println("SP Defense:" + SPDefense);
	System.out.println("Speed:" + Speed);
	System.out.println("Accuracy:"+ Accuracy);

    }
}
