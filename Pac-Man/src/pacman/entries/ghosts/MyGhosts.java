package pacman.entries.ghosts;

import java.util.EnumMap;

import pacman.controllers.Controller;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.*;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.*;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue)
	{
		myMoves.clear();
		
		for(GHOST ghost : GHOST.values())	//for each ghost
		{
			BinaryDecision nGhost = new BinaryDecision();
			BinaryDecision edibleBinaryDecision = new BinaryDecision();
			BinaryDecision fade = new BinaryDecision();
			BinaryDecision pacManNearPP = new BinaryDecision();
			BinaryDecision nearPacMan = new BinaryDecision();
			
			nGhost.setCondition(new GhostNearGhost(game, ghost));
			nGhost.setTrueBranch(new NoClustering(game, ghost));
			nGhost.setFalseBranch(edibleBinaryDecision);
			
			edibleBinaryDecision.setCondition(new IsEdible(ghost));
			edibleBinaryDecision.setTrueBranch(fade);
			edibleBinaryDecision.setFalseBranch(pacManNearPP);
			
			fade.setCondition(new GhostsFading());
			fade.setTrueBranch(new PacAttack(game, ghost)); //keep distance
			fade.setFalseBranch(new RunAwayFromPacman(game, ghost));
			
			pacManNearPP.setCondition(new PowerPillNearPacmanForGhosts(game));
			pacManNearPP.setTrueBranch(nearPacMan);
			pacManNearPP.setFalseBranch(new PacAttack(game,ghost));
			
			nearPacMan.setCondition(new GhostNearPacmanForGhosts(game));
			nearPacMan.setTrueBranch(new RunAwayFromPacman(game, ghost));
			nearPacMan.setFalseBranch(new PacAttack(game, ghost)); //Patrol
			
			IAction myAction = new RunAwayFromPacman(game, ghost);
			IAction myAttack = new PacAttack(game,ghost);
			IAction myPersonalSpace = new NoClustering(game,ghost);
	
			if(game.doesGhostRequireAction(ghost))		//if ghost requires an action
			{
				if (nGhost.makeDecision(game).getClass() == RunAwayFromPacman.class){
					myMoves.put(ghost,myAction.getMove());
					//System.out.println(myAction.getMove());
				}
				if (nGhost.makeDecision(game).getClass() == PacAttack.class){
					myMoves.put(ghost,myAttack.getMove());
					//System.out.println(myAttack.getMove());
				}
				if (nGhost.makeDecision(game).getClass() == NoClustering.class){
					myMoves.put(ghost,myPersonalSpace.getMove());
					//System.out.println(myAttack.getMove());
				}
				
			}
		}		
		return myMoves;
	}
}