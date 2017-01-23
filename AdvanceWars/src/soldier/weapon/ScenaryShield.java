package soldier.weapon;

import advancewars.behaviors.BehaviorScenary;
import soldier.core.BehaviorSoldier;
import soldier.core.WeaponDefense;

public class ScenaryShield  extends WeaponDefense{
	
	private int value = 0;
	
	public ScenaryShield(int bonusValue){
		value = bonusValue;
	}

	@Override
	public String getName() {
		return "Bonus";
	}

	@Override
	public BehaviorSoldier createExtension(BehaviorSoldier s) {
		return new BehaviorScenary(this, s, value);
	}
	
	@Override
	public ScenaryShield clone() {
		return (ScenaryShield) super.clone();
	}

	public int getValue() {
		return value;
	}
	
	

}
