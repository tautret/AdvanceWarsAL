package advancewars.actions;

import java.awt.Canvas;
import java.awt.Point;

import advancewars.scenary.Scenary;
import advancewars.units.Units;
import gameframework.moves_rules.SpeedVectorDefaultImpl;
import soldier.weapon.ScenaryShield;

public class Move extends Scenary implements Action{
	private final Point dest = new Point();
	private Units u;
	private Thread t;

	public Move(Canvas defaultCanvas, int xx, int yy,Units u, Point dest) {
		super(defaultCanvas, xx, yy, "images/move.png",new ScenaryShield(0));
		this.dest.setLocation(dest.getLocation());
		this.u = u;
		t = new Thread(){
			
			private void move(int x, int y){
				Point p = u.getPosition();
				u.setPosition(new Point(p.x+x,p.y+y));
				u.setSpeedVector(new SpeedVectorDefaultImpl(new Point(x,y)));
			}
			public void run(){
				try {
					while (!u.getPosition().equals(dest)){
						Point p = u.getPosition();
						if (dest.getX() > p.getX())
							move(1,0);
						else if (dest.getX() < p.getX())
							move(-1,0);
						else if (dest.getY() < p.getY())
							move(0,-1);
						else if (dest.getY() > p.getY())
							move(0,1);
						currentThread().sleep(20);
					}
					u.setSpeedVector(new SpeedVectorDefaultImpl(new Point(0,0)));
				} catch (InterruptedException e) {}
			}
		};
	}
	

	@Override
	public void execute() {
		t.start();
	}

}
