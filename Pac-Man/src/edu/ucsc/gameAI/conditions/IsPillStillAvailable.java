package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class IsPillStillAvailable implements ICondition{
	
	int pill;

	public IsPillStillAvailable(int pillIndex){
		pill = pillIndex;
		
	}
	@Override
	public boolean test(Game game) {
		return game.isPillStillAvailable(pill);
	}

}
