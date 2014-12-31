package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostNearPacmanForGhosts implements ICondition{
	
	int px1, px2, py1, py2, x, y;
	//private GHOST[] ghosts;

	public GhostNearPacmanForGhosts (Game game){
		x = game.getNodeXCood(game.getPacmanCurrentNodeIndex());
		y =  game.getNodeYCood(game.getPacmanCurrentNodeIndex());
		px1 = x - 50;
		py1 = y - 50;
		px2 = x + 50;
		py2 = y + 50;	
	}
	@Override
	public boolean test(Game game) {
		//System.out.println("JSFJHSDF");
		for(int j = px1; j <= px2; ++j){
			//System.out.println("ONE");
			for(int k = py1; k <= py2; ++k){
				//System.out.println("TWO");
				for(GHOST ghost : GHOST.values()){
					if(game.getGhostEdibleTime(ghost)==0){
					if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(ghost))){
						//System.out.println("Over here silly");
						if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(ghost))){
							//System.out.println("im close");
							return true;
						}
					}
				}
				}
			}
		}
		return false;
	}
}
