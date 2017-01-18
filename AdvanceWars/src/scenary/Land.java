package scenary;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.Rectangle;

import soldier.core.Weapon;

public class Land extends Scenary{	
	public Land(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/Land.png");
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}
