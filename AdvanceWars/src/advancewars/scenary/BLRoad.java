package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class BLRoad extends Scenary{	
	public BLRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomLeftRoad.png",new ScenaryShield(0));
	}
	
}
