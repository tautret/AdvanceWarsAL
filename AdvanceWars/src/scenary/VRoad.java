package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class VRoad extends Scenary{	
	public VRoad(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-Road.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
