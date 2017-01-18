package advancewars;

import gameframework.core.Movable;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.SpeedVector;

import java.awt.Point;

public class MoveBlockerCursor extends MoveBlockerCheckerDefaultImpl {

	public MoveBlockerCursor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean moveValidation(Movable m, SpeedVector mov) {
		if(!super.moveValidation(m, mov)){
			mov.setDirection(new Point(0,0));
		}
		return true;
	}
}
