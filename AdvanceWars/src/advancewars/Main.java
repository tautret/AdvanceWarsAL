package advancewars;

import java.util.ArrayList;

import gameframework.core.GameLevel;

public class Main {

	public static void main(String[] args) {
		AdvanceWarsDefaultImpl g = new AdvanceWarsDefaultImpl();
		ArrayList<GameLevel> levels = new ArrayList<>();
		
		levels.add(new GameLevelOne(g));
		
		g.setLevels(levels);
		g.start();

	}

}
