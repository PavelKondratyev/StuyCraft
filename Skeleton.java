class Skeleton extends Character{
    //Skeletons are basic enemies, they have no special attacks and can only do a regular attack
    //Their abilities scale with the wave, not the level
 
  
    public Skeleton( int wave ){
	Name = "Skeleton";
	HP = maxHP = 20 + ( wave * 20);
	Attack = (wave * 7);
	Defense = (wave * 4);
	SPDefense = (wave *2);
	Accuracy = (wave * 4);
	Speed = .65;
    }
}

