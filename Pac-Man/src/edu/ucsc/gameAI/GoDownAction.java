package edu.ucsc.gameAI;

import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoDownAction implements IAction, IBinaryNode{
	
	@Override
	public IAction makeDecision(Game game) {
		return this;
	}
	
	@Override
	public void doAction() {
		
	}

	@Override
	public MOVE getMove() {
		return MOVE.DOWN;
	}

}
