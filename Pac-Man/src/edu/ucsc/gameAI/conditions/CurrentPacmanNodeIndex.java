package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentPacmanNodeIndex implements ICondition{

	int pindex;
	public CurrentPacmanNodeIndex(int index){
		pindex = index;
	}
	@Override
	public boolean test(Game game) {
		if(pindex == game.getPacmanCurrentNodeIndex()){
			return true;
		}
		return false;
	}

}
