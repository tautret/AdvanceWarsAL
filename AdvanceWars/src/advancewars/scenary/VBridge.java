package advancewars.scenary;

import java.awt.Canvas;

import soldier.core.Weapon;

public class VBridge extends Scenary{	
	public VBridge(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/V-Bridge.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
