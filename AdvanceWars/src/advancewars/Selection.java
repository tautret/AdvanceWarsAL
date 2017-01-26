package advancewars;

import gameframework.core.GameEntity;
import gameframework.core.GameUniverse;
import gameframework.core.Movable;
import gameframework.moves_rules.MoveBlocker;

import java.awt.Canvas;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import observer_util.Observer;
import soldier.core.UnitGroup;
import advancewars.actions.Action;
import advancewars.actions.Attack;
import advancewars.actions.Move;
import advancewars.scenary.Scenary;
import advancewars.units.Units;

public class Selection {
	public enum STATE {WAITING,READY,GO};
	private GameUniverse universe;
	private Observer<GameEntity> observer;
	private Set<Action> command;
	private Canvas canvas;
	
	private GameEntity land = null;
	private GameEntity unit = null;
	private STATE state = STATE.WAITING;
	
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
		state = STATE.WAITING;
	}
	
	public void selectItem (Point p, Tour t){
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
		if(unit != null){
			Units u = ((Units)unit);
			UnitGroup g = u.getUnitGroup();
			if(g.getCamp().equals(t.getTour()) && !u.isDisable() ){
				observer.update(land);
				observer.update(unit);
				if (unit != null){
					fillCommandList();
					state = STATE.READY;
				}
			}
		}
	}
	
	private void fillCommandList(){
		Iterator<GameEntity> i = universe.gameEntities();
		HashMap<Point,Action> tmp = new HashMap<Point,Action>();
		while (i.hasNext()){
			GameEntity g = i.next();
			
			if (g instanceof Scenary && !(g instanceof MoveBlocker) && is_reachable(((Scenary) g).getPos())){
				Point p = ((Scenary) g).getPosition();
				Move m = new Move(canvas, p.x,p.y,(Units)unit,((Scenary) g).getPos());
				tmp.put(p, m);
			}
			else if (g instanceof Units && is_attackable(((Units) g).getPosition())){
				Point p = ((Units) g).getPosition();
				Units u1 = ((Units)unit);
				UnitGroup g1 = u1.getUnitGroup();
				Units u2 = ((Units)g);
				UnitGroup g2 = u2.getUnitGroup();
				Scenary s1 = foundScenary(u1);
				Scenary s2 = foundScenary(u2);
				if(!g2.getCamp().equals(g1.getCamp())){
					Attack m = new Attack(canvas, p.x,p.y,u1,u2,s1,s2,universe);
					tmp.put(p, m);
				}
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
	
	public void newTour(Tour tour){
		Iterator<GameEntity> i = universe.gameEntities();
		while (i.hasNext()){
			GameEntity g = i.next();
			if(g instanceof Units){
				if(((Units)g).getUnitGroup().getCamp().equals(tour.getTour())){
					((Units)g).setDisable(false);
				}
			}
		}
	}
	public STATE get_current_state(){
		return state;
	}
	
	public void set_state(STATE s){
		state = s;
	}
	
	public Scenary foundScenary(Units u){
		Iterator<GameEntity> it = universe.gameEntities();
		Scenary scenary = null;
		while(it.hasNext()){
			GameEntity ge = it.next();
			if(ge instanceof Scenary && ((Scenary)ge).getPos().equals(u.getPosition()))
			{
				scenary = ((Scenary)ge);
				return scenary;
			} 
		}
		return null;
	}

}
