package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class IsPowerPillStillAvailable implements ICondition {
	
	int pill;

	public IsPowerPillStillAvailable(int pillIndex){
		pill = pillIndex;
		
	}
	public boolean test(Game game) {
		return game.isPowerPillStillAvailable(pill);
	}

}
