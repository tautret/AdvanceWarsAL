package advancewars;

import java.awt.Canvas;

import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

public class GameLevelTest extends GameLevelDefaultImpl{
	Canvas canvas;

	public GameLevelTest(Game g) {
		super(g);
		canvas = g.getCanvas();
	}


	@Override
	protected void init() {
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();

		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		universe = new GameUniverseDefaultImpl(moveBlockerChecker, overlapProcessor);
		overlapProcessor.setOverlapRules(new OverlapRulesApplierDefaultImpl() {
			protected GameUniverse universe;
			@Override
			public void setUniverse(GameUniverse universe) {
				this.universe = universe;
				
			}
		});
		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);

		
		//overlapRules.setUniverse(universe);
		
		// Pacman definition and inclusion in the universe
		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
		pacDriver.setStrategy(keyStr);
		canvas.addKeyListener(keyStr);

		
	}

}
