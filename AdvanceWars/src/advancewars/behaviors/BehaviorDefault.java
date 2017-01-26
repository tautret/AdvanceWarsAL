package advancewars.behaviors;

import java.util.concurrent.ThreadLocalRandom;

import soldier.core.BehaviorSoldierStd;

public class BehaviorDefault extends BehaviorSoldierStd{

	public BehaviorDefault(float healthPoints, float force) {
		super(healthPoints, force);
		
	}

	@Override
	public float strike() {
		return alive() ? computeStrength() : 0;
	}
	
	private float computeStrength(){
		float res = force;// + ThreadLocalRandom.current().nextInt(0,9);
		res*=(this.healthPoints/10);
		return res;
	}
}
