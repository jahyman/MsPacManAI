package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostNearGhost implements ICondition{
	
	int px1, px2, py1, py2, x, y;
	//private GHOST[] ghosts;
	GHOST currGhost;

	public GhostNearGhost (Game game, GHOST ghost){
		currGhost = ghost;
			x = game.getNodeXCood(game.getGhostCurrentNodeIndex(ghost));
			y =  game.getNodeYCood(game.getGhostCurrentNodeIndex(ghost));
			px1 = x - 1;
			py1 = y - 1;
			px2 = x + 1;
			py2 = y + 1;	
	}
	@Override
	public boolean test(Game game) {
		//System.out.println("JSFJHSDF");
		for(int j = px1; j <= px2; ++j){
			//System.out.println("ONE");
			for(int k = py1; k <= py2; ++k){
				//System.out.println("TWO");
				for(GHOST ghost : GHOST.values()){
					if(ghost != currGhost){
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
