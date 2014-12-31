package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class CurrentGhostNodeIndex implements ICondition{

	GHOST gghost;
	int gindex;
	public CurrentGhostNodeIndex(GHOST ghost, int index){
		gghost = ghost;
		gindex = index;
	}
	@Override
	public boolean test(Game game) {
		if(gindex == game.getGhostCurrentNodeIndex(gghost)){
			return true;
		}
		return false;
	}

}
