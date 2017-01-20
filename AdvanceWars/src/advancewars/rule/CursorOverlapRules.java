package advancewars.rule;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.Vector;

import advancewars.Cursor;
import advancewars.scenary.BLRiver;
import advancewars.scenary.BLRoad;
import advancewars.scenary.BMountain;
import advancewars.scenary.BRRoad;
import advancewars.scenary.Building;
import advancewars.scenary.CrossDownRoad;
import advancewars.scenary.CrossUpRoad;
import advancewars.scenary.Factory;
import advancewars.scenary.Forest;
import advancewars.scenary.HBridge;
import advancewars.scenary.HRiver;
import advancewars.scenary.HRoad;
import advancewars.scenary.Land;
import advancewars.scenary.SMountain;
import advancewars.scenary.Scenary;
import advancewars.scenary.TLRoad;
import advancewars.scenary.TRRiver;
import advancewars.scenary.TRRoad;
import advancewars.scenary.VBridge;
import advancewars.scenary.VRiver;
import advancewars.scenary.VRoad;
import advancewars.units.UnitHeavyInfantry;
import advancewars.units.UnitJeep;
import advancewars.units.UnitLightInfantry;
import advancewars.units.UnitLightTank;
import advancewars.units.Units;
import gameframework.core.GameUniverse;
import gameframework.core.Overlappable;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;

public class CursorOverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	protected Vector<Scenary> vScenary = new Vector<Scenary>();
	private Point pos;

	public CursorOverlapRules(Point pos) {
		this.pos = pos;
	}

	@Override
	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}
	
	public void addScenary(Scenary s) {
		vScenary.addElement(s);
	}
	
	
	@Override
	protected void applySpecificOverlapRule(Overlappable e1, Overlappable e2) {
		Method m;
		//System.out.println(e1.getClass()+"/"+e2.getClass());
		try {
			m = getClass().getMethod("overlapRule", e1.getClass(),
					e2.getClass());
			
		} catch (NoSuchMethodException e) {
			reverseParameters(e1, e2);
			return;
		}
		invoke(m, e1, e2);
	}
	
	@Override
	protected void reverseParameters(Overlappable e1, Overlappable e2) {
		Method m;
		try {
			m = getClass().getMethod("overlapRule", e2.getClass(),
					e1.getClass());
		} catch (NoSuchMethodException e) {
			return;
		}
		invoke(m, e2, e1);
	}
	
	public void overlapRule(Cursor p, Scenary s) {
			Scenary g = (Scenary)s;
			Point coord = (Point) p.getPosition().clone();
			coord.x += 5;
			coord.y += 6;
			if (coord.equals(g.getPos()) && !p.getPosition().equals(pos)){
				s.notifyObservers(s);
				pos = (Point) p.getPosition().clone();
			}
	}
	
	public void overlapRule(Cursor p, BLRiver s) {
		overlapRule(p, (Scenary)s);
	}
	
	public void overlapRule(Cursor p, BLRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, BMountain s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, BRRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, Building s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, CrossDownRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, CrossUpRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, Factory s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, Forest s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, HBridge s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, HRiver s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, HRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, Land s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, SMountain s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, TLRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, TRRiver s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, TRRoad s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, VBridge s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, VRiver s) {
		overlapRule(p, (Scenary)s);
	}
	public void overlapRule(Cursor p, VRoad s) {
		overlapRule(p, (Scenary)s);
	}
	
	public void overlapRule(Cursor p, Units s) {
		Units u = (Units)s;
		Point coord = (Point) p.getPosition().clone();
		coord.x += 5;
		coord.y += 6;
		if (coord.equals(u.getPosition())){
			u.notifyObservers(u);
			pos = (Point) p.getPosition().clone();
		}
	}
	public void overlapRule(Cursor p, UnitJeep s) {
		overlapRule(p, (Units)s);
	}
	public void overlapRule(Cursor p, UnitHeavyInfantry s) {
		overlapRule(p, (Units)s);
	}
	public void overlapRule(Cursor p, UnitLightInfantry s) {
		overlapRule(p, (Units)s);
	}
	public void overlapRule(Cursor p, UnitLightTank s) {
		overlapRule(p, (Units)s);
	}

}
