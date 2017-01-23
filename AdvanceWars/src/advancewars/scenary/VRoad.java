package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class VRoad extends Scenary{	
	public VRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-Road.png",new ScenaryShield(0));
	}
	
}
