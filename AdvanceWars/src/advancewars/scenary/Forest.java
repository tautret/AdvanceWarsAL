package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class Forest extends Scenary{	
	public Forest(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Forest.png",new ScenaryShield(2));
	}
	
}
