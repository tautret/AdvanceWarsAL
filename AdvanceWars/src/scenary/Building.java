package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class Building extends Scenary{	
	public Building(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Building.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
