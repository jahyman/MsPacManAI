package edu.ucsc.gameAI.fsm;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.ICondition;

public class Transition implements ITransition {
	private ICondition transCondition;
	private IState transTarget;
	private IAction transAction;
	

	@Override
	public IState getTargetState() {
		return transTarget;
	}

	@Override
	public void setTargetState(IState targetState) {
		transTarget = targetState;
		
	}

	@Override
	public IAction getAction() {
		return transAction;
	}

	@Override
	public void setAction(IAction action) {
		transAction = action;
		
	}

	@Override
	public void setCondition(ICondition condition) {
		transCondition = condition;

		
	}

	@Override
	public boolean isTriggered(Game game) {
		return transCondition.test(game);
	}

}
