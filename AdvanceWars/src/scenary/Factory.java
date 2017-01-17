package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class Factory extends Scenary{	
	public Factory(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Factory.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
