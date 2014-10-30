class FrostWyrm extends Character{
    //Frost Wyrms are the boss enemies, while they don't do special attakcs, they hurt a lot
    //Their abilities scale with the wave, not the level
 
  
    public FrostWyrm( int wave ){
	Name = "Frost Wyrm";
	HP = maxHP = 40+ (wave * 20);
	Attack = (wave * 8);
	Defense = (wave * 4);
	SPDefense = 2 + (wave * 2);
	Accuracy = (wave * 5);
	Speed = .4;
    }
}

