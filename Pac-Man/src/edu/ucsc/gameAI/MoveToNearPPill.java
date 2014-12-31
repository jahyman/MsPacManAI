package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class MoveToNearPPill implements IBinaryNode, IAction{
	int[] activePills;
	private MOVE pMove = MOVE.NEUTRAL;
	public MoveToNearPPill(Game game){
			int currentNodeIndex=game.getPacmanCurrentNodeIndex();
			activePills=game.getActivePowerPillsIndices();
			if(activePills.length > 0){
				pMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getClosestNodeIndexFromNodeIndex(currentNodeIndex,activePills,DM.PATH),DM.PATH);
		}
	}
@Override
	public IAction makeDecision(Game game) {
		return this;
		}
@Override
	public void doAction() {
	}
@Override
	public MOVE getMove() {
		return pMove;
	}
}
