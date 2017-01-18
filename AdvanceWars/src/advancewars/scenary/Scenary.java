package advancewars.scenary;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;

import soldier.core.Unit;
import soldier.core.Weapon;

public abstract class Scenary implements Drawable, GameEntity {
	protected  DrawableImage image = null;
	int x, y;
	public static final int RENDERING_SIZE = 32;
	public Unit unit;
	
	
	public Scenary(Canvas defaultCanvas, int xx, int yy,String path) {
		image = new DrawableImage(path, defaultCanvas);
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
	
	public abstract Weapon getBonus();
	
	public void addSoldier(Unit s){
		unit = s;
		s.addEquipment(this.getBonus());
	}
	
	public void removeSoldier(){
		unit.removeEquipment(this.getBonus());
		unit = null;
	}
	


}
