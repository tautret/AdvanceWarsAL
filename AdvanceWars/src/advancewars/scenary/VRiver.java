package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class VRiver extends Scenary{	
	public VRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-River.png",new ScenaryShield(0));
	}
	
}
