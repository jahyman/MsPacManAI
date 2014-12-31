package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TotalTime implements ICondition {
	
	int t_min;
	int t_max;

	public TotalTime(int min, int max){
		t_min = min;
		t_max = max;
	}
	
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		if(t_min > game.getTotalTime()){
			return false;
		}
		else if(t_max < game.getTotalTime()){
			return false;
		}
		else {
			return true;
		}
	}
}
