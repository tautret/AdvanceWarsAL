package advancewars;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Point;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import advancewars.StrategyKeyboard.MoveCursorKeyboard;
import advancewars.rule.CursorOverlapRules;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameEntity;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import scenary.BLRiver;
import scenary.BLRoad;
import scenary.BMountain;
import scenary.BRRoad;
import scenary.Building;
import scenary.CrossDownRoad;
import scenary.CrossUpRoad;
import scenary.Factory;
import scenary.Forest;
import scenary.HBridge;
import scenary.HRiver;
import scenary.HRoad;
import scenary.Land;
import scenary.SMountain;
import scenary.Scenary;
import scenary.TLRoad;
import scenary.TRRiver;
import scenary.TRRoad;
import scenary.VBridge;
import scenary.VRiver;
import scenary.VRoad;

public class GameLevelOne extends GameLevelDefaultImpl{

	Canvas canvas;

	// 0 : Land ; 1 : Forest ; 2 : Small Mountain ; 3 : Big Mountain ; 4 :
	// Building ; 5 : Factory
	// 6 : V-Road ; 7 : H-Road ; 8 : Cross-Up Road ; 9 : Cross-Down Road ; 10 :
	// Top Left Road
	// 11: Top Right Road ; 12 : Bottom Left Road ; 13 : Bottom Right Road ; 14
	// : H-Bridge ; 15 : V-bridge
	// 16 : H-River ; 17 : V-River ; 18 : Bottom Left River ; 19 : Top Right
	// River
	static int[][] tab = {
			{ 2, 2, 2, 1, 1, 1, 1, 1,17, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
			{ 3, 5, 1, 5, 0, 4, 0, 4,17, 1, 0, 0, 0, 1, 1, 1, 0, 4, 4, 4, 0 },
			{ 3, 1,10, 7, 9, 7, 7, 7,14, 7, 7, 7, 0, 7, 7, 7, 7, 7, 7, 7, 7 },
			{ 1, 5, 6, 5, 6, 4, 0, 4,17, 0, 0, 0, 1, 2, 2, 1, 6, 0, 0, 0, 1 },
			{ 1, 0, 6, 0, 6, 0, 0, 1,17, 0, 0, 0, 1, 1, 3, 1, 0, 0, 0, 1, 3 },
			{ 1, 5, 6, 5, 6, 1, 0, 1,17, 0, 0, 0, 0, 1, 3, 1, 6, 1, 0, 2, 3 },
			{ 2, 0,12, 7,13, 0, 1, 2,17, 1, 0, 0, 0, 0, 1, 0, 1, 2, 1, 3, 3 },
			{ 3, 1, 2, 1, 0, 3, 2, 3,17, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3 },
			{ 3, 1, 3, 2, 4, 3, 3, 1,17, 1, 0, 2, 1, 0, 0, 1, 5, 0, 0, 0, 0 },
			{ 0, 5, 3, 3, 2, 4, 1, 0,18, 19, 0, 0, 1, 0, 0, 4, 6, 4, 0, 0, 1 },
			{ 2, 1, 3, 1, 0, 0, 0, 0, 1, 18,16,16,16,16,16,16,15,16,19, 1, 1 },
			{ 3, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 6, 1, 18,16,16 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 6, 0, 0, 0, 1 },
			{ 2, 5, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 5 },
			{ 1, 0, 0, 0, 0, 5, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 6, 0, 0, 0, 1 },
			{ 1, 1, 0, 0, 10, 7, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 1, 1 },
			{ 7, 7, 7, 5, 13, 4, 12, 5, 7, 7, 7, 7, 7, 7, 7, 5, 8, 5, 1, 2, 2 } };

	public static final int SPRITE_SIZE = 32;

	public GameLevelOne(Game g) {
		super(g);
		canvas = g.getCanvas();
		canvas.setSize(SPRITE_SIZE*tab[0].length, SPRITE_SIZE*tab.length);
		((Frame)canvas.getParent()).pack();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		// OverlapProcessor overlapProcessor = new
		// OverlapProcessorDefaultImpl();
		//
		// MoveBlockerChecker moveBlockerChecker = new
		// MoveBlockerCheckerDefaultImpl();
		// moveBlockerChecker.setMoveBlockerRules(new PacmanMoveBlockers());
		//
		// PacmanOverlapRules overlapRules = new PacmanOverlapRules(new Point(14
		// * SPRITE_SIZE, 17 * SPRITE_SIZE),
		// new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0],
		// endOfGame);
		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();
		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		universe = new GameUniverseDefaultImpl(moveBlockerChecker,
				overlapProcessor);
		CursorOverlapRules cursorOverlap = new CursorOverlapRules(new Point(0,0));
		cursorOverlap.setUniverse(universe);
		overlapProcessor.setOverlapRules(cursorOverlap);
		
		MoveCursorKeyboard keyStr = new MoveCursorKeyboard();
		canvas.addKeyListener(keyStr);

		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		// Filling up the universe with basic non movable entities and inclusion
		// in the universe
		for (int i = 0; i < tab.length; ++i) {
			for (int j = 0; j < tab[i].length; ++j) {
				Scenary s = null;
				if (tab[i][j] == 0) {
					s = new Land(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE);
				}
				if (tab[i][j] == 1) {
					s = new Forest(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 2) {
					s = new SMountain(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE);
				}
				if (tab[i][j] == 3) {
					s = new BMountain(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE);
				}
				if (tab[i][j] == 4) {
					s = new Building(canvas,
							j * SPRITE_SIZE, i * SPRITE_SIZE);
				}
				if (tab[i][j] == 5) {
					s = new Factory(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 6) {
					s = new VRoad(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE);
				}
				if (tab[i][j] == 7) {
					s = new HRoad(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE);
				}
				if (tab[i][j] == 8) {
					s = new CrossUpRoad(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE);
				}
				if (tab[i][j] == 9) {
					s = new CrossDownRoad(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE);
				}
				if (tab[i][j] == 10) {
					s = new TLRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 11) {
					s = new TRRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 12) {
					s = new BLRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 13) {
					s = new BRRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 14) {
					s = new HBridge(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 15) {
					s = new VBridge(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 16) {
					s = new HRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 17) {
					s = new VRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 18) {
					s = new BLRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				if (tab[i][j] == 19) {
					s = new TRRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE);
				}
				s.addObserver(((AdvanceWarsDefaultImpl)g).currentItem);
				universe.addGameEntity(s);
			}
			
		}

		Cursor myCursor = new Cursor(canvas);
		GameMovableDriverDefaultImpl cursorDriver = new GameMovableDriverDefaultImpl();
		cursorDriver.setStrategy(keyStr);
		cursorDriver.setmoveBlockerChecker(moveBlockerChecker);
		canvas.addKeyListener(keyStr);
		myCursor.setDriver(cursorDriver);
		myCursor.setPosition(new Point((10 * SPRITE_SIZE-5), 5 * SPRITE_SIZE-6));
		universe.addGameEntity(myCursor);
		

		// Arm�e Rouge
		// Ghost myGhost;
		// for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
		// GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
		// MoveStrategyRandom ranStr = new MoveStrategyRandom();
		// ghostDriv.setStrategy(ranStr);
		// ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		// myGhost = new Ghost(canvas);
		// myGhost.setDriver(ghostDriv);
		// myGhost.setPosition(new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE));
		// universe.addGameEntity(myGhost);
		// (overlapRules).addGhost(myGhost);
		// }

		// Arm�e Bleu
		// Ghost myGhost;
		// for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
		// GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
		// MoveStrategyRandom ranStr = new MoveStrategyRandom();
		// ghostDriv.setStrategy(ranStr);
		// ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
		// myGhost = new Ghost(canvas);
		// myGhost.setDriver(ghostDriv);
		// myGhost.setPosition(new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE));
		// universe.addGameEntity(myGhost);
		// (overlapRules).addGhost(myGhost);
		// }
	}
}
