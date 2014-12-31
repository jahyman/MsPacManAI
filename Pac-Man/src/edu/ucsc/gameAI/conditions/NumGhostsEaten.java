package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class NumGhostsEaten implements ICondition{

	public NumGhostsEaten(){
		
	}
	public boolean test(Game game) {
		int g = 0;
		boolean gZero = true;
		if(game.wasGhostEaten(GHOST.BLINKY)){
			g++;
		}
		if(game.wasGhostEaten(GHOST.INKY)){
			g++;
		}
		if(game.wasGhostEaten(GHOST.PINKY)){
			g++;
		}
		if(game.wasGhostEaten(GHOST.SUE)){
			g++;
		}
		if(g>0){
			gZero = false;
		}
		return gZero;
		
	}
}