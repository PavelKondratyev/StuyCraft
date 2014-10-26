class Skeleton extends Character{
    //Skeletons are basic enemies, they have no special attacks and can only do a regular attack
    //Their abilities scale with the wave, not the level
 
  
    public Skeleton( int wave ){
	Name = "Skeleton";
	HP = maxHP = 50 + (wave * 20);
	Attack = 5 + (wave * 5);
	Defense = 5 + (wave * 5);
	SPDefense = 2 + (wave *2);
	Accuracy = (wave * 4);
	Speed = .65;
    }
}

