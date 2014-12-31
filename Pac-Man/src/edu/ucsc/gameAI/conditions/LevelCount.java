package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class LevelCount implements ICondition {
	
	int l_index;

	public LevelCount(int index){
		l_index = index;
	}
	@Override
	public boolean test(Game game) {
		if (l_index == game.getCurrentLevel()){
			return true;
		}
		return false;
	}

}
