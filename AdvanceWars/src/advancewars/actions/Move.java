package advancewars.actions;

import java.awt.Canvas;

import advancewars.scenary.Scenary;
import soldier.weapon.ScenaryShield;

public class Move extends Scenary implements Action{

	public Move(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/move.png",new ScenaryShield(0));
	}

	@Override
	public void execute() {

	}

}
