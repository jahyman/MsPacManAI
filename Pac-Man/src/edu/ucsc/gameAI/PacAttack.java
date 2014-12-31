package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class PacAttack implements IBinaryNode, IAction{
	private MOVE pMove;
	public PacAttack(Game game,GHOST ghost){
		//for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)== 0){
				pMove = game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),game.getPacmanCurrentNodeIndex(),DM.PATH);
				//System.out.println(pMove);
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
