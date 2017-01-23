package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class BLRiver extends Scenary{	
	public BLRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomLeftRiver.png",new ScenaryShield(0));
	}

	
}