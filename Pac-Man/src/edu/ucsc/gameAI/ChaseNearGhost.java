package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class ChaseNearGhost implements IBinaryNode, IAction{
	private MOVE pMove;
	public ChaseNearGhost(Game game){
		int minDistance=Integer.MAX_VALUE;
		GHOST minGhost=null;		
		int currentNodeIndex=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)>0)
			{
				int distance=game.getShortestPathDistance(currentNodeIndex,game.getGhostCurrentNodeIndex(ghost));
				
				if(distance<minDistance)
				{
					minDistance=distance;
					minGhost=ghost;
				}
			}
		if(minGhost != null){
			pMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(minGhost),DM.PATH);
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
