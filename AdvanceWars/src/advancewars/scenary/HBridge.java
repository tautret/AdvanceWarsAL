package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class HBridge extends Scenary{	
	public HBridge(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-Bridge.png",new ScenaryShield(0));
	}
	
}
