package scenary;

import java.awt.Canvas;
import java.awt.Graphics;

import soldier.core.Weapon;

public class BMountain extends Scenary{	
	
	private static final int MORE_PIXEL = 5;
	
	public BMountain(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/BigMountain.png");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y - (MORE_PIXEL * (RENDERING_SIZE/16)), RENDERING_SIZE, RENDERING_SIZE+(MORE_PIXEL * (RENDERING_SIZE/16)),
				null);
	}

	@Override
	public Weapon getBonus() {
		return null;
	}
	
}