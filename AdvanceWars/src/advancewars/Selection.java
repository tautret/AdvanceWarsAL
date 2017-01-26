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
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveBlocker;
import observer_util.Observer;
import soldier.core.UnitGroup;

public class Selection {
	public enum STATE {WAITING,READY,GO};
	private GameUniverse universe;
	private Observer<GameEntity> observer;
	private Set<Action> command;
	private Canvas canvas;
	private ObservableValue<Boolean> endGame;
	
	private GameEntity land = null;
	private GameEntity unit = null;
	private STATE state = STATE.WAITING;
	
	public Selection(Canvas c, GameUniverse universe, Observer<GameEntity> observer, ObservableValue<Boolean> endGame) {
		super();
		this.canvas = c;
		this.universe = universe;
		this.observer = observer;
		this.command = new HashSet<Action>();
		this.endGame = endGame;
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
	
	public void disableUnit(Point p, Tour t){
		unselect();
		p.x += Cursor.DECALAGE_X;
		p.y += Cursor.DECALAGE_Y;
		Iterator<GameEntity> i = universe.gameEntities();
		while (i.hasNext()){
			GameEntity g = i.next();
			if (g instanceof Units){
				Movable m = (Movable) g;
				if (m.getPosition().equals(p)){
					Units u = ((Units)g);
					if(u.getUnitGroup().getCamp().equals(t.getTour()) && !u.isDisable() ){
						u.setDisable(true);
					}
				}
			}
		}
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
		List<Point> units_pos = new LinkedList<Point>();
		while (i.hasNext()){
			GameEntity g = i.next();
			
			if (g instanceof Scenary && !(g instanceof MoveBlocker) && is_reachable(((Scenary) g).getPos())){
				Point p = ((Scenary) g).getPosition();
				Move m = new Move(canvas, p.x,p.y,(Units)unit,((Scenary) g).getPos());
				if(!((Units)unit).isAlreadyMove()){
					tmp.put(p, m);
				}
			}
			else if (g instanceof Units){
				Units u1 = ((Units)unit);
				Point p = ((Units) g).getPosition();
				units_pos.add(p);
				if(is_attackable(p)){
					UnitGroup g1 = u1.getUnitGroup();
					Units u2 = ((Units)g);
					UnitGroup g2 = u2.getUnitGroup();
					Scenary s1 = foundScenary(u1);
					Scenary s2 = foundScenary(u2);
					if(!g2.getCamp().equals(g1.getCamp())){
						Attack m = new Attack(canvas, p.x,p.y,u1,u2,s1,s2,universe,endGame);
						tmp.put(p, m);
					}
				}
			}
		}
	
		for (Action a : tmp.values()){
			if (a instanceof Move && units_pos.contains(((Move) a).getPosition())){
				
			}else{
				command.add(a);
				universe.addGameEntity((GameEntity) a);
			}
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
					((Units)g).setAlreadyMove(false);
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
	
	public boolean canNewTurn(Tour t){
		Iterator<GameEntity> it = universe.gameEntities();
		while(it.hasNext()){
			GameEntity g = it.next();
			if(g instanceof Units && ((Units)g).getUnitGroup().getCamp().equals(t.getTour())){
				if(!((Units)g).isDisable()){
					return false;
				}
			}
		}
		return true;
	}

}
