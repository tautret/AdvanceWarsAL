package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class TRRoad extends Scenary{	
	public TRRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/TopRightRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
