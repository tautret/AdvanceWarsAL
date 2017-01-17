package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class HBridge extends Scenary{	
	public HBridge(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/H-Bridge.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
