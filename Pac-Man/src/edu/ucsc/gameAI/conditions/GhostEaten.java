package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostEaten implements ICondition{

	GHOST gghost;
	public GhostEaten(GHOST ghost){
		gghost = ghost;
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.wasGhostEaten(gghost);
	}

}
