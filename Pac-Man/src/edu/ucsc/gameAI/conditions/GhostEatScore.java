package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class GhostEatScore implements ICondition {

	int g_min;
	int g_max;
	public GhostEatScore(int min, int max){
		g_min = min;
		g_max = max;
	}
	public boolean test(Game game) {
		if(g_min > game.getGhostCurrentEdibleScore()){
			return false;
		}
		else if(g_max < game.getGhostCurrentEdibleScore()){
			return false;
		}
		return true;
	}

}
