package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class NumGhostsEaten2 implements ICondition{

	public NumGhostsEaten2(){
		
	}
	public boolean test(Game game) {
		int g = 0;
		boolean gZero = false;
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
		if(g>=3){
			gZero = true;
		}
		return gZero;
		
	}
}