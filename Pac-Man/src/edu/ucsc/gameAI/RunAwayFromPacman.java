package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class RunAwayFromPacman implements IBinaryNode, IAction{
	private MOVE pMove;
	public RunAwayFromPacman(Game game, GHOST ghost){
		int currentNodeIndex=game.getPacmanCurrentNodeIndex();
		//for(GHOST ghost : GHOST.values()){
			if(game.getGhostEdibleTime(ghost)!=0 && game.getGhostLairTime(ghost)==0)
				if(game.getShortestPathDistance(game.getGhostCurrentNodeIndex(ghost),currentNodeIndex)<100){
					pMove = game.getNextMoveAwayFromTarget(game.getGhostCurrentNodeIndex(ghost),game.getPacmanCurrentNodeIndex(),DM.PATH);
					//System.out.println(pMove);
				}
		//}
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
	    //System.out.println(pMove);
		return pMove;
	}
}
