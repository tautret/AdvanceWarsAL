package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class BRRoad extends Scenary{	
	public BRRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BottomRightRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
