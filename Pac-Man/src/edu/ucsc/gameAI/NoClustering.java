package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class NoClustering implements IBinaryNode, IAction{
	private MOVE pMove;
	public NoClustering(Game game, GHOST ghost){	
		int currentNodeIndex=game.getPacmanCurrentNodeIndex();
		for(GHOST nGhost : GHOST.values()){
			if(ghost != nGhost){
				if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
					if(game.getShortestPathDistance(currentNodeIndex,game.getGhostCurrentNodeIndex(ghost))<10){
						pMove = game.getNextMoveAwayFromTarget(game.getGhostCurrentNodeIndex(ghost),game.getGhostCurrentNodeIndex(nGhost),DM.PATH);
				}
			}
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
	    //System.out.println(pMove);
		return pMove;
	}
}