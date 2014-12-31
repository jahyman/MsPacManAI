package edu.ucsc.gameAI.conditions;
import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class MazeIndex implements ICondition {
	
	int m_index;

	public MazeIndex(int index){
		m_index = index;
	}
	public boolean test(Game game) {
		if (m_index == game.getMazeIndex()){
			return true;
		}
		return false;
	}

}
