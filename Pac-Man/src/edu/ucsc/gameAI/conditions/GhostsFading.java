package edu.ucsc.gameAI.conditions;
import static pacman.game.Constants.EDIBLE_ALERT;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;


public class GhostsFading implements ICondition{

	public GhostsFading(){
		
	}
	public boolean test(Game game) {
		for(GHOST ghost : GHOST.values()){
			if(game.isGhostEdible(ghost)){
				if((game.getGhostEdibleTime(ghost)<=EDIBLE_ALERT)){
					return true;
				}
			}
		}
		return false;
	}
}
