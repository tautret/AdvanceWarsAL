package advancewars;

import java.awt.Canvas;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import advancewars.actions.Action;
import advancewars.actions.Attack;
import advancewars.actions.Move;
import advancewars.scenary.Scenary;
import advancewars.units.Units;
import gameframework.core.GameEntity;
import gameframework.core.GameUniverse;
import gameframework.core.Movable;
import gameframework.moves_rules.MoveBlocker;
import observer_util.Observer;
import soldier.core.UnitGroup;

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
		command.clear();
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
		HashMap<Point,Action> tmp = new HashMap<Point,Action>();
		while (i.hasNext()){
			GameEntity g = i.next();
			if (g instanceof Scenary && !(g instanceof MoveBlocker) && is_reachable(((Scenary) g).getPos())){
				Point p = ((Scenary) g).getPosition();
				Move m = new Move(canvas, p.x,p.y);
				tmp.put(p, m);
			}
			else if (g instanceof Units && is_attackable(((Units) g).getPosition())){
				Point p = ((Units) g).getPosition();
				Attack m = new Attack(canvas, p.x,p.y);
				tmp.put(p, m);
			}
		}
	
		for (Action a : tmp.values()){
			command.add(a);
			universe.addGameEntity((GameEntity) a);
		}
	}
	
	private boolean is_reachable(Point p){
		Units u = ((Units)unit);
		UnitGroup g = u.getUnitGroup();
		Point current = u.getPosition().getLocation();
		int max_dst = Integer.min(g.getDeplacementTurn(),g.getMaxDeplacement())*32;
		int distance = (int) (Math.abs(current.getX()-p.x) + Math.abs(current.getY()-p.y));
		return !p.equals(current) && distance<=max_dst;
	}
	
	private boolean is_attackable(Point p){
		Units u = ((Units)unit);
		UnitGroup g = u.getUnitGroup();
		Point current = u.getPosition().getLocation();
		int min_dst = g.getMinRangeAttack()*32;
		int max_dst = g.getMaxRangeAttack()*32;
		int distance = (int) (Math.abs(current.getX()-p.x) + Math.abs(current.getY()-p.y));
		return !p.equals(current) && distance>=min_dst && distance<=max_dst;
	}

}
