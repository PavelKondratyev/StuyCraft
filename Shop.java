public class Shop extends StuyCraft {

        public static void Shop() {
        	boolean shop = true;
        	boolean hpShop = true;
                boolean mpShop = true;
        	Scanner buy = new Scanner(System.in);
        	while ( shop == true) {
        		System.out.println("Hey listen! It's dangerous to go alone! Buy something!");
        		System.out.println("You have " + hpPots + " HP potions.");
        		System.out.println("You have " + mpPots + " MP potions.")
        		do {
        			System.out.println("HP Potion | 25 moneys (Type a number)");
        			if ( buy.hasNextInt() ) {
	        			buy.nextInt();
	        			if ( ( buy * 25 ) > money ) {
	        				System.out.println("Fool! You don't have enough moneys!");
	        				System.out.println("Try again!");
	        			}
	        			else {
	        				System.out.println("Success! You bought " + buy + " HP pot(s).")
	        				money -= ( buy * 25 );
	        				hpPots += buy;
	        				hpShop = false;
	        			}
	        		else {
	        			System.out.print("Invalid response");
	        		}
	        		}
	        		} while ( hpShop = true );
	        	do {
	        		System.out.println("MP Potion | 10 moneys (Type a number)");
	        		if ( buy.hasNextInt() ) {
	        			buy.nextInt();
	        			if ( ( buy * 10 ) > money ) {
	        				System.out.println("Fool! You don't have enough moneys!");
	        				System.out.println("Try again!");
	        			}
	        			else {
	        				System.out.println("Success! You bought " + buy + " MP pot(s).")
	        				money -= ( buy * 10 );
	        				mpPots += buy;
	        				mpShop = false;
	        			}
	        		else {
	        			System.out.print("Invalid response");
	        		}
	        		}
	        		} while ( mpShop = true );
	        	System.out.println("Type in exit to leave or anything else to stay!");
	        	Scanner exit = new Scanner(System.in);
	        	exit.next();
	        	if ( exit.equalsIgnoreCase( "exit" ) ) {
	        		shop = false;
	        	}
        	System.out.println("Have a nice day!");
               }
        }
}
