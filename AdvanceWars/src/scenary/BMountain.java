package scenary;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;

public class BMountain implements GameEntity, Drawable {
	protected static DrawableImage image = null;
	int x, y;
	
	public BMountain(Canvas defaultCanvas, int xx, int yy) {
		image = new DrawableImage("images/SmallMountain.png", defaultCanvas);
		x = xx;
		y = yy;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, 16, 22,
				null);
	}
	
	public Point getPos() {
		return (new Point(x, y));
	}


}
