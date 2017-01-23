package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class Factory extends Scenary{	
	public Factory(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Factory.png",new ScenaryShield(3));
	}

	
}
