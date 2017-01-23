package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class SMountain extends Scenary{	
	public SMountain(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/SmallMountain.png",new ScenaryShield(4));
	}
	
}