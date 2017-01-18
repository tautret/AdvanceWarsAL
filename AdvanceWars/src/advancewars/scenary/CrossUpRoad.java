package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class CrossUpRoad extends Scenary{	
	public CrossUpRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/CrossUpRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
