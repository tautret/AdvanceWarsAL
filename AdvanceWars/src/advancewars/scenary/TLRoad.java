package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class TLRoad extends Scenary{	
	public TLRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/TopLeftRoad.png",new ScenaryShield(0));
	}
	
}
