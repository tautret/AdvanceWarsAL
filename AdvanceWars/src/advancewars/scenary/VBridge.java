package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class VBridge extends Scenary{	
	public VBridge(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-Bridge.png",new ScenaryShield(0));
	}

}
