package advancewars.units;

import java.awt.Canvas;

import soldier.units.LightTank;

public class UnitLightTank extends Units{
	protected LightTank myLightTank;

	public UnitLightTank(Canvas c,String name) {
		super(c,"images/Tank-"+name+".png");
		myLightTank = new LightTank();
	}
	
	public LightTank getMyLightTank() {
		return myLightTank;
	}
}
