package soldier.units;

import soldier.core.BehaviorSoldier;
import soldier.core.BehaviorSoldierStd;
import soldier.core.UnitInfantry;

public class HeavyInfantry extends UnitInfantry {

	public HeavyInfantry() {
		super("HeavyInfantry", new BehaviorSoldierStd(25, 5));
		// TODO Auto-generated constructor stub
	}

}
