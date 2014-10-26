class Skeleton extends Character{
    //Frost Wyrms are the boss enemies, while they don't do special attakcs, they hurt a lot
    //Their abilities scale with the wave, not the level
 
  
    public FrostWyrm( int wave ){
	Name = "Frost Wyrm";
	HP = maxHP = 50 + (wave * 50);
	Attack = (wave * 10);
	Defense = (wave * 5);
	SPDefense = 2 + (wave *4);
	Accuracy = (wave * 5);
	Speed = .4;
    }
}

