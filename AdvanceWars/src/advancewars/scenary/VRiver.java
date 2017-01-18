package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class VRiver extends Scenary{	
	public VRiver(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-River.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
