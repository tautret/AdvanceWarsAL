package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class CrossDownRoad extends Scenary{	
	public CrossDownRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/CrossDownRoad.png",new ScenaryShield(0));
	}


}
