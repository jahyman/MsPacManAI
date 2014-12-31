package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostInRegionEdible implements ICondition {
	
	int px1, px2, py1, py2, x, y;
	GHOST[] ghosts;

	public GhostInRegionEdible (Game game){
		x = game.getNodeXCood(game.getPacmanCurrentNodeIndex());
		y =  game.getNodeYCood(game.getPacmanCurrentNodeIndex());
		px1 = x - 2;
		py1 = y + 2;
		px2 = x + 2;
		py2 = y - 2;
		
	}
	@Override
	public boolean test(Game game) {
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY)) && game.isGhostEdible(GHOST.BLINKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.PINKY)) && game.isGhostEdible(GHOST.PINKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.INKY)) && game.isGhostEdible(GHOST.INKY)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.SUE)) && game.isGhostEdible(GHOST.SUE)){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
						return true;
					}
				}
			}
		}
		return false;
	}

}