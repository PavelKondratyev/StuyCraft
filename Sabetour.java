import java.util.Random;
import java.lang.Math;
public class Sabetour extends Character {

    // All enemies will need a counter and boolean for each debuff (probably in
    // the enemy subclass.

    //TO DO
    // Every debuff with make the previous debuff last an extra turn (does not 
    // stack [ possibly in the enemy class ] ), add mana


    public Sabetour() {
	name = "Morgan";
	heatlh = 80;
	pdefence = 70;
	mdefence = 80;
    }


    // Reduces enemy physical defence by 20% (temp) for 3 turns (temp)
    public void deprotect( Character e ) {
	e.deprotect = True;
	e.pdefence *= .8;
	System.out.println( "Deprotect Successful!" );
    }

    // Reduces enemy magical defence by 20% (temp) for 3 turns (temp)    
    public void imperil( Character e ) {
	e.imperil = True;
	e.mdefence *= .8;
	System.out.println( "Imperil Successful!" );
    }

    // Inflicts damage to the enemy each turn for 3 turns (temp) 
    public void poison( Character e ) {
        e.poison = True;
	System.out.println( "Poison Successful!" );
    }

    // Causes the enemy to be unable to take action for 3 turns (temp) with a
    // 30% chance
    public void daze( Character e ) {
	Random rand = new Random();
	int randomNum = rand.nextInt( 10 ) + 1;
	if ( randomNum <= 3) {
	    e.daze = True;
	    System.out.println( "Daze Successful!" );
	}
	else {
	    System.out.println( "Daze Unsuccessful!" );
	}
    }

    // Takes a boolean as a parameter and returns 1 if the boolean is true.
    public int booleanToInt( boolean b ) {
	if ( b ) {
	    return 1
		}
	else {
	    return 0
		} 
    }

    // A low chance instant KO skill that increases if the enemy is inflicted
    // with debuffs (base chance
    public void death( Character e ) {
	Random rand = new random();
	int randomNum = rand.nextInt( 100 ) + 1;
	double counter = booleanToInt( e.deprotect ) + booleanToInt( e.imperil ) + booleanToInt( e.poison ) + booleanToInt( e.daze );
	if ( randomNum <= Math.pow( 2, counter) ) {
	    e.health == 0;
	}
    }
}
