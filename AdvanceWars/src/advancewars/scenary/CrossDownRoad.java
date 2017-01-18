package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class CrossDownRoad extends Scenary{	
	public CrossDownRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/CrossDownRoad.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
