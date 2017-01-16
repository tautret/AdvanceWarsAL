package scenary;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;

public class CrossUpRoad implements GameEntity, Drawable {
	protected static DrawableImage image = null;
	int x, y;
	public static final int RENDERING_SIZE = 16;

	
	public CrossUpRoad(Canvas defaultCanvas, int xx, int yy) {
		image = new DrawableImage("images/CrossUpRoad.png", defaultCanvas);
		x = xx;
		y = yy;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
				null);
	}
	
	public Point getPos() {
		return (new Point(x, y));
	}


}
