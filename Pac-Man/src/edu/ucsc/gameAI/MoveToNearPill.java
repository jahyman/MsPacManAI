package edu.ucsc.gameAI;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class MoveToNearPill implements IBinaryNode, IAction{
	int[] activePills;
	int[] activePPills;
	int[] neighbors;
	private MOVE pMove;
	public MoveToNearPill(Game game){
		int currentNodeIndex=game.getPacmanCurrentNodeIndex();
		activePills=game.getActivePillsIndices();
		int[] neighbors = game.getNeighbouringNodes(currentNodeIndex);
		activePPills = game.getActivePowerPillsIndices();
		pMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getClosestNodeIndexFromNodeIndex(currentNodeIndex,activePills,DM.PATH),DM.PATH);
		for(int x = 0; x < neighbors.length; x++){
			if(game.getPowerPillIndex(neighbors[x]) != -1){
				pMove = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getFarthestNodeIndexFromNodeIndex(currentNodeIndex,activePills,DM.PATH),DM.PATH);
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
		return pMove;
	}
}
