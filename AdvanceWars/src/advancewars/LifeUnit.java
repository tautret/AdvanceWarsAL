package advancewars;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

import java.awt.Canvas;
import java.awt.Graphics;

public class LifeUnit implements Drawable,GameEntity {
	
	protected DrawableImage image = null;
	int x,y;
	public static final int RENDERING_SIZE=12;
	public static final int decallage = RENDERING_SIZE + 9 ;

	
	public LifeUnit(Canvas defaultCanvas, int xx, int yy, String path){
		image = new DrawableImage(path, defaultCanvas);
		x = xx;
		y = yy;
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x+decallage, y+decallage, RENDERING_SIZE, RENDERING_SIZE,
				null);
	}

}
