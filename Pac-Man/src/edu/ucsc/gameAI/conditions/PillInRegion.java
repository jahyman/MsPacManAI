package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class PillInRegion implements ICondition{
	
	int px1, px2, py1, py2;

	public PillInRegion (int x1, int y1, int x2, int y2){
		px1 = x1;
		px2 = x2;
		py1 = y1;
		py2 = y2;
		
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
