package advancewars.units;

import java.awt.Canvas;

import soldier.units.LightInfantry;

public class UnitLightInfantry extends Units{
	protected LightInfantry myLightInfantry;

	public UnitLightInfantry(Canvas c,String name) {
		super(c,"images/Soldier-"+name+".png");
		myLightInfantry = new LightInfantry();
	}
	
	public LightInfantry getLightInfantry() {
		return myLightInfantry;
	}
}
