package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class HRoad extends Scenary{	
	public HRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-Road.png",new ScenaryShield(0));
	}
	
}
