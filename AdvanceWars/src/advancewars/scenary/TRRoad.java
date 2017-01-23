package advancewars.scenary;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;

public class TRRoad extends Scenary{	
	public TRRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/TopRightRoad.png",new ScenaryShield(0));
	}
	
}
