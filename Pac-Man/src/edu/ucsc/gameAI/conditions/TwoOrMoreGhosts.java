package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class TwoOrMoreGhosts implements ICondition{

	boolean b, p, i, s;
	int px1, py1, px2, py2, pill;
	
	public TwoOrMoreGhosts(Game game){
		px1 = game.getNodeXCood(game.getPacmanCurrentNodeIndex()) - 2;
		py1 = game.getNodeYCood(game.getPacmanCurrentNodeIndex()) + 2;
		int[] loc = game.getActivePillsIndices();
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
	@Override
	public boolean test(Game game) {
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.BLINKY))){
						b = true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
						p = true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
						i = true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
						s = true;
					}
				}
			}
		}
		if(b&&p || b&&i || b&&s || p&&i || p&&s || i&&s){
			return true;
		}
		return false;
	}

}
