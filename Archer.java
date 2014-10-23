import java.util.Random;
import java.lang.Math;
public class Archer extends Character {

        // A character that has low damage but a chance for a crit

        public Archer() {
                name = "Robin";
                health = 80;
                
                pdefence = 80;
                mdefence = 75;
                attack = 60;
        }
        
        
        // An overwritten attack method with crit
        public void attack( Character e ) {
                Random rand = new Random();
                int randomNum = rand.nextInt( 10 ) + 1;
                if ( randomNum <= 7 ) {
                        e.health -= attack * 2;
                else {
                        e.health -= attack;
                        }
                }
        }
        
        // A
                
        
