package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class TRRiver extends Scenary{	
	public TRRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/TopRightRiver.png",new ScenaryShield(0));
	}


	
}
