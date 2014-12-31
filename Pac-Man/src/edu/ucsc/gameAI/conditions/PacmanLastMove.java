package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class PacmanLastMove implements ICondition{
	
	MOVE pmove;

	public PacmanLastMove(MOVE move){
		pmove = move;
	}
	@Override
	public boolean test(Game game) {
		if(pmove == game.getPacmanLastMoveMade()){
			return true;
		}
		return false;
	}

}
