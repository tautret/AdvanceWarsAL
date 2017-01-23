package advancewars.actions;

import java.awt.Canvas;

import advancewars.scenary.Scenary;
import soldier.weapon.ScenaryShield;

public class Attack extends Scenary implements Action {

	public Attack(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/attack.png",new ScenaryShield(0));
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
}
