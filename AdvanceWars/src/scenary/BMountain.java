package scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class BMountain extends Scenary{	
	public BMountain(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BigMountain.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}