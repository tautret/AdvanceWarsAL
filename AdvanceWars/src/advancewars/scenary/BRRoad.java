package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class BRRoad extends Scenary{	
	public BRRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomRightRoad.png",new ScenaryShield(0));
	}

	
}
