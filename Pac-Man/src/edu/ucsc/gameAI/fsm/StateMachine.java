package edu.ucsc.gameAI.fsm;

import java.util.Collection;
import java.util.LinkedList;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;

public class StateMachine implements IStateMachine {
	
	//private ITransition trans;
	private IState currentState;
	//private IState initialState;
	//private IState states;
	//private IAction action;
	//LinkedList<IStates> states = new LinkedList<IStates>();
	
	@Override
	public Collection<IAction> update(Game game) {
		// TODO Auto-generated method stub
		final LinkedList<IAction> actions = new LinkedList<IAction>();
		boolean transTriggered = false;
		
		//go througth all transitions
		for(ITransition trans : currentState.getTransitions()){  
			if(trans.isTriggered(game)){
				transTriggered = true;
				if (currentState.getExitAction() != null){
					actions.add(currentState.getExitAction());
				}
				if (trans.getAction() != null){
					actions.add(trans.getAction());
				}
				currentState = trans.getTargetState();
				if (currentState.getEntryAction() != null){
					actions.add(currentState.getEntryAction());
				}
				break;
			}
		}
			
		if(!transTriggered){
			actions.add(currentState.getAction());
		}
		return actions;
	}

	@Override
	public IState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(IState state) {
		currentState = state;
		
	}

}
