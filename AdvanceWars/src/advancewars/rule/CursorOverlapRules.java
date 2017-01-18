package advancewars.rule;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.Vector;

import advancewars.Cursor;
import gameframework.core.GameUniverse;
import gameframework.core.Overlappable;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import advancewars.scenary.Scenary;

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
		
		try {
			m = getClass().getMethod("overlapRule", e1.getClass().getSuperclass(),
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
					e1.getClass().getSuperclass());
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

}
