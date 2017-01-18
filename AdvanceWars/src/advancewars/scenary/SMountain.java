package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class SMountain extends Scenary{	
	public SMountain(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/SmallMountain.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}