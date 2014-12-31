package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;


public class Score implements ICondition {
	
	int s_min;
	int s_max;
	
	public Score(int min, int max){		
		s_min = min;
		s_max = max;
	}

	public boolean test(Game game) {
		
		if (s_min > game.getScore()){
			return false;
		}
		else if (s_max < game.getScore()){
			return false;
		}
		else {
			return true;
		}
	}

}
