package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.conditions.*;
import edu.ucsc.gameAI.*;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	//private final EnumMap<PACMAN,MOVE> myMove=new EnumMap<GHOST,MOVE>(GHOST.class);
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//Place your game logic here to play the game as Ms Pac-Man
		BinaryDecision gNear = new BinaryDecision();
		BinaryDecision pmTree = new BinaryDecision();
		BinaryDecision pNear = new BinaryDecision();
		BinaryDecision fade = new BinaryDecision();
		BinaryDecision tLeft = new BinaryDecision();
		BinaryDecision gEaten = new BinaryDecision();
		BinaryDecision gInWay = new BinaryDecision();
		BinaryDecision distGhost = new BinaryDecision();
		BinaryDecision edGhostNr =  new BinaryDecision();
		BinaryDecision gGroup = new BinaryDecision();
		BinaryDecision edGhostLeft = new BinaryDecision();
		BinaryDecision ppNear = new BinaryDecision();
		BinaryDecision ppRouteSafe = new BinaryDecision();
		//BinaryDecision move = new BinaryDecision();
		
		//move.setCondition
		
		ICondition myCond = new GhostNearPacman(game);
		myCond.test(game);
		
		gNear.setCondition(myCond);
		gNear.setTrueBranch(new RunAwayFromGhost(game));
		gNear.setFalseBranch(pmTree);
		
		pmTree.setCondition(new IsAnyGhostEdible());
		pmTree.setFalseBranch(pNear);
		pmTree.setTrueBranch(fade);
		
		pNear.setCondition(new PillNearPacman(game));
		pNear.setFalseBranch(new MoveToNearPill(game));
		pNear.setTrueBranch(gInWay);
		
		gInWay.setCondition(new GhostInPath(game));
		gInWay.setFalseBranch(new MoveToNearPill(game));
		gInWay.setTrueBranch(gGroup);
		
		gGroup.setCondition(new TwoOrMoreGhosts(game));
		gGroup.setFalseBranch(new MoveToNearPill(game));
		gGroup.setTrueBranch(ppNear);
		
		ppNear.setCondition(new PowerPillNearPacman(game));
		ppNear.setFalseBranch(new MoveToNearPill(game)); //edit
		ppNear.setTrueBranch(ppRouteSafe);
		
		ppRouteSafe.setCondition(new GhostInPPPath(game));
		ppRouteSafe.setFalseBranch(new RunAwayFromGhost(game)); //edit
		ppRouteSafe.setTrueBranch(new MoveToNearPPill(game));
		
		fade.setCondition(new GhostsFading());
		fade.setFalseBranch(gEaten);
		fade.setTrueBranch(tLeft);
		
		gEaten.setCondition(new NumGhostsEaten());
		gEaten.setFalseBranch(new ChaseNearGhost(game));
		gEaten.setTrueBranch(edGhostNr);
		
		edGhostNr.setCondition(new GhostInRegionEdible(game));
		edGhostNr.setFalseBranch(edGhostLeft);
		edGhostNr.setTrueBranch(new ChaseNearGhost(game)); //edit find safest route to ed ghost
		
		edGhostLeft.setCondition(new NumGhostsEaten2());
		edGhostLeft.setFalseBranch(new ChaseNearGhost(game));
		edGhostLeft.setTrueBranch(new MoveToNearPill(game)); //edit leave it be
		
		tLeft.setCondition(new EdibleTimeLeft());
		tLeft.setFalseBranch(new ChaseNearGhost(game));
		tLeft.setTrueBranch(distGhost);
		
		distGhost.setCondition(new DistanceToNearestEdibleGhost(game));
		distGhost.setFalseBranch(new MoveToNearPill(game)); //edit leave it be
		distGhost.setTrueBranch(new ChaseNearGhost(game));
		
		IAction myAction = new MoveToNearPill(game);
		IAction myAction2 = new ChaseNearGhost(game);
		IAction myAction3 = new MoveToNearPPill(game);
		IAction myAction4 = new RunAwayFromGhost(game);
		//myAction.getMove();
		//ICondition ghostCond = new GhostNearPacman(game);
		
		
			if (gNear.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}
			/*if (gInWay.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}
			if (gGroup.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}
			if (ppNear.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}
			if (edGhostLeft.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}
			if (distGhost.makeDecision(game).getClass() == MoveToNearPill.class){
				myMove = myAction.getMove();
			}*/
			
			
			
			
			if (gNear.makeDecision(game).getClass() == ChaseNearGhost.class){
				myMove = myAction2.getMove();
			}
			/*if (edGhostNr.makeDecision(game).getClass() == ChaseNearGhost.class){
				myMove = myAction2.getMove();
			}
			if (edGhostLeft.makeDecision(game).getClass() == ChaseNearGhost.class){
				myMove = myAction2.getMove();
			}
			if (tLeft.makeDecision(game).getClass() == ChaseNearGhost.class){
				myMove = myAction2.getMove();
			}
			if (distGhost.makeDecision(game).getClass() == ChaseNearGhost.class){
				myMove = myAction2.getMove();
			}*/
			
			
			
			
			
			if (gNear.makeDecision(game).getClass() == MoveToNearPPill.class){
				myMove = myAction3.getMove();
			}
			
			
			
			if (gNear.makeDecision(game).getClass() == RunAwayFromGhost.class){
				//System.out.println(myMove);
				myMove = myAction4.getMove();
			}
			/*if (ppRouteSafe.makeDecision(game).getClass() == RunAwayFromGhost.class){
				//System.out.println(myMove);
				myMove = myAction4.getMove();
			}*/
		return myMove;
	}
}