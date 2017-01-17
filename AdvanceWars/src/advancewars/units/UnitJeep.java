package advancewars.units;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;

public class UnitJeep extends GameMovable implements Drawable, GameEntity,Overlappable{
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 32;
	protected boolean movable = true;

	public UnitJeep(String soldierName,Canvas c) {
		spriteManager = new SpriteManagerDefaultImpl("images/Jeep-Red.png",
				c, RENDERING_SIZE, 4);
		spriteManager.setTypes(
				//
				"inactive", "right", "left",
				"up",//
				"down", "disable");
	}
	

	@Override
	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		movable = true;
		if (tmp.getX() == -1) {
			spriteType += "left";
		} else if (tmp.getY() == 1) {
			spriteType += "down";
		} else if (tmp.getY() == -1) {
			spriteType += "up";
		} else if (tmp.getX() == 1) {
			spriteType += "right";
		} else {
			spriteType += "inactive";
		}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
			spriteManager.increment();
	}


	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(0, 0, RENDERING_SIZE, RENDERING_SIZE);
	}

}
