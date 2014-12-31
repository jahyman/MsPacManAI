package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;


public class PacmanInRegion implements ICondition{
	int px1, px2, py1, py2;

	public PacmanInRegion (int x1, int y1, int x2, int y2){
		px1 = x1;
		px2 = x2;
		py1 = y1;
		py2 = y2;
		
	}
	@Override
	public boolean test(Game game) {
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				if(j == game.getNodeXCood(game.getPacmanCurrentNodeIndex())){
					if(k == game.getNodeYCood(game.getPacmanCurrentNodeIndex())){
						return true;
					}
				}
			}
		}
		return false;
	}

}
