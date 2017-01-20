package advancewars.units;

import java.awt.Canvas;

import soldier.units.Jeep;

public class UnitJeep extends Units{
	protected Jeep myJeep;

	public UnitJeep(Canvas c,String name) {
		super(c,"images/Jeep-"+name+".png");
		myJeep = new Jeep();
	}
	
	public Jeep getMyJeep() {
		return myJeep;
	}
}
