package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentLevelTime implements ICondition {

	int l_min;
	int l_max;
	
	public CurrentLevelTime(int min, int max){
		l_min = min;
		l_max = max;
	}
	public boolean test(Game game) {
		
		if(l_min > game.getCurrentLevelTime()){
			return false;
		}
		else if(l_max < game.getCurrentLevelTime()){
			return false;
		}
		else {
			return true;
		}
	}

}
