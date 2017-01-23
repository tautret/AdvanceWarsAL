package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class CrossUpRoad extends Scenary{	
	public CrossUpRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/CrossUpRoad.png",new ScenaryShield(0));
	}
	
}
