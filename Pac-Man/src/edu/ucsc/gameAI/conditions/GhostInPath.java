package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class GhostInPath implements ICondition{
	
	int px1, py1, px2, py2;
	int pill;
	
	
	public GhostInPath(Game game){
		//Get PacMan's Coords
		px1 = game.getNodeXCood(game.getPacmanCurrentNodeIndex()) - 1;
		py1 = game.getNodeYCood(game.getPacmanCurrentNodeIndex()) + 1;
		//System.out.println("hello");
		
		//Get nearest pill's Coords		
		int[] loc = game.getActivePillsIndices();
	//	System.out.println("before for 1");
		px2 = game.getNodeXCood(loc[loc.length-1]);
		py2 = game.getNodeYCood(loc[loc.length-1]);
		for(int j = px1; j <= px2; ++j){
		//	System.out.println("For 1");
			for(int k = py1; k <= py2; ++k){
			//	System.out.println("For 2");
				for(int i = 0; i < loc.length; ++i){
				//	System.out.println("For 3");
					if(j == game.getNodeXCood(loc[i])){
					//	System.out.println("If 1");
						if(k == game.getNodeYCood(loc[i])){
						//	System.out.println("If 2");
							pill = loc[i];
						}
					}
				}
			}
		}
		px2 = game.getNodeXCood(pill);
		py2 = game.getNodeYCood(pill);
	}
	@Override
	public boolean test(Game game) {
		//System.out.println("YOLO");
		for(int j = px1; j <= px2; ++j){
			for(int k = py1; k <= py2; ++k){
				for(GHOST ghost : GHOST.values()){
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(ghost))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(ghost))){
						//System.out.println("Blinky");
						return true;
					}
				}
				/*if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.PINKY))){
						System.out.println("Pinky");
						//return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.INKY))){
						System.out.println("Inky");
						//return true;
					}
				}
				if(j == game.getNodeXCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
					if(k == game.getNodeYCood(game.getGhostCurrentNodeIndex(GHOST.SUE))){
						System.out.println("Sue");
						//return true;
					}
				}
			}*/
			
				}
			}	
		}
		//System.out.println("Hi");
		return false;

		}
	}
