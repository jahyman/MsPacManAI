package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class LairTime implements ICondition{

	GHOST gghost;
	int gmin;
	int gmax;
	
	public LairTime(GHOST ghost, int min, int max){
		gghost = ghost;
		gmin = min;
		gmax = max;
	}
	@Override
	public boolean test(Game game) {
		if(gmin > game.getGhostLairTime(gghost)){
			return false;
		}
		if(gmax < game.getGhostLairTime(gghost)){
			return false;
		}
		return true;
	}
}
