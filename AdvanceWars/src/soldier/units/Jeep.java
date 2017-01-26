package soldier.units;

import advancewars.behaviors.BehaviorDefault;
import soldier.core.UnitRider;

public class Jeep extends UnitRider {

	public Jeep() {
		super("Jeep", new BehaviorDefault(10,3.5f),1,1,8,80);
	}

}
