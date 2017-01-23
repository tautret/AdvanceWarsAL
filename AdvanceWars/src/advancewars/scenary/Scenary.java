package advancewars.scenary;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.core.Movable;
import gameframework.core.Overlappable;
import gameframework.moves_rules.SpeedVector;
import gameframework.moves_rules.SpeedVectorDefaultImpl;
import observer_util.ObservableAbstract;
import soldier.weapon.ScenaryShield;

public abstract class Scenary extends ObservableAbstract<GameEntity> implements Drawable, GameEntity, Overlappable, Movable {
	protected  DrawableImage image = null;
	int x, y;
	public static final int RENDERING_SIZE = 32;
	private ScenaryShield behavior;
	
	public Scenary(Canvas defaultCanvas, int xx, int yy,String path,ScenaryShield bs) {
		image = new DrawableImage(path, defaultCanvas);
		x = xx;
		y = yy;
		this.behavior = bs;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
				null);
	}
	
	public Point getPos() {
		return (new Point(x, y));
	}
	
	@Override
	public Point getPosition() {
		return this.getPos();
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(0,0,RENDERING_SIZE,RENDERING_SIZE);
	}
	

	public SpeedVector getSpeedVector(){
		return SpeedVectorDefaultImpl.createNullVector();
	}

	public void setSpeedVector(SpeedVector m){
		
	}

	public void oneStepMove(){
		
	}
	
	public DrawableImage getImage(){
		return image;
	}

	public ScenaryShield getBehavior() {
		return behavior;
	}
	
	

}
