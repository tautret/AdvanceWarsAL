package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class TLRoad extends Scenary{	
	public TLRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/TopLeftRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
