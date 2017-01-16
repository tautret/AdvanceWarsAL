package advancewars;

import java.awt.Canvas;
import java.awt.Point;

import pacman.entity.Ghost;
import pacman.entity.Pacman;
import pacman.rule.GhostMovableDriver;
import pacman.rule.PacmanMoveBlockers;
import pacman.rule.PacmanOverlapRules;
import scenary.*;
import gameframework.core.CanvasDefaultImpl;
import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverseDefaultImpl;
import gameframework.core.GameUniverseViewPortDefaultImpl;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveStrategyKeyboard;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.OverlapProcessor;
import gameframework.moves_rules.OverlapProcessorDefaultImpl;

public class GameLevelOne extends GameLevelDefaultImpl {

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
			{ 2, 2, 2, 1, 1, 1, 1, 1, 17, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
			{ 3, 5, 1, 5, 0, 4, 0, 4, 17, 1, 0, 0, 0, 1, 1, 1, 0, 4, 4, 4, 0 },
			{ 3, 1, 10, 7, 9, 7, 7, 7, 14, 7, 7, 7, 0, 7, 7, 7, 7, 7, 7, 7, 7 },
			{ 1, 5, 6, 5, 6, 4, 0, 4, 14, 0, 0, 0, 1, 2, 2, 1, 6, 0, 0, 0, 1 },
			{ 1, 0, 6, 0, 6, 0, 0, 1, 14, 0, 0, 0, 1, 1, 3, 1, 0, 0, 0, 1, 3 },
			{ 1, 5, 6, 5, 6, 1, 0, 1, 14, 0, 0, 0, 0, 1, 3, 1, 6, 1, 0, 2, 3 },
			{ 2, 0, 12, 7, 13, 0, 1, 2, 14, 1, 0, 0, 0, 0, 1, 0, 1, 2, 1, 3, 3 },
			{ 3, 1, 2, 1, 0, 3, 2, 3, 14, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3 },
			{ 3, 1, 3, 2, 4, 3, 3, 1, 14, 1, 0, 2, 1, 0, 0, 1, 5, 0, 0, 0, 0 },
			{ 0, 5, 3, 3, 2, 4, 1, 0, 18, 19, 0, 0, 1, 0, 0, 4, 6, 4, 0, 0, 1 },
			{ 2, 1, 3, 1, 0, 0, 0, 0, 1, 18, 16, 16, 16, 16, 16, 16, 15, 16,
					19, 1, 1 },
			{ 3, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 6, 1, 18, 17, 17 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 6, 0, 0, 0, 1 },
			{ 2, 5, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 5 },
			{ 1, 0, 0, 0, 0, 5, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 6, 0, 0, 0, 1 },
			{ 1, 1, 0, 0, 10, 7, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 1, 1 },
			{ 6, 6, 6, 5, 6, 4, 6, 5, 6, 6, 6, 6, 6, 6, 6, 5, 8, 5, 1, 2, 2 } };

	public static final int SPRITE_SIZE = 16;

	public GameLevelOne(Game g) {
		super(g);
		canvas = g.getCanvas();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
//		OverlapProcessor overlapProcessor = new OverlapProcessorDefaultImpl();
//
//		MoveBlockerChecker moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
//		moveBlockerChecker.setMoveBlockerRules(new PacmanMoveBlockers());
//		
//		PacmanOverlapRules overlapRules = new PacmanOverlapRules(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE),
//				new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE), life[0], score[0], endOfGame);
//		overlapProcessor.setOverlapRules(overlapRules);
//		
		universe = new GameUniverseDefaultImpl(moveBlockerChecker,
				overlapProcessor);
		overlapRules.setUniverse(universe);

		gameBoard = new GameUniverseViewPortDefaultImpl(canvas, universe);
		((CanvasDefaultImpl) canvas).setDrawingGameBoard(gameBoard);
		// Filling up the universe with basic non movable entities and inclusion
		// in the universe
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 21; ++j) {
				if (tab[i][j] == 0) {
					universe.addGameEntity(new Land(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE));
				}
				if (tab[i][j] == 1) {
					universe.addGameEntity(new Forest(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 2) {
					universe.addGameEntity(new SMountain(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 3) {
					universe.addGameEntity(new BMountain(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 4) {
					universe.addGameEntity(new Building(canvas,
							j * SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 5) {
					universe.addGameEntity(new Factory(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 6) {
					universe.addGameEntity(new VRoad(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE));
				}
				if (tab[i][j] == 7) {
					universe.addGameEntity(new HRoad(canvas, j * SPRITE_SIZE, i
							* SPRITE_SIZE));
				}
				if (tab[i][j] == 8) {
					universe.addGameEntity(new CrossUpRoad(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 9) {
					universe.addGameEntity(new CrossDownRoad(canvas, j
							* SPRITE_SIZE, i * SPRITE_SIZE));
				}
				if (tab[i][j] == 10) {
					universe.addGameEntity(new TLRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 11) {
					universe.addGameEntity(new TRRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 12) {
					universe.addGameEntity(new BLRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 13) {
					universe.addGameEntity(new BRRoad(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 14) {
					universe.addGameEntity(new HBridge(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 15) {
					universe.addGameEntity(new VBridge(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 16) {
					universe.addGameEntity(new HRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 17) {
					universe.addGameEntity(new VRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 18) {
					universe.addGameEntity(new BLRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
				if (tab[i][j] == 19) {
					universe.addGameEntity(new TRRiver(canvas, j * SPRITE_SIZE,
							i * SPRITE_SIZE));
				}
			}
		}
		
		/* A Remplacer par un curseur */
		
//		Pacman myPac = new Pacman(canvas);
//		GameMovableDriverDefaultImpl pacDriver = new GameMovableDriverDefaultImpl();
//		MoveStrategyKeyboard keyStr = new MoveStrategyKeyboard();
//		pacDriver.setStrategy(keyStr);
//		pacDriver.setmoveBlockerChecker(moveBlockerChecker);
//		canvas.addKeyListener(keyStr);
//		myPac.setDriver(pacDriver);
//		myPac.setPosition(new Point(14 * SPRITE_SIZE, 17 * SPRITE_SIZE));
//		universe.addGameEntity(myPac);

		// Armée Rouge
//		Ghost myGhost;
//		for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
//			GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
//			MoveStrategyRandom ranStr = new MoveStrategyRandom();
//			ghostDriv.setStrategy(ranStr);
//			ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
//			myGhost = new Ghost(canvas);
//			myGhost.setDriver(ghostDriv);
//			myGhost.setPosition(new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE));
//			universe.addGameEntity(myGhost);
//			(overlapRules).addGhost(myGhost);
//		}
		
		// Armée Bleu
//		Ghost myGhost;
//		for (int t = 0; t < NUMBER_OF_GHOSTS; ++t) {
//			GameMovableDriverDefaultImpl ghostDriv = new GhostMovableDriver();
//			MoveStrategyRandom ranStr = new MoveStrategyRandom();
//			ghostDriv.setStrategy(ranStr);
//			ghostDriv.setmoveBlockerChecker(moveBlockerChecker);
//			myGhost = new Ghost(canvas);
//			myGhost.setDriver(ghostDriv);
//			myGhost.setPosition(new Point(14 * SPRITE_SIZE, 15 * SPRITE_SIZE));
//			universe.addGameEntity(myGhost);
//			(overlapRules).addGhost(myGhost);
//		}
	}
}
