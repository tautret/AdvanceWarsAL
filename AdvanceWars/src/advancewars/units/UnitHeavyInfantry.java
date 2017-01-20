package advancewars.units;

import java.awt.Canvas;

import soldier.units.HeavyInfantry;

public class UnitHeavyInfantry extends Units{
	protected HeavyInfantry myHeavyInfantry;

	public UnitHeavyInfantry(Canvas c,String name) {
		super(c,"images/Bazooka-"+name+".png");
		myHeavyInfantry = new HeavyInfantry();
	}
	
	public HeavyInfantry getHeavyInfantry() {
		return myHeavyInfantry;
	}
}
