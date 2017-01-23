package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class HRiver extends Scenary{	
	public HRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-River.png",new ScenaryShield(0));
	}
	
}
