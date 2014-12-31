package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import edu.ucsc.gameAI.IAction;

public class State implements IState {
	private Collection<ITransition> stateTransitions;
	private IAction entryAction;
	private IAction exitAction;
	private IAction stateAction;

	
	@Override
	public IAction getAction() {
		return stateAction;
		
	}

	@Override
	public void setAction(IAction action) {
		stateAction = action;
		
	}

	@Override
	public IAction getEntryAction() {
		return entryAction;
	}

	@Override
	public void setEntryAction(IAction action) {
		entryAction = action;
		
	}

	@Override
	public IAction getExitAction() {
		return exitAction;
	}

	@Override
	public void setExitAction(IAction action) {
		exitAction = action;
		
	}

	@Override
	public Collection<ITransition> getTransitions() {
		return stateTransitions;
		
	}

	@Override
	public void setTransitions(Collection<ITransition> trans) {
		stateTransitions = trans;
		
	}

}
