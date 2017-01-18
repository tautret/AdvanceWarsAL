package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class BLRiver extends Scenary{	
	public BLRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomLeftRiver.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}