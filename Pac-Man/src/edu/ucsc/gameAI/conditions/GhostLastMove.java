package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class GhostLastMove implements ICondition {

	MOVE gmove;
	GHOST gghost;
	public GhostLastMove(GHOST ghost, MOVE move){
		gghost = ghost;
		gmove = move;
		
	}
	@Override
	public boolean test(Game game) {
		if (game.getGhostLastMoveMade(gghost) == gmove){
			return true;
		}
		return false;
	}

}
