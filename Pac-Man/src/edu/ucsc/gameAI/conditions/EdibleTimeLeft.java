package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class EdibleTimeLeft implements ICondition{
	
	
	public EdibleTimeLeft(){
		
	}

	@Override
	public boolean test(Game game) {
		for(GHOST ghost : GHOST.values()){
			int time = game.getGhostEdibleTime(ghost);
			if(time <= Constants.EDIBLE_ALERT/2){
				return true;
			}	
		}
		return false;
	}

}
