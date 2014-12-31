package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class NumberOfLivesRemaining implements ICondition{

	int lmin;
	int lmax;
	public NumberOfLivesRemaining(int min, int max){
		lmin = min;
		lmax = max;
	}
	@Override
	public boolean test(Game game) {
		if(lmin > game.getPacmanNumberOfLivesRemaining()){
			return false;
		}
		if(lmax < game.getPacmanNumberOfLivesRemaining()){
			return false;
		}
		return true;
	}

}
