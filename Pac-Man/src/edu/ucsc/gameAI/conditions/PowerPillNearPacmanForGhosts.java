package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PowerPillNearPacmanForGhosts implements ICondition{
	int px1, px2, py1, py2, x, y;
	
	public PowerPillNearPacmanForGhosts(Game game){
		x = game.getNodeXCood(game.getPacmanCurrentNodeIndex());
		y =  game.getNodeYCood(game.getPacmanCurrentNodeIndex());
		px1 = x - 20;
		py1 = y - 20;
		px2 = x + 20;
		py2 = y + 20;
	}
	@Override
	public boolean test(Game game) {
		int[] loc = game.getActivePowerPillsIndices();
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