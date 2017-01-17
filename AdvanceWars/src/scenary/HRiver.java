package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class HRiver extends Scenary{	
	public HRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-River.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
