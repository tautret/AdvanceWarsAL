package advancewars;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.SpeedVector;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cursor extends GameMovable implements Drawable, GameEntity, Overlappable {
	
	
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 64;
	public static final int DECALAGE_X = 5;
	public static final int DECALAGE_Y = 6;
	protected boolean movable = true;
	
	public Cursor(Canvas defaultCanvas) {
		spriteManager = new SpriteManagerDefaultImpl("images/cursor.png", defaultCanvas, RENDERING_SIZE, 4);
		spriteManager.setTypes("onCase");
	}

	@Override
	public void draw(Graphics g) {
		String spriteType = "";
		movable = true;
		spriteType = "onCase";
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
			spriteManager.increment();
	}

	public Rectangle getBoundingBox() {
		return (new Rectangle(0, 0, RENDERING_SIZE/2, RENDERING_SIZE/2));
	}
	
	@Override
	public void oneStepMove() {
		super.oneStepMove();
		if ((getPosition().getX()+DECALAGE_X)%(RENDERING_SIZE/2) == 0 && (getPosition().getY()+DECALAGE_Y)%(RENDERING_SIZE/2) ==0){
			SpeedVector m = getDriver().getSpeedVector(this);
			m.setDirection(new Point(0,0));
		}
	}

}
