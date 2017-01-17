package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class BLRoad extends Scenary{	
	public BLRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomLeftRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
