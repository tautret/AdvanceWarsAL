package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class Land extends Scenary{	
	public Land(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Land.png",new ScenaryShield(1));
	}
	
}
