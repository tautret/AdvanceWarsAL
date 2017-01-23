package advancewars;

import java.awt.Canvas;
import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import advancewars.actions.Action;
import advancewars.scenary.Scenary;
import gameframework.core.GameEntity;
import gameframework.core.GameUniverse;
import gameframework.core.Movable;
import observer_util.Observer;

public class Selection {
	private GameUniverse universe;
	private Observer<GameEntity> observer;
	private Set<Action> command;
	private Canvas canvas;
	
	private GameEntity land = null;
	private GameEntity unit = null;
	
	public Selection(Canvas c, GameUniverse universe, Observer<GameEntity> observer) {
		super();
		this.canvas = c;
		this.universe = universe;
		this.observer = observer;
		this.command = new HashSet<Action>();
	}
	
	public void unselect(){
		land = unit = null;
		observer.update(null);
		for (Action a : command){
			universe.removeGameEntity((GameEntity) a);
		}
	}
	
	public void selectItem (Point p){
		unselect();
		p.x += Cursor.DECALAGE_X;
		p.y += Cursor.DECALAGE_Y;
		Iterator<GameEntity> i = universe.gameEntities();
		while (i.hasNext()){
			GameEntity g = i.next();
			if (g instanceof Movable){
				Movable m = (Movable) g;
				if (m.getPosition().equals(p)){
					if (m instanceof Scenary)
						land = g;
					else
						unit = g;
				}
			}
		}
		observer.update(land);
		observer.update(unit);
		if (unit != null)
			fillCommandList();
	}
	
	private void fillCommandList(){
		Iterator<GameEntity> i = universe.gameEntities();
		while (i.hasNext()){
			GameEntity g = i.next();
		}
	}

}
