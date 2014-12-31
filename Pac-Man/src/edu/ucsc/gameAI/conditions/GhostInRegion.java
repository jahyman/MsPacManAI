package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostInRegion implements ICondition {
	
	int px1, px2, py1, py2;
	GHOST[] ghosts;

	public GhostInRegion (int x1, int y1, int x2, int y2){
		px1 = x1;
		px2 = x2;
		py1 = y1;
		py2 = y2;
		
	}
	@Override
	public boolean test(Game game) {
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
						return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
						return true;
					}
				}
			}
		}
		return false;
	}

}
