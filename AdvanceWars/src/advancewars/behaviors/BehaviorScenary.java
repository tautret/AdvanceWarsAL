package advancewars.behaviors;

import soldier.core.BehaviorExtension;
import soldier.core.BehaviorSoldier;
import soldier.core.Weapon;

public class BehaviorScenary extends BehaviorExtension{
	private int bonusValue;
	
	public BehaviorScenary(Weapon owner, BehaviorSoldier s, int value) {
		super(owner, s);
		bonusValue = value;
	}
	
	@Override
	public float parry(float force) {
		float effectiveReceivedForce = force * (1-(bonusValue/10));
		return super.parry(effectiveReceivedForce);
	}

}
