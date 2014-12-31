package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class DistanceToNearestEdibleGhost implements ICondition{

	int px1, px2, py1, py2, x, y, distB, distP, distI, distS;
	int distSh = 0;
	GHOST[] ghosts;

	public DistanceToNearestEdibleGhost(Game game){
		x = game.getNodeXCood(game.getPacmanCurrentNodeIndex());
		y =  game.getNodeYCood(game.getPacmanCurrentNodeIndex());
		px1 = x - 10;
		py1 = y + 10;
		px2 = x + 10;
		py2 = y - 10;
		
	}
	@Override
	public boolean test(Game game) {
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY)) && game.isGhostEdible(GHOST.BLINKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){				
						distB = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.BLINKY));
						distSh = distB;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.PINKY)) && game.isGhostEdible(GHOST.PINKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
						distP = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.PINKY));
						if(distP < distSh){
							distSh = distP;
						}
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.INKY)) && game.isGhostEdible(GHOST.INKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
						distI = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.INKY));
						if(distI < distSh){
							distSh = distI;
						}
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.SUE)) && game.isGhostEdible(GHOST.SUE)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
						distS = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.SUE));
						if(distS < distSh){
							distSh = distS;
						}
					}
				}
				if(distSh >= 8){
					return false;
				}
			}
		}
		return true;
	}
}