package soldier.units;

import advancewars.behaviors.BehaviorDefault;
import soldier.core.UnitRider;

public class LightTank extends UnitRider {

	public LightTank() {
		super("LightTank", new BehaviorDefault(10,7.5f),1,1,5,50);
		// TODO Auto-generated constructor stub
	}

}
