package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TimeOfLastGlobalReversal implements ICondition {
	
	int g_min;
	int g_max;

	public TimeOfLastGlobalReversal(int min, int max){
		g_min = min;
		g_max = max;
	}
	public boolean test(Game game) {
		if(g_min > game.getTimeOfLastGlobalReversal()){
			return false;
		}
		if(g_max < game.getTimeOfLastGlobalReversal()){
			return false;
		}
		return true;
	}

}
