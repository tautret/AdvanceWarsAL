package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class HRoad extends Scenary{	
	public HRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-Road.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
