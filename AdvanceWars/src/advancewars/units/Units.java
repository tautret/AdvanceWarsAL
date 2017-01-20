package advancewars.units;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.Movable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import observer_util.ObservableAbstract;
import soldier.core.UnitGroup;

public abstract class Units extends ObservableAbstract<GameEntity> implements
		Drawable, GameEntity, Overlappable, Movable {
	
	protected final SpriteManager spriteManager;
	protected int rendering_size;
	protected boolean movable = true;
	Point position = new Point();
	SpeedVector speedVector = SpeedVectorDefaultImpl.createNullVector();

	
	public Units(Canvas c, String name, int rendering_size){
		spriteManager = new SpriteManagerDefaultImpl(name, c, rendering_size, 4);
		spriteManager.setTypes(
				//
				"inactive","right","left",
				"up","down",
				"disable");
		this.rendering_size = rendering_size;
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(0, 0, rendering_size, rendering_size);

	}
	
	public void setPosition(Point p) {
		position = (Point) p.clone();
	}

	public void setSpeedVector(SpeedVector speedVector) {
		this.speedVector = (SpeedVector) speedVector.clone();
	}

	public SpeedVector getSpeedVector() {
		return (SpeedVector) speedVector.clone();
	}

	@Override
	public void oneStepMove() {
		spriteManager.increment();

	}
	
	@Override
	public Point getPosition() {
		return position;
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
	
	public abstract UnitGroup getUnitGroup();
	
	public abstract void createArmy(int nb_unit);

}
