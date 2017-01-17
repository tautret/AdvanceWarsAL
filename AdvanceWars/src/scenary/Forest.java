package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class Forest extends Scenary{	
	public Forest(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Forest.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
