package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PillNearPacman implements ICondition{
	
	int px1, px2, py1, py2, x, y;
	
	public PillNearPacman(Game game){
		x = game.getNodeXCood(game.getPacmanCurrentNodeIndex());
		y =  game.getNodeYCood(game.getPacmanCurrentNodeIndex());
		px1 = x - 2;
		py1 = y - 2;
		px2 = x + 2;
		py2 = y + 2;
	}
	@Override
	public boolean test(Game game) {
		int[] loc = game.getActivePillsIndices();
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				for(int i = 0; i < loc.length; ++i){
					if(j == game.getNodeXCood(loc[i])){
						if(k == game.getNodeYCood(loc[i])){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
