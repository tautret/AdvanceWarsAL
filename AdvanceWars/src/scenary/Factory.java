package scenary;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;

public class Factory implements GameEntity, Drawable {
	protected static DrawableImage image = null;
	int x, y;
	
	public Factory(Canvas defaultCanvas, int xx, int yy) {
		image = new DrawableImage("images/Factory.png", defaultCanvas);
		x = xx;
		y = yy;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, 16, 15,
				null);
	}
	
	public Point getPos() {
		return (new Point(x, y));
	}


}
