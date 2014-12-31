package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class EdibleTime implements ICondition{

	GHOST gghost;
	int gmin;
	int gmax;
	public EdibleTime(GHOST ghost, int min, int max){
		gghost = ghost;
		gmin = min;
		gmax = max;
	}
	@Override
	public boolean test(Game game) {
		if (gmin > game.getGhostEdibleTime(gghost)){
			return false;
		}
		if(gmax < game.getGhostEdibleTime(gghost)){
			return false;
		}
		return true;
	}

}
