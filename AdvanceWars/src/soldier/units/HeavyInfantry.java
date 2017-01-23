package soldier.units;

import advancewars.behaviors.BehaviorDefault;
import soldier.core.UnitInfantry;

public class HeavyInfantry extends UnitInfantry {

	public HeavyInfantry() {
		super("HeavyInfantry", new BehaviorDefault(10, 4.5f),1,1,2,70);
		// TODO Auto-generated constructor stub
	}

}
