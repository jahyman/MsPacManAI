package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;


public class GhostInPPPath implements ICondition{
	int px1, py1, px2, py2;
	int pill;
	
	
	public GhostInPPPath(Game game){
		//Get PacMan's Coords
		px1 = game.getNodeXCood(game.getPacmanCurrentNodeIndex()) - 1;
		py1 = game.getNodeYCood(game.getPacmanCurrentNodeIndex()) + 1;
		
		//Get nearest pill's Coords		
		int[] loc = game.getActivePowerPillsIndices();
		if(loc.length-1 > 0){
			px2 = game.getNodeXCood(loc[loc.length-1]);
			py2 = game.getNodeYCood(loc[loc.length-1]);
		}
		else{
			px2 = px1;
			py2 = py1;
		}
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				for(int i = 0; i < loc.length; ++i){
					if(j == game.getNodeXCood(loc[i])){
						if(k == game.getNodeYCood(loc[i])){
							pill = loc[i];
						}
					}
				}
			}
		}
		px2 = game.getNodeXCood(pill);
		py2 = game.getNodeYCood(pill);
	}

	public boolean test(Game game) {
		//System.out.println("YOLO SQUARED");
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
