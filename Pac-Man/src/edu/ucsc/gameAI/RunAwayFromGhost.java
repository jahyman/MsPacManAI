package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class RunAwayFromGhost implements IBinaryNode, IAction{
	private MOVE pMove;
	public RunAwayFromGhost(Game game){
		//int minDistance=Integer.MAX_VALUE;
		//GHOST minGhost=null;		
		int currentNodeIndex=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values()){
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
				if(game.getShortestPathDistance(currentNodeIndex,game.getGhostCurrentNodeIndex(ghost))<10){
					pMove = game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}
					
			/*if(game.getGhostEdibleTime(ghost)<=0){
			int distance=game.getShortestPathDistance(currentNodeIndex,game.getGhostCurrentNodeIndex(ghost));			
			if(distance<minDistance){
				minDistance=distance;
				minGhost=ghost;
			}
			if(minGhost != null){
				pMove = game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(minGhost),DM.PATH);
				//System.out.println(pMove);
			}*/
			//}
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
