package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;


public class IsAnyGhostEdible implements ICondition{
	
	
	public IsAnyGhostEdible(){
		
	}


	@Override
	public boolean test(Game game) {
		if(game.isGhostEdible(GHOST.BLINKY)){
			return true;
		}
		if(game.isGhostEdible(GHOST.PINKY)){
			return true;
		}
		if(game.isGhostEdible(GHOST.INKY)){
			return true;
		}
		if(game.isGhostEdible(GHOST.SUE)){
			return true;
		}
		return false;
	}

}
